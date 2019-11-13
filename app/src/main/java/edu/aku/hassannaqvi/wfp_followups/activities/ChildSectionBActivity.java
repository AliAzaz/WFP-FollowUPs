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

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.core.DateUtils;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivityChildSectionBBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.ClearClass;
import edu.aku.hassannaqvi.wfp_followups.validation.ValidatorClass02;

public class ChildSectionBActivity extends AppCompatActivity {
    ActivityChildSectionBBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_child_section_b);
        bi.setCallback(this);
        this.setTitle(getString(R.string.cfbheading));
        setUpViews();
    }

    private void setUpViews() {

        bi.cfb03.setMinDate(DateUtils.getThreeDaysBack("dd/MM/yyyy", -60));
        bi.cfb01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.cfb01a.getId()) {
                    ClearClass.ClearAllCardFields(bi.fldgrpcfbb, false);
                    bi.fldgrpcfbb.setVisibility(View.GONE);
                } else {
                    ClearClass.ClearAllCardFields(bi.fldgrpcfbb, true);
                    bi.fldgrpcfbb.setVisibility(View.VISIBLE);

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

              /*  startActivity(new Intent(this, bi.cfb01a.isChecked() && !bi.cfb02b.isChecked() ? SectionCActivity.class : EndingActivity.class)
                        .putExtra("complete", true)
                        .putExtra("pwMonth", !bi.pfb03.getText().toString().isEmpty() && (Integer.valueOf(bi.pfb03.getText().toString()) < 9)));*/
                startActivity(new Intent(this, bi.cfb01a.isChecked() ? SectionHActivity.class : EndingActivity.class)
                        .putExtra("childMonth",
                                !bi.cfb02m.getText().toString().isEmpty()
                                        && (Integer.valueOf(bi.cfb02m.getText().toString()) == 24))
                        .putExtra("complete", true));
                finish();
            }
        }

    }

    public void BtnEnd() {
        AppMain.endActivity(this, this);
    }


    public void saveDraft() throws JSONException {

        JSONObject sB = new JSONObject();

        sB.put("cfb01", bi.cfb01a.isChecked() ? "1" : bi.cfb01b.isChecked() ? "2" : bi.cfb01c.isChecked() ? "3" : bi.cfb01d.isChecked() ? "4" : bi.cfb01e.isChecked() ? "5" : bi.cfb01f.isChecked() ? "6" : bi.cfb01g.isChecked() ? "7" : "0");
        sB.put("cfb02m", bi.cfb02m.getText().toString());
        sB.put("cfb02d", bi.cfb02d.getText().toString());
        sB.put("cfb03", bi.cfb03.getText().toString());

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

        /*if (!validatorClass.EmptyRadioButton(this, bi.cfb01, bi.cfb01g, getString(R.string.cfb01))) {
            return false;
        }

        if (bi.cfb01a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.cfb02m, getString(R.string.month))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.cfb02m, 7, 24, getString(R.string.cfb02), "Months")) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.cfb02d, getString(R.string.day))) {
                return false;
            }
            return validatorClass.RangeTextBox(this, bi.cfb02d, 0, 29, getString(R.string.cfb02), "Day");
        }*/


        return ValidatorClass02.EmptyCheckingContainer(this, bi.fldGrpChildB01);
    }


}
