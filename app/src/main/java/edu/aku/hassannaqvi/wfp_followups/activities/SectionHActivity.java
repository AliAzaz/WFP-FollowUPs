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
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivitySectionHBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class SectionHActivity extends AppCompatActivity {


    ActivitySectionHBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h);
        bi.setCallback(this);

        this.setTitle(getString(R.string.pfhheading));

        setupViews();


    }

    private void setupViews() {

        bi.pfh01a.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(AppMain.loginMem)));
        bi.pfh01b.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(AppMain.loginMem)));
        bi.pfh02a.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(AppMain.loginMem)));
        bi.pfh02b.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(AppMain.loginMem)));

        bi.pfh01a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    bi.pfh01b.setSelection(0);
                    bi.pfh01b.setEnabled(false);
                } else {
                    bi.pfh01b.setEnabled(true);

                    String[] users = new String[AppMain.loginMem.length - 1];
                    int j = 0;
                    for (String s : AppMain.loginMem) {
                        if (!s.equals(bi.pfh01a.getSelectedItem().toString())) {
                            users[j] = s;
                            j++;
                        }
                    }

                    bi.pfh01b.setAdapter(new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(users)));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bi.pfh02a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    bi.pfh02b.setSelection(0);
                    bi.pfh02b.setEnabled(false);
                } else {
                    bi.pfh02b.setEnabled(true);

                    String[] users = new String[AppMain.loginMem.length - 1];
                    int j = 0;
                    for (String s : AppMain.loginMem) {
                        if (!s.equals(bi.pfh02a.getSelectedItem().toString())) {
                            users[j] = s;
                            j++;
                        }
                    }

                    bi.pfh02b.setAdapter(new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, Arrays.asList(users)));
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

                startActivity(new Intent(this, SectionIActivity.class));
                finish();
            }
        }

    }

    public void saveDraft() throws JSONException {

        JSONObject sH = new JSONObject();
        sH.put("pfh01a", bi.pfh01a.getSelectedItem().toString());
        sH.put("pfh0101", bi.pfh0101.getText().toString());
        sH.put("pfh01b", bi.pfh01b.getSelectedItem().toString());
        sH.put("pfh0102", bi.pfh0102.getText().toString());
        sH.put("pfh02a", bi.pfh02a.getSelectedItem().toString());
        sH.put("pfh0201", bi.pfh0201.getText().toString());
        sH.put("pfh02b", bi.pfh02b.getSelectedItem().toString());
        sH.put("pfh0202", bi.pfh0202.getText().toString());
        sH.put("pfh03", bi.pfh0399.isChecked() ? "99" : bi.pfh03.getText().toString());
        AppMain.fc.setsH(String.valueOf(sH));
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updatesH();

        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public boolean formValidation() {

        if (!validatorClass.EmptySpinner(this, bi.pfh01a, getString(R.string.pfh01))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.pfh0101, getString(R.string.pfh01a))) {
            return false;
        }

        if (!validatorClass.PatternTextBox(this, bi.pfh0101, getString(R.string.pfh01a), "^(\\d{3,3}\\.\\d{2,2})$", "XXX.XX")) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.pfh0101, 10d, 140d, getString(R.string.pfh01a), "height")) {
            return false;
        }

        if (!validatorClass.EmptySpinner(this, bi.pfh01b, getString(R.string.pfh01))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.pfh0102, getString(R.string.pfh01a))) {
            return false;
        }

        if (!validatorClass.PatternTextBox(this, bi.pfh0102, getString(R.string.pfh01a), "^(\\d{3,3}\\.\\d{2,2})$", "XXX.XX")) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.pfh0102, 10d, 140d, getString(R.string.pfh01a), "height")) {
            return false;
        }

        if (!validatorClass.EmptySpinner(this, bi.pfh02a, getString(R.string.pfh02))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.pfh0201, getString(R.string.pfh02a))) {
            return false;
        }

        if (!validatorClass.PatternTextBox(this, bi.pfh0201, getString(R.string.pfh02a), "^(\\d{2,2}\\.\\d{2,2})$", "XX.XX")) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.pfh0201, 0.5d, 40d, getString(R.string.pfh02a), "weight")) {
            return false;
        }

        if (!validatorClass.EmptySpinner(this, bi.pfh02b, getString(R.string.pfh02))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.pfh0202, getString(R.string.pfh02a))) {
            return false;
        }

        if (!validatorClass.PatternTextBox(this, bi.pfh0202, getString(R.string.pfh02a), "^(\\d{2,2}\\.\\d{2,2})$", "XX.XX")) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.pfh0202, 0.5d, 40d, getString(R.string.pfh02a), "weight")) {
            return false;
        }

        if (!bi.pfh0399.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.pfh03, getString(R.string.pfh03))) {
                return false;
            }

            if (!validatorClass.PatternTextBox(this, bi.pfh03, getString(R.string.pfh03), "^(\\d{2,2}\\.\\d{1,1})$", "XX.X")) {
                return false;
            }
            return validatorClass.RangeTextBox(this, bi.pfh03, 4.0d, 20.0d, getString(R.string.pfh03), "g/dL");
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
