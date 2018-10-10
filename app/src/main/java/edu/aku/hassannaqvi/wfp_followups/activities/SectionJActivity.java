package edu.aku.hassannaqvi.wfp_followups.activities;

import android.content.Intent;
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
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivitySectionJBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.ClearClass;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class SectionJActivity extends AppCompatActivity {


    ActivitySectionJBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j);
        bi.setCallback(this);

        this.setTitle(getString(R.string.pfjheading));
        validatorClass.setScrollViewFocus(bi.scrollview);

        setupViews();


    }

    private void setupViews() {

        bi.pfj0100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.fldgrppfj02.setVisibility(View.GONE);
                    bi.fldgrppfj03.setVisibility(View.GONE);
                    bi.pfj0101.clearCheck();
                    bi.pfj0102.clearCheck();
                    bi.pfj0103.clearCheck();
                    bi.pfj0104.clearCheck();
                    bi.pfj0105.clearCheck();
                    bi.pfj0106.clearCheck();
                    bi.pfj0107.clearCheck();
                    bi.pfj0108.clearCheck();
                    bi.pfj0109.clearCheck();
                    bi.pfj0109ax.setText(null);
                    bi.pfj02.clearCheck();
                    bi.pfj03a.setChecked(false);
                    bi.pfj03b.setChecked(false);
                    bi.pfj03c.setChecked(false);
                    bi.pfj03d.setChecked(false);
                    bi.pfj03e.setChecked(false);
                    bi.pfj03f.setChecked(false);
                    bi.pfj03g.setChecked(false);
                    bi.pfj03h.setChecked(false);
                    bi.pfj03i.setChecked(false);
                    bi.pfj03ix.setText(null);
                } else {
                    bi.fldgrppfjmain.setVisibility(View.VISIBLE);
                    bi.fldgrppfj02.setVisibility(View.VISIBLE);
                    bi.fldgrppfj03.setVisibility(View.VISIBLE);

                }
            }
        });

        bi.pfj02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


                if (i == R.id.pfj02b) {
                    bi.fldgrppfj03.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfj03, false);
                    bi.pfj03ix.setText(null);
                } else {
                    bi.fldgrppfj03.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfj03, true);
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

    public void saveDraft() throws JSONException {

        JSONObject sJ = new JSONObject();

        sJ.put("pfj0101", bi.pfj0101a.isChecked() ? "1" : bi.pfj0101a.isChecked() ? "2" : "0");
        sJ.put("pfj0102", bi.pfj0102a.isChecked() ? "1" : bi.pfj0102b.isChecked() ? "2" : "0");
        sJ.put("pfj0103", bi.pfj0103a.isChecked() ? "1" : bi.pfj0103b.isChecked() ? "2" : "0");
        sJ.put("pfj0104", bi.pfj0104a.isChecked() ? "1" : bi.pfj0104b.isChecked() ? "2" : "0");
        sJ.put("pfj0105", bi.pfj0105a.isChecked() ? "1" : bi.pfj0105b.isChecked() ? "2" : "0");
        sJ.put("pfj0106", bi.pfj0106a.isChecked() ? "1" : bi.pfj0106b.isChecked() ? "2" : "0");
        sJ.put("pfj0107", bi.pfj0107a.isChecked() ? "1" : bi.pfj0107b.isChecked() ? "2" : "0");
        sJ.put("pfj0108", bi.pfj0108a.isChecked() ? "1" : bi.pfj0108b.isChecked() ? "2" : "0");
        sJ.put("pfj0109", bi.pfj0109a.isChecked() ? "1" : bi.pfj0109b.isChecked() ? "2" : "0");
        sJ.put("pfj0109x", bi.pfj0109ax.getText().toString());
        sJ.put("pfj0198", bi.pfj0100.isChecked() ? "1" : "0");
        sJ.put("pfj02", bi.pfj02a.isChecked() ? "1" : bi.pfj02b.isChecked() ? "2" : "0");
        sJ.put("pfj03a", bi.pfj03a.isChecked() ? "1" : "0");
        sJ.put("pfj03b", bi.pfj03b.isChecked() ? "2" : "0");
        sJ.put("pfj03c", bi.pfj03c.isChecked() ? "3" : "0");
        sJ.put("pfj03d", bi.pfj03d.isChecked() ? "4" : "0");
        sJ.put("pfj03e", bi.pfj03e.isChecked() ? "5" : "0");
        sJ.put("pfj03f", bi.pfj03f.isChecked() ? "6" : "0");
        sJ.put("pfj03g", bi.pfj03g.isChecked() ? "7" : "0");
        sJ.put("pfj03h", bi.pfj03h.isChecked() ? "8" : "0");
        sJ.put("pfj03i", bi.pfj03i.isChecked() ? "96" : "0");
        sJ.put("pfj03i96", bi.pfj03ix.getText().toString());

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
        AppMain.fc.setsB(String.valueOf(sB));*/
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updatesJ();

        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public boolean formValidation() {

        if (!bi.pfj0100.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.pfj0101, bi.pfj0101a, getString(R.string.pfj01))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfj0102, bi.pfj0102a, getString(R.string.pfj01))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfj0103, bi.pfj0103a, getString(R.string.pfj01))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfj0104, bi.pfj0104a, getString(R.string.pfj01))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfj0105, bi.pfj0105a, getString(R.string.pfj01))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfj0106, bi.pfj0106a, getString(R.string.pfj01))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfj0107, bi.pfj0107a, getString(R.string.pfj01))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfj0108, bi.pfj0108a, getString(R.string.pfj01))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfj0109, bi.pfj0109a, getString(R.string.pfj01))) {
                return false;
            }
            if (bi.pfj0109a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pfj0109ax, getString(R.string.pfj01))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfj02, bi.pfj02a, getString(R.string.pfj02))) {
                return false;
            }
            if (!bi.pfj02b.isChecked()) {
                if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppfj03, bi.pfj03a, getString(R.string.pfj03))) {
                    return false;
                }
                if (bi.pfj03i.isChecked()) {
                    return validatorClass.EmptyTextBox(this, bi.pfj03ix, getString(R.string.pfj03));
                }
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
