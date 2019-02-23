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

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.contracts.FormsContract;
import edu.aku.hassannaqvi.wfp_followups.contracts.PregnancyContract;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivityLmUnscheduledBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class LMUnscheduleActivity extends Activity {

    private static final String TAG = LMUnscheduleActivity.class.getSimpleName();
    public static PregnancyContract curPWParticipant;
    public static boolean serFlagPW = false, flagLM = false;
    static String id = "";
    ActivityLmUnscheduledBinding bi;
    List<String> LHWsName;
    DatabaseHelper db;
    HashMap<String, String> LHWs;
    Boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_lm_unscheduled);
        bi.setCallback(this);

        this.setTitle(R.string.pfaheading);
        db = new DatabaseHelper(this);

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
                bi.pfa04.clearCheck();
                bi.pfa06.clearCheck();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void onCheckParticipantsClick() {
        //TODO implement

        if (!bi.studyID.getText().toString().isEmpty()) {
            curPWParticipant = db.getCurrentPWByStudyID(bi.studyID.getText().toString());

            if (curPWParticipant != null) {

                Toast.makeText(getApplicationContext(), "Current PW found", Toast.LENGTH_LONG).show();
                plwData();
                AppMain.hideKeyboard(this);
                bi.fldGrpParticipant.setVisibility(View.VISIBLE);
                check = true;

                bi.pfa04.check(bi.pfa04b.getId());

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
        bi.viewGroup01.pwName.setText(curPWParticipant.getPw_name());
        bi.viewGroup01.hName.setText(curPWParticipant.getH_name());

        bi.viewGroup01.fuptxt.setText("STUDY ID");
        bi.viewGroup01.fupround.setText(curPWParticipant.getStudyid());

        bi.viewGroup01.fupdate.setText(curPWParticipant.getFormdate());
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
                        .putExtra("valCheck", bi.pfa04a.isChecked());
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

        AppMain.fc.setUccode(curPWParticipant.getUc_code());
        AppMain.fc.setTehsilcode(curPWParticipant.getTehsil_code());
        AppMain.fc.setVillagecode(curPWParticipant.getVillage_code());
        AppMain.fc.setLhwCode(curPWParticipant.getLhw_code());

        AppMain.fc.setDeviceID(AppMain.deviceId);
        AppMain.fc.setStudyID(bi.studyID.getText().toString());
        AppMain.fc.setFormType(AppMain.formType);

        AppMain.fc.setApp_version(AppMain.versionName + "." + AppMain.versionCode);

        JSONObject sInfo = new JSONObject();
        sInfo.put("puid", curPWParticipant.getPuid());
        sInfo.put("pw_name", curPWParticipant.getPw_name());
        sInfo.put("h_name", curPWParticipant.getH_name());
        sInfo.put("fup_formdate", curPWParticipant.getFormdate());
        sInfo.put("resp_type", "unscheduled_lm");

        sInfo.put(AppMain.formType + "a04", bi.pfa04a.isChecked() ? "1" : bi.pfa04b.isChecked() ? "2" : "0");
        sInfo.put(AppMain.formType + "a06", bi.pfa06a.isChecked() ? "1" : bi.pfa06b.isChecked() ? "2" : "0");

        flagLM = bi.pfa04b.isChecked();
        serFlagPW = false;

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
