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
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivitySection16BBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class Section16_BActivity extends AppCompatActivity {

    ActivitySection16BBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section16__b);
        bi.setCallback(this);

        this.setTitle(getString(R.string.app_name16));

        bi.mp16b02.setManager(getSupportFragmentManager());
        bi.mp16b02.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));
        String date = "30/06/2017";
        bi.mp16b02.setMinDate(date);

    }


    public void BtnEnd() {
        AppMain.endActivity(this, this);
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

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updatesB();

        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }


        //return true;
    }

    public void saveDraft() throws JSONException {

        JSONObject sB = new JSONObject();

        sB.put("mp16b01", bi.mp16b02.getText().toString());
        sB.put("mp16b02", bi.mp16b01a.isChecked() ? "1" : bi.mp16b01b.isChecked() ? "2" : bi.mp16b01c.isChecked() ? "3" : bi.mp16b01d.isChecked() ? "4" : bi.mp16b01e.isChecked() ? "5" : bi.mp16b01f.isChecked() ? "6" : bi.mp16b01g.isChecked() ? "7" : bi.mp16b01h.isChecked() ? "8" : bi.mp16b01i.isChecked() ? "9" : bi.mp16b01j.isChecked() ? "88" :"0");
        sB.put("mp16b02x", bi.mp16b01jx.getText().toString());
        sB.put("mp16b03", bi.mp16b03.getText().toString());
        AppMain.fc.setsB(String.valueOf(sB));
    }

    public boolean formValidation() {


        if (!validatorClass.EmptyTextBox(this, bi.mp16b02, getString(R.string.mp16b02))) {

            bi.mp16b02.requestFocus();
            return false;
        } else {

            bi.mp16b02.clearFocus();
        }

        if (!validatorClass.EmptyRadioButton(this, bi.mp16b01, bi.mp16b01a, getString(R.string.mp16b01))) {

            bi.mp16b01.requestFocus();
            return false;
        } else {

            bi.mp16b01.clearFocus();
        }

        if (bi.mp16b01j.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.mp16b01jx, getString(R.string.mp16b01))) {

                bi.mp16b01jx.requestFocus();
                return false;
            } else {

                bi.mp16b01jx.clearFocus();
            }
        }

        if(!validatorClass.EmptyTextBox(this,bi.mp16b03,"Notes must not be empty")){
            return false;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}
