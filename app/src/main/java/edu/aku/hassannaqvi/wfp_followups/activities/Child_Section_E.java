package edu.aku.hassannaqvi.wfp_followups.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivityChildSectionEBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.ClearClass;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class Child_Section_E extends AppCompatActivity {


    ActivityChildSectionEBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_child__section__e);
        bi.setCallback(this);

        bi.cfe0197.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.fldgrpcfemain.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccg01a, false);
                } else {
                    bi.fldgrpcfemain.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccg01a, true);
                }
            }
        });

        bi.cfe02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == bi.cfe02b.getId()) {
                    bi.fldgrpcfe03.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpcfe03, false);
                    bi.fldgrpcfe04.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpcfe04, false);
                } else {
                    bi.fldgrpcfe03.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpcfe03, true);
                    bi.fldgrpcfe04.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpcfe04, true);
                }
            }
        });
    }


    public void BtnContinue() {

        if (formValidation()) {
            Toast.makeText(this, "validated", Toast.LENGTH_SHORT).show();
            try {
                saveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

//                startActivity(new Intent(this, bi.pfb01a.isChecked() && !bi.pfb02b.isChecked() ? SectionCActivity.class : EndingActivity.class)
//                        .putExtra("complete", true)
//                        .putExtra("pwMonth", !bi.pfb03.getText().toString().isEmpty() && (Integer.valueOf(bi.pfb03.getText().toString()) < 9)));
                // finish();
            }
        }

    }

    private void saveDraft() throws JSONException {

        JSONObject cfE = new JSONObject();
        cfE.put("cfe01a", bi.cfe01a01.isChecked() ? "1" : bi.cfe01a01.isChecked() ? "2" : "0");
        cfE.put("cfe01b", bi.cfe01b01.isChecked() ? "1" : bi.cfe01b01.isChecked() ? "2" : "0");
        cfE.put("cfe01c", bi.cfe01c01.isChecked() ? "1" : bi.cfe01c01.isChecked() ? "2" : "0");
        cfE.put("cfe01d", bi.cfe01d01.isChecked() ? "1" : bi.cfe01d01.isChecked() ? "2" : "0");
        cfE.put("cfe01e", bi.cfe01e01.isChecked() ? "1" : bi.cfe01e01.isChecked() ? "2" : "0");
        cfE.put("cfe01f", bi.cfe01f01.isChecked() ? "1" : bi.cfe01f01.isChecked() ? "2" : "0");
        cfE.put("cfe01g", bi.cfe01g01.isChecked() ? "1" : bi.cfe01g01.isChecked() ? "2" : "0");
        cfE.put("cfe01h", bi.cfe01h01.isChecked() ? "1" : bi.cfe01h01.isChecked() ? "2" : "0");
        cfE.put("cfe0196", bi.cfe019601.isChecked() ? "1" : bi.cfe019601.isChecked() ? "2" : "0");
        cfE.put("cfe0196x", bi.cfe0196x.getText().toString());
        cfE.put("cfe0197", bi.cfe0197.isChecked() ? "97" : "0");

        cfE.put("cfe02", bi.cfe02a.isChecked() ? "1" : bi.cfe02b.isChecked() ? "2" : "0");

        cfE.put("cfe03a", bi.cfe03a.isChecked() ? "1" : "0");
        cfE.put("cfe03b", bi.cfe03b.isChecked() ? "2" : "0");
        cfE.put("cfe03c", bi.cfe03c.isChecked() ? "3" : "0");
        cfE.put("cfe03d", bi.cfe03d.isChecked() ? "4" : "0");
        cfE.put("cfe03e", bi.cfe03e.isChecked() ? "5" : "0");
        cfE.put("cfe03f", bi.cfe03f.isChecked() ? "6" : "0");
        cfE.put("cfe03g", bi.cfe03g.isChecked() ? "7" : "0");
        cfE.put("cfe03h", bi.cfe03h.isChecked() ? "8" : "0");
        cfE.put("cfe0396", bi.cfe0396.isChecked() ? "96" : "0");
        cfE.put("cfe0396x", bi.ccg0396x.getText().toString());

        cfE.put("cfe04a", bi.cfe04a.isChecked() ? "1" : "0");
        cfE.put("cfe04b", bi.cfe04b.isChecked() ? "2" : "0");
        cfE.put("cfe04c", bi.cfe04c.isChecked() ? "3" : "0");
        cfE.put("cfe04d", bi.cfe04d.isChecked() ? "4" : "0");
        cfE.put("cfe04e", bi.cfe04e.isChecked() ? "5" : "0");
        cfE.put("cfe04f", bi.cfe04f.isChecked() ? "6" : "0");
        cfE.put("cfe04g", bi.cfe04g.isChecked() ? "7" : "0");
        cfE.put("cfe04h", bi.cfe04h.isChecked() ? "8" : "0");
        cfE.put("cfe04i", bi.cfe04i.isChecked() ? "9" : "0");
        cfE.put("cfe04j", bi.cfe04j.isChecked() ? "10" : "0");

    }

    private boolean UpdateDB() {

        return true;
    }

    private boolean formValidation() {

        if (!bi.cfe0197.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.cfe01a, bi.cfe01a01, getString(R.string.cfe01a))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cfe01b, bi.cfe01b01, getString(R.string.cfe01b))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cfe01c, bi.cfe01c01, getString(R.string.cfe01c))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cfe01d, bi.cfe01d01, getString(R.string.cfe01d))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cfe01e, bi.cfe01e01, getString(R.string.cfe01e))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cfe01f, bi.cfe01f01, getString(R.string.cfe01f))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cfe01g, bi.cfe01g01, getString(R.string.cfe01g))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cfe01h, bi.cfe01h01, getString(R.string.cfe01h))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cfe0196, bi.cfe019601, getString(R.string.other))) {
                return false;
            }
            if (bi.cfe019601.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.cfe0196x, getString(R.string.other))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cfe02, bi.cfe02a, getString(R.string.cfe02))) {
                return false;
            }
            if (!bi.cfe02b.isChecked()) {
                if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrpcfe03, bi.cfe03a, getString(R.string.cfe03))) {
                    return false;
                }
                if (bi.cfe0396.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.ccg0396x, getString(R.string.other))) {
                        return false;
                    }
                }
                return validatorClass.EmptyCardCheckBox(this, bi.fldgrpcfe04, bi.cfe04a, getString(R.string.cfe04));
            }

        }
        return true;
    }

    public void BtnEnd() {
        AppMain.endActivity(this, this);
    }

}
