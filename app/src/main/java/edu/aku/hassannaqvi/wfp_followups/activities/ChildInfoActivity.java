package edu.aku.hassannaqvi.wfp_followups.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
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

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.contracts.EnrolledContract;
import edu.aku.hassannaqvi.wfp_followups.contracts.FormsContract;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivityChildInfoBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class ChildInfoActivity extends AppCompatActivity {
    ActivityChildInfoBinding bi;
    Boolean check = false;
    DatabaseHelper db;
    public static EnrolledContract enrolledParticipant;
    private static final String TAG = InfoActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_child_info);
        bi.setCallback(this);

        this.setTitle(R.string.pfaheading);
        db = new DatabaseHelper(this);

        bi.cfa06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.cfa06b) {
                    bi.btnContinue.setVisibility(View.GONE);
                    bi.btnEnd.setVisibility(View.VISIBLE);
                } else {
                    bi.btnContinue.setVisibility(View.VISIBLE);
                    bi.btnEnd.setVisibility(View.GONE);
                }
            }
        });


        bi.cstudyID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                check = false;
                bi.fldGrpChild.setVisibility(View.GONE);
                bi.cfa06.clearCheck();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void onCheckChildClick() {
        if (!bi.cstudyID.getText().toString().isEmpty()) {
            bi.fldGrpChild.setVisibility(View.VISIBLE);
          /*  enrolledParticipant = db.getEnrolledByStudyID(bi.cstudyID.getText().toString());

            if (enrolledParticipant != null) {

                Long days = AppMain.getDaysBWDates(new Date(), AppMain.stringToDate(enrolledParticipant.getFupdt()));

                if (days > -8 && days < 8) {
                    Toast.makeText(getApplicationContext(), "Participant found", Toast.LENGTH_LONG).show();

                    childData();

                    AppMain.hideKeyboard(this);

                    bi.fldGrpChild.setVisibility(View.VISIBLE);

                    check = true;
                } else {
                    Toast.makeText(this, "Follow Up not found!!", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(getApplicationContext(), "Child Not found", Toast.LENGTH_LONG).show();

                check = false;
            }*/
        } else {

            if (!validatorClass.EmptyTextBox(this, bi.cstudyID, getString(R.string.cfa01))) {
                return;
            }
            bi.fldGrpChild.setVisibility(View.GONE);
        }
    }

    public void childData() {
      /*  bi.viewGroup02.childName.setText(enrolledParticipant.getPw_name());
        bi.viewGroup02.mName.setText(enrolledParticipant.getH_name());
        bi.viewGroup02.cfupround.setText(enrolledParticipant.getFupround());
        bi.viewGroup02.cfupdate.setText(enrolledParticipant.getFupdt());*/
        bi.viewGroup02.childName.setText("Chinko");
        bi.viewGroup02.mName.setText("Pinki");
        bi.viewGroup02.cfupround.setText("1");
        bi.viewGroup02.cfupdate.setText("19-11-2018");
    }
    public void onBtnEndClick() {
//        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                AppMain.endActivity(this, this);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
//        }
    }
    private void SaveDraft() throws JSONException {

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        AppMain.fc = new FormsContract();

        AppMain.fc.setTagID(sharedPref.getString("tagName", null));
        AppMain.fc.setFormDate((DateFormat.format("dd-MM-yyyy HH:mm", new Date())).toString());
        AppMain.fc.setInterviewer01(AppMain.loginMem[1]);
        AppMain.fc.setInterviewer02(AppMain.loginMem[2]);

      /*  AppMain.fc.setUccode(enrolledParticipant.getUc_code());
        AppMain.fc.setTehsilcode(enrolledParticipant.getTehsil_code());
        AppMain.fc.setVillagecode(enrolledParticipant.getVillage_code());
        AppMain.fc.setLhwCode(enrolledParticipant.getLhw_code());*/

        AppMain.fc.setDeviceID(AppMain.deviceId);
        AppMain.fc.setStudyID(bi.cstudyID.getText().toString());
        AppMain.fc.setFormType(AppMain.formType);

        AppMain.fc.setApp_version(AppMain.versionName + "." + AppMain.versionCode);

        JSONObject sInfo = new JSONObject();
       /* sInfo.put("cuid", enrolledParticipant.getPuid());
        sInfo.put("child_name", enrolledParticipant.getPw_name());
        sInfo.put("m_name", enrolledParticipant.getH_name());
        sInfo.put("lmp", enrolledParticipant.getLmp());
        sInfo.put("edd", enrolledParticipant.getEdd());
        sInfo.put("fupdt", enrolledParticipant.getFupdt());
        sInfo.put("fupround", enrolledParticipant.getFupround());
        sInfo.put("resp_type", enrolledParticipant.getResp_type());
        sInfo.put("fup_formdate", enrolledParticipant.getFormdate());*/
        sInfo.put(AppMain.formType + "a06", bi.cfa06a.isChecked() ? "1" : bi.cfa06b.isChecked() ? "2" : "0");


        AppMain.fc.setsInfo(String.valueOf(sInfo));

        setGPS();

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
                Intent intent = new Intent(this, ChildSectionBActivity.class);
                startActivity(intent);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public boolean ValidateForm() {

        return validatorClass.EmptyRadioButton(this, bi.cfa06, bi.cfa06b, getString(R.string.pfa06));

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


}
