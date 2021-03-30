

/**
 * Created by linuxiao on 2017-06-23.
 */
public class TBDmsOpenRecord {
    private Long _id;
    private String tokenId=""; // string 凭证号
    private String tcmRid=""; // string 卡类类型
    private String tcmName=""; // string 卡类名称
    private String staffRid=""; // string 人员 rid
    private String staffNo=""; // string 人员编号
    private String staffName=""; // string 人员姓名
    private String orginazitionId=""; // string 组织机构rid
    private String orginazitionName=""; // string 组织机构名称
    private String devTypeCode=""; // string 设备类型
    private String devNo=""; // number 机号
    private String doorNo=""; // number 读头号或者门号
    private String devName=""; // string 读头名称
    private String openDate=""; // string 开门时间
    private String workStationId=""; // string 工作站Id
    private String workStationName=""; // string 工作站名称
    private String gid=""; // string 项目id
    private String rid=""; // string 唯一标识
    private String openPicture="";
    private String facePicture="";
    private String subSystem="";

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getTokenId() {
        return this.tokenId;
    }
    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
    public String getTcmRid() {
        return this.tcmRid;
    }
    public void setTcmRid(String tcmRid) {
        this.tcmRid = tcmRid;
    }
    public String getTcmName() {
        return this.tcmName;
    }
    public void setTcmName(String tcmName) {
        this.tcmName = tcmName;
    }
    public String getStaffRid() {
        return this.staffRid;
    }
    public void setStaffRid(String staffRid) {
        this.staffRid = staffRid;
    }
    public String getStaffNo() {
        return this.staffNo;
    }
    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }
    public String getStaffName() {
        return this.staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    public String getOrginazitionId() {
        return this.orginazitionId;
    }
    public void setOrginazitionId(String orginazitionId) {
        this.orginazitionId = orginazitionId;
    }
    public String getOrginazitionName() {
        return this.orginazitionName;
    }
    public void setOrginazitionName(String orginazitionName) {
        this.orginazitionName = orginazitionName;
    }
    public String getDevTypeCode() {
        return this.devTypeCode;
    }
    public void setDevTypeCode(String devTypeCode) {
        this.devTypeCode = devTypeCode;
    }
    public String getDevNo() {
        return this.devNo;
    }
    public void setDevNo(String devNo) {
        this.devNo = devNo;
    }
    public String getDoorNo() {
        return this.doorNo;
    }
    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }
    public String getDevName() {
        return this.devName;
    }
    public void setDevName(String devName) {
        this.devName = devName;
    }
    public String getOpenDate() {
        return this.openDate;
    }
    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }
    public String getWorkStationId() {
        return this.workStationId;
    }
    public void setWorkStationId(String workStationId) {
        this.workStationId = workStationId;
    }
    public String getWorkStationName() {
        return this.workStationName;
    }
    public void setWorkStationName(String workStationName) {
        this.workStationName = workStationName;
    }
    public String getGid() {
        return this.gid;
    }
    public void setGid(String gid) {
        this.gid = gid;
    }
    public String getRid() {
        return this.rid;
    }
    public void setRid(String rid) {
        this.rid = rid;
    }
    public String getOpenPicture() {
        return this.openPicture;
    }
    public void setOpenPicture(String openPicture) {
        this.openPicture = openPicture;
    }
    public String getFacePicture() {
        return this.facePicture;
    }
    public void setFacePicture(String facePicture) {
        this.facePicture = facePicture;
    }
    public String getSubSystem() {
        return this.subSystem;
    }
    public void setSubSystem(String subSystem) {
        this.subSystem = subSystem;
    }

    @Override
    public String toString() {
        return "TBDmsOpenRecord{" +
                "id=" + _id +
                ", tokenId='" + tokenId + '\'' +
                ", tcmRid='" + tcmRid + '\'' +
                ", tcmName='" + tcmName + '\'' +
                ", staffRid='" + staffRid + '\'' +
                ", staffNo='" + staffNo + '\'' +
                ", staffName='" + staffName + '\'' +
                ", orginazitionId='" + orginazitionId + '\'' +
                ", orginazitionName='" + orginazitionName + '\'' +
                ", devTypeCode='" + devTypeCode + '\'' +
                ", devNo='" + devNo + '\'' +
                ", doorNo='" + doorNo + '\'' +
                ", devName='" + devName + '\'' +
                ", openDate='" + openDate + '\'' +
                ", workStationId='" + workStationId + '\'' +
                ", workStationName='" + workStationName + '\'' +
                ", gid='" + gid + '\'' +
                ", rid='" + rid + '\'' +
                ", openPicture='" + openPicture + '\'' +
                ", facePicture='" + facePicture + '\'' +
                ", subSystem='" + subSystem + '\'' +
                '}';
    }
}
