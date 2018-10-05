package edu.aku.hassannaqvi.wfp_followups.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 12/2/2016.
 */
public class EnrolledContract {
    private static final String TAG = "ELEGIBLES_CONTRACT";

    private Long _ID;

    // for child level Randomisation

    private String LUID; // Link UID from Source
    private String subAreaCode; // Cluster
    private String lhwCode; // Cluster
    private String houseHold;  // Structure
    private String women_name;
    private String sno;
    private String s1;

    public EnrolledContract() {
    }

    public EnrolledContract(EnrolledContract ec) {
        this.LUID = ec.getLUID();
        this.subAreaCode = ec.getSubAreaCode();
        this.lhwCode = ec.getLhwCode();
        this.houseHold = ec.getHouseHold();
        this.women_name = ec.getWomen_name();
        this.sno = ec.getSno();
        this.s1 = ec.getS1();
    }

    public EnrolledContract Sync(JSONObject jsonObject) throws JSONException {
        this.LUID = jsonObject.getString(EnrolledTable.COLUMN_NAME_LUID);
        this.subAreaCode = jsonObject.getString(EnrolledTable.COLUMN_NAME_SUBAREACODE);
        this.lhwCode = jsonObject.getString(EnrolledTable.COLUMN_NAME_LHWCODE);
        this.houseHold = jsonObject.getString(EnrolledTable.COLUMN_NAME_HOUSEHOLD);
        this.women_name = jsonObject.getString(EnrolledTable.COLUMN_NAME_WOMEN_NAME);
        this.sno = jsonObject.getString(EnrolledTable.COLUMN_NAME_SNO);
        this.s1 = jsonObject.getString(EnrolledTable.COLUMN_NAME_S1);
        return this;

    }

    public EnrolledContract Hydrate(Cursor cursor) {
        this.LUID = cursor.getString(cursor.getColumnIndex(EnrolledTable.COLUMN_NAME_LUID));
        this.subAreaCode = cursor.getString(cursor.getColumnIndex(EnrolledTable.COLUMN_NAME_SUBAREACODE));
        this.lhwCode = cursor.getString(cursor.getColumnIndex(EnrolledTable.COLUMN_NAME_LHWCODE));
        this.houseHold = cursor.getString(cursor.getColumnIndex(EnrolledTable.COLUMN_NAME_HOUSEHOLD));
        this.women_name = cursor.getString(cursor.getColumnIndex(EnrolledTable.COLUMN_NAME_WOMEN_NAME));
        this.sno = cursor.getString(cursor.getColumnIndex(EnrolledTable.COLUMN_NAME_SNO));
        this.s1 = cursor.getString(cursor.getColumnIndex(EnrolledTable.COLUMN_NAME_S1));
        return this;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public Long get_ID() {
        return _ID;
    }

    public void set_ID(Long _ID) {
        this._ID = _ID;
    }

    public String getLUID() {
        return LUID;
    }

    public void setLUID(String LUID) {
        this.LUID = LUID;
    }

    public String getSubAreaCode() {
        return subAreaCode;
    }

    public void setSubAreaCode(String subAreaCode) {
        this.subAreaCode = subAreaCode;
    }

    public String getHouseHold() {
        return houseHold;
    }

    public void setHouseHold(String houseHold) {
        this.houseHold = houseHold;
    }

    public String getWomen_name() {
        return women_name;
    }

    public void setWomen_name(String women_name) {
        this.women_name = women_name;
    }

    public String getLhwCode() {
        return lhwCode;
    }

    public void setLhwCode(String lhwCode) {
        this.lhwCode = lhwCode;
    }

    public String
    getSno() {
        return sno;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(EnrolledTable._ID, this._ID);
        json.put(EnrolledTable.COLUMN_NAME_LUID, this.LUID);
        json.put(EnrolledTable.COLUMN_NAME_SUBAREACODE, this.subAreaCode);
        json.put(EnrolledTable.COLUMN_NAME_LHWCODE, this.lhwCode);
        json.put(EnrolledTable.COLUMN_NAME_HOUSEHOLD, this.houseHold);
        json.put(EnrolledTable.COLUMN_NAME_WOMEN_NAME, this.women_name);
        json.put(EnrolledTable.COLUMN_NAME_SNO, this.sno);
        json.put(EnrolledTable.COLUMN_NAME_S1, this.s1);

        return json;
    }

    public static abstract class EnrolledTable implements BaseColumns {

        public static final String _URI = "enrolled.php";

        public static final String TABLE_NAME = "enrolled";

        public static final String _ID = "id";
        public static final String COLUMN_NAME_LUID = "uid";
        public static final String COLUMN_NAME_SUBAREACODE = "clustercode";
        public static final String COLUMN_NAME_LHWCODE = "lhwcode";
        public static final String COLUMN_NAME_HOUSEHOLD = "hhno";
        public static final String COLUMN_NAME_WOMEN_NAME = "epname";
        public static final String COLUMN_NAME_SNO = "sno";
        public static final String COLUMN_NAME_S1 = "s1";

        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String _URIGET = "geteligibles.php";
    }

}
