import java.io.Serializable;
import java.util.List;


public class TBUserInfo implements Serializable,Cloneable {
    public static final long serialVersionUID = -1;
    private String staffNo="";// 人员编号
    private String staffName=""; // string 人员姓名
    private String sex=""; // number 性别 0 男 1 女 2 保留
    private String birthday=""; // string 出生日期
    private String idNo=""; // string 身份证号
    private String mobileNo=""; // string 手机号码
    private String address=""; // string 居住地址
    private String organizationId=""; // string 组织机构Id
    private String organizationName=""; // string 组织机构名称
    private String facePicture=""; // string 人脸图片url
    private String facePictureLocal="";//本地人脸图片
    private String faceString="";//人脸特征
    private boolean syncRemote;
    private boolean syncRemotePicture;
    private int faceId;
    private String staffRid="";
    private String subSystem="";
    private boolean isSelected;
    private int ComeNumber;
    private int GoNumber;
    private String pinYin="";
    private int tokenType;
    private int useModel;
    private String carPass="";
    private int openMode;
    //下载失败次数
    private int defeated;
    //失败原因
    private int causeOfFailure;
    private int failed;
    private int bizCode=0;
    private String tokenId=""; // string 凭证号
    private String id="";//服务器的数据ｉｄ，删除数据时用//只能保证在谭工数据库的唯一性，固定人员都是有这个的
    private int perType;//人员类型
    private String validityTime="";//有效时间
    private String accessTime="";
    private String floor="";
    private String tcmRid="";
    private String tcmName="";
    private int accredit;
    private String rid=""; // string 人员唯一标识
    private String gid=""; // string 集团标识号
    //卡类安全级别
    private int tcmCode;
    //IC卡的TOkenID
    private String icToken="";
    //身份证的TokenID
    private String idToken="";

    private Boolean isUpload;
    private String uploadFacePicture="";
    private List<String> facePicturesList;

    public List<String> getFacePicturesList() {
        return facePicturesList;
    }

    public void setFacePicturesList(List<String> facePicturesList) {
        this.facePicturesList = facePicturesList;
    }

    private int type;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getFacePicture() {
        return facePicture;
    }

    public void setFacePicture(String facePicture) {
        this.facePicture = facePicture;
    }

    public String getFacePictureLocal() {
        return facePictureLocal;
    }

    public void setFacePictureLocal(String facePictureLocal) {
        this.facePictureLocal = facePictureLocal;
    }

    public String getFaceString() {
        return faceString;
    }

    public void setFaceString(String faceString) {
        this.faceString = faceString;
    }

    public boolean isSyncRemote() {
        return syncRemote;
    }

    public void setSyncRemote(boolean syncRemote) {
        this.syncRemote = syncRemote;
    }

    public boolean isSyncRemotePicture() {
        return syncRemotePicture;
    }

    public void setSyncRemotePicture(boolean syncRemotePicture) {
        this.syncRemotePicture = syncRemotePicture;
    }

    public int getFaceId() {
        return faceId;
    }

    public void setFaceId(int faceId) {
        this.faceId = faceId;
    }

    public String getStaffRid() {
        return staffRid;
    }

    public void setStaffRid(String staffRid) {
        this.staffRid = staffRid;
    }

    public String getSubSystem() {
        return subSystem;
    }

    public void setSubSystem(String subSystem) {
        this.subSystem = subSystem;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getComeNumber() {
        return ComeNumber;
    }

    public void setComeNumber(int comeNumber) {
        ComeNumber = comeNumber;
    }

    public int getGoNumber() {
        return GoNumber;
    }

    public void setGoNumber(int goNumber) {
        GoNumber = goNumber;
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    public int getTokenType() {
        return tokenType;
    }

    public void setTokenType(int tokenType) {
        this.tokenType = tokenType;
    }

    public int getUseModel() {
        return useModel;
    }

    public void setUseModel(int useModel) {
        this.useModel = useModel;
    }

    public String getCarPass() {
        return carPass;
    }

    public void setCarPass(String carPass) {
        this.carPass = carPass;
    }

    public int getOpenMode() {
        return openMode;
    }

    public void setOpenMode(int openMode) {
        this.openMode = openMode;
    }

    public int getDefeated() {
        return defeated;
    }

    public void setDefeated(int defeated) {
        this.defeated = defeated;
    }

    public int getCauseOfFailure() {
        return causeOfFailure;
    }

    public void setCauseOfFailure(int causeOfFailure) {
        this.causeOfFailure = causeOfFailure;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    public int getBizCode() {
        return bizCode;
    }

    public void setBizCode(int bizCode) {
        this.bizCode = bizCode;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPerType() {
        return perType;
    }

    public void setPerType(int perType) {
        this.perType = perType;
    }

    public String getValidityTime() {
        return validityTime;
    }

    public void setValidityTime(String validityTime) {
        this.validityTime = validityTime;
    }

    public String getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(String accessTime) {
        this.accessTime = accessTime;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getTcmRid() {
        return tcmRid;
    }

    public void setTcmRid(String tcmRid) {
        this.tcmRid = tcmRid;
    }

    public String getTcmName() {
        return tcmName;
    }

    public void setTcmName(String tcmName) {
        this.tcmName = tcmName;
    }

    public int getAccredit() {
        return accredit;
    }

    public void setAccredit(int accredit) {
        this.accredit = accredit;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public int getTcmCode() {
        return tcmCode;
    }

    public void setTcmCode(int tcmCode) {
        this.tcmCode = tcmCode;
    }

    public String getIcToken() {
        return icToken;
    }

    public void setIcToken(String icToken) {
        this.icToken = icToken;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public Boolean getUpload() {
        return isUpload;
    }

    public void setUpload(Boolean upload) {
        isUpload = upload;
    }

    public String getUploadFacePicture() {
        return uploadFacePicture;
    }

    public void setUploadFacePicture(String uploadFacePicture) {
        this.uploadFacePicture = uploadFacePicture;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    protected TBUserInfo clone() throws CloneNotSupportedException {
        return (TBUserInfo) super.clone();
    }

}
