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

public class InfoActivity extends Activity {

    private static final String TAG = InfoActivity.class.getSimpleName();
    static String id = "";
    List<String> LHWsName;
    DatabaseHelper db;
    HashMap<String, String> LHWs;
    Boolean check = false;
    Collection<EnrolledContract> enrolledParticipant;
    //    @BindView(R.id.app_header)
//    TextView appHeader;
//    @BindView(R.id.mp08a001)
//    EditText mp08a001;
//    @BindView(R.id.mp08a002)
//    EditText mp08a002;
//    @BindView(R.id.mp08a003)
//    Spinner mp08a003;
//    @BindView(R.id.lhws)
//    Spinner lhws;
//    @BindView(R.id.mp08a005)
//    EditText mp08a005;
//    @BindView(R.id.mp08a008)
//    EditText mp08a008;
//    @BindView(R.id.mp08a007)
//    EditText mp08a007;
    @BindView(R.id.mp08a013)
    RadioGroup mp08a013;
    @BindView(R.id.mp08a01301)
    RadioButton mp08a01301;
    @BindView(R.id.mp08a01302)
    RadioButton mp08a01302;
    @BindView(R.id.btn_Continue)
    Button btn_Continue;
    @BindView(R.id.fldGrpParticipant)
    LinearLayout fldGrpParticipant;
    ArrayList<String> partNames;
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
//        lhws.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, LHWsName));
//
//        lhws.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//
//                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorPrimary));
//                ((TextView) parent.getChildAt(0)).setTextSize(28);
//                Log.d("Selected LHWs", LHWs.get(lhws.getSelectedItem().toString()));
//
//
//                mp08a001.setText(null);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        mp08a013.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.mp08a01302) {
                    btn_Continue.setVisibility(View.GONE);
                } else {
                    btn_Continue.setVisibility(View.VISIBLE);

                }
            }
        });
