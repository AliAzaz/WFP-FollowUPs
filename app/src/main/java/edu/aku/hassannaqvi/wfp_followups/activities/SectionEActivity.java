package edu.aku.hassannaqvi.wfp_followups.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivitySectionEBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class SectionEActivity extends AppCompatActivity {

    ActivitySectionEBinding bi;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_g);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e);

        this.setTitle(getString(R.string.pfeheading));

        db = new DatabaseHelper(this);
        bi.setCallback(this);
    }

    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.pfe01, bi.pfe01a, getString(R.string.pfe01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe02, bi.pfe02a, getString(R.string.pfe02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe03, bi.pfe03a, getString(R.string.pfe03))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe04, bi.pfe04a, getString(R.string.pfe04))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe05, bi.pfe05a, getString(R.string.pfe05))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe06, bi.pfe06a, getString(R.string.pfe06))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe07, bi.pfe07a, getString(R.string.pfe07))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe08, bi.pfe08a, getString(R.string.pfe08))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe09, bi.pfe09a, getString(R.string.pfe09))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe10, bi.pfe10a, getString(R.string.pfe10))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe11, bi.pfe11a, getString(R.string.pfe11))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe12, bi.pfe12a, getString(R.string.pfe12))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe13, bi.pfe13a, getString(R.string.pfe13))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe14, bi.pfe14a, getString(R.string.pfe14))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe15, bi.pfe15a, getString(R.string.pfe15))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe16, bi.pfe16a, getString(R.string.pfe16))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfe17, bi.pfe17a, getString(R.string.pfe17))) {
            return false;
        }
        return validatorClass.EmptyRadioButton(this, bi.pfe18, bi.pfe18a, getString(R.string.pfe18));
    }

    private void SaveDraft() throws JSONException {

        JSONObject sE = new JSONObject();

        sE.put("pfe01", bi.pfe01a.isChecked() ? "1"
                : bi.pfe01b.isChecked() ? "2"
                : "0");


        sE.put("pfe02", bi.pfe02a.isChecked() ? "1"
                : bi.pfe02b.isChecked() ? "2"
                : "0");


        sE.put("pfe03", bi.pfe03a.isChecked() ? "1"
                : bi.pfe03b.isChecked() ? "2"
                : "0");


        sE.put("pfe04", bi.pfe04a.isChecked() ? "1"
                : bi.pfe04b.isChecked() ? "2"
                : "0");


        sE.put("pfe05", bi.pfe05a.isChecked() ? "1"
                : bi.pfe05b.isChecked() ? "2"
                : "0");


        sE.put("pfe06", bi.pfe06a.isChecked() ? "1"
                : bi.pfe06b.isChecked() ? "2"
                : "0");


        sE.put("pfe07", bi.pfe07a.isChecked() ? "1"
                : bi.pfe07b.isChecked() ? "2"
                : "0");


        sE.put("pfe08", bi.pfe08a.isChecked() ? "1"
                : bi.pfe08b.isChecked() ? "2"
                : "0");


        sE.put("pfe09", bi.pfe09a.isChecked() ? "1"
                : bi.pfe09b.isChecked() ? "2"
                : "0");


        sE.put("pfe10", bi.pfe10a.isChecked() ? "1"
                : bi.pfe10b.isChecked() ? "2"
                : "0");


        sE.put("pfe11", bi.pfe11a.isChecked() ? "1"
                : bi.pfe11b.isChecked() ? "2"
                : "0");


        sE.put("pfe12", bi.pfe12a.isChecked() ? "1"
                : bi.pfe12b.isChecked() ? "2"
                : "0");


        sE.put("pfe13", bi.pfe13a.isChecked() ? "1"
                : bi.pfe13b.isChecked() ? "2"
                : "0");


        sE.put("pfe14", bi.pfe14a.isChecked() ? "1"
                : bi.pfe14b.isChecked() ? "2"
                : "0");


        sE.put("pfe15", bi.pfe15a.isChecked() ? "1"
                : bi.pfe15b.isChecked() ? "2"
                : "0");

        sE.put("pfe16", bi.pfe16a.isChecked() ? "1"
                : bi.pfe16b.isChecked() ? "2"
                : "0");

        sE.put("pfe17", bi.pfe17a.isChecked() ? "1"
                : bi.pfe17b.isChecked() ? "2"
                : "0");

        sE.put("pfe18", bi.pfe18a.isChecked() ? "1"
                : bi.pfe18b.isChecked() ? "2"
                : "0");

//        AppMain.fc.setsG(String.valueOf(sG));
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        /*int updcount = db.updateSG();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return true;
    }

    public void BtnEnd() {
        AppMain.endActivity(this, this);
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionFActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


}