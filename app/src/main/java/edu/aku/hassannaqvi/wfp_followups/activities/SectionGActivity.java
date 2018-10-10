package edu.aku.hassannaqvi.wfp_followups.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivitySectionGBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.ClearClass;

public class SectionGActivity extends AppCompatActivity {

    ActivitySectionGBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g);
        bi.setCallback(this);
        this.setTitle(R.string.pfgheading);

        setupViews();
    }

    private void setupViews() {


        bi.pfg15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.pfg15a) {
                    bi.fldgrppfg16.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg16, false);
                    bi.fldgrppfg17.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg17, false);
                    bi.fldgrppfg18.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg18, false);
                    bi.fldgrppfg19.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg19, false);
                    bi.fldgrppfg20.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg20, false);
                    bi.fldgrppfg21.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg21, false);
                    bi.fldgrppfg22.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg22, false);
                    bi.fldgrppfg23.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg23, false);
                    bi.fldgrppfg24.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg24, false);
                    bi.fldgrppfg25.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg25, false);
                    bi.fldgrppfg26.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg26, false);
                } else {

                    bi.fldgrppfg16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg16, true);
                    bi.fldgrppfg17.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg17, true);
                    bi.fldgrppfg18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg18, true);
                    bi.fldgrppfg19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg19, true);
                    bi.fldgrppfg20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg20, true);
                    bi.fldgrppfg21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg21, true);
                    bi.fldgrppfg22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg22, true);
                    bi.fldgrppfg23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg23, true);
                    bi.fldgrppfg24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg24, true);
                    bi.fldgrppfg25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg25, true);
                    bi.fldgrppfg26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg26, true);

                }
            }
        });

        bi.pfg18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfg18b) {
                    bi.fldgrppfg19.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg19, false);
                    bi.fldgrppfg20.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg20, false);
                    bi.fldgrppfg21.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg21, false);
                    bi.fldgrppfg22.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg22, false);
                } else {
                    bi.fldgrppfg19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg19, true);
                    bi.fldgrppfg20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg20, true);
                    bi.fldgrppfg21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg21, true);
                    bi.fldgrppfg22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg22, true);
                }
            }
        });

        bi.pfg23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfg23b) {
                    bi.fldgrppfg24.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg24, false);
                    bi.fldgrppfg25.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg25, false);
                    bi.fldgrppfg26.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg26, false);
                } else {

                    bi.fldgrppfg24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg24, true);
                    bi.fldgrppfg25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg25, true);
                    bi.fldgrppfg26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrppfg26, true);
                }
            }
        });


    }


    public void BtnContinue() {

        if (formValidation()) {
            saveDraft();

            if (UpdateDB()) {

                startActivity(new Intent(this, EndingActivity.class)
                        .putExtra("complete", true));
                finish();
            }
        }

    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updatesG();

        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void saveDraft() {
    }

    private boolean formValidation() {


        return true;
    }

    public void BtnEnd() {
        AppMain.endActivity(this, this);
    }
}
