package edu.aku.hassannaqvi.wfp_followups.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivitySectionBBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.ClearClass;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class SectionBActivity extends AppCompatActivity {


    ActivitySectionBBinding bi;

    public static int currentlyPR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b);
        bi.setCallback(this);

        this.setTitle(getString(R.string.pfbheading));

        setupViews();


    }

    private void setupViews() {

        bi.pfb05.setMinDate(AppMain.convertDateFormat(getIntent().getStringExtra("fdate")));
        bi.pfb04.setMinDate(AppMain.convertDateFormat(getIntent().getStringExtra("fdate")));
        bi.pfb04.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        bi.pfb01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.pfb01a.getId()) {
                    ClearClass.ClearAllCardFields(bi.fldgrppfba, false);
                } else {
                    ClearClass.ClearAllCardFields(bi.fldgrppfba, true);

                    // Get check from prv activity
                    boolean flag = getIntent().getBooleanExtra("valCheck", false);
                    /*if (flag == 1) {
                        bi.pfb02e.setEnabled(false);
                        bi.pfb02f.setEnabled(false);
                    } else {
                        bi.pfb02a.setEnabled(false);
                        bi.pfb02b.setEnabled(false);
                        bi.pfb02c.setEnabled(false);
                        bi.pfb02d.setEnabled(false);
                    }*/
                    if (flag) {
                        bi.pfb02c.setEnabled(false);
                        bi.pfb02d.setEnabled(false);
                        bi.pfb02e.setEnabled(false);
                        bi.pfb02f.setEnabled(false);
                        bi.pfb02g.setEnabled(false);
                        bi.pfb02h.setEnabled(false);
                    } else {
                        bi.pfb02a.setEnabled(false);
                        bi.pfb02b.setEnabled(false);

                        if (!AppMain.currentPrg) {
                            bi.pfb02c.setEnabled(false);
                            bi.pfb02d.setEnabled(false);
                        }
                    }
                }
            }
        });

        bi.pfb02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.pfb02a.getId() || i != bi.pfb02e.getId()) {
                    ClearClass.ClearAllCardFields(bi.fldgrppfbb, true);
                }

                if (i == bi.pfb02e.getId()) {
                    if (AppMain.currentPrg)
                        bi.fldgrppfb04.setVisibility(View.VISIBLE);
                    else
                        bi.fldgrppfb04.setVisibility(View.GONE);
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

                startActivity(new Intent(this, bi.pfb01a.isChecked() && !bi.pfb02b.isChecked() ? SectionCActivity.class : EndingActivity.class)
                        .putExtra("complete", true)
                        .putExtra("pwMonth", !bi.pfb03.getText().toString().isEmpty() &&
                                (Integer.valueOf(bi.pfb03.getText().toString()) != 8 && Integer.valueOf(bi.pfb03.getText().toString()) != 9)));
                finish();
            }
        }

    }

    public void saveDraft() throws JSONException {

        JSONObject sB = new JSONObject();

        sB.put("pfb01", bi.pfb01a.isChecked() ? "1" : bi.pfb01b.isChecked() ? "2" : bi.pfb01c.isChecked() ? "3" : bi.pfb01d.isChecked() ? "4" : bi.pfb01e.isChecked() ? "5" : bi.pfb01f.isChecked() ? "6" : bi.pfb01g.isChecked() ? "7" : "0");
        sB.put("pfb02", bi.pfb02a.isChecked() ? "1" : bi.pfb02b.isChecked() ? "2" : bi.pfb02c.isChecked() ? "3" : bi.pfb02d.isChecked() ? "4" : bi.pfb02e.isChecked() ? "5" : bi.pfb02f.isChecked() ? "6" : bi.pfb02g.isChecked() ? "7" : bi.pfb02h.isChecked() ? "8" : "0");
        sB.put("pfb03", bi.pfb03.getText().toString());
        sB.put("pfb04", bi.pfb04.getText().toString());
        sB.put("pfb05", bi.pfb05.getText().toString());

        currentlyPR = bi.pfb02a.isChecked() ? 1 : bi.pfb02b.isChecked() ? 2 : bi.pfb02c.isChecked() ? 3 : bi.pfb02d.isChecked() ? 4 : bi.pfb02e.isChecked() ? 5 : bi.pfb02f.isChecked() ? 6 : 0;

        AppMain.fc.setsB(String.valueOf(sB));

    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updatesB();

        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.pfb01, bi.pfb01g, getString(R.string.pfb01))) {
            return false;
        }

        if (bi.pfb01a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.pfb02, bi.pfb02f, getString(R.string.pfb02))) {
                return false;
            }

            if (bi.pfb02a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pfb03, getString(R.string.pfb03))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.pfb03, 1, 10, getString(R.string.pfb03), "Months")) {
                    return false;
                }
            }

            if (bi.pfb02e.isChecked()) {
                if (AppMain.currentPrg)
                    return validatorClass.EmptyTextBox(this, bi.pfb04, getString(R.string.pfb04));
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
