package edu.aku.hassannaqvi.wfp_followups.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.aku.hassannaqvi.wfp_followups.R;
import edu.aku.hassannaqvi.wfp_followups.contracts.FormsContract;
import edu.aku.hassannaqvi.wfp_followups.core.AndroidDatabaseManager;
import edu.aku.hassannaqvi.wfp_followups.core.AppMain;
import edu.aku.hassannaqvi.wfp_followups.core.DatabaseHelper;
import edu.aku.hassannaqvi.wfp_followups.getclasses.GetPWs;
import edu.aku.hassannaqvi.wfp_followups.otherclasses.FormsList;
import edu.aku.hassannaqvi.wfp_followups.syncclasses.SyncAllData;


public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    @BindView(R.id.adminsec)
    LinearLayout adminsec;
    @BindView(R.id.recordSummary)
    TextView recordSummary;
    @BindView(R.id.areaCode)
    EditText areaCode;
    @BindView(R.id.testing)
    TextView testing;

    @BindView(R.id.spUC)
    Spinner spUC;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    AlertDialog.Builder builder;
    String m_Text = "";
    DatabaseHelper db;
    List<String> clustersName;
    HashMap<String, String> cluster;
    private String rSumText = "";
    private ProgressDialog pd;
    private Boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (Integer.valueOf(AppMain.versionName.split("\\.")[0]) > 0) {
            testing.setVisibility(View.GONE);
        } else {
            testing.setVisibility(View.VISIBLE);
        }

        // Reset working variables
        AppMain.child_name = "Test";

        if (AppMain.admin) {
            adminsec.setVisibility(View.VISIBLE);
        } else {
            adminsec.setVisibility(View.GONE);
        }

        sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        editor = sharedPref.edit();

        builder = new AlertDialog.Builder(MainActivity.this);
        ImageView img = new ImageView(getApplicationContext());
        img.setImageResource(R.drawable.tagimg);
        img.setPadding(0, 15, 0, 15);
        builder.setCustomTitle(img);

        final EditText input = new EditText(MainActivity.this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                if (!m_Text.equals("")) {
                    editor.putString("tagName", m_Text);
                    editor.commit();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        if (sharedPref.getString("tagName", null) == "" || sharedPref.getString("tagName", null) == null) {
            builder.show();
        }


        /*if (AppMain.admin) {
            adminsec.setVisibility(View.VISIBLE);
        } else {
            adminsec.setVisibility(View.GONE);
        }

*/
        db = new DatabaseHelper(this);
        Collection<FormsContract> todaysForms = db.getTodayForms();
        Collection<FormsContract> unsyncedForms6 = db.getAllForms();

        rSumText += "TODAY'S RECORDS SUMMARY\r\n";

        rSumText += "=======================\r\n";
        rSumText += "\r\n";
        rSumText += "Total Forms Today: " + todaysForms.size() + "\r\n";
        rSumText += "\r\n";
        if (todaysForms.size() > 0) {
            rSumText += "\tFORMS' LIST: \r\n";
            String iStatus;
            rSumText += "--------------------------------------------------\r\n";
            rSumText += "[ FORM_ID ] \t[Form Status] \t[Sync Status]----------\r\n";
            rSumText += "--------------------------------------------------\r\n";

            for (FormsContract fc : todaysForms) {
                if (fc.getIstatus() != null) {
                    switch (fc.getIstatus()) {
                        case "1":
                            iStatus = "\tComplete";
                            break;
                        case "2":
                            iStatus = "\tIncomplete";
                            break;
                        case "3":
                            iStatus = "\tRefused";
                            break;
                        case "4":
                            iStatus = "\tRefused";
                            break;
                        default:
                            iStatus = "\tN/A";
                    }
                } else {
                    iStatus = "\tN/A";
                }

                rSumText += fc.getID();

                rSumText += " " + iStatus + " ";

                rSumText += (fc.getSynced() == null ? "\t\tNot Synced" : "\t\tSynced");
                rSumText += "\r\n";
                rSumText += "--------------------------------------------------\r\n";
            }
        }
        if (AppMain.admin) {
            adminsec.setVisibility(View.VISIBLE);
            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            rSumText += "Last Data Download: \t" + syncPref.getString("LastDownSyncServer", "Never Updated");
            rSumText += "\r\n";
            rSumText += "Last Data Upload: \t" + syncPref.getString("LastUpSyncServer", "Never Synced");
            rSumText += "\r\n";
            rSumText += "\r\n";
            rSumText += "Unsynced Forms8: \t" + unsyncedForms6.size();
            rSumText += "\r\n";

        }
        Log.d(TAG, "onCreate: " + rSumText);
        recordSummary.setText(rSumText);


    }

    public void openForm(View v) {
        switch (v.getId()) {

            case R.id.openFormPW:
                AppMain.formType = AppMain.PREGNANTWOMEN;
                break;

            case R.id.openFormChild:
                AppMain.formType = AppMain.CHILD;
                break;
            default:
                break;
        }
        if (sharedPref.getString("tagName", null) != "" && sharedPref.getString("tagName", null) != null) {
            Intent oF = new Intent();
            if(AppMain.formType.equals(AppMain.PREGNANTWOMEN)){
                oF = new Intent(MainActivity.this, InfoActivity.class);

            }else if(AppMain.formType.equals(AppMain.CHILD)){
                oF = new Intent(MainActivity.this, ChildInfoActivity.class);
            }
            startActivity(oF);
        } else {

            builder = new AlertDialog.Builder(MainActivity.this);
            ImageView img = new ImageView(getApplicationContext());
            img.setImageResource(R.drawable.tagimg);
            img.setPadding(0, 15, 0, 15);
            builder.setCustomTitle(img);

            final EditText input = new EditText(MainActivity.this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    m_Text = input.getText().toString();
                    if (!m_Text.equals("")) {
                        editor.putString("tagName", m_Text);
                        editor.commit();
                        Intent oF = new Intent();
                        if(AppMain.formType.equals(AppMain.PREGNANTWOMEN)){
                            oF = new Intent(MainActivity.this, InfoActivity.class);

                        }else if(AppMain.formType.equals(AppMain.CHILD)){
                            oF = new Intent(MainActivity.this, ChildInfoActivity.class);

                        }

                        startActivity(oF);
                    }
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
    }

    public void openMembers(View v) {
        //Intent iMem = new Intent(this, FamilyMembersActivity.class);
        //startActivity(iMem);
    }

    public void openA(View v) {
        Intent iA = new Intent(this, InfoActivity.class);
        startActivity(iA);
    }


    public void openDB(View v) {
        Intent dbmanager = new Intent(getApplicationContext(), AndroidDatabaseManager.class);
        startActivity(dbmanager);
    }

    public void CheckCluster(View v) {
        if (!areaCode.getText().toString().isEmpty()) {

            areaCode.setError(null);

            Intent Clist = new Intent(getApplicationContext(), FormsList.class);
            Clist.putExtra("areaCode", areaCode.getText().toString());
            startActivity(Clist);
        } else {
            Toast.makeText(this, "Error(Empty): Data Required", Toast.LENGTH_SHORT).show();
            areaCode.setError("Error(Empty): Data Required");
        }
    }

    public void syncServer(View view) {
        Log.e(TAG, "syncServer: 1");
        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        Log.e(TAG, "syncServer: 2");
        if (networkInfo != null && networkInfo.isConnected()) {
            /*Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();
            new SyncForms(this).execute();*/
            //new SyncForms5(this).execute();

            /*Toast.makeText(getApplicationContext(), "Syncing Participants", Toast.LENGTH_SHORT).show();
            new SyncParticipants(this).execute();
*/
            /*Toast.makeText(getApplicationContext(), "Syncing Eligibles", Toast.LENGTH_SHORT).show();
            new SyncEligibles(this).execute();*/

            Toast.makeText(getApplicationContext(), "Syncing Forms PW", Toast.LENGTH_SHORT).show();
            new SyncAllData(
                    this,
                    "PWForms",
                    "updateSyncedForms",
                    FormsContract.class,
                    AppMain._HOST_URL + FormsContract.FormsTable._URL,
                    db.getUnsyncedForms(AppMain.PREGNANTWOMEN)
            ).execute();

            Toast.makeText(getApplicationContext(), "Syncing Forms Child", Toast.LENGTH_SHORT).show();
            new SyncAllData(
                    this,
                    "ChildForms",
                    "updateSyncedForms",
                    FormsContract.class,
                    AppMain._HOST_URL + FormsContract.FormsTable._URL.replace("plw_followups.php","child_followups.php"),
                    db.getUnsyncedForms(AppMain.CHILD)
            ).execute();

            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastUpSyncServer", dtToday);

            editor.apply();

        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }

    }

    public void syncDevice(View view) {

        //String usersUrl = AppMain._HOST_URL + "virband/api/users.php";
        //String randsUrl = AppMain._HOST_URL + "virband/api/random.php"; // url to sync randomise data
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            // Sync Randomization
            Toast.makeText(getApplicationContext(), "Getting PW's", Toast.LENGTH_SHORT).show();
            new GetPWs(this).execute();


            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastDownSyncServer", dtToday);

            editor.apply();
        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity

            Intent ii = new Intent(this, LoginActivity.class);
            ii.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(ii);
            finish();

        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
    }
}