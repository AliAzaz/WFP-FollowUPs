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

import java.util.ArrayList;

import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.databinding.ActivitySectionIBinding;
import edu.aku.hassannaqvi.wfp_followups.validation.ClearClass;
import edu.aku.hassannaqvi.wfp_followups.validation.validatorClass;

public class SectionIActivity extends AppCompatActivity {


    ActivitySectionIBinding bi;
    ArrayList<Integer> answersArray = new ArrayList<>();
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i);
        bi.setCallback(this);
        this.setTitle(getString(R.string.pfiheading));


        if (!InfoActivity.enrolledParticipant.getFupround().equals("1")) {

            bi.fldgrppfifirstfollowup.setVisibility(View.GONE);
            ClearClass.ClearAllFields(bi.fldgrppfi01, false);
            ClearClass.ClearAllFields(bi.fldgrppfi02, false);
            ClearClass.ClearAllFields(bi.fldgrppfi03, false);
            ClearClass.ClearAllFields(bi.fldgrppfi04, false);
            ClearClass.ClearAllFields(bi.fldgrppfi05, false);
            ClearClass.ClearAllFields(bi.fldgrppfi06, false);
        }

        //=====================skip patterns=======================================

        bi.pfi01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.pfi01a) {
                    ClearClass.ClearAllFields(bi.flgrppfia, true);
                } else {
                    ClearClass.ClearAllFields(bi.flgrppfia, false);
                }
            }
        });

        bi.pfi03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.pfi03b) {
                    ClearClass.ClearAllFields(bi.fldgrppfi04, false);
                } else {
                    ClearClass.ClearAllFields(bi.fldgrppfi04, true);
                }
            }
        });

        bi.pfi05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.pfi05a.getId()) {
                    bi.fldgrppfi06.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrppfi06, true);
                } else {
                    bi.fldgrppfi06.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.pfi0699.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    ClearClass.ClearAllFields(bi.fldgrpppfi06a, false);
                } else {
                    ClearClass.ClearAllFields(bi.fldgrpppfi06a, true);
                }
            }
        });

        bi.pfi07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.pfi07a.getId()) {
                    bi.pfi0701.clearCheck();
                }
            }
        });

        RadioGroup.OnCheckedChangeListener check = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.pfi12a02.getId() || i == bi.pfi12b02.getId() || i == bi.pfi12c02.getId() || i == bi.pfi12d02.getId()
                        || i == bi.pfi12e02.getId() || i == bi.pfi12f02.getId() || i == bi.pfi12g02.getId() || i == bi.pfi12h02.getId()
                        || i == bi.pfi12i02.getId() || i == bi.pfi12j02.getId() || i == bi.pfi12k02.getId() || i == bi.pfi12l02.getId()
                        || i == bi.pfi12m02.getId() || i == bi.pfi12n02.getId() || i == bi.pfi12o02.getId() || i == bi.pfi12p02.getId()
                        || i == bi.pfi12q02.getId()) {
                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {
                    flag = answersArray.get(j) == 2;
                }

                if (flag) {
                    bi.fldgrppfi13.setVisibility(View.GONE);
                    bi.pfi13.clearCheck();
                } else {
                    bi.fldgrppfi13.setVisibility(View.VISIBLE);
                }

            }
        };

        bi.pfi12a.setOnCheckedChangeListener(check);
        bi.pfi12b.setOnCheckedChangeListener(check);
        bi.pfi12c.setOnCheckedChangeListener(check);
        bi.pfi12d.setOnCheckedChangeListener(check);
        bi.pfi12e.setOnCheckedChangeListener(check);
        bi.pfi12f.setOnCheckedChangeListener(check);
        bi.pfi12g.setOnCheckedChangeListener(check);
        bi.pfi12h.setOnCheckedChangeListener(check);
        bi.pfi12i.setOnCheckedChangeListener(check);
        bi.pfi12j.setOnCheckedChangeListener(check);
        bi.pfi12k.setOnCheckedChangeListener(check);
        bi.pfi12l.setOnCheckedChangeListener(check);
        bi.pfi12m.setOnCheckedChangeListener(check);
        bi.pfi12n.setOnCheckedChangeListener(check);
        bi.pfi12o.setOnCheckedChangeListener(check);
        bi.pfi12p.setOnCheckedChangeListener(check);
        bi.pfi12q.setOnCheckedChangeListener(check);

        /*bi.pfi12a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12a02) {
                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {
                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12b02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12c02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12d.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12d02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12e02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12f.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12f02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }
            }
        });
        bi.pfi12g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12g02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12h.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12h02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12i.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12i02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12j.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12j02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12k.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12k02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12l.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12l02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12m.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12m02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12n.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12n02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12o.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12o02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12p.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12p02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);

                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });
        bi.pfi12q.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.pfi12q02) {

                    answersArray.add(2);
                } else {
                    answersArray.add(1);
                }

                for (int j = 0; j < answersArray.size(); j++) {

                    if (answersArray.get(j) == 2) {
                        bi.fldgrppfi12.setVisibility(View.GONE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, false);
                    } else {
                        bi.fldgrppfi12.setVisibility(View.VISIBLE);
                        ClearClass.ClearAllFields(bi.fldgrppfi12, true);
                    }
                }

            }
        });*/

        bi.pfi13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.pfi13a) {
                    bi.fldgrppfi14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrppfi14, true);

                } else {
                    if (!flag) {
                        bi.fldgrppfi14.setVisibility(View.VISIBLE);
                    }


                }
            }
        });

        bi.pfi15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.pfi15a) {
                    ClearClass.ClearAllFields(bi.flgrppfib, true);
                }
            }
        });
    }

    public void BtnContinue() {

        if (formValidate()) {

            try {
                saveData();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (updateDB()) {
                finish();
                Intent secNext = new Intent(this, SectionBActivity.currentlyPR == 2 ? EndingActivity.class : SectionJActivity.class);
                startActivity(secNext);
            }
        }


    }

    public boolean updateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updatesI();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void saveData() throws JSONException {

        JSONObject sI = new JSONObject();

        sI.put("pfi01", bi.pfi01a.isChecked() ? "1" : bi.pfi01b.isChecked() ? "2" : bi.pfi0198.isChecked() ? "98" : "0");
        sI.put("pfi02", bi.pfi02a.isChecked() ? "000" : bi.pfi02h.isChecked() ? "1" : bi.pfi02d.isChecked() ? "2" : "0");
        sI.put("pfi02h", bi.pfi02hx.getText().toString());
        sI.put("pfi02d", bi.pfi02dx.getText().toString());
        sI.put("pfi03", bi.pfi03a.isChecked() ? "1" : bi.pfi03b.isChecked() ? "2" : bi.pfi0398.isChecked() ? "98" : "0");
        sI.put("pfi04", bi.pfi04a.isChecked() ? "1" : bi.pfi04b.isChecked() ? "2" : bi.pfi04c.isChecked() ? "3" : bi.pfi0496.isChecked() ? "96" : "0");
        sI.put("pfi04x", bi.pfi0496x.getText().toString());
        sI.put("pfi05", bi.pfi05a.isChecked() ? "1" : bi.pfi05b.isChecked() ? "2" : "0");

        sI.put("pfi06a", bi.pfi06a.isChecked() ? "1" : "0");
        sI.put("pfi06b", bi.pfi06b.isChecked() ? "2" : "0");
        sI.put("pfi06c", bi.pfi06c.isChecked() ? "3" : "0");
        sI.put("pfi06d", bi.pfi06d.isChecked() ? "4" : "0");
        sI.put("pfi06e", bi.pfi06e.isChecked() ? "5" : "0");
        sI.put("pfi06f", bi.pfi06f.isChecked() ? "6" : "0");
        sI.put("pfi06g", bi.pfi06g.isChecked() ? "7" : "0");
        sI.put("pfi06h", bi.pfi06h.isChecked() ? "8" : "0");
        sI.put("pfi06i", bi.pfi06i.isChecked() ? "9" : "0");
        sI.put("pfi06j", bi.pfi06j.isChecked() ? "10" : "0");
        sI.put("pfi0696", bi.pfi0696.isChecked() ? "96" : "0");
        sI.put("pfi0699", bi.pfi0699.isChecked() ? "99" : "0");
        sI.put("pfi0696x", bi.pfi0696x.getText().toString());

        sI.put("pfi07", bi.pfi07a.isChecked() ? "1" : bi.pfi07b.isChecked() ? "2" : bi.pfi0798.isChecked() ? "98" : "0");
        sI.put("pfi07a", bi.pfi0701a.isChecked() ? "1" : bi.pfi0701b.isChecked() ? "2" : bi.pfi070198.isChecked() ? "98" : "0");
        sI.put("pfi08", bi.pfi08a.isChecked() ? "1" : bi.pfi08b.isChecked() ? "2" : bi.pfi0898.isChecked() ? "98" : "0");
        sI.put("pfi09", bi.pfi09a.isChecked() ? "1" : bi.pfi09b.isChecked() ? "2" : bi.pfi0998.isChecked() ? "98" : "0");

        sI.put("pfi10a", bi.pfi10a01.isChecked() ? "1" : bi.pfi10a02.isChecked() ? "2" : bi.pfi10a98.isChecked() ? "98" : "0");
        sI.put("pfi10b", bi.pfi10b01.isChecked() ? "1" : bi.pfi10b02.isChecked() ? "2" : bi.pfi10b98.isChecked() ? "98" : "0");
        sI.put("pfi10bt", bi.pfi10bx.getText().toString());
        sI.put("pfi10c", bi.pfi10c01.isChecked() ? "1" : bi.pfi10c02.isChecked() ? "2" : bi.pfi10c98.isChecked() ? "98" : "0");
        sI.put("pfi10ct", bi.pfi10c01x.getText().toString());
        sI.put("pfi10d", bi.pfi10d01.isChecked() ? "1" : bi.pfi10d02.isChecked() ? "2" : bi.pfi10d98.isChecked() ? "98" : "0");
        sI.put("pfi10e", bi.pfi10e01.isChecked() ? "1" : bi.pfi10e02.isChecked() ? "2" : bi.pfi10e98.isChecked() ? "98" : "0");
        sI.put("pfi10f", bi.pfi10f01.isChecked() ? "1" : bi.pfi10f02.isChecked() ? "2" : bi.pfi10f98.isChecked() ? "98" : "0");
        sI.put("pfi10ft", bi.pfi10f01x.getText().toString());
        sI.put("pfi10g", bi.pfi10g01.isChecked() ? "1" : bi.pfi10g02.isChecked() ? "2" : bi.pfi10g98.isChecked() ? "98" : "0");
        sI.put("pfi10h", bi.pfi10h01.isChecked() ? "1" : bi.pfi10h02.isChecked() ? "2" : bi.pfi10h98.isChecked() ? "98" : "0");
        sI.put("pfi10i", bi.pfi10i01.isChecked() ? "1" : bi.pfi10i02.isChecked() ? "2" : bi.pfi10i98.isChecked() ? "98" : "0");

        sI.put("pfi12a", bi.pfi12a01.isChecked() ? "1" : bi.pfi12a02.isChecked() ? "2" : bi.pfi12a98.isChecked() ? "98" : "0");
        sI.put("pfi12b", bi.pfi12b01.isChecked() ? "1" : bi.pfi12b02.isChecked() ? "2" : bi.pfi12b98.isChecked() ? "98" : "0");
        sI.put("pfi12c", bi.pfi12c01.isChecked() ? "1" : bi.pfi12c02.isChecked() ? "2" : bi.pfi12c98.isChecked() ? "98" : "0");
        sI.put("pfi12d", bi.pfi12d01.isChecked() ? "1" : bi.pfi12d02.isChecked() ? "2" : bi.pfi12d98.isChecked() ? "98" : "0");
        sI.put("pfi12e", bi.pfi12e01.isChecked() ? "1" : bi.pfi12e02.isChecked() ? "2" : bi.pfi12e98.isChecked() ? "98" : "0");
        sI.put("pfi12f", bi.pfi12f01.isChecked() ? "1" : bi.pfi12f02.isChecked() ? "2" : bi.pfi12f98.isChecked() ? "98" : "0");
        sI.put("pfi12g", bi.pfi12g01.isChecked() ? "1" : bi.pfi12g02.isChecked() ? "2" : bi.pfi12g98.isChecked() ? "98" : "0");
        sI.put("pfi12h", bi.pfi12h01.isChecked() ? "1" : bi.pfi12h02.isChecked() ? "2" : bi.pfi12h98.isChecked() ? "98" : "0");
        sI.put("pfi12i", bi.pfi12i01.isChecked() ? "1" : bi.pfi12i02.isChecked() ? "2" : bi.pfi12i98.isChecked() ? "98" : "0");
        sI.put("pfi12j", bi.pfi12j01.isChecked() ? "1" : bi.pfi12j02.isChecked() ? "2" : bi.pfi12j98.isChecked() ? "98" : "0");
        sI.put("pfi12k", bi.pfi12k01.isChecked() ? "1" : bi.pfi12k02.isChecked() ? "2" : bi.pfi12k98.isChecked() ? "98" : "0");
        sI.put("pfi12l", bi.pfi12l01.isChecked() ? "1" : bi.pfi12l02.isChecked() ? "2" : bi.pfi12l98.isChecked() ? "98" : "0");
        sI.put("pfi12m", bi.pfi12m01.isChecked() ? "1" : bi.pfi12m02.isChecked() ? "2" : bi.pfi12m98.isChecked() ? "98" : "0");
        sI.put("pfi12n", bi.pfi12n01.isChecked() ? "1" : bi.pfi12n02.isChecked() ? "2" : bi.pfi12n98.isChecked() ? "98" : "0");
        sI.put("pfi12o", bi.pfi12o01.isChecked() ? "1" : bi.pfi12o02.isChecked() ? "2" : bi.pfi12o98.isChecked() ? "98" : "0");
        sI.put("pfi12p", bi.pfi12p01.isChecked() ? "1" : bi.pfi12p02.isChecked() ? "2" : bi.pfi12p98.isChecked() ? "98" : "0");
        sI.put("pfi12q", bi.pfi12q01.isChecked() ? "1" : bi.pfi12q02.isChecked() ? "2" : bi.pfi12q98.isChecked() ? "98" : "0");

        sI.put("pfi13", bi.pfi13a.isChecked() ? "1" : bi.pfi13b.isChecked() ? "2" : bi.pfi1398.isChecked() ? "98" : "0");
        sI.put("pfi14", bi.pfi1498.isChecked() ? "98" : "0");
        sI.put("pfi14t", bi.pfi14t.getText().toString());
        sI.put("pfi15", bi.pfi15a.isChecked() ? "1" : bi.pfi15b.isChecked() ? "2" : bi.pfi1598.isChecked() ? "98" : "0");

        sI.put("pfi16", bi.pfi16a.isChecked() ? "1" : bi.pfi16b.isChecked() ? "2"
                : bi.pfi16c.isChecked() ? "3"
                : bi.pfi1696.isChecked() ? "96"
                : "0");
        sI.put("pfi1696x", bi.pfi1696x.getText().toString());

        sI.put("pfi17", bi.pfi17a.isChecked() ? "1" : bi.pfi17b.isChecked() ? "2"
                : bi.pfi17c.isChecked() ? "3"
                : bi.pfi1796.isChecked() ? "96"
                : "0");
        sI.put("pfi1796x", bi.pfi1796x.getText().toString());

        sI.put("pfi18", bi.pfi18a.isChecked() ? "1" : bi.pfi18b.isChecked() ? "2" : bi.pfi1898.isChecked() ? "98" : "0");

        AppMain.fc.setsI(String.valueOf(sI));

    }

    private boolean formValidate() {

        if (InfoActivity.enrolledParticipant.getFupround().equals("1")) {

            if (!validatorClass.EmptyRadioButton(this, bi.pfi01, bi.pfi01a, getString(R.string.pfi01))) {
                return false;
            }

            // Q 1.1 check
            if (bi.pfi01a.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.pfi02, bi.pfi02a, getString(R.string.pfi02))) {
                    return false;
                }
                //Q2 check
                if (!validatorClass.EmptyRadioButton(this, bi.pfi02, bi.pfi02a, getString(R.string.pfi02))) {
                    return false;
                }
                if (bi.pfi02h.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfi02hx, getString(R.string.pfi02))) {
                        return false;
                    }
                    if (!validatorClass.RangeTextBox(this, bi.pfi02hx, 1, 23, getString(R.string.pfi02), "Hour(s)")) {
                        return false;
                    }
                }
                if (bi.pfi02d.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfi02dx, getString(R.string.pfi02))) {
                        return false;
                    }
                    if (!validatorClass.RangeTextBox(this, bi.pfi02dx, 1, 60, getString(R.string.pfi02), "Day(s)")) {
                        return false;
                    }
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi03, bi.pfi03a, getString(R.string.pfi03))) {
                    return false;
                }

                if (bi.pfi03b.isChecked()) {
                    if (!validatorClass.EmptyRadioButton(this, bi.pfi04, bi.pfi0496, bi.pfi0496x, getString(R.string.pfi04))) {
                        return false;
                    }
                }

                if (!validatorClass.EmptyRadioButton(this, bi.pfi05, bi.pfi05a, getString(R.string.pfi05))) {
                    return false;
                }

                if (bi.pfi05a.isChecked() && !bi.pfi0699.isChecked()) {
                    if (!validatorClass.EmptyCheckBox(this, bi.fldgrpppfi06a, bi.pfi06a, getString(R.string.pfi06))) {
                        return false;
                    }
                    if (bi.pfi0696.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.pfi0696x, getString(R.string.pfi06))) {
                            return false;
                        }
                    }
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi07, bi.pfi07a, getString(R.string.pfi07))) {
                    return false;
                }

                if (!bi.pfi01a.isChecked() && !bi.pfi07a.isChecked()) {
                    if (!validatorClass.EmptyRadioButton(this, bi.pfi0701, bi.pfi0701a, getString(R.string.pfi07a))) {
                        return false;
                    }
                }

                if (!validatorClass.EmptyRadioButton(this, bi.pfi08, bi.pfi08a, getString(R.string.pfi08))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi09, bi.pfi09a, getString(R.string.pfi09))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10a, bi.pfi10a01, getString(R.string.pfi10a))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10b, bi.pfi10b01, getString(R.string.pfi10b))) {
                    return false;
                }
                if (bi.pfi10b01.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfi10bx, getString(R.string.pfi10b))) {
                        return false;
                    }
                    if (!validatorClass.RangeTextBox(this, bi.pfi10bx, 1, 12, getString(R.string.pfi10b), "Times")) {
                        return false;
                    }

                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10c, bi.pfi10c01, getString(R.string.pfi10c))) {
                    return false;
                }
                if (bi.pfi10c01.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfi10c01x, getString(R.string.pfi10c))) {
                        return false;
                    }
                    if (!validatorClass.RangeTextBox(this, bi.pfi10c01x, 1, 12, getString(R.string.pfi10c), "Times")) {
                        return false;
                    }

                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10d, bi.pfi10d01, getString(R.string.pfi10d))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10e, bi.pfi10e01, getString(R.string.pfi10e))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10f, bi.pfi10f01, getString(R.string.pfi10f))) {
                    return false;
                }
                if (bi.pfi10f01.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfi10f01x, getString(R.string.pfi10f))) {
                        return false;
                    }
                    if (!validatorClass.RangeTextBox(this, bi.pfi10f01x, 1, 12, getString(R.string.pfi10f), "Times")) {
                        return false;
                    }
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10g, bi.pfi10g01, getString(R.string.pfi10g))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10h, bi.pfi10h01, getString(R.string.pfi10h))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10i, bi.pfi10i01, getString(R.string.pfi10i))) {
                    return false;
                }

                if (!validatorClass.EmptyRadioButton(this, bi.pfi12a, bi.pfi12a01, getString(R.string.pfi12a))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12b, bi.pfi12b01, getString(R.string.pfi12b))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12c, bi.pfi12c01, getString(R.string.pfi12c))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12d, bi.pfi12d01, getString(R.string.pfi12d))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12e, bi.pfi12e01, getString(R.string.pfi12e))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12f, bi.pfi12f01, getString(R.string.pfi12f))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12g, bi.pfi12g01, getString(R.string.pfi12g))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12h, bi.pfi12h01, getString(R.string.pfi12h))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12i, bi.pfi12i01, getString(R.string.pfi12i))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12j, bi.pfi12j01, getString(R.string.pfi12j))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12k, bi.pfi12k01, getString(R.string.pfi12k))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12l, bi.pfi12l01, getString(R.string.pfi12l))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12m, bi.pfi12m01, getString(R.string.pfi12m))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12n, bi.pfi12n01, getString(R.string.pfi12n))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12o, bi.pfi12o01, getString(R.string.pfi12o))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12p, bi.pfi12p01, getString(R.string.pfi12p))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12q, bi.pfi12q01, getString(R.string.pfi12q))) {
                    return false;
                }

                if (!flag) {
                    if (!validatorClass.EmptyRadioButton(this, bi.pfi13, bi.pfi13a, getString(R.string.pfi13))) {
                        return false;
                    }
                }

                if (!flag && bi.pfi13a.isChecked()) {
                    if (!bi.pfi1498.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.pfi14t, getString(R.string.pfi14))) {
                            return false;
                        }
                        if (!validatorClass.RangeTextBox(this, bi.pfi14t, 1, 12, getString(R.string.pfi14), "Times")) {
                            return false;
                        }
                    }

                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi15, bi.pfi15a, getString(R.string.pfi15))) {
                    return false;
                }

                if (bi.pfi15a.isChecked()) {
                    if (!validatorClass.EmptyRadioButton(this, bi.pfi16, bi.pfi1696, bi.pfi1696x, getString(R.string.pfi16))) {
                        return false;
                    }
                    if (!validatorClass.EmptyRadioButton(this, bi.pfi17, bi.pfi1796, bi.pfi1796x, getString(R.string.pfi17))) {
                        return false;
                    }
                    return validatorClass.EmptyRadioButton(this, bi.pfi18, bi.pfi18a, getString(R.string.pfi18));
                }
            } else {
                if (!validatorClass.EmptyRadioButton(this, bi.pfi0701, bi.pfi0701a, getString(R.string.pfi07a))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi08, bi.pfi08a, getString(R.string.pfi08))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi09, bi.pfi09a, getString(R.string.pfi09))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10a, bi.pfi10a01, getString(R.string.pfi10a))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10b, bi.pfi10b01, getString(R.string.pfi10b))) {
                    return false;
                }
                if (bi.pfi10b01.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfi10bx, getString(R.string.pfi10b))) {
                        return false;
                    }

                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10c, bi.pfi10c01, getString(R.string.pfi10c))) {
                    return false;
                }
                if (bi.pfi10c01.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfi10c01x, getString(R.string.pfi10c))) {
                        return false;
                    }

                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10d, bi.pfi10d01, getString(R.string.pfi10d))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10e, bi.pfi10e01, getString(R.string.pfi10e))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10f, bi.pfi10f01, getString(R.string.pfi10f))) {
                    return false;
                }
                if (bi.pfi10f01.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfi10f01x, getString(R.string.pfi10f))) {
                        return false;
                    }
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10g, bi.pfi10g01, getString(R.string.pfi10g))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10h, bi.pfi10h01, getString(R.string.pfi10h))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi10i, bi.pfi10i01, getString(R.string.pfi10i))) {
                    return false;
                }

                if (!validatorClass.EmptyRadioButton(this, bi.pfi12a, bi.pfi12a01, getString(R.string.pfi12a))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12b, bi.pfi12b01, getString(R.string.pfi12b))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12c, bi.pfi12c01, getString(R.string.pfi12c))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12d, bi.pfi12d01, getString(R.string.pfi12d))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12e, bi.pfi12e01, getString(R.string.pfi12e))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12f, bi.pfi12f01, getString(R.string.pfi12f))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12g, bi.pfi12g01, getString(R.string.pfi12g))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12h, bi.pfi12h01, getString(R.string.pfi12h))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12i, bi.pfi12i01, getString(R.string.pfi12i))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12j, bi.pfi12j01, getString(R.string.pfi12j))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12k, bi.pfi12k01, getString(R.string.pfi12k))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12l, bi.pfi12l01, getString(R.string.pfi12l))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12m, bi.pfi12m01, getString(R.string.pfi12m))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12n, bi.pfi12n01, getString(R.string.pfi12n))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12o, bi.pfi12o01, getString(R.string.pfi12o))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12p, bi.pfi12p01, getString(R.string.pfi12p))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi12q, bi.pfi12q01, getString(R.string.pfi12q))) {
                    return false;
                }

                if (!flag) {
                    if (!validatorClass.EmptyRadioButton(this, bi.pfi13, bi.pfi13a, getString(R.string.pfi13))) {
                        return false;
                    }
                }

                if (!flag && bi.pfi13a.isChecked()) {
                    if (!bi.pfi1498.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.pfi14t, getString(R.string.pfi14))) {
                            return false;
                        }
                    }

                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi15, bi.pfi15a, getString(R.string.pfi15))) {
                    return false;
                }

                if (bi.pfi15a.isChecked()) {
                    if (!validatorClass.EmptyRadioButton(this, bi.pfi16, bi.pfi1696, bi.pfi1696x, getString(R.string.pfi16))) {
                        return false;
                    }
                    if (!validatorClass.EmptyRadioButton(this, bi.pfi17, bi.pfi1796, bi.pfi1796x, getString(R.string.pfi17))) {
                        return false;
                    }
                    return validatorClass.EmptyRadioButton(this, bi.pfi18, bi.pfi18a, getString(R.string.pfi18));
                }
            }

        } else {
            if (!validatorClass.EmptyRadioButton(this, bi.pfi07, bi.pfi07a, getString(R.string.pfi07))) {
                return false;
            }
            if (!bi.pfi01a.isChecked() && !bi.pfi07a.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.pfi0701, bi.pfi0701a, getString(R.string.pfi07a))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi08, bi.pfi08a, getString(R.string.pfi08))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi09, bi.pfi09a, getString(R.string.pfi09))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi10a, bi.pfi10a01, getString(R.string.pfi10a))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi10b, bi.pfi10b01, getString(R.string.pfi10b))) {
                return false;
            }
            if (bi.pfi10b01.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pfi10bx, getString(R.string.pfi10b))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.pfi10bx, 1, 12, getString(R.string.pfi10b), "Times")) {
                    return false;
                }

            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi10c, bi.pfi10c01, getString(R.string.pfi10c))) {
                return false;
            }
            if (bi.pfi10c01.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pfi10c01x, getString(R.string.pfi10c))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.pfi10c01x, 1, 12, getString(R.string.pfi10c), "Times")) {
                    return false;
                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi10d, bi.pfi10d01, getString(R.string.pfi10d))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi10e, bi.pfi10e01, getString(R.string.pfi10e))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi10f, bi.pfi10f01, getString(R.string.pfi10f))) {
                return false;
            }
            if (bi.pfi10f01.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.pfi10f01x, getString(R.string.pfi10f))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.pfi10f01x, 1, 12, getString(R.string.pfi10f), "Times")) {
                    return false;
                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi10g, bi.pfi10g01, getString(R.string.pfi10g))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi10h, bi.pfi10h01, getString(R.string.pfi10h))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi10i, bi.pfi10i01, getString(R.string.pfi10i))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.pfi12a, bi.pfi12a01, getString(R.string.pfi12a))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12b, bi.pfi12b01, getString(R.string.pfi12b))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12c, bi.pfi12c01, getString(R.string.pfi12c))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12d, bi.pfi12d01, getString(R.string.pfi12d))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12e, bi.pfi12e01, getString(R.string.pfi12e))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12f, bi.pfi12f01, getString(R.string.pfi12f))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12g, bi.pfi12g01, getString(R.string.pfi12g))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12h, bi.pfi12h01, getString(R.string.pfi12h))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12i, bi.pfi12i01, getString(R.string.pfi12i))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12j, bi.pfi12j01, getString(R.string.pfi12j))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12k, bi.pfi12k01, getString(R.string.pfi12k))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12l, bi.pfi12l01, getString(R.string.pfi12l))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12m, bi.pfi12m01, getString(R.string.pfi12m))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12n, bi.pfi12n01, getString(R.string.pfi12n))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12o, bi.pfi12o01, getString(R.string.pfi12o))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12p, bi.pfi12p01, getString(R.string.pfi12p))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi12q, bi.pfi12q01, getString(R.string.pfi12q))) {
                return false;
            }

            if (!flag) {
                if (!validatorClass.EmptyRadioButton(this, bi.pfi13, bi.pfi13a, getString(R.string.pfi13))) {
                    return false;
                }
            }
            if (!flag && bi.pfi13a.isChecked()) {
                if (!bi.pfi1498.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.pfi14t, getString(R.string.pfi14))) {
                        return false;
                    }
                    if (!validatorClass.RangeTextBox(this, bi.pfi14t, 1, 12, getString(R.string.pfi14), "Times")) {
                        return false;
                    }
                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.pfi15, bi.pfi15a, getString(R.string.pfi15))) {
                return false;
            }

            if (bi.pfi15a.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.pfi16, bi.pfi1696, bi.pfi1696x, getString(R.string.pfi16))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.pfi17, bi.pfi1796, bi.pfi1796x, getString(R.string.pfi17))) {
                    return false;
                }
                return validatorClass.EmptyRadioButton(this, bi.pfi18, bi.pfi18a, getString(R.string.pfi18));
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
