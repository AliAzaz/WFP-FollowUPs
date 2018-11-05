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
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivitySectionGBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.ClearClass;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class SectionGActivity extends AppCompatActivity {

    ActivitySectionGBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g);
        bi.setCallback(this);
        this.setTitle(R.string.pfgheading);

        validatorClass.setScrollViewFocus(bi.scrollView);

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

        bi.pfg07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfg07a) {
                    bi.pfg07ax.setVisibility(View.VISIBLE);
                    bi.pfg07bx.setVisibility(View.GONE);
                    bi.pfg07bx.setText(null);
                }
                if (i == R.id.pfg07b) {
                    bi.pfg07ax.setVisibility(View.GONE);
                    bi.pfg07bx.setVisibility(View.VISIBLE);
                    bi.pfg07ax.setText(null);
                }

                if (i == R.id.pfg07c) {
                    bi.pfg07ax.setVisibility(View.GONE);
                    bi.pfg07bx.setVisibility(View.GONE);
                    bi.pfg07ax.setText(null);
                    bi.pfg07bx.setText(null);
                }
            }
        });

        bi.pfg09h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg09a.setChecked(false);
                    bi.pfg09b.setChecked(false);
                    bi.pfg09c.setChecked(false);
                    bi.pfg09d.setChecked(false);
                    bi.pfg09e.setChecked(false);
                    bi.pfg09f.setChecked(false);
                    bi.pfg09g.setChecked(false);
                    bi.pfg0996.setChecked(false);
                    bi.pfg0996x.setText(null);
                }
            }
        });

        bi.pfg09a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg09h.setChecked(false);
                } else {
                    bi.pfg09h.setChecked(true);
                }
            }
        });
        bi.pfg09b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg09h.setChecked(false);
                } else {
                    bi.pfg09h.setChecked(true);
                }
            }
        });
        bi.pfg09c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg09h.setChecked(false);
                } else {
                    bi.pfg09h.setChecked(true);
                }
            }
        });
        bi.pfg09d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg09h.setChecked(false);
                } else {
                    bi.pfg09h.setChecked(true);
                }
            }
        });
        bi.pfg09e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg09h.setChecked(false);
                } else {
                    bi.pfg09h.setChecked(true);
                }
            }
        });
        bi.pfg09f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg09h.setChecked(false);
                } else {
                    bi.pfg09h.setChecked(true);
                }
            }
        });
        bi.pfg09g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg09h.setChecked(false);
                } else {
                    bi.pfg09h.setChecked(true);
                }
            }
        });
        bi.pfg0996.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg09h.setChecked(false);
                    bi.pfg0996x.setVisibility(View.VISIBLE);
                } else {
                    bi.pfg09h.setChecked(true);
                    bi.pfg0996x.setVisibility(View.GONE);
                    bi.pfg0996x.setText(null);
                }
            }
        });

        bi.pfg1698.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg16a.setChecked(false);
                    bi.pfg16b.setChecked(false);
                    bi.pfg16c.setChecked(false);
                    bi.pfg16d.setChecked(false);
                    bi.pfg16e.setChecked(false);
                    bi.pfg16f.setChecked(false);
                    bi.pfg1696.setChecked(false);
                    bi.pfg1696x.setText(null);
                }
            }
        });

        bi.pfg16b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg1698.setChecked(false);
                } else {
                    bi.pfg1698.setChecked(true);
                }
            }
        });
        bi.pfg16c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg1698.setChecked(false);
                } else {
                    bi.pfg1698.setChecked(true);
                }
            }
        });
        bi.pfg16d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg1698.setChecked(false);
                } else {
                    bi.pfg1698.setChecked(true);
                }
            }
        });
        bi.pfg16e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg1698.setChecked(false);
                } else {
                    bi.pfg1698.setChecked(true);
                }
            }
        });
        bi.pfg16f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg1698.setChecked(false);
                } else {
                    bi.pfg1698.setChecked(true);
                }
            }
        });
        bi.pfg1696.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.pfg1698.setChecked(false);
                    bi.pfg1696x.setVisibility(View.VISIBLE);
                } else {
                    bi.pfg1698.setChecked(true);
                    bi.pfg1696x.setVisibility(View.GONE);
                    bi.pfg1696x.setText(null);
                }
            }
        });


    }


    public void BtnContinue() {

        if (formValidation()) {
            Toast.makeText(this, "validated", Toast.LENGTH_SHORT).show();
            try {
                saveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (UpdateDB()) {

                startActivity(new Intent(this, SectionHActivity.class)
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

    private void saveDraft() throws JSONException {

        JSONObject sG = new JSONObject();

        sG.put("pfg01", bi.pfg01.getText().toString());
        sG.put("pfg02", bi.pfg02a.isChecked() ? "1" : bi.pfg02b.isChecked() ? "2" : "0");
        sG.put("pfg03d", bi.pfg03d.getText().toString());
        sG.put("pfg03m", bi.pfg03m.getText().toString());
        sG.put("pfg04", bi.pfg04a.isChecked() ? "1" : bi.pfg04b.isChecked() ? "2" : "0");
        sG.put("pfg05", bi.pfg05.getText().toString());
        sG.put("pfg06", bi.pfg06a.isChecked() ? "1" : bi.pfg06b.isChecked() ? "2" : "0");
        sG.put("pfg07", bi.pfg07a.isChecked() ? "1" : bi.pfg07b.isChecked() ? "2" : bi.pfg07c.isChecked() ? "98" : "0");
        sG.put("pfg07a", bi.pfg07ax.getText().toString());
        sG.put("pfg07b", bi.pfg07bx.getText().toString());
        sG.put("pfg08", bi.pfg08a.isChecked() ? "1"
                : bi.pfg08b.isChecked() ? "2"
                : bi.pfg08c.isChecked() ? "3"
                : bi.pfg08d.isChecked() ? "4"
                : bi.pfg08e.isChecked() ? "5"
                : bi.pfg08f.isChecked() ? "6"
                : bi.pfg08g.isChecked() ? "7"
                : bi.pfg0896.isChecked() ? "96"
                : "0");
        sG.put("pfg0896", bi.pfg0896x.getText().toString());
        sG.put("pfg09a", bi.pfg09a.isChecked() ? "1" : "0");
        sG.put("pfg09b", bi.pfg09b.isChecked() ? "2" : "0");
        sG.put("pfg09c", bi.pfg09c.isChecked() ? "3" : "0");
        sG.put("pfg09d", bi.pfg09d.isChecked() ? "4" : "0");
        sG.put("pfg09e", bi.pfg09e.isChecked() ? "5" : "0");
        sG.put("pfg09f", bi.pfg09f.isChecked() ? "6" : "0");
        sG.put("pfg09g", bi.pfg09g.isChecked() ? "7" : "0");
        sG.put("pfg09h", bi.pfg09h.isChecked() ? "8" : "0");
        sG.put("pfg0996", bi.pfg0996.isChecked() ? "96" : "0");
        sG.put("pfg0996x", bi.pfg0996x.getText().toString());

        sG.put("pfg10", bi.pfg10a.isChecked() ? "1"
                : bi.pfg10b.isChecked() ? "2"
                : bi.pfg10d.isChecked() ? "3"
                : bi.pfg10e.isChecked() ? "4"
                : bi.pfg10f.isChecked() ? "5"
                : bi.pfg10g.isChecked() ? "6"
                : bi.pfg10h.isChecked() ? "7"
                : bi.pfg10i.isChecked() ? "8"
                : bi.pfg10j.isChecked() ? "9"
                : bi.pfg1096.isChecked() ? "96"
                : "0");
        sG.put("pfg109601", bi.pfg1096x.getText().toString());
        sG.put("pfg10i", bi.pfg10ix.getText().toString());
        sG.put("pfg109602", bi.pfg10jx.getText().toString());
        sG.put("pfg11", bi.pfg11a.isChecked() ? "1" : bi.pfg11b.isChecked() ? "2" : bi.pfg1198.isChecked() ? "98" : "0");
        sG.put("pfg12", bi.pfg12a.isChecked() ? "1" : bi.pfg12b.isChecked() ? "2" : bi.pfg1298.isChecked() ? "98" : "0");
        sG.put("pfg13", bi.pfg13a.isChecked() ? "1" : bi.pfg13b.isChecked() ? "2" : bi.pfg1398.isChecked() ? "98" : "0");
        sG.put("pfg14", bi.pfg13a.isChecked() ? "1"
                : bi.pfg14b.isChecked() ? "2"
                : bi.pfg14c.isChecked() ? "3"
                : bi.pfg14d.isChecked() ? "97"
                : bi.pfg1498.isChecked() ? "98"
                : "0");
        sG.put("pfg14d", bi.pfg14bx.getText().toString());
        sG.put("pfg14h", bi.pfg14cx.getText().toString());
        sG.put("pfg15", bi.pfg15a.isChecked() ? "1" : bi.pfg15b.isChecked() ? "2" : bi.pfg1598.isChecked() ? "98" : "0");

        sG.put("pfg16a", bi.pfg16a.isChecked() ? "1" : "0");
        sG.put("pfg16b", bi.pfg16b.isChecked() ? "2" : "0");
        sG.put("pfg16c", bi.pfg16c.isChecked() ? "3" : "0");
        sG.put("pfg16d", bi.pfg16d.isChecked() ? "4" : "0");
        sG.put("pfg16e", bi.pfg16e.isChecked() ? "5" : "0");
        sG.put("pfg16f", bi.pfg16f.isChecked() ? "6" : "0");
        sG.put("pfg1696", bi.pfg1696.isChecked() ? "96" : "0");
        sG.put("pfg1698", bi.pfg1698.isChecked() ? "98" : "0");
        sG.put("pfg1696x", bi.pfg1696x.getText().toString());

        sG.put("pfg17", bi.pfg17a.isChecked() ? "1"
                : bi.pfg17b.isChecked() ? "2"
                : bi.pfg17c.isChecked() ? "3"
                : bi.pfg17d.isChecked() ? "4"
                : bi.pfg17e.isChecked() ? "5"
                : bi.pfg1796.isChecked() ? "961"
                : bi.pfg17f.isChecked() ? "6"
                : bi.pfg17g.isChecked() ? "7"
                : bi.pfg17h.isChecked() ? "8"
                : bi.pfg17i.isChecked() ? "9"
                : bi.pfg17j.isChecked() ? "10"
                : bi.pfg179602.isChecked() ? "962"
                : bi.pfg17k.isChecked() ? "11"
                : bi.pfg17l.isChecked() ? "12"
                : bi.pfg17m.isChecked() ? "13"
                : bi.pfg179603.isChecked() ? "963"
                : "0");
        sG.put("pfg17961", bi.pfg1796x.getText().toString());
        sG.put("pfg17962", bi.pfg179602x.getText().toString());
        sG.put("pfg17963", bi.pfg179603x.getText().toString());
        sG.put("pfg18", bi.pfg18a.isChecked() ? "1" : bi.pfg18b.isChecked() ? "2" : "0");
        sG.put("pfg19a", bi.pfg19a.isChecked() ? "1" : "0");
        sG.put("pfg19b", bi.pfg19a.isChecked() ? "2" : "0");
        sG.put("pfg19c", bi.pfg19a.isChecked() ? "3" : "0");
        sG.put("pfg19d", bi.pfg19a.isChecked() ? "4" : "0");
        sG.put("pfg19e", bi.pfg19a.isChecked() ? "5" : "0");
        sG.put("pfg19f", bi.pfg19a.isChecked() ? "6" : "0");
        sG.put("pfg19g", bi.pfg19a.isChecked() ? "7" : "0");
        sG.put("pfg1996", bi.pfg19a.isChecked() ? "96" : "0");

        sG.put("pfg1996x", bi.pfg1996x.getText().toString());

        sG.put("pfg20", bi.pfg20a.isChecked() ? "1"
                : bi.pfg20b.isChecked() ? "2"
                : bi.pfg20c.isChecked() ? "3"
                : bi.pfg2098.isChecked() ? "98"
                : "0");
        sG.put("pfg20h", bi.pfg20ax.getText().toString());
        sG.put("pfg20d", bi.pfg20bx.getText().toString());
        sG.put("pfg20w", bi.pfg20cx.getText().toString());

        sG.put("pfg21", bi.pfg21.getText().toString());

        sG.put("pfg22a", bi.pfg22a.isChecked() ? "1" : "0");
        sG.put("pfg22b", bi.pfg22a.isChecked() ? "2" : "0");
        sG.put("pfg22c", bi.pfg22a.isChecked() ? "3" : "0");
        sG.put("pfg22d", bi.pfg22a.isChecked() ? "4" : "0");
        sG.put("pfg22e", bi.pfg22a.isChecked() ? "5" : "0");
        sG.put("pfg22f", bi.pfg22a.isChecked() ? "6" : "0");
        sG.put("pfg22g", bi.pfg22a.isChecked() ? "7" : "0");
        sG.put("pfg22h", bi.pfg22a.isChecked() ? "8" : "0");
        sG.put("pfg2296", bi.pfg22a.isChecked() ? "96" : "0");
        sG.put("pfg2296x", bi.pfg2296x.getText().toString());

        sG.put("pfg23", bi.pfg23a.isChecked() ? "1" : bi.pfg23b.isChecked() ? "2" : "0");
        sG.put("pfg24a", bi.pfg24a.isChecked() ? "1" : "0");
        sG.put("pfg24b", bi.pfg24b.isChecked() ? "2" : "0");
        sG.put("pfg24c", bi.pfg24c.isChecked() ? "3" : "0");
        sG.put("pfg24d", bi.pfg24d.isChecked() ? "4" : "0");
        sG.put("pfg24e", bi.pfg24e.isChecked() ? "5" : "0");
        sG.put("pfg24f", bi.pfg24f.isChecked() ? "6" : "0");
        sG.put("pfg24g", bi.pfg24g.isChecked() ? "7" : "0");
        sG.put("pfg2496", bi.pfg2496.isChecked() ? "96" : "0");
        sG.put("pfg2496x", bi.pfg2496x.getText().toString());

        sG.put("pfg25", bi.pfg25a.isChecked() ? "1"
                : bi.pfg25b.isChecked() ? "2"
                : bi.pfg25c.isChecked() ? "3"
                : bi.pfg2598.isChecked() ? "98"
                : "0");
        sG.put("pfg25h", bi.pfg25ax.getText().toString());
        sG.put("pfg25d", bi.pfg25bx.getText().toString());
        sG.put("pfg25w", bi.pfg25cx.getText().toString());

        sG.put("pfg26a", bi.pfg26a.isChecked() ? "1" : "0");
        sG.put("pfg26b", bi.pfg26b.isChecked() ? "2" : "0");
        sG.put("pfg26c", bi.pfg26c.isChecked() ? "3" : "0");
        sG.put("pfg26d", bi.pfg26d.isChecked() ? "4" : "0");
        sG.put("pfg26e", bi.pfg26e.isChecked() ? "5" : "0");
        sG.put("pfg2696", bi.pfg2696.isChecked() ? "96" : "0");
        sG.put("pfg2696x", bi.pfg2696x.getText().toString());

        AppMain.fc.setsG(String.valueOf(sG));

    }

    private boolean formValidation() {

        if (!validatorClass.EmptyTextBox(this, bi.pfg01, getString(R.string.pfg01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfg02, bi.pfg02a, getString(R.string.pfg02))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.pfg03m, getString(R.string.pfg03))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.pfg03m, 0, 6, getString(R.string.pfg03), "Months")) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.pfg03d, getString(R.string.pfg03))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.pfg03d, 0, 29, getString(R.string.pfg03), "Days")) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.pfg04, bi.pfg04a, getString(R.string.pfg04))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.pfg05, getString(R.string.pfg05))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.pfg05, 22, 40, getString(R.string.pfg05), "Weeks")) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.pfg06, bi.pfg06a, getString(R.string.pfg06))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfg07, bi.pfg07a, getString(R.string.pfg07))) {
            return false;
        }
        if (!bi.pfg07c.isChecked()) {
            if (bi.pfg07a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pfg07ax, getString(R.string.pfg07))) {
                    return false;
                }
            }
            if (bi.pfg07b.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pfg07bx, getString(R.string.pfg07))) {
                    return false;
                }
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfg08, bi.pfg08a, getString(R.string.pfg08))) {
            return false;
        }
        if (bi.pfg0896.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.pfg0896x, getString(R.string.pfg08))) {
                return false;
            }
        }
        if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppfg09, bi.pfg09a, getString(R.string.pfg09))) {
            return false;
        }
        if (!bi.pfg09h.isChecked()) {
            if (bi.pfg0996.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pfg0996x, getString(R.string.pfg09))) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.pfg10, bi.pfg10a, getString(R.string.pfg10))) {
            return false;
        }
        if (bi.pfg1096.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.pfg1096x, getString(R.string.pfg10))) {
                return false;
            }
        }
        if (bi.pfg10i.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.pfg10ix, getString(R.string.pfg10))) {
                return false;
            }
        }
        if (bi.pfg10j.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.pfg10jx, getString(R.string.pfg10))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfg11, bi.pfg11a, getString(R.string.pfg11))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfg12, bi.pfg12a, getString(R.string.pfg12))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfg13, bi.pfg13a, getString(R.string.pfg13))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfg14, bi.pfg14a, getString(R.string.pfg14))) {
            return false;
        }
        if (!bi.pfg1498.isChecked() || !bi.pfg14d.isChecked()) {
            if (bi.pfg14b.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pfg14bx, getString(R.string.pfg14))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.pfg14bx, 0, 23, getString(R.string.pfg14), "Hours")) {
                    return false;
                }
            }
            if (bi.pfg14c.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pfg14cx, getString(R.string.pfg14))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.pfg14cx, 1, 60, getString(R.string.pfg14), "Days")) {
                    return false;
                }
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.pfg15, bi.pfg15a, getString(R.string.pfg15))) {
            return false;
        }
        if (bi.pfg15a.isChecked()) {

            if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppfg16, bi.pfg16a, getString(R.string.pfg16))) {
                return false;
            }
            if (!bi.pfg1698.isChecked()) {
                if (bi.pfg1696.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfg1696x, getString(R.string.pfg16))) {
                        return false;
                    }
                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfg17, bi.pfg17a, getString(R.string.pfg17))) {
                return false;
            }
            if (bi.pfg1796.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pfg1796x, getString(R.string.pfg17))) {
                    return false;
                }
            }
            if (bi.pfg179602.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pfg179602x, getString(R.string.pfg17))) {
                    return false;
                }
            }
            if (bi.pfg179603.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pfg179603x, getString(R.string.pfg17))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfg18, bi.pfg18a, getString(R.string.pfg18))) {
                return false;
            }
            if (!bi.pfg18b.isChecked()) {
                if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppfg19, bi.pfg19a, getString(R.string.pfg19))) {
                    return false;
                }
                if (bi.pfg1996.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfg1996x, getString(R.string.pfg19))) {
                        return false;
                    }
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfg20, bi.pfg20a, getString(R.string.pfg20))) {
                    return false;
                }
                if (!bi.pfg2098.isChecked()) {
                    if (bi.pfg20a.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.pfg20ax, getString(R.string.pfg20))) {
                            return false;
                        }
                        if (!validatorClass.RangeTextBox(this, bi.pfg20ax, 0, 23, getString(R.string.pfg20), "Hours")) {
                            return false;
                        }
                    }
                    if (bi.pfg20b.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.pfg20bx, getString(R.string.pfg20))) {
                            return false;
                        }
                        if (!validatorClass.RangeTextBox(this, bi.pfg20bx, 1, 6, getString(R.string.pfg20), "Days")) {
                            return false;
                        }
                    }
                    if (bi.pfg20c.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.pfg20cx, getString(R.string.pfg20))) {
                            return false;
                        }
                        if (!validatorClass.RangeTextBox(this, bi.pfg20cx, 1, 10, getString(R.string.pfg20), "Weeks")) {
                            return false;
                        }
                    }
                }
                if (!validatorClass.EmptyTextBox(this, bi.pfg21, getString(R.string.pfg21))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.pfg21, 1, 5, getString(R.string.pfg21), "Times")) {
                    return false;
                }

                if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppfg22, bi.pfg22a, getString(R.string.pfg22))) {
                    return false;
                }
                if (bi.pfg2296.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfg2296x, getString(R.string.pfg22))) {
                        return false;
                    }
                }

            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfg23, bi.pfg23a, getString(R.string.pfg23))) {
                return false;
            }
            if (!bi.pfg23b.isChecked()) {
                if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppfg24, bi.pfg24a, getString(R.string.pfg24))) {
                    return false;
                }
                if (bi.pfg2496.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfg2496x, getString(R.string.pfg24))) {
                        return false;
                    }
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfg25, bi.pfg25a, getString(R.string.pfg25))) {
                    return false;
                }
                if (!bi.pfg2598.isChecked()) {
                    if (bi.pfg25a.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.pfg25ax, getString(R.string.pfg25))) {
                            return false;
                        }
                        if (!validatorClass.RangeTextBox(this, bi.pfg25ax, 0, 23, getString(R.string.pfg25), "Hours")) {
                            return false;
                        }
                    }
                    if (bi.pfg25b.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.pfg25bx, getString(R.string.pfg25))) {
                            return false;
                        }
                        if (!validatorClass.RangeTextBox(this, bi.pfg25bx, 1, 6, getString(R.string.pfg25), "Days")) {
                            return false;
                        }
                    }
                    if (bi.pfg25c.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.pfg25cx, getString(R.string.pfg25))) {
                            return false;
                        }
                        if (!validatorClass.RangeTextBox(this, bi.pfg25cx, 1, 10, getString(R.string.pfg25), "Weeks")) {
                            return false;
                        }
                    }
                }
                if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrppfg26, bi.pfg26a, getString(R.string.pfg26))) {
                    return false;
                }
                if (bi.pfg2696.isChecked()) {
                    return validatorClass.EmptyTextBox(this, bi.pfg2696x, getString(R.string.pfg26));
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

