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

        JSONObject sB = new JSONObject();

        sB.put("pfb01", bi.pfb01a.isChecked() ? "1" : bi.pfb01b.isChecked() ? "2" : bi.pfb01c.isChecked() ? "3" : bi.pfb01d.isChecked() ? "4" : bi.pfb01e.isChecked() ? "5" : bi.pfb01f.isChecked() ? "6" : bi.pfb01g.isChecked() ? "7" : "0");
        sB.put("pfb02", bi.pfb02a.isChecked() ? "1" : bi.pfb02b.isChecked() ? "2" : bi.pfb02c.isChecked() ? "3" : bi.pfb02d.isChecked() ? "4" : bi.pfb02e.isChecked() ? "5" : bi.pfb02f.isChecked() ? "6" : "0");
        sB.put("pfb03", bi.pfb03.getText().toString());
        sB.put("pfb04", bi.pfb04.getText().toString());

        AppMain.fc.setsB(String.valueOf(sB));

        /*sB.put("mp15b01", bi.mp15b01a.isChecked() ? "1" : bi.mp15b01b.isChecked() ? "2" : bi.mp15b01c.isChecked() ? "3" : bi.mp15b01d.isChecked() ? "4" : "0");
        sB.put("mp15b02", bi.mp15b02a.isChecked() ? "1" : bi.mp15b02b.isChecked() ? "2" : "0");
        sB.put("mp15b03", bi.mp15b03a.isChecked() ? "1" : bi.mp15b03b.isChecked() ? "2" : bi.mp15b03c.isChecked() ? "3" : bi.mp15b03d.isChecked() ? "4" : bi.mp15b03e.isChecked() ? "5" : "0");
        sB.put("mp15b04", bi.mp15b04a.isChecked() ? "1" : bi.mp15b04b.isChecked() ? "2" : bi.mp15b04c.isChecked() ? "3" : bi.mp15b04d.isChecked() ? "4" : "0");
        sB.put("mp15b05", bi.mp15b05a.isChecked() ? "1" : bi.mp15b05b.isChecked() ? "2" : bi.mp15b05c.isChecked() ? "3" : bi.mp15b05d.isChecked() ? "4" : bi.mp15b05e.isChecked() ? "5" : "0");
        sB.put("mp15b06", bi.mp15b06a.isChecked() ? "1" : bi.mp15b06b.isChecked() ? "2" : bi.mp15b06c.isChecked() ? "3" : bi.mp15b06d.isChecked() ? "4" : bi.mp15b06e.isChecked() ? "5" : "0");
        sB.put("mp15b07", bi.mp15b07a.isChecked() ? "1" : bi.mp15b07b.isChecked() ? "2" : "0");
        sB.put("mp15b08", bi.mp15b08a.isChecked() ? "1" : bi.mp15b08b.isChecked() ? "2" : "0");
        sB.put("mp15b09", bi.mp15b09a.isChecked() ? "1" : bi.mp15b09b.isChecked() ? "2" :
                bi.mp15b09c.isChecked() ? "3" : bi.mp15b09d.isChecked() ? "4" : bi.mp15b09e.isChecked() ? "5" :
                        bi.mp15b09f.isChecked() ? "6" : bi.mp15b09g.isChecked() ? "7" : bi.mp15b09h.isChecked() ? "8" :
                                bi.mp15b09i.isChecked() ? "9" : bi.mp15b09j.isChecked() ? "10" : bi.mp15b09k.isChecked() ? "11" : bi.mp15b09l.isChecked() ? "12" : bi.mp15b09m.isChecked() ? "88" : "0");
        sB.put("mp15b09x", bi.mp15b09mx.getText().toString());
        sB.put("mp15b10", bi.mp15b10a.isChecked() ? "1" : bi.mp15b10b.isChecked() ? "2" : bi.mp15b10c.isChecked() ? "3"
                : bi.mp15b10d.isChecked() ? "4" : bi.mp15b10e.isChecked() ? "5" : "0");
        sB.put("mp15b11", bi.mp15b11a.isChecked() ? "1" : bi.mp15b11b.isChecked() ? "2" : bi.mp15b11c.isChecked() ? "3"
                : bi.mp15b11d.isChecked() ? "4" : bi.mp15b11e.isChecked() ? "5" : "0");
        sB.put("mp15b12a", bi.mp15b12a.isChecked() ? "1" : "0");
        sB.put("mp15b12b", bi.mp15b12b.isChecked() ? "2" : "0");
        sB.put("mp15b12c", bi.mp15b12c.isChecked() ? "3" : "0");
        sB.put("mp15b12d", bi.mp15b12d.isChecked() ? "4" : "0");
        sB.put("mp15b12e", bi.mp15b12e.isChecked() ? "5" : "0");
        sB.put("mp15b12f", bi.mp15b12f.isChecked() ? "6" : "0");
        sB.put("mp15b12g", bi.mp15b12g.isChecked() ? "7" : "0");
        sB.put("mp15b12h", bi.mp15b12h.isChecked() ? "8" : "0");
        sB.put("mp15b12i", bi.mp15b12i.isChecked() ? "9" : "0");
        sB.put("mp15b12j", bi.mp15b12j.isChecked() ? "88" : "0");
        sB.put("mp15b12x", bi.mp15b12jx.getText().toString());
        sB.put("mp15b12k", bi.mp15b12k.isChecked() ? "99" : "0");
        sB.put("mp15b13", bi.mp15b13a.isChecked() ? "1" : bi.mp15b13b.isChecked() ? "2" : "0");
        sB.put("mp15b14", bi.mp15b14a.isChecked() ? "1" : bi.mp15b14b.isChecked() ? "2" : bi.mp15b14c.isChecked() ? "3" : bi.mp15b14d.isChecked() ? "4" : bi.mp15b14e.isChecked() ? "5" : bi.mp15b14f.isChecked() ? "6" : bi.mp15b14g.isChecked() ? "7" : bi.mp15b14h.isChecked() ? "8" : bi.mp15b14i.isChecked() ? "9" : bi.mp15b14j.isChecked() ? "88" : "0");
        sB.put("mp15b14x", bi.mp15b14jx.getText().toString());
        sB.put("mp15b15", bi.mp15b15a.isChecked() ? "1" : bi.mp15b15b.isChecked() ? "2" : "0");
        sB.put("mp15b16", bi.mp15b16a.isChecked() ? "1" : bi.mp15b16b.isChecked() ? "2" : bi.mp15b16c.isChecked() ? "3" : bi.mp15b16d.isChecked() ? "4" : bi.mp15b16e.isChecked() ? "5" : bi.mp15b16f.isChecked() ? "6" : bi.mp15b16g.isChecked() ? "7" : bi.mp15b16h.isChecked() ? "8" : bi.mp15b16i.isChecked() ? "9" : bi.mp15b16j.isChecked() ? "88" : "0");
        sB.put("mp15b16x", bi.mp15b16jx.getText().toString());
        sB.put("mp15b17", bi.mp15b17a.isChecked() ? "1" : bi.mp15b17b.isChecked() ? "2" : bi.mp15b17c.isChecked() ? "3" : bi.mp15b17d.isChecked() ? "99" : "0");
        sB.put("mp15b18", bi.mp15b18a.isChecked() ? "1" : bi.mp15b18b.isChecked() ? "2" : "0");
        sB.put("mp15b19", bi.mp15b19a.isChecked() ? "1" : bi.mp15b19b.isChecked() ? "2" : bi.mp15b19c.isChecked() ? "3" : bi.mp15b19d.isChecked() ? "4" : "0");
        sB.put("mp15b20", bi.mp15b20a.isChecked() ? "1" : bi.mp15b20b.isChecked() ? "2" : bi.mp15b20c.isChecked() ? "99" : "0");
        sB.put("mp15b21", bi.mp15b21a.isChecked() ? "1" : bi.mp15b21b.isChecked() ? "2" : bi.mp15b21c.isChecked() ? "3" : bi.mp15b21d.isChecked() ? "4" : bi.mp15b21e.isChecked() ? "5" : "0");
        sB.put("mp15b22", bi.mp15b22a.isChecked() ? "1" : bi.mp15b22b.isChecked() ? "2" : bi.mp15b22c.isChecked() ? "99" : "0");
        */
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
