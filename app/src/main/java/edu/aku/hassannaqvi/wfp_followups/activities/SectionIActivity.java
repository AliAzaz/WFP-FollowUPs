package edu.aku.hassannaqvi.wfp_followups.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivitySectionIBinding;

public class SectionIActivity extends AppCompatActivity {


    ActivitySectionIBinding bi;
    ArrayList<Integer> answersArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i);
        bi.setCallback(this);
        this.setTitle("Section I");


        //=====================skip patterns=======================================


        /*bi.cci01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.cci01a) {

                    bi.fldgrpcci02.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpcci02, true);

                } else {
                    bi.fldgrpcci02.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpcci02, false);
                }
            }
        });

        bi.cci08a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08a02) {
                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {
                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08b02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08c02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08d.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08d02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08e02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08f.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08f02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }
            }
        });
        bi.cci08g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08g02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08h.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08h02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08i.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08i02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08j.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08j02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08k.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08k02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08l.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08l02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08m.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08m02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08n.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08n02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08o.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08o02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08p.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08p02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);

                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });
        bi.cci08q.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci08q02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrpcci08.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, false);
                    } else {
                        bi.fldgrpcci08.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrpcci08, true);
                    }
                }

            }
        });

        bi.cci09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cci09a) {
                    bi.fldgrpcci09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpcci09, true);

                } else {
                    bi.fldgrpcci09.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpcci09, false);
                }
            }
        });*/
    }

    public void BtnContinue() {

        if (formValidate()) {

            try {
                saveData();
                if (updateDb()) {
                    Intent secNext = new Intent(this, SectionJActivity.class);
                    secNext.putExtra("check", false);
                    startActivity(secNext);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }

    public boolean updateDb() {
        DatabaseHelper db = new DatabaseHelper(this);

        /*int updcount = db.updateSI();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }

    public void saveData() {

        JSONObject sI = new JSONObject();

        /*sI.put("cci01", bi.cci01a.isChecked() ? "1" : bi.cci01b.isChecked() ? "2" : bi.cci0198.isChecked() ? "98" : "0");
        sI.put("cci02", bi.cci02a.isChecked() ? "1" : bi.cci02b.isChecked() ? "2" : bi.cci0298.isChecked() ? "98" : "0");
        sI.put("cci03", bi.cci03a.isChecked() ? "1" : bi.cci03h.isChecked() ? "2" : bi.cci03d.isChecked() ? "3" : "0");
        sI.put("cci03h", bi.cci03hx.getText().toString());
        sI.put("cci03d", bi.cci03dx.getText().toString());
        sI.put("cci04", bi.cci04a.isChecked() ? "1" : bi.cci04b.isChecked() ? "2" : bi.cci0498.isChecked() ? "98" : "0");
        sI.put("cci05", bi.cci05a.isChecked() ? "1" : bi.cci05b.isChecked() ? "2" : bi.cci0598.isChecked() ? "98" : "0");
        sI.put("cci06", bi.cci06a.isChecked() ? "1" : bi.cci06b.isChecked() ? "2" : bi.cci0698.isChecked() ? "98" : "0");
        sI.put("cci07a", bi.cci07a01.isChecked() ? "1" : bi.cci07a02.isChecked() ? "1" : bi.cci07a98.isChecked() ? "98" : "0");
        sI.put("cci07b", bi.cci07b01.isChecked() ? "1" : bi.cci07b02.isChecked() ? "1" : bi.cci07b98.isChecked() ? "98" : "0");
        sI.put("cci07bt", bi.cci07bx.getText().toString());
        sI.put("cci07c", bi.cci07c01.isChecked() ? "1" : bi.cci07c02.isChecked() ? "1" : bi.cci07c98.isChecked() ? "98" : "0");
        sI.put("cci07ct", bi.cci07c01x.getText().toString());
        sI.put("cci07d", bi.cci07d01.isChecked() ? "1" : bi.cci07d02.isChecked() ? "1" : bi.cci07d98.isChecked() ? "98" : "0");
        sI.put("cci07e", bi.cci07e01.isChecked() ? "1" : bi.cci07e02.isChecked() ? "1" : bi.cci07e98.isChecked() ? "98" : "0");
        sI.put("cci07f", bi.cci07f01.isChecked() ? "1" : bi.cci07f02.isChecked() ? "1" : bi.cci07f98.isChecked() ? "98" : "0");
        sI.put("cci07ft", bi.cci07f01x.getText().toString());
        sI.put("cci07g", bi.cci07g01.isChecked() ? "1" : bi.cci07g02.isChecked() ? "1" : bi.cci07g98.isChecked() ? "98" : "0");
        sI.put("cci07h", bi.cci07h01.isChecked() ? "1" : bi.cci07h02.isChecked() ? "1" : bi.cci07h98.isChecked() ? "98" : "0");
        sI.put("cci07i", bi.cci07i01.isChecked() ? "1" : bi.cci07i02.isChecked() ? "1" : bi.cci07i98.isChecked() ? "98" : "0");

        sI.put("cci08a", bi.cci08a01.isChecked() ? "1" : bi.cci08a02.isChecked() ? "1" : bi.cci08a98.isChecked() ? "98" : "0");
        sI.put("cci08b", bi.cci08b01.isChecked() ? "1" : bi.cci08b02.isChecked() ? "1" : bi.cci08b98.isChecked() ? "98" : "0");
        sI.put("cci08c", bi.cci08c01.isChecked() ? "1" : bi.cci08c02.isChecked() ? "1" : bi.cci08c98.isChecked() ? "98" : "0");
        sI.put("cci08d", bi.cci08d01.isChecked() ? "1" : bi.cci08d02.isChecked() ? "1" : bi.cci08d98.isChecked() ? "98" : "0");
        sI.put("cci08e", bi.cci08e01.isChecked() ? "1" : bi.cci08e02.isChecked() ? "1" : bi.cci08e98.isChecked() ? "98" : "0");
        sI.put("cci08f", bi.cci08f01.isChecked() ? "1" : bi.cci08f02.isChecked() ? "1" : bi.cci08f98.isChecked() ? "98" : "0");
        sI.put("cci08g", bi.cci08g01.isChecked() ? "1" : bi.cci08g02.isChecked() ? "1" : bi.cci08g98.isChecked() ? "98" : "0");
        sI.put("cci08h", bi.cci08h01.isChecked() ? "1" : bi.cci08h02.isChecked() ? "1" : bi.cci08h98.isChecked() ? "98" : "0");
        sI.put("cci08i", bi.cci08i01.isChecked() ? "1" : bi.cci08i02.isChecked() ? "1" : bi.cci08i98.isChecked() ? "98" : "0");
        sI.put("cci08j", bi.cci08j01.isChecked() ? "1" : bi.cci08j02.isChecked() ? "1" : bi.cci08j98.isChecked() ? "98" : "0");
        sI.put("cci08k", bi.cci08k01.isChecked() ? "1" : bi.cci08k02.isChecked() ? "1" : bi.cci08k98.isChecked() ? "98" : "0");
        sI.put("cci08l", bi.cci08l01.isChecked() ? "1" : bi.cci08l02.isChecked() ? "1" : bi.cci08l98.isChecked() ? "98" : "0");
        sI.put("cci08m", bi.cci08m01.isChecked() ? "1" : bi.cci08m02.isChecked() ? "1" : bi.cci08m98.isChecked() ? "98" : "0");
        sI.put("cci08n", bi.cci08n01.isChecked() ? "1" : bi.cci08n02.isChecked() ? "1" : bi.cci08n98.isChecked() ? "98" : "0");
        sI.put("cci08o", bi.cci08o01.isChecked() ? "1" : bi.cci08o02.isChecked() ? "1" : bi.cci08o98.isChecked() ? "98" : "0");
        sI.put("cci08p", bi.cci08p01.isChecked() ? "1" : bi.cci08p02.isChecked() ? "1" : bi.cci08p98.isChecked() ? "98" : "0");
        sI.put("cci08q", bi.cci08q01.isChecked() ? "1" : bi.cci08q02.isChecked() ? "1" : bi.cci08q98.isChecked() ? "98" : "0");

        sI.put("cci09", bi.cci09a.isChecked() ? "1" : bi.cci09b.isChecked() ? "2" : bi.cci0998.isChecked() ? "98" : "0");
        sI.put("cci10", bi.cci1098.isChecked() ? "98" : "0");
        sI.put("cci10t", bi.cci10t.getText().toString());
        sI.put("cci11", bi.cci11a.isChecked() ? "1" : bi.cci11b.isChecked() ? "2" : bi.cci1198.isChecked() ? "98" : "0");
        sI.put("cci12", bi.cci12a.isChecked() ? "1" : bi.cci12b.isChecked() ? "2" : bi.cci1298.isChecked() ? "98" : "0");
        sI.put("cci13", bi.cci13a.isChecked() ? "1" : bi.cci13b.isChecked() ? "2" : bi.cci1398.isChecked() ? "98" : "0");
        sI.put("cci14", bi.cci14a.isChecked() ? "1" : bi.cci14b.isChecked() ? "2" : bi.cci1498.isChecked() ? "98" : "0");
        sI.put("cci15", bi.cci15a.isChecked() ? "1" : bi.cci15b.isChecked() ? "2" : bi.cci1598.isChecked() ? "98" : "0");
        sI.put("cci16", bi.cci16m.isChecked() ? "1" : bi.cci16d.isChecked() ? "2" : bi.cci1697.isChecked() ? "97" : "0");
        sI.put("cci16m", bi.cci16mx.getText().toString());
        sI.put("cci16d", bi.cci16dx.getText().toString());
        MainApp.fc.setsI(String.valueOf(sI));
        Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show();*/

    }

    private boolean formValidate() {


       /* if (!validatorClass.EmptyRadioButton(this, bi.cci01, bi.cci01a, getString(R.string.cci01))) {
            return false;
        }

        // Q 1.1 check
        if (!bi.cci01a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.cci02, bi.cci02a, getString(R.string.cci02))) {
                return false;
            }
        }
        //Q2 check
        if (!validatorClass.EmptyRadioButton(this, bi.cci03, bi.cci03a, getString(R.string.cci03))) {
            return false;
        }
        if (bi.cci03h.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.cci03hx, getString(R.string.cci03))) {
                return false;
            }
        }
        if (bi.cci03d.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.cci03dx, getString(R.string.cci03))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci04, bi.cci04a, getString(R.string.cci04))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci05, bi.cci05a, getString(R.string.cci05))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci06, bi.cci06a, getString(R.string.cci06))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci07a, bi.cci07a01, getString(R.string.cci07a))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci07b, bi.cci07b01, getString(R.string.cci07b))) {
            return false;
        }
        if (bi.cci07b01.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.cci07bx, getString(R.string.cci07b))) {
                return false;
            }

        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci07c, bi.cci07c01, getString(R.string.cci07c))) {
            return false;
        }
        if (bi.cci07c01.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.cci07c01x, getString(R.string.cci07c))) {
                return false;
            }

        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci07d, bi.cci07d01, getString(R.string.cci07d))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci07e, bi.cci07e01, getString(R.string.cci07e))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci07f, bi.cci07f01, getString(R.string.cci07f))) {
            return false;
        }
        if (bi.cci07f01.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.cci07f01x, getString(R.string.cci07f))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci07g, bi.cci07g01, getString(R.string.cci07g))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci07h, bi.cci07h01, getString(R.string.cci07h))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci07i, bi.cci07i01, getString(R.string.cci07i))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.cci08a, bi.cci08a01, getString(R.string.cci08a))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08b, bi.cci08b01, getString(R.string.cci08b))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08c, bi.cci08c01, getString(R.string.cci08c))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08d, bi.cci08d01, getString(R.string.cci08d))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08e, bi.cci08e01, getString(R.string.cci08e))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08f, bi.cci08f01, getString(R.string.cci08f))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08g, bi.cci08g01, getString(R.string.cci08g))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08h, bi.cci08h01, getString(R.string.cci08h))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08i, bi.cci08i01, getString(R.string.cci08i))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08j, bi.cci08j01, getString(R.string.cci08j))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08k, bi.cci08k01, getString(R.string.cci08k))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08l, bi.cci08l01, getString(R.string.cci08l))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08m, bi.cci08m01, getString(R.string.cci08m))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08n, bi.cci08n01, getString(R.string.cci08n))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08o, bi.cci08o01, getString(R.string.cci08o))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08p, bi.cci08p01, getString(R.string.cci08p))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci08q, bi.cci08q01, getString(R.string.cci08q))) {
            return false;
        }
        for (int j = 0; j < answersArray.size(); j++) {
            if (answersArray.get(j) != 2) {
                if (!validatorClass.EmptyRadioButton(this, bi.cci09, bi.cci09a, getString(R.string.cci09))) {
                    return false;
                }
            }
        }
        if (!bi.cci1098.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.cci10t, getString(R.string.cci10))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci11, bi.cci11a, getString(R.string.cci11))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci12, bi.cci12a, getString(R.string.cci12))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci13, bi.cci13a, getString(R.string.cci13))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci14, bi.cci14a, getString(R.string.cci14))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cci15, bi.cci15a, getString(R.string.cci15))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.cci16, bi.cci16m, getString(R.string.cci16))) {
            return false;
        }

        if (bi.cci16m.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.cci16mx, getString(R.string.cci16))) {
                return false;
            }
        }
        if (bi.cci16d.isChecked()) {
            return validatorClass.EmptyTextBox(this, bi.cci16dx, getString(R.string.cci16));
        }*/

        return true;
    }

    public void BtnEnd() {

        AppMain.endActivity(this, this);

    }
}
