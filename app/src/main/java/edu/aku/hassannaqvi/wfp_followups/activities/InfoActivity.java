package edu.aku.hassannaqvi.wfp_followups.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.contracts.EnrolledContract;
import edu.aku.hassannaqvi.wfp_followups.contracts.FormsContract;
import edu.aku.hassannaqvi.wfp_followups.contracts.LHWsContract;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class InfoActivity extends Activity {

    private static final String TAG = InfoActivity.class.getSimpleName();
    static String id = "";
    List<String> LHWsName;
    DatabaseHelper db;
    HashMap<String, String> LHWs;
    Boolean check = false;
    EnrolledContract enrolledParticipant;
    @BindView(R.id.studyID)
    EditText studyID;
    @BindView(R.id.pfa01)
    EditText pfa01;
    @BindView(R.id.pfa04)
    RadioGroup pfa04;
    @BindView(R.id.pfa04a)
    RadioButton pfa04a;
    @BindView(R.id.pfa04b)
    RadioButton pfa04b;
    @BindView(R.id.pfa06)
    RadioGroup pfa06;
    @BindView(R.id.pfa06a)
    RadioButton pfa06a;
    @BindView(R.id.pfa06b)
    RadioButton pfa06b;
    @BindView(R.id.btn_Continue)
    Button btn_Continue;
    @BindView(R.id.fldGrpParticipant)
    LinearLayout fldGrpParticipant;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        this.setTitle(R.string.pfaheading);
        db = new DatabaseHelper(this);

        LHWsName = new ArrayList<>();

        LHWs = new HashMap<>();

        final Collection<LHWsContract> collectionLHWs = db.getLHWsByCluster(AppMain.curCluster);

        for (LHWsContract lhws : collectionLHWs) {
            LHWsName.add(lhws.getLhwName());
            Collections.sort(LHWsName);
            LHWs.put(lhws.getLhwName(), lhws.getLhwId());

        }

        pfa06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.pfa06b) {
                    btn_Continue.setVisibility(View.GONE);
                } else {
                    btn_Continue.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @OnTextChanged(value = R.id.studyID, callback = OnTextChanged.Callback.TEXT_CHANGED)
    void afterstudyIDInput(Editable editable) {
        check = false;
        fldGrpParticipant.setVisibility(View.GONE);
    }


    @OnClick(R.id.checkParticipants)
    void onCheckParticipantsClick() {
        //TODO implement

        if (!studyID.getText().toString().isEmpty()) {
            enrolledParticipant = db.getEnrolledByStudyID(studyID.getText().toString());

            if (enrolledParticipant != null) {

                Toast.makeText(getApplicationContext(), "Participant found", Toast.LENGTH_LONG).show();

                pfa01.setText(enrolledParticipant.getPw_name());

                fldGrpParticipant.setVisibility(View.VISIBLE);

                check = true;


            } else {
                Toast.makeText(getApplicationContext(), "Participant Not found", Toast.LENGTH_LONG).show();

                check = false;
            }
        } else {

            if (!validatorClass.EmptyTextBox(this, studyID, getString(R.string.studyID))) {
                return;
            }
        }


    }


    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                AppMain.endActivity(this, this);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @OnClick(R.id.btn_Continue)
    void onBtnContinueClick() {
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                finish();
                Intent intent = new Intent(this, SectionBActivity.class);
                startActivity(intent);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean UpdateDB() {
        Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        rowId = db.addForm(AppMain.fc);

        AppMain.fc.setID(rowId);

        if (rowId != null) {
            AppMain.fc.setUID(
                    (AppMain.fc.getDeviceID() + AppMain.fc.getID()));
            Toast.makeText(this, "Current Form No: " + AppMain.fc.getUID(), Toast.LENGTH_SHORT).show();

            // Update UID of Last Inserted Form
            db.updateFormsUID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        AppMain.fc = new FormsContract();

        AppMain.fc.setTagID(sharedPref.getString("tagName", null));
        AppMain.fc.setFormDate((DateFormat.format("dd-MM-yyyy HH:mm", new Date())).toString());
        AppMain.fc.setInterviewer01(AppMain.loginMem[1]);
        AppMain.fc.setInterviewer02(AppMain.loginMem[2]);

        AppMain.fc.setUccode(enrolledParticipant.getUc_code());
        AppMain.fc.setTehsilcode(enrolledParticipant.getTehsil_code());
        AppMain.fc.setVillagecode(enrolledParticipant.getVillage_code());
        AppMain.fc.setLhwCode(enrolledParticipant.getLhw_code());

        AppMain.fc.setDeviceID(AppMain.deviceId);
        AppMain.fc.setStudyID(studyID.getText().toString());
        AppMain.fc.setFormType(AppMain.formType);

        AppMain.fc.setApp_version(AppMain.versionName + "." + AppMain.versionCode);

        JSONObject sInfo = new JSONObject();
        sInfo.put("puid", enrolledParticipant.getPuid());
        sInfo.put("pw_name", enrolledParticipant.getPw_name());
        sInfo.put("h_name", enrolledParticipant.getH_name());
        sInfo.put("lmp", enrolledParticipant.getLmp());
        sInfo.put("edd", enrolledParticipant.getEdd());
        sInfo.put("fupdt", enrolledParticipant.getFupdt());
        sInfo.put("fupround", enrolledParticipant.getFupround());
        sInfo.put("resp_type", enrolledParticipant.getResp_type());

        sInfo.put(AppMain.formType + "a04", pfa04a.isChecked() ? "1" : pfa04b.isChecked() ? "2" : "0");
        sInfo.put(AppMain.formType + "a06", pfa06a.isChecked() ? "1" : pfa06b.isChecked() ? "2" : "0");

        AppMain.fc.setsInfo(String.valueOf(sInfo));

        setGPS();

    }

    public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);

        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String dt = GPSPref.getString("Time", "0");

            if (lat.equals("0") && lang.equals("0")) {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(dt)).toString();

            AppMain.fc.setGpsLat(lat);
            AppMain.fc.setGpsLng(lang);
            AppMain.fc.setGpsAcc(acc);
            AppMain.fc.setGpsTime(date); // Timestamp is converted to date above

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }

    public boolean ValidateForm() {

        if (!validatorClass.EmptyRadioButton(this, pfa04, pfa04b, getString(R.string.pfa04))) {
            return false;
        }
        return validatorClass.EmptyRadioButton(this, pfa06, pfa06b, getString(R.string.pfa03));
    }

}
