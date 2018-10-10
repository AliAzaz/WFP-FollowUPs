package edu.aku.hassannaqvi.wfp_followups.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.contracts.FormsContract;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivitySectionBBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class SectionBActivity extends AppCompatActivity {


    ActivitySectionBBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b);
        bi.setCallback(this);

        this.setTitle(getString(R.string.pfbheading));

        setupViews();


    }

    private void setupViews() {

        bi.pfb04.setManager(getSupportFragmentManager());
        bi.pfb04.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

    }

    public void BtnContinue() {

        if (formValidation()) {
            try {
                saveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                startActivity(new Intent(this, SectionCActivity.class)
                        .putExtra("complete", true));
                finish();
            }
        }

    }

    public void saveDraft() throws JSONException {

        AppMain.fc = new FormsContract();
        JSONObject sB = new JSONObject();

        sB.put("pfb01", bi.pfb01a.isChecked() ? "1" : bi.pfb01b.isChecked() ? "2" : bi.pfb01c.isChecked() ? "3" : bi.pfb01d.isChecked() ? "4" : bi.pfb01e.isChecked() ? "5" : bi.pfb01f.isChecked() ? "6" : bi.pfb01g.isChecked() ? "7" : "0");
        sB.put("pfb02", bi.pfb02a.isChecked() ? "1" : bi.pfb02b.isChecked() ? "2" : bi.pfb02c.isChecked() ? "3" : bi.pfb02d.isChecked() ? "4" : bi.pfb02e.isChecked() ? "5" : bi.pfb02f.isChecked() ? "6" : "0");
        sB.put("pfb03", bi.pfb03.getText().toString());
        sB.put("pfb04", bi.pfb04.getText().toString());

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

        if (!validatorClass.EmptyRadioButton(this, bi.pfb02, bi.pfb02f, getString(R.string.pfb02))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.pfb03, getString(R.string.pfb03))) {
            return false;
        }

        return validatorClass.EmptyTextBox(this, bi.pfb04, getString(R.string.pfb04));
    }

    public void BtnEnd() {
        AppMain.endActivity(this, this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}
