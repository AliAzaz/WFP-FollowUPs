package edu.aku.hassannaqvi.wfp_followups.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsContract {

    private String projectName = "WFP-PW Study";
    private String surveyType = "Monthly follow-up form for PLW - Pishin study";
    private Long _ID;
    private String UID = "";
    private String formDate = ""; // Date
    private String interviewer01 = ""; // Interviewer 01
    private String interviewer02 = ""; // Interviewer 02
    private String clustercode = "0000"; // Area Code
    private String villageacode = ""; // Sub-Area Code
    private String household = ""; // Household number
    private String istatus = ""; // Interview Status
    private String endingDateTime = "";
    private String lhwCode = ""; // lhwcode
    private String formType = "";
    private String sno = "";
    private String sInfo = "";
    private String sB = "";
    private String sC = "";
    private String sD = "";
    private String sE = "";
    private String sF = "";
    private String sG = "";
    private String sH = "";
    private String sI = "";
    private String sJ = "";
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsTime = "";
    private String gpsAcc = "";
    private String deviceID = "";
    private String tagID = "";
    private String app_version = "";
    private String synced = "";
    private String synced_date = "";

    public FormsContract() {
    }

    public FormsContract(String formDate, String household, String istatus, String sno, String formType) {
        this.formDate = formDate;
        this.household = household;
        this.istatus = istatus;
        this.sno = sno;
        this.formType = formType;
    }

    public String getFormType() {
        return formType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getSurveyType() {
        return surveyType;
    }

    public Long getID() {
        return _ID;
    }

    public void setID(Long _ID) {
        this._ID = _ID;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getInterviewer01() {
        return interviewer01;
    }

    public void setInterviewer01(String interviewer01) {
        this.interviewer01 = interviewer01;
    }

    public String getInterviewer02() {
        return interviewer02;
    }

    public void setInterviewer02(String interviewer02) {
        this.interviewer02 = interviewer02;
    }

    public String getClustercode() {
        return clustercode;
    }

    public void setClustercode(String clustercode) {
        this.clustercode = clustercode;
    }

    public String getVillageacode() {
        return villageacode;
    }

    public void setVillageacode(String villageacode) {
        this.villageacode = villageacode;
    }

    public String getHousehold() {
        return household;
    }

    public void setHousehold(String household) {
        this.household = household;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getEndingDateTime() {
        return endingDateTime;
    }

    public void setEndingDateTime(String endingDateTime) {
        this.endingDateTime = endingDateTime;
    }

    public String getsInfo() {
        return sInfo;
    }

    public void setsInfo(String sInfo) {
        this.sInfo = sInfo;
    }

    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }

    public String getsC() {
        return sC;
    }

    public void setsC(String sC) {
        this.sC = sC;
    }

    public String getsD() {
        return sD;
    }

    public void setsD(String sD) {
        this.sD = sD;
    }

    public String getsE() {
        return sE;
    }

    public void setsE(String sE) {
        this.sE = sE;
    }

    public String getsF() {
        return sF;
    }

    public void setsF(String sF) {
        this.sF = sF;
    }

    public String getsG() {
        return sG;
    }

    public void setsG(String sG) {
        this.sG = sG;
    }

    public String getsH() {
        return sH;
    }

    public void setsH(String sH) {
        this.sH = sH;
    }

    public String getsI() {
        return sI;
    }

    public void setsI(String sI) {
        this.sI = sI;
    }

    public String getsJ() {
        return sJ;
    }

    public void setsJ(String sJ) {
        this.sJ = sJ;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public String getLhwCode() {
        return lhwCode;
    }

    public void setLhwCode(String lhwCode) {
        this.lhwCode = lhwCode;
    }

    public String getTagID() {
        return tagID;
    }

    public void setTagID(String tagID) {
        this.tagID = tagID;
    }

/*    public FormsContract Sync(JSONObject jsonObject) throws JSONException {
        this.projectName = jsonObject.getString(FormsTable.COLUMN_PROJECTNAME);
        this.surveyType = jsonObject.getString(FormsTable.COLUMN_SURVEYTYPE);
        this._ID = jsonObject.getLong(FormsTable.COLUMN__ID);
        this.UID = jsonObject.getString(FormsTable.COLUMN_UID);
        this.formDate = jsonObject.getString(FormsTable.COLUMN_FORMDATE);
        this.interviewer01 = jsonObject.getString(FormsTable.COLUMN_INTERVIEWER01);
        this.interviewer02 = jsonObject.getString(FormsTable.COLUMN_INTERVIEWER02);
        this.clustercode = jsonObject.getString(FormsTable.COLUMN_CLUSTERCODE);
        this.villageacode = jsonObject.getString(FormsTable.COLUMN_VILLAGEACODE);
        this.household = jsonObject.getString(FormsTable.COLUMN_HOUSEHOLD);
        this.lhwCode = jsonObject.getString(FormsTable.COLUMN_LHWCODE);
        this.istatus = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.sno = jsonObject.getString(FormsTable.COLUMN_SNO);
        this.formType = jsonObject.getString(FormsTable.COLUMN_FORMTYPE);
        this.sInfo = jsonObject.getString(FormsTable.COLUMN_SINFO);
        this.sB = jsonObject.getString(FormsTable.COLUMN_SB);
        this.sC = jsonObject.getString(FormsTable.COLUMN_SC);
        this.sD = jsonObject.getString(FormsTable.COLUMN_SD);
        this.sE = jsonObject.getString(FormsTable.COLUMN_SE);
        this.endingDateTime = jsonObject.getString(FormsTable.COLUMN_ENDINGDATETIME);
        this.gpsLat = jsonObject.getString(FormsTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsTable.COLUMN_GPSLNG);
        this.gpsTime = jsonObject.getString(FormsTable.COLUMN_GPSTIME);
        this.gpsAcc = jsonObject.getString(FormsTable.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsTable.COLUMN_DEVICEID);
        this.tagID = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID);
        this.app_version = jsonObject.getString(FormsTable.COLUMN_APP_VERSION);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);

        return this;

    }*/

    public FormsContract Hydrate(Cursor cursor) {
        this.projectName = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_PROJECTNAME));
        this.surveyType = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SURVEYTYPE));
        this._ID = cursor.getLong(cursor.getColumnIndex(FormsTable.COLUMN__ID));
        this.UID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));
        this.formDate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FORMDATE));
        this.interviewer01 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_INTERVIEWER01));
        this.interviewer02 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_INTERVIEWER02));
        this.clustercode = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_CLUSTERCODE));
        this.villageacode = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_VILLAGEACODE));
        this.household = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_HOUSEHOLD));
        this.lhwCode = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_LHWCODE));
        this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.sno = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SNO));
        this.formType = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FORMTYPE));
        this.sInfo = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SINFO));
        this.sB = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB));
        this.sC = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SC));
        this.sD = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SD));
        this.sE = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SE));
        this.sF = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SF));
        this.sG = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SG));
        this.sH = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SH));
        this.sI = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SI));
        this.sJ = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SJ));
        this.endingDateTime = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ENDINGDATETIME));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLNG));
        this.gpsTime = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSTIME));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.tagID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
        this.app_version = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APP_VERSION));
        this.synced = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED_DATE));

        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_PROJECTNAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(FormsTable.COLUMN_SURVEYTYPE, this.surveyType == null ? JSONObject.NULL : this.surveyType);
        json.put(FormsTable.COLUMN__ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormsTable.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(FormsTable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(FormsTable.COLUMN_INTERVIEWER01, this.interviewer01 == null ? JSONObject.NULL : this.interviewer01);
        json.put(FormsTable.COLUMN_INTERVIEWER02, this.interviewer02 == null ? JSONObject.NULL : this.interviewer02);
        json.put(FormsTable.COLUMN_CLUSTERCODE, this.clustercode == null ? JSONObject.NULL : this.clustercode);
        json.put(FormsTable.COLUMN_VILLAGEACODE, this.villageacode == null ? JSONObject.NULL : this.villageacode);
        json.put(FormsTable.COLUMN_HOUSEHOLD, this.household == null ? JSONObject.NULL : this.household);
        json.put(FormsTable.COLUMN_LHWCODE, this.lhwCode == null ? JSONObject.NULL : this.lhwCode);
        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_SNO, this.sno == null ? JSONObject.NULL : this.sno);
        json.put(FormsTable.COLUMN_FORMTYPE, this.formType == null ? JSONObject.NULL : this.formType);
        try {
            if (!this.sInfo.equals("")) {
                json.put(FormsTable.COLUMN_SINFO, this.sInfo == null ? JSONObject.NULL : new JSONObject(this.sInfo));
            }
        } catch (Exception e) {
        }
        try {
            if (!this.sB.equals("")) {
                json.put(FormsTable.COLUMN_SB, this.sB == null ? JSONObject.NULL : new JSONObject(this.sB));
            }
        } catch (Exception e) {
        }

        try {
            if (!this.sC.equals("")) {
                json.put(FormsTable.COLUMN_SC, this.sC == null ? JSONObject.NULL : new JSONObject(this.sC));
            }
        } catch (Exception e) {
        }

        try {
            if (!this.sD.equals("")) {
                json.put(FormsTable.COLUMN_SD, this.sD == null ? JSONObject.NULL : new JSONObject(this.sD));
            }
        } catch (Exception e) {
        }

        try {
            if (!this.sE.equals("")) {
                json.put(FormsTable.COLUMN_SE, this.sE == null ? JSONObject.NULL : new JSONObject(this.sE));
            }
        } catch (Exception e) {
        }

        try {
            if (!this.sF.equals("")) {
                json.put(FormsTable.COLUMN_SF, this.sF == null ? JSONObject.NULL : new JSONObject(this.sF));
            }
        } catch (Exception e) {
        }

        try {
            if (!this.sG.equals("")) {
                json.put(FormsTable.COLUMN_SG, this.sG == null ? JSONObject.NULL : new JSONObject(this.sG));
            }
        } catch (Exception e) {
        }

        try {
            if (!this.sH.equals("")) {
                json.put(FormsTable.COLUMN_SH, this.sH == null ? JSONObject.NULL : new JSONObject(this.sH));
            }
        } catch (Exception e) {
        }

        try {
            if (!this.sI.equals("")) {
                json.put(FormsTable.COLUMN_SI, this.sI == null ? JSONObject.NULL : new JSONObject(this.sI));
            }
        } catch (Exception e) {
        }

        try {
            if (!this.sJ.equals("")) {
                json.put(FormsTable.COLUMN_SJ, this.sJ == null ? JSONObject.NULL : new JSONObject(this.sJ));
            }
        } catch (Exception e) {
        }

        json.put(FormsTable.COLUMN_ENDINGDATETIME, this.endingDateTime == null ? JSONObject.NULL : this.endingDateTime);
        json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(FormsTable.COLUMN_GPSTIME, this.gpsTime == null ? JSONObject.NULL : this.gpsTime);
        json.put(FormsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.tagID == null ? JSONObject.NULL : this.tagID);
        json.put(FormsTable.COLUMN_APP_VERSION, this.app_version == null ? JSONObject.NULL : this.app_version);
        json.put(FormsTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(FormsTable.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);


        return json;
    }

    public static abstract class FormsTable implements BaseColumns {

        public static final String TABLE_NAME = "forms";
        public static final String _URL = "forms.php";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECTNAME = "projectname";
        public static final String COLUMN_SURVEYTYPE = "surveytype";
        public static final String COLUMN__ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_INTERVIEWER01 = "interviewer01";
        public static final String COLUMN_INTERVIEWER02 = "interviewer02";
        public static final String COLUMN_CLUSTERCODE = "clustercode";
        public static final String COLUMN_VILLAGEACODE = "villageacode";
        public static final String COLUMN_HOUSEHOLD = "household";
        public static final String COLUMN_LHWCODE = "lhwcode";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_SNO = "sno";
        public static final String COLUMN_FORMTYPE = "formtype";
        public static final String COLUMN_SINFO = "info";
        public static final String COLUMN_SB = "sb";
        public static final String COLUMN_SC = "sc";
        public static final String COLUMN_SD = "sd";
        public static final String COLUMN_SE = "se";
        public static final String COLUMN_SF = "sf";
        public static final String COLUMN_SG = "sg";
        public static final String COLUMN_SH = "sh";
        public static final String COLUMN_SI = "si";
        public static final String COLUMN_SJ = "sj";
        public static final String COLUMN_ENDINGDATETIME = "endingdatetime";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSTIME = "gpstime";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_APP_VERSION = "app_version";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
    }
}
