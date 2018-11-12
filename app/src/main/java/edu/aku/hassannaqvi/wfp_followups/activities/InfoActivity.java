package edu.aku.hassannaqvi.wfp_followups.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
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

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.contracts.EnrolledContract;
import edu.aku.hassannaqvi.wfp_followups.contracts.FormsContract;
import edu.aku.hassannaqvi.wfp_followups.contracts.LHWsContract;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivityInfoBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class InfoActivity extends Activity {

    ActivityInfoBinding bi;

    private static final String TAG = InfoActivity.class.getSimpleName();
    static String id = "";
    List<String> LHWsName;
    DatabaseHelper db;
    HashMap<String, String> LHWs;
    Boolean check = false;
    public static EnrolledContract enrolledParticipant;
    //    @BindView(R.id.studyID)
//    EditText studyID;
//    @BindView(R.id.pfa01)
//    EditText pfa01;
//    @BindView(R.id.pfa04)
//    RadioGroup pfa04;
//    @BindView(R.id.pfa04a)
//    RadioButton pfa04a;
//    @BindView(R.id.pfa04b)
//    RadioButton pfa04b;
//    @BindView(R.id.pfa06)
//    RadioGroup pfa06;
//    @BindView(R.id.pfa06a)
//    RadioButton pfa06a;
//    @BindView(R.id.pfa06b)
//    RadioButton pfa06b;
//    @BindView(R.id.btn_Continue)
//    Button btn_Continue;
//    @BindView(R.id.fldGrpParticipant)
//    LinearLayout fldGrpParticipant;
    int position;

    public static boolean flagLM = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        bi = DataBindingUtil.setContentView(this, R.layout.activity_info);
        bi.setCallback(this);

//        bi.fldgrppfa01.

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


        bi.pfa06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.pfa06b) {
                    bi.btnContinue.setVisibility(View.GONE);
                    bi.btnEnd.setVisibility(View.VISIBLE);
                } else {
                    bi.btnContinue.setVisibility(View.VISIBLE);
                    bi.btnEnd.setVisibility(View.GONE);
                }
            }
        });

        bi.studyID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                check = false;
                bi.fldGrpParticipant.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void onCheckParticipantsClick() {
        //TODO implement

        if (!bi.studyID.getText().toString().isEmpty()) {
            enrolledParticipant = db.getEnrolledByStudyID(bi.studyID.getText().toString());

            if (enrolledParticipant != null) {

                Long days = AppMain.getDaysBWDates(new Date(), AppMain.stringToDate(enrolledParticipant.getFupdt()));

                if (days > -8 && days < 8) {
                    Toast.makeText(getApplicationContext(), "Participant found", Toast.LENGTH_LONG).show();

                    plwData();

                    AppMain.hideKeyboard(this);

                    bi.fldGrpParticipant.setVisibility(View.VISIBLE);

                    check = true;
                } else {
                    Toast.makeText(this, "Follow Up not found!!", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(getApplicationContext(), "Participant Not found", Toast.LENGTH_LONG).show();

                check = false;
            }
        } else {

            if (!validatorClass.EmptyTextBox(this, bi.studyID, getString(R.string.studyID))) {
                return;
            }
        }

    }

    public void plwData() {
        bi.viewGroup01.pwName.setText(enrolledParticipant.getPw_name());
        bi.viewGroup01.hName.setText(enrolledParticipant.getH_name());
        bi.viewGroup01.fupround.setText(enrolledParticipant.getFupround());
        bi.viewGroup01.fupdate.setText(enrolledParticipant.getFupdt());
    }


    public void onBtnEndClick() {
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


    public void onBtnContinueClick() {
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                finish();
                Intent intent = new Intent(this, SectionBActivity.class)
                        .putExtra("valCheck", bi.pfa04a.isChecked() ? 1 : 2);
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
        AppMain.fc.setStudyID(bi.studyID.getText().toString());
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
        sInfo.put("fup_formdate", enrolledParticipant.getFormdate());

        sInfo.put(AppMain.formType + "a04", bi.pfa04a.isChecked() ? "1" : bi.pfa04b.isChecked() ? "2" : "0");
        sInfo.put(AppMain.formType + "a06", bi.pfa06a.isChecked() ? "1" : bi.pfa06b.isChecked() ? "2" : "0");

        flagLM = bi.pfa04b.isChecked();

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

        if (!validatorClass.EmptyRadioButton(this, bi.pfa04, bi.pfa04b, getString(R.string.pfa04))) {
            return false;
        }
        return validatorClass.EmptyRadioButton(this, bi.pfa06, bi.pfa06b, getString(R.string.pfa03));
    }

}
