

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class APPConfig implements Serializable, Cloneable {


    //后台IP地址
    private String ip = "";
    //可识别人脸框最小值(其余型号)
    private int faceSizeToHome = 100;
    //可识别人脸框最小值(622和694M)
    private int faceSizeToHomeWithAccessAnd694M = 80;
    //后台端口号
    private int host = 60009;
    //识别距离
    private String recognitionDistance;
    //识别分数
    private String recognitionScore = "77";
    //识别间隔
    private String recognitionInterval = "0";
    //692H识别间隔
    private String recognitionInterval_692H = "3";

    public String getRecognitionInterval_692H() {
        return recognitionInterval_692H;
    }

    public void setRecognitionInterval_692H(String recognitionInterval_692H) {
        this.recognitionInterval_692H = recognitionInterval_692H;
    }

    //识别模式
    private String recognitionMode = "0";
    //安全级别
    private String securityLevel;
    //多人脸检测+
    private String multiFaceDetection;
    //活体检测
    private String liveDetection = "1";
    //是否显示活检失败提示语
    private boolean isShowLivenessFailNote = false;
    //活体检测分数
    private String liveScore = "30";
    //相机类别
    private String cameraCategory = "1";
    //开门时间
    private String doorOpenTime;
    //提示标语
    private String promptSlogan;
    //语音模式
    private String voiceMode = "0";
    //语音自定义内容
    private String customizeVoice;
    //待机画面时间
    private String standbyScreenTime = "30";
    //陌生人识别
    private String strangerRecognition = "1";
    //陌生人语音
    private String strangerVoice = "0";
    //陌生人自定义语音内容
    private String customizeStrangerVoice;
    //系统自动重启
    private String systemAutoRestart = "0";
    //系统重启时间
    private String systemRestartTime = "04:00";
    //密码配置(MD5加密初始密码)
    private String systemPassword = "4a7d1ed414474e4033ac29ccb8653d9b";
    //门禁初始密码(MD5加密初始密码)
    private String accessPassword = "8ddcff3a80f4189ca1c9d4d902c3c909";
    //密码开门默认密码
    private String openDoorPaw = "";
    //高峰时段
    private String peakHours;
    //开门超时报警
    private String doorOpenTimeoutAlarm;
    //非法闯入报警
    private String intrusionAlarm;
    //消防报警
    private String fireAlarm;
    //胁迫报警
    private String duressAlarm;
    //超时时间
    private String overtimeTime;
    //报警时间
    private String alarmTime;
    //图像服务器地址
    private String imageServerUrl;
    //是否已经初始化
    private int isInit = 0;
    //是否开启程序保活
    private boolean systemAlive = true;
    //是否开启高峰期时段
    private boolean isOpenPeak = false;
    //是否开启开状态时段
    private boolean isOpenDoor = false;
    //一进一出功能(只针对访客人员)
    private boolean is_Goin_and_out = false;
    //是否上传陌生人识别记录
    private boolean isUpload_Stranger_record = false;
    //是否开启考勤模式
    private boolean isOpenAttendance = false;
    //是否开启人脸AE
    private boolean isOpenFaceAE = true;
    //出入口
    private int inWithOut = 0;
    //高峰期时段集合
    private List<Peak> peaks = new ArrayList<>();
  //  补光灯晚间时段集合
    private List<Peak> evenings = new ArrayList<>();
 //   开门时段集合
    private List<Door> doors = new ArrayList<>();
//    考勤时段集合
    private List<Peak> attendances = new ArrayList<>();
//    考勤时段集合(从服务端获取)

//
//
//    //补光灯晚间时段集合
//    private String evenings;
////    开门时段集合
//    private String doors;
//
//    private String peaks;
//
//    public String getEvenings() {
//        return evenings;
//    }
//
//    public void setEvenings(String evenings) {
//        this.evenings = evenings;
//    }
//
//    public String getDoors() {
//        return doors;
//    }
//
//    public void setDoors(String doors) {
//        this.doors = doors;
//    }
//
//    public String getPeaks() {
//        return peaks;
//    }
//
//    public void setPeaks(String peaks) {
//        this.peaks = peaks;
//    }

    //    private List<Peak> attendancesFromServer = new ArrayList<>();
    //考勤数据获取方式(1:从后台获取 2:本地编辑获取)
    private int attendanceAcquireType = 1;
    //肖像逗留时间
    private String verifySuccessShowTime = "1";
    //陌生人识别时间
    private String verifyStangerTime = "3";
    //密码开门开关
    private boolean usePwdOpenDoor = false;
    //设备号
    private int deviceNo;
    //com1串口的波特率ID
    private int comOneIndex = 3;
    //com4串口的波特率ID
    private int comFourIndex = 3;
    //补光灯控制
    private int lightControl = 0;
    //自动重启默认下标
    private int restartIdnex = 0;
    //人体感应switch
    private boolean humanBody = false;
    //是否显示图像
    private boolean iShowImage = false;
    //是否有人体感应
    private boolean isFelling = false;
    //是否是双目
    private boolean isBinocular = false;
    //星期几
    private int week = 0;
    //进入深度待机时间
    private int stanbdyTime = 30;

    //是否开启扫描动画
    private boolean isScanning = false;
    //自动检测版本更新时间
    private String updateCheckTime = "02:00";
    //自动检测版本更新默认下标
    private int updateCheckIdnex = 0;
    //app版本号
    private int appVersionCode = 0;

    private boolean isOffLine;
    //是否延时
    private boolean isDelay = false;
    //延时时间
    private long delayTime = 0;
    //门禁扇区默认下标
    private int sectorIndex = 2;
    //电梯门禁扇区
    private int liftSectorIndex = 7;
    //IC读卡模式密码
    private String icPassWord = "FFFFFFFFFFFF";

    //脱机模式下设备号
    private String offDevNo = "1";

    //iC卡读卡模式
    private int modeIndex = 0;

    //人脸曝光灵敏度
    private int faceAESensitivity = 0;
    //人脸背光亮度
    private int faceAEBrightness = 0;

    private int functionVersion = 0;

    public int getFunctionVersion() {
        return functionVersion;
    }

    public void setFunctionVersion(int functionVersion) {
        this.functionVersion = functionVersion;
    }

    private int isLift = 1;

    private boolean isFirstEnterSet = false;

    private boolean anyOpen = false;

    //记录上一次重启时间
    private long lastRebootTime;

    //IC卡开关（622和694MCB默认打开）
    private boolean isOpenICcard = true;

    //IC卡开关 (692And694T,632默认关闭）
    private boolean isOpenICcardWith692And694T = false;

    private int netWorkModel = 0;

    private int chioseModel = 0;
    private String doorID;

    private String parameter_hasCode = "";

    public String getParameter_hasCode() {
        return parameter_hasCode;
    }

    public void setParameter_hasCode(String parameter_hasCode) {
        this.parameter_hasCode = parameter_hasCode;
    }

    public int getNetWorkModel() {
        return netWorkModel;
    }

    public void setNetWorkModel(int netWorkModel) {
        this.netWorkModel = netWorkModel;
    }

    private int initDloadTips = 0;

    public int getInitDloadTips() {
        return initDloadTips;
    }

    public void setInitDloadTips(int initDloadTips) {
        this.initDloadTips = initDloadTips;
    }

    //身份证阅读器类型（0:中控IDM40串口读卡器 1:中控IDM40USB读卡器）
    private int cardReaderType = 0;
    //佩戴口罩开关
    private boolean openWearAMask = false;

    //体温监测开关
    private boolean bodyTemperatureMonitoring = true;

    private boolean mask_release = false;

    private boolean body_temperature_release = false;

    public boolean isMask_release() {
        return mask_release;
    }

    public void setMask_release(boolean mask_release) {
        this.mask_release = mask_release;
    }

    public boolean isBody_temperature_release() {
        return body_temperature_release;
    }

    public void setBody_temperature_release(boolean body_temperature_release) {
        this.body_temperature_release = body_temperature_release;
    }

    public String getAlarm_temperature() {
        return alarm_temperature;
    }

    public void setAlarm_temperature(String alarm_temperature) {
        this.alarm_temperature = alarm_temperature;
    }

    private String alarm_temperature = "37.3";

    public boolean isBodyTemperatureMonitoring() {
        return bodyTemperatureMonitoring;
    }

    public void setBodyTemperatureMonitoring(boolean bodyTemperatureMonitoring) {
        this.bodyTemperatureMonitoring = bodyTemperatureMonitoring;
    }

    public boolean isOpenWearAMask() {
        return openWearAMask;
    }

    public void setOpenWearAMask(boolean openWearAMask) {
        this.openWearAMask = openWearAMask;
    }

    public boolean isUpload_Stranger_record() {
        return isUpload_Stranger_record;
    }

    public void setUpload_Stranger_record(boolean upload_Stranger_record) {
        isUpload_Stranger_record = upload_Stranger_record;
    }


    private String client_id = "02ABF7F6-4F89-4874-86CA-0C740347FD2D";

    private String client_secret = "5678";

    private String grant_type = "client_credentials";

    private String author = "1BA12BF9-2633-46FE-B5EC-F2E7B389EE0C";


    private int sw_remote_debug = 1;

    public int getSw_remote_debug() {
        return sw_remote_debug;
    }

    public void setSw_remote_debug(int sw_remote_debug) {
        this.sw_remote_debug = sw_remote_debug;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

//    任意开门集合
    private List<Peak> anyDoor = new ArrayList<>();

    public boolean isAnyOpen() {
        return anyOpen;
    }

    public void setAnyOpen(boolean anyOpen) {
        this.anyOpen = anyOpen;
    }

    public List<Peak> getAnyDoor() {
        return anyDoor;
    }

    public int getChioseModel() {
        return chioseModel;
    }

    public void setChioseModel(int chioseModel) {
        this.chioseModel = chioseModel;
    }

    public void setAnyDoor(List<Peak> anyDoor) {
        this.anyDoor = anyDoor;
    }

    //网络连接方式下标
    private int networkType = 0;

    public String getOffDevNo() {
        return offDevNo;
    }

    public void setOffDevNo(String offDevNo) {
        this.offDevNo = offDevNo;
    }

    public boolean isFirstEnterSet() {
        return isFirstEnterSet;
    }

    public void setFirstEnterSet(boolean firstEnterSet) {
        isFirstEnterSet = firstEnterSet;
    }

    public int getIsLift() {
        return isLift;
    }

    public void setIsLift(int isLift) {
        this.isLift = isLift;
    }

    public int getModeIndex() {
        return modeIndex;
    }

    public int getLiftSectorIndex() {
        return liftSectorIndex;
    }

    public void setLiftSectorIndex(int liftSectorIndex) {
        this.liftSectorIndex = liftSectorIndex;
    }

    public void setModeIndex(int modeIndex) {
        this.modeIndex = modeIndex;
    }

    public int getSectorIndex() {
        return sectorIndex;
    }

    public void setSectorIndex(int sectorIndex) {
        this.sectorIndex = sectorIndex;
    }

    public String getIcPassWord() {
        return icPassWord;
    }

    public void setIcPassWord(String icPassWord) {
        this.icPassWord = icPassWord;
    }

    private long openDoorDelayTime = 0;

    public long getOpenDoorDelayTime() {
        return openDoorDelayTime;
    }

    public void setOpenDoorDelayTime(long openDoorDelayTime) {
        this.openDoorDelayTime = openDoorDelayTime;
    }

    public boolean isDelay() {
        return isDelay;
    }

    public void setDelay(boolean delay) {
        isDelay = delay;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    public boolean isOffLine() {
        return isOffLine;
    }

    public void setOffLine(boolean offLine) {
        isOffLine = offLine;
    }

    public boolean isIs_Goin_and_out() {
        return is_Goin_and_out;
    }

    public void setIs_Goin_and_out(boolean is_Goin_and_out) {
        this.is_Goin_and_out = is_Goin_and_out;
    }


    //白名单初始化页下标
    private int currentPag = 1;
    //心跳间隔
    private int heart_interval = 2;
    //屏幕休眠控制
    private int screenSleepControl = 0;
    //开门延时时间下标
    private int openDoorDelay = 2;
    //扬声器音量选项下标
    private int speakerVolume = 0;

    public boolean isUsePwdOpenDoor() {
        return usePwdOpenDoor;
    }

    public void setUsePwdOpenDoor(boolean usePwdOpenDoor) {
        this.usePwdOpenDoor = usePwdOpenDoor;
    }

    //是否开启二维码扫描
    private boolean isOpenQrcodeSacan = false;
    //是否开启ic卡识别
    private boolean isOpenIcCardIdentity = false;
    //是否显示全名
    private boolean isShowFullName = true;

    private int showFull = 0;

    public int getShowFull() {
        return showFull;
    }

    public void setShowFull(int showFull) {
        this.showFull = showFull;
    }

    //是否开启防撬
    private boolean isFloodPrevention = false;
    //活检失败提示语
    private String livenessFailDescription = "";
    //陌生人提示语
    private String strangerDescription = "";
    //考勤提示语
    private String attendanceDescription = "";
    //识别成功入口提示语
    private String identifySucComeDescription = "";
    //识别成功出口提示语
    private String identifySucOutDescription = "";
    //是否打开单目活检
    private boolean isOpenMonocularLive = false;
    //单目活检外扩系数下标
    private int monocularExtraParaIndex = 1;
    //是否打开趣味识别
    private boolean isOpenInterestIdentification = false;
    //输入信号开关
    private boolean inputSignalDetection = false;
    //是否打开开门信号检测
    private boolean isOpenSignalDetection = false;
    //是否打开消防信号检测
    private boolean fireSignalDetection = false;
    //是否打开PWM控制
    private boolean isOpenPWMControl = false;

    //身份证识别模式
    private int idcardIdentityIndex = 0;
    //身份证识别模式(694MIB型号)
    private int idcardIdentityIndex694MIB = 2;

    //人证比对阈值
    private String idcardIdentityThreshold = "60";

    //单目活检失败次数记录
    private int singleLiveFailCount;
    //单目活检成功次数记录
    private int singleLiveSuccessCount;
    /**
     * 安全质询随机数
     */
    private Long random;
    /**
     * 3des加密密钥
     */
    private String sdes_secret_key = "fujicaQW";
    /**
     * 时间戳
     */
    private Long expires_in;
    /**
     * 质询状态
     */
    private int access_token_status = 0;

    /**
     * 门常开、常闭状态
     */
    private int stateOfTheDoor = 0x00;

    public int getStateOfTheDoor() {
        return stateOfTheDoor;
    }

    public void setStateOfTheDoor(int stateOfTheDoor) {
        this.stateOfTheDoor = stateOfTheDoor;
    }

    public int getAccess_token_status() {
        return access_token_status;
    }

    public void setAccess_token_status(int access_token_status) {
        this.access_token_status = access_token_status;
    }

    public String getSdes_secret() {
        return sdes_secret;
    }

    public void setSdes_secret(String sdes_secret) {
        this.sdes_secret = sdes_secret;
    }

    /**
     * 质询返回密钥
     */
    private String sdes_secret;

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    public String getLiveScore() {
        return liveScore;
    }

    public void setLiveScore(String liveScore) {
        this.liveScore = liveScore;
    }

    public Long getRandom() {
        return random;
    }

    public void setRandom(Long random) {
        this.random = random;
    }

    public String getSdes_secret_key() {
        return sdes_secret_key;
    }

    public void setSdes_secret_key(String sdes_secret_key) {
        this.sdes_secret_key = sdes_secret_key;
    }

    public int getCurrentPag() {
        return currentPag;
    }

    public void setCurrentPag(int currentPag) {
        this.currentPag = currentPag;
    }

    private boolean lightStatus = true;

    private String eveingstart = "16:40";

    private String eveintend = "08:30";

    private boolean playVoice = true;

    public boolean isPlayVoice() {
        return playVoice;
    }

    public void setPlayVoice(boolean playVoice) {
        this.playVoice = playVoice;
    }

    public String getOpenDoorPaw() {
        return openDoorPaw;
    }

    public void setOpenDoorPaw(String openDoorPaw) {
        this.openDoorPaw = openDoorPaw;
    }

    public String getEveingstart() {
        return eveingstart;
    }

    public boolean isLightStatus() {
        return lightStatus;
    }

    public void setLightStatus(boolean lightStatus) {
        this.lightStatus = lightStatus;
    }

    public void setEveingstart(String eveingstart) {
        this.eveingstart = eveingstart;
    }

    public String getEveintend() {
        return eveintend;
    }

    public boolean isScanning() {
        return isScanning;
    }

    public void setScanning(boolean scanning) {
        isScanning = scanning;
    }

    public void setEveintend(String eveintend) {
        this.eveintend = eveintend;
    }

    public int getStanbdyTime() {
        return stanbdyTime;
    }

    public void setStanbdyTime(int stanbdyTime) {
        this.stanbdyTime = stanbdyTime;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getRestartIdnex() {
        return restartIdnex;
    }

    public void setRestartIdnex(int restartIdnex) {
        this.restartIdnex = restartIdnex;
    }

    public boolean isFelling() {
        return isFelling;
    }

    public void setFelling(boolean felling) {
        isFelling = felling;
    }

    public boolean isBinocular() {
        return isBinocular;
    }

    public void setBinocular(boolean binocular) {
        isBinocular = binocular;
    }

    public boolean isiShowImage() {
        return iShowImage;
    }

    public void setiShowImage(boolean iShowImage) {
        this.iShowImage = iShowImage;
    }

    public boolean isHumanBody() {
        return humanBody;
    }

    public void setHumanBody(boolean humanBody) {
        this.humanBody = humanBody;
    }

    public int getLightControl() {
        return lightControl;
    }

    public void setLightControl(int lightControl) {
        this.lightControl = lightControl;
    }

    public int getComOneIndex() {
        return comOneIndex;
    }

    public void setComOneIndex(int comOneIndex) {
        this.comOneIndex = comOneIndex;
    }

    public int getComFourIndex() {
        return comFourIndex;
    }

    public void setComFourIndex(int comFourIndex) {
        this.comFourIndex = comFourIndex;
    }

    public boolean isSystemAlive() {
        return systemAlive;
    }

    public void setSystemAlive(boolean systemAlive) {
        this.systemAlive = systemAlive;
    }

    public int getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(int deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getVerifyStangerTime() {
        return verifyStangerTime;
    }

    public void setVerifyStangerTime(String verifyStangerTime) {
        this.verifyStangerTime = verifyStangerTime;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public int getIsInit() {
        return isInit;
    }

    public List<Peak> getPeaks() {
        return peaks;
    }

    public void setPeaks(List<Peak> peaks) {
        this.peaks = peaks;
    }

    public void setIsInit(int isInit) {
        this.isInit = isInit;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getInWithOut() {
        return inWithOut;
    }

    public boolean isOpenPeak() {
        return isOpenPeak;
    }

    public void setOpenPeak(boolean openPeak) {
        isOpenPeak = openPeak;
    }

    public boolean isOpenDoor() {
        return isOpenDoor;
    }

    public void setOpenDoor(boolean openDoor) {
        isOpenDoor = openDoor;
    }

    public void setInWithOut(int inWithOut) {
        this.inWithOut = inWithOut;
    }

    public String getVerifySuccessShowTime() {
        return verifySuccessShowTime;
    }

    public void setVerifySuccessShowTime(String verifySuccessShowTime) {
        this.verifySuccessShowTime = verifySuccessShowTime;
    }

    public int getFaceSizeToHome() {
        return faceSizeToHome;
    }

    public void setFaceSizeToHome(int faceSizeToHome) {
        this.faceSizeToHome = faceSizeToHome;
    }

    public int getHost() {
        return host;
    }

    public void setHost(int host) {
        this.host = host;
    }

    public String getRecognitionDistance() {
        return recognitionDistance;
    }

    public void setRecognitionDistance(String recognitionDistance) {
        this.recognitionDistance = recognitionDistance;
    }

    public String getRecognitionScore() {
        return recognitionScore;
    }

    public void setRecognitionScore(String recognitionScore) {
        this.recognitionScore = recognitionScore;
    }

    public String getRecognitionInterval() {
        return recognitionInterval;
    }

    public void setRecognitionInterval(String recognitionInterval) {
        this.recognitionInterval = recognitionInterval;
    }

    public String getRecognitionMode() {
        return recognitionMode;
    }

    public void setRecognitionMode(String recognitionMode) {
        this.recognitionMode = recognitionMode;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getMultiFaceDetection() {
        return multiFaceDetection;
    }

    public void setMultiFaceDetection(String multiFaceDetection) {
        this.multiFaceDetection = multiFaceDetection;
    }

    public String getLiveDetection() {
        return liveDetection;
    }

    public void setLiveDetection(String liveDetection) {
        this.liveDetection = liveDetection;
    }

    public String getLiveDetectionScore() {
        return liveScore;
    }

    public void setLiveDetectionScore(String liveDetectionScore) {
        this.liveScore = liveDetectionScore;
    }

    public String getCameraCategory() {
        return cameraCategory;
    }

    public void setCameraCategory(String cameraCategory) {
        this.cameraCategory = cameraCategory;
    }

    public String getDoorOpenTime() {
        return doorOpenTime;
    }

    public void setDoorOpenTime(String doorOpenTime) {
        this.doorOpenTime = doorOpenTime;
    }

    public String getPromptSlogan() {
        return promptSlogan;
    }

    public void setPromptSlogan(String promptSlogan) {
        this.promptSlogan = promptSlogan;
    }

    public String getVoiceMode() {
        return voiceMode;
    }

    public void setVoiceMode(String voiceMode) {
        this.voiceMode = voiceMode;
    }

    public String getCustomizeVoice() {
        return customizeVoice;
    }

    public void setCustomizeVoice(String customizeVoice) {
        this.customizeVoice = customizeVoice;
    }

    public String getStandbyScreenTime() {
        return standbyScreenTime;
    }

    public void setStandbyScreenTime(String standbyScreenTime) {
        this.standbyScreenTime = standbyScreenTime;
    }

    public String getStrangerRecognition() {
        return strangerRecognition;
    }

    public void setStrangerRecognition(String strangerRecognition) {
        this.strangerRecognition = strangerRecognition;
    }

    public String getStrangerVoice() {
        return strangerVoice;
    }

    public void setStrangerVoice(String strangerVoice) {
        this.strangerVoice = strangerVoice;
    }

    public String getCustomizeStrangerVoice() {
        return customizeStrangerVoice;
    }

    public void setCustomizeStrangerVoice(String customizeStrangerVoice) {
        this.customizeStrangerVoice = customizeStrangerVoice;
    }

    public String getSystemAutoRestart() {
        return systemAutoRestart;
    }

    public void setSystemAutoRestart(String systemAutoRestart) {
        this.systemAutoRestart = systemAutoRestart;
    }

    public String getSystemRestartTime() {
        return systemRestartTime;
    }

    public void setSystemRestartTime(String systemRestartTime) {
        this.systemRestartTime = systemRestartTime;
    }

    public String getSystemPassword() {
        return systemPassword;
    }

    public void setSystemPassword(String systemPassword) {
        this.systemPassword = systemPassword;
    }

    public String getAccessPassword() {
        return accessPassword;
    }

    public void setAccessPassword(String accessPassword) {
        this.accessPassword = accessPassword;
    }

    public String getPeakHours() {
        return peakHours;
    }

    public void setPeakHours(String peakHours) {
        this.peakHours = peakHours;
    }

    public String getDoorOpenTimeoutAlarm() {
        return doorOpenTimeoutAlarm;
    }

    public void setDoorOpenTimeoutAlarm(String doorOpenTimeoutAlarm) {
        this.doorOpenTimeoutAlarm = doorOpenTimeoutAlarm;
    }

    public String getIntrusionAlarm() {
        return intrusionAlarm;
    }

    public void setIntrusionAlarm(String intrusionAlarm) {
        this.intrusionAlarm = intrusionAlarm;
    }

    public String getFireAlarm() {
        return fireAlarm;
    }

    public void setFireAlarm(String fireAlarm) {
        this.fireAlarm = fireAlarm;
    }

    public String getDuressAlarm() {
        return duressAlarm;
    }

    public void setDuressAlarm(String duressAlarm) {
        this.duressAlarm = duressAlarm;
    }

    public String getOvertimeTime() {
        return overtimeTime;
    }

    public void setOvertimeTime(String overtimeTime) {
        this.overtimeTime = overtimeTime;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getImageServerUrl() {
        return imageServerUrl;
    }

    public void setImageServerUrl(String imageServerUrl) {
        this.imageServerUrl = imageServerUrl;
    }

    public int getHeart_interval() {
        return heart_interval;
    }

    public void setHeart_interval(int heart_interval) {
        this.heart_interval = heart_interval;
    }

    public boolean isOpenQrcodeSacan() {
        return isOpenQrcodeSacan;
    }

    public void setOpenQrcodeSacan(boolean openQrcodeSacan) {
        isOpenQrcodeSacan = openQrcodeSacan;
    }

    public boolean isOpenIcCardIdentity() {
        return isOpenIcCardIdentity;
    }

    public void setOpenIcCardIdentity(boolean openIcCardIdentity) {
        isOpenIcCardIdentity = openIcCardIdentity;
    }

    public boolean isShowFullName() {
        return isShowFullName;
    }

    public void setShowFullName(boolean showFullName) {
        isShowFullName = showFullName;
    }


    public int getScreenSleepControl() {
        return screenSleepControl;
    }

    public void setScreenSleepControl(int screenSleepControl) {
        this.screenSleepControl = screenSleepControl;
    }

    public boolean isFloodPrevention() {
        return isFloodPrevention;
    }

    public void setFloodPrevention(boolean floodPrevention) {
        isFloodPrevention = floodPrevention;
    }

    public int getOpenDoorDelay() {
        return openDoorDelay;
    }

    public void setOpenDoorDelay(int openDoorDelay) {
        this.openDoorDelay = openDoorDelay;
    }

    public boolean isShowLivenessFailNote() {
        return isShowLivenessFailNote;
    }

    public void setShowLivenessFailNote(boolean showLivenessFailNote) {
        isShowLivenessFailNote = showLivenessFailNote;
    }

    public String getLivenessFailDescription() {
        return livenessFailDescription;
    }

    public void setLivenessFailDescription(String livenessFailDescription) {
        this.livenessFailDescription = livenessFailDescription;
    }

    public String getStrangerDescription() {
        return strangerDescription;
    }

    public void setStrangerDescription(String strangerDescription) {
        this.strangerDescription = strangerDescription;
    }

    public List<Peak> getEvenings() {
        return evenings;
    }

    public void setEvenings(List<Peak> evenings) {
        this.evenings = evenings;
    }

    public String getUpdateCheckTime() {
        return updateCheckTime;
    }

    public void setUpdateCheckTime(String updateCheckTime) {
        this.updateCheckTime = updateCheckTime;
    }

    public int getUpdateCheckIdnex() {
        return updateCheckIdnex;
    }

    public void setUpdateCheckIdnex(int updateCheckIdnex) {
        this.updateCheckIdnex = updateCheckIdnex;
    }

    public boolean isOpenAttendance() {
        return isOpenAttendance;
    }

    public void setOpenAttendance(boolean openAttendance) {
        isOpenAttendance = openAttendance;
    }

    public List<Peak> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Peak> attendances) {
        this.attendances = attendances;
    }

    public int getAppVersionCode() {
        return appVersionCode;
    }

    public void setAppVersionCode(int appVersionCode) {
        this.appVersionCode = appVersionCode;
    }

    public int getSpeakerVolume() {
        return speakerVolume;
    }

    public void setSpeakerVolume(int speakerVolume) {
        this.speakerVolume = speakerVolume;
    }

    public boolean isOpenFaceAE() {
        return isOpenFaceAE;
    }

    public void setOpenFaceAE(boolean openFaceAE) {
        isOpenFaceAE = openFaceAE;
    }

    public int getNetworkType() {
        return networkType;
    }

    public void setNetworkType(int networkType) {
        this.networkType = networkType;
    }

    public String getAttendanceDescription() {
        return attendanceDescription;
    }

    public void setAttendanceDescription(String attendanceDescription) {
        this.attendanceDescription = attendanceDescription;
    }

    public String getIdentifySucComeDescription() {
        return identifySucComeDescription;
    }

    public void setIdentifySucComeDescription(String identifySucComeDescription) {
        this.identifySucComeDescription = identifySucComeDescription;
    }

    public String getIdentifySucOutDescription() {
        return identifySucOutDescription;
    }

    public void setIdentifySucOutDescription(String identifySucOutDescription) {
        this.identifySucOutDescription = identifySucOutDescription;
    }

    public long getLastRebootTime() {
        return lastRebootTime;
    }

    public void setLastRebootTime(long lastRebootTime) {
        this.lastRebootTime = lastRebootTime;
    }

    public boolean isOpenMonocularLive() {
        return isOpenMonocularLive;
    }

    public void setOpenMonocularLive(boolean openMonocularLive) {
        isOpenMonocularLive = openMonocularLive;
    }

    public boolean isOpenInterestIdentification() {
        return isOpenInterestIdentification;
    }

    public void setOpenInterestIdentification(boolean openInterestIdentification) {
        isOpenInterestIdentification = openInterestIdentification;
    }

    public boolean isOpenSignalDetection() {
        return isOpenSignalDetection;
    }

    public void setOpenSignalDetection(boolean openSignalDetection) {
        isOpenSignalDetection = openSignalDetection;
    }

    public int getIdcardIdentityIndex() {
        return idcardIdentityIndex;
    }

    public void setIdcardIdentityIndex(int idcardIdentityIndex) {
        this.idcardIdentityIndex = idcardIdentityIndex;
    }

    public String getIdcardIdentityThreshold() {
        return idcardIdentityThreshold;
    }

    public void setIdcardIdentityThreshold(String idcardIdentityThreshold) {
        this.idcardIdentityThreshold = idcardIdentityThreshold;
    }

    public int getMonocularExtraParaIndex() {
        return monocularExtraParaIndex;
    }

    public void setMonocularExtraParaIndex(int monocularExtraParaIndex) {
        this.monocularExtraParaIndex = monocularExtraParaIndex;
    }

    public boolean isOpenPWMControl() {
        return isOpenPWMControl;
    }

    public void setOpenPWMControl(boolean openPWMControl) {
        isOpenPWMControl = openPWMControl;
    }

    public int getIdcardIdentityIndex694MIB() {
        return idcardIdentityIndex694MIB;
    }

    public void setIdcardIdentityIndex694MIB(int idcardIdentityIndex694MIB) {
        this.idcardIdentityIndex694MIB = idcardIdentityIndex694MIB;
    }

//    public List<Peak> getAttendancesFromServer() {
//        return attendancesFromServer;
//    }
//
//    public void setAttendancesFromServer(List<Peak> attendancesFromServer) {
//        this.attendancesFromServer = attendancesFromServer;
//    }

    public int getAttendanceAcquireType() {
        return attendanceAcquireType;
    }

    public void setAttendanceAcquireType(int attendanceAcquireType) {
        this.attendanceAcquireType = attendanceAcquireType;
    }

    public int getFaceSizeToHomeWithAccessAnd694M() {
        return faceSizeToHomeWithAccessAnd694M;
    }

    public void setFaceSizeToHomeWithAccessAnd694M(int faceSizeToHomeWithAccessAnd694M) {
        this.faceSizeToHomeWithAccessAnd694M = faceSizeToHomeWithAccessAnd694M;
    }

    public boolean isOpenICcard() {
        return isOpenICcard;
    }

    public void setOpenICcard(boolean openICcard) {
        isOpenICcard = openICcard;
    }

    public int getSingleLiveFailCount() {
        return singleLiveFailCount;
    }

    public void setSingleLiveFailCount(int singleLiveFailCount) {
        this.singleLiveFailCount = singleLiveFailCount;
    }

    public int getSingleLiveSuccessCount() {
        return singleLiveSuccessCount;
    }

    public void setSingleLiveSuccessCount(int singleLiveSuccessCount) {
        this.singleLiveSuccessCount = singleLiveSuccessCount;
    }

    public int getCardReaderType() {
        return cardReaderType;
    }

    public void setCardReaderType(int cardReaderType) {
        this.cardReaderType = cardReaderType;
    }


    public String getDoorID() {
        return doorID;
    }

    public void setDoorID(String doorID) {
        this.doorID = doorID;
    }

    @Override
    public String toString() {
        return "APPConfig{" +
                "ip='" + ip + '\'' +
                ", faceSizeToHome=" + faceSizeToHome +
                ", faceSizeToHomeWithAccessAnd694M=" + faceSizeToHomeWithAccessAnd694M +
                ", host=" + host +
                ", recognitionDistance='" + recognitionDistance + '\'' +
                ", recognitionScore='" + recognitionScore + '\'' +
                ", recognitionInterval='" + recognitionInterval + '\'' +
                ", recognitionInterval_692H='" + recognitionInterval_692H + '\'' +
                ", recognitionMode='" + recognitionMode + '\'' +
                ", securityLevel='" + securityLevel + '\'' +
                ", multiFaceDetection='" + multiFaceDetection + '\'' +
                ", liveDetection='" + liveDetection + '\'' +
                ", isShowLivenessFailNote=" + isShowLivenessFailNote +
                ", liveScore='" + liveScore + '\'' +
                ", cameraCategory='" + cameraCategory + '\'' +
                ", doorOpenTime='" + doorOpenTime + '\'' +
                ", promptSlogan='" + promptSlogan + '\'' +
                ", voiceMode='" + voiceMode + '\'' +
                ", customizeVoice='" + customizeVoice + '\'' +
                ", standbyScreenTime='" + standbyScreenTime + '\'' +
                ", strangerRecognition='" + strangerRecognition + '\'' +
                ", strangerVoice='" + strangerVoice + '\'' +
                ", customizeStrangerVoice='" + customizeStrangerVoice + '\'' +
                ", systemAutoRestart='" + systemAutoRestart + '\'' +
                ", systemRestartTime='" + systemRestartTime + '\'' +
                ", systemPassword='" + systemPassword + '\'' +
                ", accessPassword='" + accessPassword + '\'' +
                ", openDoorPaw='" + openDoorPaw + '\'' +
                ", peakHours='" + peakHours + '\'' +
                ", doorOpenTimeoutAlarm='" + doorOpenTimeoutAlarm + '\'' +
                ", intrusionAlarm='" + intrusionAlarm + '\'' +
                ", fireAlarm='" + fireAlarm + '\'' +
                ", duressAlarm='" + duressAlarm + '\'' +
                ", overtimeTime='" + overtimeTime + '\'' +
                ", alarmTime='" + alarmTime + '\'' +
                ", imageServerUrl='" + imageServerUrl + '\'' +
                ", isInit=" + isInit +
                ", systemAlive=" + systemAlive +
                ", isOpenPeak=" + isOpenPeak +
                ", isOpenDoor=" + isOpenDoor +
                ", isOpenAttendance=" + isOpenAttendance +
                ", isOpenFaceAE=" + isOpenFaceAE +
                ", inWithOut=" + inWithOut +
//                ", peaks=" + peaks +
//                ", evenings=" + evenings +
//                ", doors=" + doors +
//                ", attendances=" + attendances +
//                ", attendancesFromServer=" + attendancesFromServer +
                ", attendanceAcquireType=" + attendanceAcquireType +
                ", verifySuccessShowTime='" + verifySuccessShowTime + '\'' +
                ", verifyStangerTime='" + verifyStangerTime + '\'' +
                ", usePwdOpenDoor=" + usePwdOpenDoor +
                ", deviceNo=" + deviceNo +
                ", comOneIndex=" + comOneIndex +
                ", comFourIndex=" + comFourIndex +
                ", lightControl=" + lightControl +
                ", restartIdnex=" + restartIdnex +
                ", humanBody=" + humanBody +
                ", iShowImage=" + iShowImage +
                ", isFelling=" + isFelling +
                ", isBinocular=" + isBinocular +
                ", week=" + week +
                ", stanbdyTime=" + stanbdyTime +
                ", isScanning=" + isScanning +
                ", updateCheckTime='" + updateCheckTime + '\'' +
                ", updateCheckIdnex=" + updateCheckIdnex +
                ", appVersionCode=" + appVersionCode +
                ", isOffLine=" + isOffLine +
                ", isDelay=" + isDelay +
                ", delayTime=" + delayTime +
                ", sectorIndex=" + sectorIndex +
                ", liftSectorIndex=" + liftSectorIndex +
                ", icPassWord='" + icPassWord + '\'' +
                ", offDevNo='" + offDevNo + '\'' +
                ", modeIndex=" + modeIndex +
                ", isLift=" + isLift +
                ", isFirstEnterSet=" + isFirstEnterSet +
                ", anyOpen=" + anyOpen +
                ", lastRebootTime=" + lastRebootTime +
                ", isOpenICcard=" + isOpenICcard +
                ", netWorkModel=" + netWorkModel +
                ", chioseModel=" + chioseModel +
                ", doorID='" + doorID + '\'' +
                ", initDloadTips=" + initDloadTips +
                ", cardReaderType=" + cardReaderType +
                ", openWearAMask=" + openWearAMask +
                ", bodyTemperatureMonitoring=" + bodyTemperatureMonitoring +
                ", mask_release=" + mask_release +
                ", body_temperature_release=" + body_temperature_release +
                ", alarm_temperature='" + alarm_temperature + '\'' +
                ", client_id='" + client_id + '\'' +
                ", client_secret='" + client_secret + '\'' +
                ", grant_type='" + grant_type + '\'' +
                ", author='" + author + '\'' +
//                ", anyDoor=" + anyDoor +
                ", networkType=" + networkType +
                ", openDoorDelayTime=" + openDoorDelayTime +
                ", currentPag=" + currentPag +
                ", heart_interval=" + heart_interval +
                ", screenSleepControl=" + screenSleepControl +
                ", openDoorDelay=" + openDoorDelay +
                ", speakerVolume=" + speakerVolume +
                ", isOpenQrcodeSacan=" + isOpenQrcodeSacan +
                ", isOpenIcCardIdentity=" + isOpenIcCardIdentity +
                ", isShowFullName=" + isShowFullName +
                ", showFull=" + showFull +
                ", isFloodPrevention=" + isFloodPrevention +
                ", livenessFailDescription='" + livenessFailDescription + '\'' +
                ", strangerDescription='" + strangerDescription + '\'' +
                ", attendanceDescription='" + attendanceDescription + '\'' +
                ", identifySucComeDescription='" + identifySucComeDescription + '\'' +
                ", identifySucOutDescription='" + identifySucOutDescription + '\'' +
                ", isOpenMonocularLive=" + isOpenMonocularLive +
                ", monocularExtraParaIndex=" + monocularExtraParaIndex +
                ", isOpenInterestIdentification=" + isOpenInterestIdentification +
                ", isOpenSignalDetection=" + isOpenSignalDetection +
                ", isOpenPWMControl=" + isOpenPWMControl +
                ", idcardIdentityIndex=" + idcardIdentityIndex +
                ", idcardIdentityIndex694MIB=" + idcardIdentityIndex694MIB +
                ", idcardIdentityThreshold='" + idcardIdentityThreshold + '\'' +
                ", singleLiveFailCount=" + singleLiveFailCount +
                ", singleLiveSuccessCount=" + singleLiveSuccessCount +
                ", lightStatus=" + lightStatus +
                ", eveingstart='" + eveingstart + '\'' +
                ", eveintend='" + eveintend + '\'' +
                ", playVoice=" + playVoice +
                '}';
    }

    public boolean isOpenICcardWith692And694T() {
        return isOpenICcardWith692And694T;
    }

    public void setOpenICcardWith692And694T(boolean openICcardWith692And694T) {
        isOpenICcardWith692And694T = openICcardWith692And694T;
    }

    public int getFaceAESensitivity() {
        return faceAESensitivity;
    }

    public void setFaceAESensitivity(int faceAESensitivity) {
        this.faceAESensitivity = faceAESensitivity;
    }

    public int getFaceAEBrightness() {
        return faceAEBrightness;
    }

    public void setFaceAEBrightness(int faceAEBrightness) {
        this.faceAEBrightness = faceAEBrightness;
    }

    public boolean isInputSignalDetection() {
        return inputSignalDetection;
    }

    public void setInputSignalDetection(boolean inputSignalDetection) {
        this.inputSignalDetection = inputSignalDetection;
    }

    public boolean isFireSignalDetection() {
        return fireSignalDetection;
    }

    public void setFireSignalDetection(boolean fireSignalDetection) {
        this.fireSignalDetection = fireSignalDetection;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (Exception e) {
            System.out.println("TBUserInfo :   "+"TBUSERINFO_CLONE_FAILED");
        }
        return null;
    }
}
