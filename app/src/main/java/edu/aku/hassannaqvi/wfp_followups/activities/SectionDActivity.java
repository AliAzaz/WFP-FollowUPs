package edu.aku.hassannaqvi.wfp_followups.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivitySectionDBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.ClearClass;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class SectionDActivity extends AppCompatActivity {

    ActivitySectionDBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d);
        bi.setCallback(this);

        this.setTitle(R.string.pfdheading);


        //=====================Skip patterns=============================

        bi.pfd01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.pfd01a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrppda, true);

                    if (i == bi.pfd01b.getId()) {
                        ClearClass.ClearAllCardFields(bi.fldgrppd12, true);
                    }
                } else {
                    ClearClass.ClearAllCardFields(bi.fldgrppd12, true);
                }
            }
        });

        bi.pfd06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.pfd06b) {
                    bi.fldgrppd07.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppd07, false);
                } else {
                    bi.fldgrppd07.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppd07, true);
                }
            }
        });

        bi.pfd08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfd08b) {

                    bi.fldgrppd09.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppd09, false);
                    bi.fldgrppd10.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppd10, false);
                    bi.fldgrppd11.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppd11, false);

                } else {

                    bi.fldgrppd09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppd09, true);
                    bi.fldgrppd10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppd10, true);
                    bi.fldgrppd11.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppd11, true);
                }
            }
        });

        bi.pfd1198.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    bi.pfd11a.setChecked(false);
                    bi.pfd11a.setEnabled(false);
                    bi.pfd11b.setChecked(false);
                    bi.pfd11b.setEnabled(false);
                    bi.pfd11c.setChecked(false);
                    bi.pfd11c.setEnabled(false);
                    bi.pfd1196.setChecked(false);
                    bi.pfd1196.setEnabled(false);
                    bi.pfd1196x.setText(null);
                } else {
                    bi.pfd11a.setEnabled(true);
                    bi.pfd11b.setEnabled(true);
                    bi.pfd11c.setEnabled(true);
                    bi.pfd1196.setEnabled(true);
                }
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

                startActivity(new Intent(this, SectionEActivity.class));
                finish();
            }
        }

    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updatesD();

        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void saveDraft() throws JSONException {

        JSONObject sD = new JSONObject();
        sD.put("pfd01", bi.pfd01a.isChecked() ? "1"
                : bi.pfd01b.isChecked() ? "2"
                : bi.pfd01c.isChecked() ? "3" : "0");
        sD.put("pfd01reason", bi.pfd01bx.getText().toString());
        sD.put("pfd02", bi.pfd02.getText().toString());
        sD.put("pfd03", bi.pfd03.getText().toString());
        sD.put("pfd04d", bi.pfd04a.getText().toString());
        sD.put("pfd04sachet", bi.pfd04b.getText().toString());
        sD.put("pfd05a", bi.pfd05a.getText().toString());
        sD.put("pfd05b", bi.pfd05b.getText().toString());
        sD.put("pfd06", bi.pfd06a.isChecked() ? "1" : bi.pfd06b.isChecked() ? "2" : "0");
        sD.put("pfd07a", bi.pfd07a.isChecked() ? "1" : "0");
        sD.put("pfd07b", bi.pfd07b.isChecked() ? "2" : "0");
        sD.put("pfd07c", bi.pfd07c.isChecked() ? "3" : "0");
        sD.put("pfd07d", bi.pfd07d.isChecked() ? "4" : "0");
        sD.put("pfd0796", bi.pfd0796.isChecked() ? "96" : "0");
        sD.put("pfd0796x", bi.pfd0796x.getText().toString());
        sD.put("pfd08", bi.pfd08a.isChecked() ? "1" : bi.pfd08b.isChecked() ? "2" : "0");
        sD.put("pfd09a", bi.pfd09a.isChecked() ? "2" : "0");
        sD.put("pfd09b", bi.pfd09b.isChecked() ? "3" : "0");
        sD.put("pfd09c", bi.pfd09c.isChecked() ? "4" : "0");
        sD.put("pfd0996", bi.pfd0996.isChecked() ? "96" : "0");
        sD.put("pfd0996x", bi.pfd0996x.getText().toString());
        sD.put("pfd10", bi.pfd10.getText().toString());
        sD.put("pfd11a", bi.pfd11a.isChecked() ? "1" : "0");
        sD.put("pfd11b", bi.pfd11b.isChecked() ? "2" : "0");
        sD.put("pfd11c", bi.pfd11c.isChecked() ? "3" : "0");
        sD.put("pfd1196", bi.pfd1196.isChecked() ? "96" : "0");
        sD.put("pfd1196x", bi.pfd1196x.getText().toString());
        sD.put("pfd1198", bi.pfd1198.isChecked() ? "98" : "0");
        sD.put("pfd12a", bi.pfd12a.isChecked() ? "1" : "0");
        sD.put("pfd12b", bi.pfd12b.isChecked() ? "2" : "0");
        sD.put("pfd12c", bi.pfd12c.isChecked() ? "3" : "0");
        sD.put("pfd12d", bi.pfd12d.isChecked() ? "4" : "0");
        sD.put("pfd12e", bi.pfd12e.isChecked() ? "5" : "0");
        sD.put("pfd12f", bi.pfd12f.isChecked() ? "6" : "0");
        sD.put("pfd12g", bi.pfd12g.isChecked() ? "7" : "0");
        sD.put("pfd1296", bi.pfd1296.isChecked() ? "96" : "0");
        sD.put("pfd1196x", bi.pfd1196x.getText().toString());
        sD.put("pfd1296x", bi.pfd1296x.getText().toString());

        AppMain.fc.setsD(String.valueOf(sD));

    }

    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.pfd01, bi.pfd01a, getString(R.string.pfd01))) {
            return false;
        }
        if (bi.pfd01a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.pfd02, getString(R.string.pfd02))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.pfd03, getString(R.string.pfd03))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.pfd03, 1, 3, getString(R.string.pfd03), "Sachets")) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.pfd04a, getString(R.string.pfd04))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.pfd04a, 1, 31, getString(R.string.pfd04), "Days")) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.pfd04b, getString(R.string.pfd04))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.pfd04b, 1, 31, getString(R.string.pfd04), "Sachets")) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.pfd05a, getString(R.string.pfd05))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.pfd05b, getString(R.string.pfd05))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfd06, bi.pfd06a, getString(R.string.pfd06))) {
                return false;
            }
            if (!bi.pfd06b.isChecked()) {
                if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppd07, bi.pfd07a, getString(R.string.pfd07))) {
                    return false;
                }
                if (bi.pfd0796.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfd0796x, getString(R.string.pfd07))) {
                        return false;
                    }
                }

            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfd08, bi.pfd08a, getString(R.string.pfd08))) {
                return false;
            }
            if (!bi.pfd08b.isChecked()) {
                if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppd09, bi.pfd09a, getString(R.string.pfd09))) {
                    return false;
                }
                if (bi.pfd0996.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfd0996x, getString(R.string.pfd09))) {
                        return false;
                    }
                }
                if (!validatorClass.EmptyTextBox(this, bi.pfd10, getString(R.string.pfd10))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.pfd10, 1, 90, getString(R.string.pfd10), "Sachets")) {
                    return false;
                }
                if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppd11, bi.pfd11a, getString(R.string.pfd11))) {
                    return false;
                }
                if (!bi.pfd1198.isChecked()) {
                    if (bi.pfd1196.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.pfd1196x, getString(R.string.pfd11))) {
                            return false;
                        }
                    }
                }
            }
        }

        if (bi.pfd01b.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.pfd01bx, getString(R.string.pfd01))) {
                return false;
            }
        }

        if (bi.pfd01c.isChecked()) {
            if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppd12, bi.pfd12a, getString(R.string.pfd12))) {
                return false;
            }
            if (bi.pfd1296.isChecked()) {
                return validatorClass.EmptyTextBox(this, bi.pfd1296x, getString(R.string.pfd12));
            }
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
