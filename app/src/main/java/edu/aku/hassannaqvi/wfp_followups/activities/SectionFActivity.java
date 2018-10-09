package edu.aku.hassannaqvi.wfp_followups.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivitySectionFBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.ClearClass;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class SectionFActivity extends AppCompatActivity {


    ActivitySectionFBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f);
        bi.setCallback(this);

        setTitle("ANC & Morbidity");


        //============================Skip Patterns===============================

        bi.pff01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff01b) {
                    bi.fldgrppff02.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppff02, false);
                    bi.fldgrppff03.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppff03, false);
                    bi.fldgrppff04.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppff04, false);
                    bi.fldgrppff05.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppff05, false);
                } else {
                    bi.fldgrppff02.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppff02, true);
                    bi.fldgrppff03.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppff03, true);
                    bi.fldgrppff04.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppff04, true);
                    bi.fldgrppff05.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppff05, true);
                }
            }
        });

        bi.pff06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff06b) {
                    bi.fldgrppff07.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppff07, false);
                } else {
                    bi.fldgrppff07.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppff07, true);
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

                startActivity(new Intent(this, EndingActivity.class)
                        .putExtra("complete", true));
                finish();
            }
        }

    }

    private boolean UpdateDB() {

        return true;
    }

    private void saveDraft() throws JSONException {

        JSONObject sF = new JSONObject();
        sF.put("pff01", bi.pff01a.isChecked() ? "1" : bi.pff01b.isChecked() ? "2" : "0");
        sF.put("pff02a", bi.pff02a.isChecked() ? "1" : "0");
        sF.put("pff02b", bi.pff02b.isChecked() ? "2" : "0");
        sF.put("pff02c", bi.pff02c.isChecked() ? "3" : "0");
        sF.put("pff02d", bi.pff02d.isChecked() ? "4" : "0");
        sF.put("pff02e", bi.pff02e.isChecked() ? "5" : "0");
        sF.put("pff02f", bi.pff02f.isChecked() ? "6" : "0");
        sF.put("pff02g", bi.pff02g.isChecked() ? "7" : "0");
        sF.put("pff02h", bi.pff02h.isChecked() ? "8" : "0");
        sF.put("pff0296", bi.pff0296.isChecked() ? "96" : "0");
        sF.put("pff0296x", bi.pff0296x.getText().toString());
        sF.put("pff03a", bi.pff03a.isChecked() ? "1" : "0");
        sF.put("pff03b", bi.pff03b.isChecked() ? "2" : "0");
        sF.put("pff03c", bi.pff03c.isChecked() ? "3" : "0");
        sF.put("pff03d", bi.pff03d.isChecked() ? "4" : "0");
        sF.put("pff0396", bi.pff0396.isChecked() ? "96" : "0");
        sF.put("pff0396x", bi.pff0396x.getText().toString());

        sF.put("pff04a", bi.pff04a.isChecked() ? "1" : "0");
        sF.put("pff04b", bi.pff04b.isChecked() ? "2" : "0");
        sF.put("pff04c", bi.pff04c.isChecked() ? "3" : "0");
        sF.put("pff04d", bi.pff04d.isChecked() ? "4" : "0");
        sF.put("pff04e", bi.pff04e.isChecked() ? "5" : "0");
        sF.put("pff0496", bi.pff0496.isChecked() ? "96" : "0");
        sF.put("pff0496x", bi.pff0496x.getText().toString());
        sF.put("pff05", bi.pff05a.isChecked() ? "1" : bi.pff05b.isChecked() ? "2" : "0");
        sF.put("pff06", bi.pff06a.isChecked() ? "1" : bi.pff06b.isChecked() ? "2" : "0");
        sF.put("pff07d", bi.pff07d.getText().toString());
        sF.put("pff07", bi.pff07d.isChecked() ? "1" : bi.pff0797.isChecked() ? "97" : bi.pff0798.isChecked() ? "98" : "0");
        sF.put("pff08", bi.pff08a.isChecked() ? "1" : bi.pff08b.isChecked() ? "2" : "0");
        sF.put("pff0901", bi.pff0901a.isChecked() ? "1" : bi.pff0901b.isChecked() ? "2" : "0");
        sF.put("pff0902", bi.pff0902a.isChecked() ? "1" : bi.pff0902b.isChecked() ? "2" : "0");
        sF.put("pff0903", bi.pff0903a.isChecked() ? "1" : bi.pff0903b.isChecked() ? "2" : "0");
        sF.put("pff0904", bi.pff0904a.isChecked() ? "1" : bi.pff0904b.isChecked() ? "2" : "0");
        sF.put("pff0905", bi.pff0905a.isChecked() ? "1" : bi.pff0905b.isChecked() ? "2" : "0");
        sF.put("pff0906", bi.pff0906a.isChecked() ? "1" : bi.pff0906b.isChecked() ? "2" : "0");
        sF.put("pff0907", bi.pff0907a.isChecked() ? "1" : bi.pff0907b.isChecked() ? "2" : "0");
        sF.put("pff0908", bi.pff0908a.isChecked() ? "1" : bi.pff0908b.isChecked() ? "2" : "0");
        sF.put("pff0909", bi.pff0909a.isChecked() ? "1" : bi.pff0909b.isChecked() ? "2" : "0");
        sF.put("pff0910", bi.pff0910a.isChecked() ? "1" : bi.pff0910b.isChecked() ? "2" : "0");
        sF.put("pff0911", bi.pff0911a.isChecked() ? "1" : bi.pff0911b.isChecked() ? "2" : "0");
        sF.put("pff0912", bi.pff0912a.isChecked() ? "1" : bi.pff0912b.isChecked() ? "2" : "0");
        sF.put("pff0913", bi.pff0913a.isChecked() ? "1" : bi.pff0913b.isChecked() ? "2" : "0");
        sF.put("pff0914", bi.pff0914a.isChecked() ? "1" : bi.pff0914b.isChecked() ? "2" : "0");
        sF.put("pff0996", bi.pff0996a.isChecked() ? "1" : bi.pff0996b.isChecked() ? "2" : "0");
        sF.put("pff0996x", bi.pff0996x.getText().toString());
        sF.put("pff0998", bi.pff0998.isChecked() ? "98" : "0");
        sF.put("pff10", bi.pff10a.isChecked() ? "1" : bi.pff10b.isChecked() ? "2" : "0");

        sF.put("pff11a", bi.pff11a.isChecked() ? "1" : "0");
        sF.put("pff11b", bi.pff11b.isChecked() ? "2" : "0");
        sF.put("pff11c", bi.pff11c.isChecked() ? "3" : "0");
        sF.put("pff11d", bi.pff11d.isChecked() ? "4" : "0");
        sF.put("pff11e", bi.pff11e.isChecked() ? "5" : "0");
        sF.put("pff11f", bi.pff11f.isChecked() ? "6" : "0");
        sF.put("pff11g", bi.pff11g.isChecked() ? "7" : "0");
        sF.put("pff11h", bi.pff11h.isChecked() ? "8" : "0");
        sF.put("pff1196", bi.pff1196.isChecked() ? "96" : "0");
        sF.put("pff1196x", bi.pff1196x.getText().toString());


    }

    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.pff01, bi.pff01a, getString(R.string.pff01))) {
            return false;
        }
        if (!bi.pff01b.isChecked()) {
            if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppff02, bi.pff02a, getString(R.string.pff02))) {
                return false;
            }
            if (bi.pff0296.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pff0296x, getString(R.string.pff02))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppff03, bi.pff03a, getString(R.string.pff03))) {
                return false;
            }
            if (bi.pff0396.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pff0396x, getString(R.string.pff03))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppff04, bi.pff04a, getString(R.string.pff04))) {
                return false;
            }
            if (bi.pff0496.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pff0496x, getString(R.string.pff04))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pff05, bi.pff05a, getString(R.string.pff05))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pff06, bi.pff06a, getString(R.string.pff06))) {
            return false;
        }
        if (!bi.pff06b.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.pff07, bi.pff07d, getString(R.string.pff07))) {
                return false;
            }
            if (bi.pff07d.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pff07dx, getString(R.string.pff07))) {
                    return false;
                }
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pff08, bi.pff08a, getString(R.string.pff08))) {
            return false;
        }
        if (!bi.pff0998.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.pff0901, bi.pff0901a, getString(R.string.pff09))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.pff0902, bi.pff0902a, getString(R.string.pff09))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.pff0903, bi.pff0903a, getString(R.string.pff09))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.pff0904, bi.pff0904a, getString(R.string.pff09))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.pff0905, bi.pff0905a, getString(R.string.pff09))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.pff0906, bi.pff0906a, getString(R.string.pff09))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pff0907, bi.pff0907a, getString(R.string.pff09))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pff0908, bi.pff0908a, getString(R.string.pff09))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pff0909, bi.pff0909a, getString(R.string.pff09))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pff0910, bi.pff0910a, getString(R.string.pff09))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pff0911, bi.pff0911a, getString(R.string.pff09))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pff0912, bi.pff0912a, getString(R.string.pff09))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pff0913, bi.pff0913a, getString(R.string.pff09))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pff0914, bi.pff0914a, getString(R.string.pff09))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pff0996, bi.pff0996a, getString(R.string.pff09))) {
                return false;
            }
            if (bi.pff0996a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pff0996x, getString(R.string.pff09))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pff10, bi.pff10a, getString(R.string.pff10))) {
                return false;
            }
            if (!bi.pff10b.isChecked()) {
                if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppff11, bi.pff11a, getString(R.string.pff11))) {
                    return false;
                }
                if (bi.pff1196.isChecked()) {
                    return validatorClass.EmptyTextBox(this, bi.pff1196x, getString(R.string.pff11));
                }
            }
        }


        return true;
    }

    public void BtnEnd() {
        AppMain.endActivity(this, this);
    }
}
