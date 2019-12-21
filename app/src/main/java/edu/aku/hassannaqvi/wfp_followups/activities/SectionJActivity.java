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

        this.setTitle(getString(R.string.pfkheading));
        validatorClass.setScrollViewFocus(bi.scrollview);

        setupViews();


    }

    private void setupViews() {

        bi.pfj0100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.fldgrppfj02.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfj02, false);
                    bi.fldgrppfj03.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfj03, false);
                    bi.fldgrppfj04.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfj04, false);
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
//                    bi.pfj0101.clearCheck();
//                    bi.pfj0102.clearCheck();
//                    bi.pfj0103.clearCheck();
//                    bi.pfj0104.clearCheck();
//                    bi.pfj0105.clearCheck();
//                    bi.pfj0106.clearCheck();
//                    bi.pfj0107.clearCheck();
//                    bi.pfj0108.clearCheck();
//                    bi.pfj0109.clearCheck();
//                    bi.pfj0109ax.setText(null);
//                    bi.pfj02.clearCheck();
//                    bi.pfj03a.setChecked(false);
//                    bi.pfj03b.setChecked(false);
//                    bi.pfj03c.setChecked(false);
//                    bi.pfj03d.setChecked(false);
//                    bi.pfj03e.setChecked(false);
//                    bi.pfj03f.setChecked(false);
//                    bi.pfj03g.setChecked(false);
//                    bi.pfj03h.setChecked(false);
//                    bi.pfj03i.setChecked(false);
//                    bi.pfj03ix.setText(null);
                } else {
                    bi.fldgrppfj02.setVisibility(View.VISIBLE);
                    bi.fldgrppfj03.setVisibility(View.VISIBLE);
                    bi.fldgrppfj04.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfj02, true);
                    ClearClass.ClearAllCardFields(bi.fldgrppfj03, true);
                    ClearClass.ClearAllCardFields(bi.fldgrppfj04, true);

                }
            }
        });

        bi.pfj02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


                if (i == R.id.pfj02b) {
                    bi.fldgrppfj03.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfj03, false);
                    bi.fldgrppfj04.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfj04, false);
                    bi.pfj03ix.setText(null);
                } else {
                    bi.fldgrppfj03.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfj03, true);
                    bi.fldgrppfj04.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfj04, true);
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
                finish();
                if (AppMain.formType.equals(AppMain.CHILD)) {
                    startActivity(new Intent(this, Child_Section_D.class));
                } else {
                    startActivity(new Intent(this, EndingActivity.class)
                            .putExtra("complete", true));
                }


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

        sJ.put("pfj04a", bi.pfj04a.isChecked() ? "1" : "0");
        sJ.put("pfj04b", bi.pfj04b.isChecked() ? "2" : "0");
        sJ.put("pfj04c", bi.pfj04c.isChecked() ? "3" : "0");
        sJ.put("pfj04d", bi.pfj04d.isChecked() ? "4" : "0");
        sJ.put("pfj04e", bi.pfj04e.isChecked() ? "5" : "0");
        sJ.put("pfj04f", bi.pfj04f.isChecked() ? "6" : "0");
        sJ.put("pfj04g", bi.pfj04g.isChecked() ? "7" : "0");
        sJ.put("pfj04h", bi.pfj04h.isChecked() ? "8" : "0");
        sJ.put("pfj04i", bi.pfj04i.isChecked() ? "9" : "0");
        sJ.put("pfj04j", bi.pfj04j.isChecked() ? "10" : "0");
        sJ.put("pfj0496", bi.pfj0496.isChecked() ? "96" : "0");
        sJ.put("pfj0496x", bi.pfj0496x.getText().toString());

        AppMain.fc.setsJ(String.valueOf(sJ));
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
                    if (!validatorClass.EmptyTextBox(this, bi.pfj03ix, getString(R.string.pfj03))) {
                        return false;
                    }
                }
                if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppfj04, bi.pfj04a, getString(R.string.pfj04))) {
                    return false;
                }
                if (bi.pfj0496.isChecked()) {
                    return validatorClass.EmptyTextBox(this, bi.pfj0496x, getString(R.string.pfj04));
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
