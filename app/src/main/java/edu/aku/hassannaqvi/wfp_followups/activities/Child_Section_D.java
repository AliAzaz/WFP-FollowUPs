package edu.aku.hassannaqvi.wfp_followups.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivityChildSectionDBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class Child_Section_D extends AppCompatActivity {

    ActivityChildSectionDBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_child__section__d);
        bi.setCallback(this);

        setupViews();
    }

    private void setupViews() {

        bi.cfd01a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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

    private boolean UpdateDB() {


        return true;
    }

    private void saveDraft() throws JSONException {

        JSONObject cfd = new JSONObject();

        cfd.put("cfd01a", bi.cfd01a01.isChecked() ? "1"
                : bi.cfd01a02.isChecked() ? "2"
                : "0");

        cfd.put("cfd01reason", bi.cfd01a03x.getText().toString());

        cfd.put("cfd01b", bi.cfd01b01.isChecked() ? "1"
                : bi.cfd01b02.isChecked() ? "2"
                : bi.cfd01b03.isChecked() ? "3"
                : bi.cfd01b04.isChecked() ? "4"
                : bi.cfd01b05.isChecked() ? "5"
                : bi.cfd01b06.isChecked() ? "6"
                : bi.cfd01b07.isChecked() ? "7"
                : bi.cfd01b96.isChecked() ? "96"
                : "0");
        cfd.put("cfd01b96x", bi.cfd01b96x.getText().toString());
        cfd.put("cfd03a01", bi.cfd03a01.getText().toString());
        cfd.put("cfd03a02", bi.cfd03a02.isChecked() ? "1" : "0");

        cfd.put("cfd03b", bi.cfd03b01.isChecked() ? "1"
                : bi.cfd03b02.isChecked() ? "2"
                : bi.cfd03b03.isChecked() ? "3"
                : bi.cfd03b04.isChecked() ? "4"
                : bi.cfd03b05.isChecked() ? "5"
                : bi.cfd03b06.isChecked() ? "6"
                : bi.cfd03b07.isChecked() ? "7"
                : bi.cfd03b96.isChecked() ? "96"
                : "0");
        cfd.put("cfd03b96x", bi.cfd03b96x.getText().toString());

        cfd.put("cfd04a01", bi.cfd04a01.getText().toString());
        cfd.put("cfd04a02", bi.cfd04a02.getText().toString());

        cfd.put("cfd04b", bi.cfd04b01.isChecked() ? "1"
                : bi.cfd04b02.isChecked() ? "2"
                : bi.cfd04b03.isChecked() ? "3"
                : bi.cfd04b04.isChecked() ? "4"
                : bi.cfd04b05.isChecked() ? "5"
                : bi.cfd04b96.isChecked() ? "96"
                : "0");
        cfd.put("cfd04b96x", bi.cfd04b96x.getText().toString());

        cfd.put("cfd05a", bi.cfd05a.getText().toString());
        cfd.put("cfd05b", bi.cfd05b.getText().toString());

        cfd.put("cfd06a", bi.cfd06a01.isChecked() ? "1"
                : bi.cfd06a01.isChecked() ? "2"
                : "0");

        cfd.put("cfd06b", bi.cfd06b01.isChecked() ? "1"
                : bi.cfd06b02.isChecked() ? "2"
                : bi.cfd06b03.isChecked() ? "3"
                : bi.cfd06b04.isChecked() ? "4"
                : bi.cfd06b96.isChecked() ? "96"
                : "0");
        cfd.put("cfd06b96x", bi.cfd06b96x.getText().toString());

        cfd.put("cfd07a", bi.cfd07a01.isChecked() ? "1"
                : bi.cfd07a02.isChecked() ? "2"
                : "0");

        cfd.put("cfd07b", bi.cfd07b01.isChecked() ? "1"
                : bi.cfd07b02.isChecked() ? "2"
                : bi.cfd07b03.isChecked() ? "3"
                : bi.cfd07b96.isChecked() ? "96"
                : "0");

        cfd.put("cfd07b96x", bi.cfd07b96x.getText().toString());
        cfd.put("cfd07c", bi.cfd07c.getText().toString());

        cfd.put("cfd07d", bi.cfd07d01.isChecked() ? "1"
                : bi.cfd07d02.isChecked() ? "2"
                : bi.cfd07d03.isChecked() ? "3"
                : bi.cfd07d96.isChecked() ? "96"
                : bi.cfd07d98.isChecked() ? "98"
                : "0");

        cfd.put("cfd07d96x", bi.cfd07d96x.getText().toString());
    }

    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.cfd01a, bi.cfd01a01, getString(R.string.cfd01a))) {
            return false;
        }
        if (bi.cfd01a02.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.cfd01a03x, getString(R.string.reason))) {
                return false;
            }
        }

        if (bi.cfd01a03.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.cfd01b, bi.cfd01b01, getString(R.string.cfd01b))) {
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
            if (!validatorClass.EmptyRadioButton(this, bi.cfd03b, bi.cfd03b01, getString(R.string.cfd03b))) {
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
        if (!validatorClass.EmptyRadioButton(this, bi.cfd04b, bi.cfd04b01, getString(R.string.cfd04b))) {
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
            if (!validatorClass.EmptyRadioButton(this, bi.cfd06b, bi.cfd06b01, getString(R.string.cfd06b))) {
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
            if (!validatorClass.EmptyRadioButton(this, bi.cfd07b, bi.cfd07b01, getString(R.string.cfd07b))) {
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
            if (!validatorClass.EmptyRadioButton(this, bi.cfd07d, bi.cfd07d01, getString(R.string.cfd07d))) {
                return false;
            }
            if (bi.cfd07d96.isChecked()) {
                return validatorClass.EmptyTextBox(this, bi.cfd07d96x, getString(R.string.cfd07d));
            }
        }


        return true;
    }

    public void BtnEnd() {
        AppMain.endActivity(this, this);
    }

}
