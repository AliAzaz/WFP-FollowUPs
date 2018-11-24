package edu.aku.hassannaqvi.wfp_followups.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivitySectionCBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class SectionCActivity extends AppCompatActivity {


    ActivitySectionCBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c);
        bi.setCallback(this);

        this.setTitle(getString(R.string.pfcheading));

        setupViews();


    }

    private void setupViews() {
        if (AppMain.formType.equals(AppMain.PREGNANTWOMEN)) {
            if (getIntent().getBooleanExtra("pwMonth", false) || InfoActivity.flagLM) {
                bi.pfc0299.setChecked(true);
//            bi.pfc0299.setEnabled(false);
            }
            bi.fldgrpcfc01.setVisibility(View.GONE);
            bi.lblc02sub.setText(getString(R.string.pfc02sub));
        } else if (AppMain.formType.equals(AppMain.CHILD)) {
            if (!getIntent().getBooleanExtra("childMonth", false)) {
                bi.pfc0299.setChecked(true);
            }
            bi.fldgrpcfc01.setVisibility(View.VISIBLE);
            bi.lblc02sub.setText(getString(R.string.cfc02sub));


   /* if (getIntent().getBooleanExtra("pwMonth", false) || InfoActivity.flagLM) {
        bi.pfc0299.setChecked(true);
//            bi.pfc0299.setEnabled(false);
    }*/
        }


        bi.pfc01a.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(AppMain.loginMem)));
        bi.pfc01b.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(AppMain.loginMem)));
        if (AppMain.formType.equals(AppMain.CHILD)) {
            bi.cfc01a.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(AppMain.loginMem)));
            bi.cfc01b.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(AppMain.loginMem)));
        }

        bi.pfc01a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    bi.pfc01b.setSelection(0);
                    bi.pfc01b.setEnabled(false);
                } else {
                    bi.pfc01b.setEnabled(true);

                    String[] users = new String[AppMain.loginMem.length - 1];
                    int j = 0;
                    for (String s : AppMain.loginMem) {
                        if (!s.equals(bi.pfc01a.getSelectedItem().toString())) {
                            users[j] = s;
                            j++;
                        }
                    }

                    bi.pfc01b.setAdapter(new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(users)));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        bi.cfc01a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    bi.cfc01b.setSelection(0);
                    bi.cfc01b.setEnabled(false);
                } else {
                    bi.cfc01b.setEnabled(true);

                    String[] users = new String[AppMain.loginMem.length - 1];
                    int j = 0;
                    for (String s : AppMain.loginMem) {
                        if (!s.equals(bi.cfc01a.getSelectedItem().toString())) {
                            users[j] = s;
                            j++;
                        }
                    }

                    bi.cfc01b.setAdapter(new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(users)));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void BtnContinue() {

        if (formValidation()) {
            try {
                saveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (UpdateDB()) {
                if (AppMain.formType.equals(AppMain.PREGNANTWOMEN)) {
                    startActivity(new Intent(this, SectionDActivity.class)
                            .putExtra("complete", true));
                    finish();
                } else if (AppMain.formType.equals(AppMain.CHILD)) {
                    startActivity(new Intent(this, Child_Section_D.class));
                    finish();
                }


            }
        }

    }

    public void saveDraft() throws JSONException {

        JSONObject sC = new JSONObject();

        sC.put(AppMain.formType + "c01a", bi.pfc01a.getSelectedItem().toString());
        sC.put(AppMain.formType + "c0101", bi.pfc0101.getText().toString());
        sC.put(AppMain.formType + "c01b", bi.pfc01b.getSelectedItem().toString());
        sC.put(AppMain.formType + "c0102", bi.pfc0102.getText().toString());
        sC.put(AppMain.formType + "c02", bi.pfc0299.isChecked() ? "99" : bi.pfc02.getText().toString());

        if (AppMain.formType.equals(AppMain.CHILD)) {
            sC.put(AppMain.formType + "c03a", bi.cfc01a.getSelectedItem().toString());
            sC.put(AppMain.formType + "c0301", bi.cfc0101.getText().toString());
            sC.put(AppMain.formType + "c03b", bi.cfc01b.getSelectedItem().toString());
            sC.put(AppMain.formType + "c0302", bi.cfc0102.getText().toString());
        }
        AppMain.fc.setsC(String.valueOf(sC));

    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updatesC();

        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public boolean formValidation() {
        if (AppMain.formType.equals(AppMain.CHILD)) {
            if (!validatorClass.EmptySpinner(this, bi.cfc01a, getString(R.string.cfc01))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.cfc0101, getString(R.string.cfc01a))) {
                return false;
            }

            if (!validatorClass.PatternTextBox(this, bi.cfc0101, getString(R.string.cfc01a), "^(\\d{3,3}\\.\\d{2,2})$", "XXX.XX")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.cfc0101, 55d, 95d, getString(R.string.cfc01a), "length")) {
                return false;
            }
            if (!validatorClass.EmptySpinner(this, bi.cfc01b, getString(R.string.cfc01))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.cfc0102, getString(R.string.cfc01a))) {
                return false;
            }

            if (!validatorClass.PatternTextBox(this, bi.cfc0102, getString(R.string.cfc01a), "^(\\d{3,3}\\.\\d{2,2})$", "XXX.XX")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.cfc0102, 55d, 95d, getString(R.string.cfc01a), "length")) {
                return false;
            }

        }
        if (!validatorClass.EmptySpinner(this, bi.pfc01a, getString(R.string.pfc01))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.pfc0101, getString(R.string.pfc01a))) {
            return false;
        }

        if (!validatorClass.PatternTextBox(this, bi.pfc0101, getString(R.string.pfc01a), "^(\\d{3,3}\\.\\d{2,2})$", "XXX.XX")) {
            return false;
        }
        if(AppMain.formType.equals(AppMain.PREGNANTWOMEN)){

        if (!validatorClass.RangeTextBox(this, bi.pfc0101, 25d, 120d, getString(R.string.pfc01a), "weight")) {
            return false;
        }
        }else if(AppMain.formType.equals(AppMain.CHILD)){
            if (!validatorClass.RangeTextBox(this, bi.pfc0101, 4d,20d, getString(R.string.pfc01a), "weight")) {
                return false;
            }
        }



        if (!validatorClass.EmptySpinner(this, bi.pfc01b, getString(R.string.pfc01))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.pfc0102, getString(R.string.pfc01a))) {
            return false;
        }

        if (!validatorClass.PatternTextBox(this, bi.pfc0102, getString(R.string.pfc01a), "^(\\d{3,3}\\.\\d{2,2})$", "XXX.XX")) {
            return false;
        }
        if(AppMain.formType.equals(AppMain.PREGNANTWOMEN)){

            if (!validatorClass.RangeTextBox(this, bi.pfc0102, 25d, 120d, getString(R.string.pfc01a), "weight")) {
                return false;
            }
        }else if(AppMain.formType.equals(AppMain.CHILD)){
            if (!validatorClass.RangeTextBox(this, bi.pfc0102, 4d,20d, getString(R.string.pfc01a), "weight")) {
                return false;
            }
        }

        if (!bi.pfc0299.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.pfc02, getString(R.string.pfc02))) {
                return false;
            }

            if (!validatorClass.PatternTextBox(this, bi.pfc02, getString(R.string.pfc02), "^(\\d{2,2}\\.\\d{1,1})$", "XX.X")) {
                return false;
            }
            return validatorClass.RangeTextBox(this, bi.pfc02, 4.0, 20.0, getString(R.string.pfc02), "Range");
        }

        return true;

    }

    public void BtnEnd() {
        AppMain.endActivity(this, this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}
