package edu.aku.hassannaqvi.wfp_followups.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class PregnancyContract {
    private static final String TAG = "PREGNANCY_CONTRACT";

    private String puid;
    private String uc_code;
    private String tehsil_code;
    private String village_code;
    private String lhw_code;
    private String studyid;
    private String formdate;
    private String pw_name;
    private String h_name;

    public PregnancyContract() {
    }

    public PregnancyContract Sync(JSONObject jsonObject) throws JSONException {
        this.puid = jsonObject.getString(PregnancyTable.COLUMN_PUID);
        this.uc_code = jsonObject.getString(PregnancyTable.COLUMN_UC_CODE);
        this.tehsil_code = jsonObject.getString(PregnancyTable.COLUMN_TEHSIL_CODE);
        this.village_code = jsonObject.getString(PregnancyTable.COLUMN_VILLAGE_CODE);
        this.lhw_code = jsonObject.getString(PregnancyTable.COLUMN_LHW_CODE);
        this.studyid = jsonObject.getString(PregnancyTable.COLUMN_STUDYID);
        this.formdate = jsonObject.getString(PregnancyTable.COLUMN_FORMDATE);
        this.pw_name = jsonObject.getString(PregnancyTable.COLUMN_PW_NAME);
        this.h_name = jsonObject.getString(PregnancyTable.COLUMN_H_NAME);

        return this;
    }

    public PregnancyContract Hydrate(Cursor cursor) {
        this.puid = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_PUID));
        this.uc_code = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_UC_CODE));
        this.tehsil_code = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_TEHSIL_CODE));
        this.village_code = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_VILLAGE_CODE));
        this.lhw_code = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_LHW_CODE));
        this.studyid = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_STUDYID));
        this.formdate = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_FORMDATE));
        this.pw_name = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_PW_NAME));
        this.h_name = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_H_NAME));

        return this;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(PregnancyTable.COLUMN_PUID, this.puid == null ? JSONObject.NULL : this.puid);
        json.put(PregnancyTable.COLUMN_UC_CODE, this.uc_code == null ? JSONObject.NULL : this.uc_code);
        json.put(PregnancyTable.COLUMN_TEHSIL_CODE, this.tehsil_code == null ? JSONObject.NULL : this.tehsil_code);
        json.put(PregnancyTable.COLUMN_VILLAGE_CODE, this.village_code == null ? JSONObject.NULL : this.village_code);
        json.put(PregnancyTable.COLUMN_LHW_CODE, this.lhw_code == null ? JSONObject.NULL : this.lhw_code);
        json.put(PregnancyTable.COLUMN_STUDYID, this.studyid == null ? JSONObject.NULL : this.studyid);
        json.put(PregnancyTable.COLUMN_FORMDATE, this.formdate == null ? JSONObject.NULL : this.formdate);
        json.put(PregnancyTable.COLUMN_PW_NAME, this.pw_name == null ? JSONObject.NULL : this.pw_name);
        json.put(PregnancyTable.COLUMN_H_NAME, this.h_name == null ? JSONObject.NULL : this.h_name);

        return json;
    }

    public String getPuid() {
        return puid;
    }

    public void setPuid(String puid) {
        this.puid = puid;
    }

    public String getUc_code() {
        return uc_code;
    }

    public void setUc_code(String uc_code) {
        this.uc_code = uc_code;
    }

    public String getTehsil_code() {
        return tehsil_code;
    }

    public void setTehsil_code(String tehsil_code) {
        this.tehsil_code = tehsil_code;
    }

    public String getVillage_code() {
        return village_code;
    }

    public void setVillage_code(String village_code) {
        this.village_code = village_code;
    }

    public String getLhw_code() {
        return lhw_code;
    }

    public void setLhw_code(String lhw_code) {
        this.lhw_code = lhw_code;
    }

    public String getStudyid() {
        return studyid;
    }

    public void setStudyid(String studyid) {
        this.studyid = studyid;
    }

    public String getFormdate() {
        return formdate;
    }

    public void setFormdate(String formdate) {
        this.formdate = formdate;
    }

    public String getPw_name() {
        return pw_name;
    }

    public void setPw_name(String pw_name) {
        this.pw_name = pw_name;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public static abstract class PregnancyTable implements BaseColumns {

        public static final String TABLE_NAME = "cur_preg";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_PUID = "puid";
        public static final String COLUMN_UC_CODE = "uc_code";
        public static final String COLUMN_TEHSIL_CODE = "tehsil_code";
        public static final String COLUMN_VILLAGE_CODE = "village_code";
        public static final String COLUMN_LHW_CODE = "lhw_code";
        public static final String COLUMN_STUDYID = "studyid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_PW_NAME = "pw_name";
        public static final String COLUMN_H_NAME = "h_name";

        public static final String _URI = "currently_pregnant.php";
    }

}
