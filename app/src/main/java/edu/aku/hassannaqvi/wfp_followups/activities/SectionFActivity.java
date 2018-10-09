package edu.aku.hassannaqvi.wfp_followups.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import org.json.JSONException;

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.validation.ClearClass;

public class SectionFActivity extends AppCompatActivity {


    ActivitySectionFBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f);
        bi.setCallback(this);

        setTitle("ANC & Morbidity");


        //============================Skip Patterns===============================

        bi.pff01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.pff01a) {

                    bi.fldgrppff02.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrppff02, false);
                    bi.fldgrppff03.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrppff03, false);
                    bi.fldgrppff04.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrppff04, false);
                    bi.fldgrppff05.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrppff05, false);


                } else {
                    bi.fldgrppff02.setVisibility(View.VISIBLE);
                    bi.fldgrppff03.setVisibility(View.VISIBLE);
                    bi.fldgrppff04.setVisibility(View.VISIBLE);
                    bi.fldgrppff05.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrppff02, true);
                    ClearClass.ClearAllFields(bi.fldgrppff03, true);
                    ClearClass.ClearAllFields(bi.fldgrppff04, true);
                    ClearClass.ClearAllFields(bi.fldgrppff05, true);
                }
            }
        });

        bi.pff06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.pff06a) {

                    bi.fldgrppff07.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrppff07, false);


                } else {
                    bi.fldgrppff07.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrppff07, true);
                }
            }
        });

        bi.pff0915.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pff0901.clearCheck();
                    bi.pff0902.clearCheck();
                    bi.pff0903.clearCheck();
                    bi.pff0904.clearCheck();
                    bi.pff0905.clearCheck();
                    bi.pff0906.clearCheck();
                    bi.pff0907.clearCheck();
                    bi.pff0908.clearCheck();
                    bi.pff0909.clearCheck();
                    bi.pff0910.clearCheck();
                    bi.pff0911.clearCheck();
                    bi.pff0912.clearCheck();
                    bi.pff0913.clearCheck();
                    bi.pff0914.clearCheck();
                    bi.pff0996.clearCheck();
                    bi.pff0996x.setText(null);
                }
            }
        });

        bi.pff0901.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0901a || i == R.id.pff0901b) {

                    bi.pff0915.setChecked(false);

                }
            }
        });

        bi.pff0902.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0902a || i == R.id.pff0902b) {

                    bi.pff0915.setChecked(false);

                }
            }
        });

        bi.pff0903.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0903a || i == R.id.pff0903b) {

                    bi.pff0915.setChecked(false);

                }
            }
        });

        bi.pff0904.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0904a || i == R.id.pff0904b) {

                    bi.pff0915.setChecked(false);

                }
            }
        });

        bi.pff0905.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0905a || i == R.id.pff0905b) {

                    bi.pff0915.setChecked(false);

                }
            }
        });

        bi.pff0906.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0906a || i == R.id.pff0906b) {

                    bi.pff0915.setChecked(false);

                }
            }
        });

        bi.pff0907.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0907a || i == R.id.pff0907b) {

                    bi.pff0915.setChecked(false);

                }
            }
        });

        bi.pff0908.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0908a || i == R.id.pff0908b) {

                    bi.pff0915.setChecked(false);

                }
            }
        });

        bi.pff0909.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0909a || i == R.id.pff0909b) {

                    bi.pff0915.setChecked(false);

                }
            }
        });

        bi.pff0910.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0910a || i == R.id.pff0910b) {

                    bi.pff0915.setChecked(false);

                }
            }
        });

        bi.pff0911.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0911a || i == R.id.pff0911b) {

                    bi.pff0915.setChecked(false);

                }
            }
        });

        bi.pff0912.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0912a || i == R.id.pff0912b) {

                    bi.pff0915.setChecked(false);

                }
            }

        });

        bi.pff0913.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0913a || i == R.id.pff0913b) {

                    bi.pff0915.setChecked(false);

                }
            }
        });

        bi.pff0914.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0914a || i == R.id.pff0914b) {

                    bi.pff0915.setChecked(false);

                }
            }
        });

        bi.pff0996.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pff0996a || i == R.id.pff0996b) {

                    bi.pff0915.setChecked(false);
                    bi.pff0996x.setVisibilty(View.VISIBLE);

                }else{
                    bi.pff0915.setChecked(false);
                    bi.pff0996x.setVisibilty(View.GONE);
                    bi.pff0996x.setText(null);
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

    private boolean UpdateDB() {

        return true;
    }

    private void saveDraft() {
    }

    private boolean formValidation() {


        return true;
    }
}