//        mp08a003.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                mp08a002.setText(AppMain.Eparticipant.get(i).getSno());
//
//
//                position = i;
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


        if (AppMain.formType.equals("15")) {
            AppMain.ftype = "mp15";
            this.setTitle(getResources().getString(R.string.app_name15));
        } else if (AppMain.formType.equals("16")) {
            AppMain.ftype = "mp16";
            this.setTitle(getResources().getString(R.string.app_name16));
        }

    }

    @OnTextChanged(value = R.id.mp08a001,
            callback = OnTextChanged.Callback.TEXT_CHANGED)
    void aftermp08a001Input(Editable editable) {
        check = false;
        fldGrpParticipant.setVisibility(View.GONE);
    }


    @OnClick(R.id.checkParticipants)
    void onCheckParticipantsClick() {
        //TODO implement

        //enrolledParticipant = db.getEnrolledByHousehold(AppMain.curCluster, LHWs.get(lhws.getSelectedItem().toString()), mp08a001.getText().toString());

        if (enrolledParticipant.size() != 0) {

            Toast.makeText(getApplicationContext(), "Participant found", Toast.LENGTH_LONG).show();

            AppMain.Eparticipant = new ArrayList<>();

            partNames = new ArrayList<>();

            partNames.add("....");
            AppMain.Eparticipant.add(new EnrolledContract());

            for (EnrolledContract ec : enrolledParticipant) {
                AppMain.Eparticipant.add(new EnrolledContract(ec));

                partNames.add(ec.getWomen_name().replaceFirst(String.valueOf(ec.getWomen_name().charAt(0)),
                        String.valueOf(ec.getWomen_name().toUpperCase().charAt(0))));
            }
            fldGrpParticipant.setVisibility(View.VISIBLE);

            check = true;

            //mp08a003.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, partNames));


        } else {
            Toast.makeText(getApplicationContext(), "Participant Not found", Toast.LENGTH_LONG).show();

            check = false;
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
        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();

        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();
                if (AppMain.formType.equals("15")) {

                    Intent intent = new Intent(this, SectionBActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(this, SectionBActivity.class);
                    startActivity(intent);
                }
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
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
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
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        AppMain.fc = new FormsContract();

        AppMain.fc.setSurveyType(AppMain.ftype.equals("mp15") ? "Exit Questionnaire" : "End of Study Participation");
        AppMain.fc.setTagID(sharedPref.getString("tagName", null));
        AppMain.fc.setFormDate((DateFormat.format("dd-MM-yyyy HH:mm", new Date())).toString());
        AppMain.fc.setInterviewer01(AppMain.loginMem[1]);
        AppMain.fc.setInterviewer02(AppMain.loginMem[2]);
        AppMain.fc.setClustercode(AppMain.curCluster);
        //AppMain.fc.setHousehold(mp08a001.getText().toString());
        AppMain.fc.setDeviceID(AppMain.deviceId);
        AppMain.fc.setSno(AppMain.Eparticipant.get(position).getSno());
        AppMain.fc.setFormType(AppMain.formType);
        // AppMain.fc.setVillageacode(mp08a007.getText().toString());

        AppMain.fc.setLhwCode(AppMain.Eparticipant.get(position).getLhwCode());
        AppMain.fc.setApp_version(AppMain.versionName + "." + AppMain.versionCode);

        // id = AppMain.curCluster + AppMain.Eparticipant.get(position).getLhwCode() + mp08a001.getText().toString() + AppMain.Eparticipant.get(position).getSno();

        JSONObject sInfo = new JSONObject();

        sInfo.put("luid", AppMain.Eparticipant.get(position).getLUID());
//        sInfo.put("uid_f4", AppMain.Eparticipant.get(position).getS1());
        //sInfo.put(AppMain.ftype + "a003", mp08a003.getSelectedItem().toString());
        //sInfo.put(AppMain.ftype + "a005", mp08a005.getText().toString());
        //sInfo.put(AppMain.ftype + "a008", mp08a008.getText().toString());
        sInfo.put(AppMain.ftype + "a013", mp08a01301.isChecked() ? "1" : mp08a01302.isChecked() ? "2" : "0");

        AppMain.fc.setsInfo(String.valueOf(sInfo));

        setGPS();

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);

//        String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String dt = GPSPref.getString("Time", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            AppMain.fc.setGpsLat(GPSPref.getString("Latitude", "0"));
            AppMain.fc.setGpsLng(GPSPref.getString("Longitude", "0"));
            AppMain.fc.setGpsAcc(GPSPref.getString("Accuracy", "0"));
            AppMain.fc.setGpsTime(date); // Timestamp is converted to date above

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }

    public boolean ValidateForm() {

        //======================= Q 1 ===============

//        if (mp08a001.getText().toString().isEmpty()) {
//            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.mp08a001), Toast.LENGTH_SHORT).show();
//            mp08a001.setError("This data is Required!");
//            Log.i(TAG, "mp08a001: This Data is Required!");
//            mp08a001.requestFocus();
//            return false;
//        } else {
//            mp08a001.setError(null);
//        }

        //======================= Q 3 ===============

//        if (mp08a003.getSelectedItem() == "....") {
////        if (mp08a003.getSelectedItem().equals("")) {
//            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.mp08a003), Toast.LENGTH_SHORT).show();
//            ((TextView) mp08a003.getSelectedView()).setText("This Data is Required");
//            ((TextView) mp08a003.getSelectedView()).setError("This Data is Required");
//            ((TextView) mp08a003.getSelectedView()).setTextColor(Color.RED);
//            mp08a003.requestFocus();
//
//            Log.i(TAG, "mp08a003: This Data is Required!");
//            return false;
//        } else {
//            ((TextView) mp08a003.getSelectedView()).setError(null);
//        }

        //======================= Q 2 ===============

//        if (mp08a002.getText().toString().isEmpty()) {
//            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.mp08a002), Toast.LENGTH_SHORT).show();
//            mp08a002.setError("This data is Required!");
//            mp08a002.requestFocus();
//            Log.i(TAG, "mp08a002: This Data is Required!");
//            return false;
//        } else {
//            mp08a002.setError(null);
//        }

        /*if (mp08a003.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.mp08a003), Toast.LENGTH_SHORT).show();
            mp08a003.setError("This data is Required!");

            Log.i(TAG, "mp08a003: This Data is Required!");
            return false;
        } else {
            mp08a003.setError(null);
        }*/

//        if (mp08a005.getText().toString().isEmpty()) {
//            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.mp08a005), Toast.LENGTH_SHORT).show();
//            mp08a005.setError("This data is Required!");
//            mp08a005.requestFocus();
//            Log.i(TAG, "mp08a005: This Data is Required!");
//            return false;
//        } else {
//            mp08a005.setError(null);
//        }
//
//        if (mp08a007.getText().toString().isEmpty()) {
//            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.mp08a006), Toast.LENGTH_SHORT).show();
//            mp08a007.setError("This data is Required!");
//            mp08a007.requestFocus();
//            Log.i(TAG, "mp08a007: This Data is Required!");
//            return false;
//        } else {
//            mp08a007.setError(null);
//        }

//        if (mp08a008.getText().toString().isEmpty()) {
//            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.mp08a008), Toast.LENGTH_SHORT).show();
//            mp08a008.setError("This data is Required!");
//            mp08a008.requestFocus();
//            Log.i(TAG, "mp08a008: This Data is Required!");
//            return false;
//        } else {
//            mp08a008.setError(null);
//        }


        if (mp08a013.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.mp08a013), Toast.LENGTH_SHORT).show();
            mp08a01302.setError("This data is Required!");
            mp08a01302.setFocusable(true);
            mp08a01302.setFocusableInTouchMode(true);
            mp08a01302.requestFocus();
            Log.i(TAG, "mp08a013: This Data is Required!");
            return false;
        } else {
            mp08a01302.setError(null);
        }


        return true;
    }

    /*@Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
*/

}
