package edu.aku.hassannaqvi.wfp_followups.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivityChildSectionDBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.ClearClass;
import edu.aku.hassannaqvi.wfp_followups.validation.ValidatorClass02;

public class Child_Section_D extends AppCompatActivity {

    ActivityChildSectionDBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_child__section__d);
        bi.setCallback(this);
        this.setTitle(R.string.cfdheading);

        setupViews();
    }

    private void setupViews() {

        /*bi.cfd01a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == bi.cfd01a02.getId()) {
                    bi.fldgrpmain1.setVisibility(View.GONE);
                    bi.cfd01a03x.setVisibility(View.VISIBLE);
                } else {
                    bi.fldgrpmain1.setVisibility(View.VISIBLE);
                    bi.cfd01a03x.setVisibility(View.GONE);
                    bi.cfd01a03x.setText(null);
                }

                if (i == bi.cfd01a01.getId()) {
                    bi.fldgrpcfd01b.setVisibility(View.GONE);
                }
                if (i == bi.cfd01a03.getId()) {
                    bi.fldgrpcfd01b.setVisibility(View.VISIBLE);
                }
            }
        });*/

        bi.cfd01a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.cfd01a02.getId())
                    ClearClass.ClearAllFields(bi.fldgrpmain1, null);
                else if (i == bi.cfd01a01.getId())
                    ClearClass.ClearCheckBoxes(bi.fldgrpcfd01b);

            }
        });

        bi.cfd06a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.cfd06a02.getId())
                    ClearClass.ClearAllFields(bi.fldgrpcfd06b, null);
            }
        });

        bi.cfd07d98.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    ClearClass.ClearAllFields(bi.fldgrpcfd07d, false);
                else
                    ClearClass.ClearAllFields(bi.fldgrpcfd07d, true);
            }
        });

        bi.cfd03a02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!b)
                    ClearClass.ClearCheckBoxes(bi.fldgrpcfd03b);
            }
        });

        bi.cfd07a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.cfd07a02.getId())
                    ClearClass.ClearAllFields(bi.fldGrpChildD02, null);
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

                finish();
                startActivity(new Intent(this, EndingActivity.class)
                        .putExtra("complete", true));
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

        JSONObject cfd = new JSONObject();

        cfd.put("cfd01a", bi.cfd01a01.isChecked() ? "1"
                : bi.cfd01a02.isChecked() ? "2"
                : "0");
        cfd.put("cfd01a03x", bi.cfd01a03x.getText().toString());

        cfd.put("cfd01b01", bi.cfd01b01.isChecked() ? "1" : "0");
        cfd.put("cfd01b02", bi.cfd01b02.isChecked() ? "2" : "0");
        cfd.put("cfd01b03", bi.cfd01b03.isChecked() ? "3" : "0");
        cfd.put("cfd01b04", bi.cfd01b04.isChecked() ? "4" : "0");
        cfd.put("cfd01b05", bi.cfd01b05.isChecked() ? "5" : "0");
        cfd.put("cfd01b06", bi.cfd01b06.isChecked() ? "6" : "0");
        cfd.put("cfd01b07", bi.cfd01b07.isChecked() ? "7" : "0");
        cfd.put("cfd01b96", bi.cfd01b96.isChecked() ? "96" : "0");
        cfd.put("cfd01b96x", bi.cfd01b96x.getText().toString());

        cfd.put("cfd02", bi.cfd02.getText().toString());
        cfd.put("cfd03a01", bi.cfd03a01.getText().toString());
        cfd.put("cfd03a02", bi.cfd03a02.isChecked() ? "1" : "0");

        cfd.put("cfd03b01", bi.cfd03b01.isChecked() ? "1" : "0");
        cfd.put("cfd03b02", bi.cfd03b02.isChecked() ? "2" : "0");
        cfd.put("cfd03b03", bi.cfd03b03.isChecked() ? "3" : "0");
        cfd.put("cfd03b04", bi.cfd03b04.isChecked() ? "4" : "0");
        cfd.put("cfd03b05", bi.cfd03b05.isChecked() ? "5" : "0");
        cfd.put("cfd03b06", bi.cfd03b06.isChecked() ? "6" : "0");
        cfd.put("cfd03b07", bi.cfd03b07.isChecked() ? "7" : "0");
        cfd.put("cfd03b96", bi.cfd03b96.isChecked() ? "96" : "0");
        cfd.put("cfd03b96x", bi.cfd03b96x.getText().toString());

        cfd.put("cfd04a01", bi.cfd04a01.getText().toString());
        cfd.put("cfd04a02", bi.cfd04a02.getText().toString());


        cfd.put("cfd04b01", bi.cfd04b01.isChecked() ? "1" : "0");
        cfd.put("cfd04b02", bi.cfd04b02.isChecked() ? "2" : "0");
        cfd.put("cfd04b03", bi.cfd04b03.isChecked() ? "3" : "0");
        cfd.put("cfd04b04", bi.cfd04b04.isChecked() ? "4" : "0");
        cfd.put("cfd04b05", bi.cfd04b05.isChecked() ? "5" : "0");
        cfd.put("cfd04b96", bi.cfd04b96.isChecked() ? "96" : "0");
        cfd.put("cfd04b96x", bi.cfd04b96x.getText().toString());

        cfd.put("cfd05a", bi.cfd05a.getText().toString());
        cfd.put("cfd05b", bi.cfd05b.getText().toString());

        cfd.put("cfd06a", bi.cfd06a01.isChecked() ? "1"
                : bi.cfd06a02.isChecked() ? "2"
                : "0");

        cfd.put("cfd06b01", bi.cfd06b01.isChecked() ? "1" : "0");
        cfd.put("cfd06b02", bi.cfd06b02.isChecked() ? "2" : "0");
        cfd.put("cfd06b03", bi.cfd06b03.isChecked() ? "3" : "0");
        cfd.put("cfd06b04", bi.cfd06b04.isChecked() ? "4" : "0");
        cfd.put("cfd06b96", bi.cfd06b96.isChecked() ? "96" : "0");
        cfd.put("cfd06b96x", bi.cfd06b96x.getText().toString());

        cfd.put("cfd07a", bi.cfd07a01.isChecked() ? "1"
                : bi.cfd07a02.isChecked() ? "2"
                : "0");

        cfd.put("cfd07b01", bi.cfd07b01.isChecked() ? "1" : "0");
        cfd.put("cfd07b02", bi.cfd07b02.isChecked() ? "2" : "0");
        cfd.put("cfd07b03", bi.cfd07b03.isChecked() ? "3" : "0");
        cfd.put("cfd07b96", bi.cfd07b96.isChecked() ? "96" : "0");
        cfd.put("cfd07b96x", bi.cfd07b96x.getText().toString());

        cfd.put("cfd07c", bi.cfd07c.getText().toString());

        cfd.put("cfd07d01", bi.cfd07d01.isChecked() ? "1" : "0");
        cfd.put("cfd07d02", bi.cfd07d02.isChecked() ? "2" : "0");
        cfd.put("cfd07d03", bi.cfd07d03.isChecked() ? "3" : "0");
        cfd.put("cfd07d96", bi.cfd07d96.isChecked() ? "96" : "0");
        cfd.put("cfd07d98", bi.cfd07d98.isChecked() ? "98" : "0");
        cfd.put("cfd07d96x", bi.cfd07d96x.getText().toString());



       /*cfd.put("cfd07d", bi.cfd07d01.isChecked() ? "1"
                : bi.cfd07d02.isChecked() ? "2"
                : bi.cfd07d03.isChecked() ? "3"
                : bi.cfd07d96.isChecked() ? "96"
                : bi.cfd07d98.isChecked() ? "98"
                : "0");*/

        AppMain.fc.setsD(String.valueOf(cfd));

    }

    private boolean formValidation() {

        /*if (!validatorClass.EmptyRadioButton(this, bi.cfd01a, bi.cfd01a01, getString(R.string.cfd01a))) {
            return false;
        }
        if (bi.cfd01a02.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.cfd01a03x, getString(R.string.reason))) {
                return false;
            }
        }

        if (bi.cfd01a03.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, bi.fldgrpcfd01b, bi.cfd01b01, getString(R.string.cfd01b))) {
                return false;
            }
            if (bi.cfd01b96.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.cfd01b96x, getString(R.string.other))) {
                    return false;
                }
            }
        }
        if (!validatorClass.EmptyTextBox(this, bi.cfd02, getString(R.string.cfd02))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.cfd02, 1, 90, getString(R.string.cfd02), "Sachets")) {
            return false;
        }

        if (!bi.cfd03a02.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.cfd03a01, getString(R.string.cfd03a))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.cfd03a01, 1, 3, getString(R.string.cfd03a), "Sachets")) {
                return false;
            }
        }
        if (bi.cfd03a02.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, bi.fldgrpcfd03b, bi.cfd03b01, getString(R.string.cfd03b))) {
                return false;
            }
            if (bi.cfd03b96.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.cfd03b96x, getString(R.string.cfd03b))) {
                    return false;
                }
            }
        }
        if (!validatorClass.EmptyTextBox(this, bi.cfd04a01, getString(R.string.cfd04a))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.cfd04a01, 1, 31, getString(R.string.cfd04a), "Day(s)")) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.cfd04a02, getString(R.string.cfd04a))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.cfd04a02, 1, 60, getString(R.string.cfd04a), "Sachets")) {
            return false;
        }
        if (!validatorClass.EmptyCheckBox(this, bi.fldgrpcfd04b, bi.cfd04b01, getString(R.string.cfd04b))) {
            return false;
        }
        if (bi.cfd04b96.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.cfd04b96x, getString(R.string.cfd04b))) {
                return false;
            }
        }
        if (!validatorClass.EmptyTextBox(this, bi.cfd05a, getString(R.string.cfd05a))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.cfd05a, 0, 90, getString(R.string.cfd05a), "Sachets")) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.cfd05b, getString(R.string.cfd05b))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.cfd05b, 0, 90, getString(R.string.cfd05b), "Sachets")) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.cfd06a, bi.cfd06a01, getString(R.string.cfd06a))) {
            return false;
        }
        if (bi.cfd06a01.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, bi.fldgrpcfd06b, bi.cfd06b01, getString(R.string.cfd06b))) {
                return false;
            }
            if (bi.cfd06b96.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.cfd06b96x, getString(R.string.cfd06b))) {
                    return false;
                }
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cfd07a, bi.cfd07a01, getString(R.string.cfd07a))) {
            return false;
        }
        if (bi.cfd07a01.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, bi.fldgrpcfd07b, bi.cfd07b01, getString(R.string.cfd07b))) {
                return false;
            }
            if (bi.cfd07b96.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.cfd07b96x, getString(R.string.cfd07b))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyTextBox(this, bi.cfd07c, getString(R.string.cfd07c))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.cfd07c, 1, 90, getString(R.string.cfd07c), "Sachets")) {
                return false;
            }
            if (!validatorClass.EmptyCheckBox(this, bi.fldgrpcfd07d, bi.cfd07d01, getString(R.string.cfd07d))) {
                return false;
            }
            if (bi.cfd07d96.isChecked()) {
                return validatorClass.EmptyTextBox(this, bi.cfd07d96x, getString(R.string.cfd07d));
            }
        }*/


        return ValidatorClass02.EmptyCheckingContainer(this, bi.fldGrpChildD01);
    }

    public void BtnEnd() {
        AppMain.endActivity(this, this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
}
