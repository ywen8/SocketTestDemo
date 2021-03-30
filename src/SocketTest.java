import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Base64;


public class SocketTest {
    private static boolean stop=false;
    /**
     * 人员白名单集合
     */
    private static List<TBUserInfo> infoList;
    static StringBuffer buffer = new StringBuffer("");
    private static ByteBuffer mRemainingBuf;
    /**
     *原始数据包体字节数组
     */
    private static byte[] mBodyBytes;
    /**
     * 最大读取数据数(单位:MB)
     * 防止数据过大导致内存溢出
     */
    private static int maxReadDataMB=20;
    /**
     * 包体对象
     */
    private static MsgBean msgBean = new MsgBean();

    static OutputStream outputStream;
    static InputStream inputStream;
    private static int door_status=0;
    static ByteBuffer tempBuff;
    static String user_time_zone="[{\"zoneNo\":1,\"BeginTime\":\"08:30\",\"EndTime\":\"12:00\",\"Monday\":0,\"Tuesday\":0,\"Wednesday\":1,\"Thursday\":1,\"Friday\":0,\"Saturday\":0,\"Sunday\":0},"+
    "{\"zoneNo\":1,\"BeginTime\":\"14:00\",\"EndTime\":\"21:00\",\"Monday\":0,\"Tuesday\":0,\"Wednesday\":0,\"Thursday\":1,\"Friday\":0,\"Saturday\":1,\"Sunday\":1},"+
        "{\"zoneNo\":2,\"BeginTime\":\"08:00\",\"EndTime\":\"10:00\",\"Monday\":0,\"Tuesday\":0,\"Wednesday\":0,\"Thursday\":0,\"Friday\":0,\"Saturday\":0,\"Sunday\":1},"+
    "{\"zoneNo\":2,\"BeginTime\":\"18:00\",\"EndTime\":\"19:00\",\"Monday\":0,\"Tuesday\":0,\"Wednesday\":0,\"Thursday\":0,\"Friday\":1,\"Saturday\":0,\"Sunday\":1}]";


    static String door_status_time_zone="[{\"BeginTime\":\"08:30\",\"EndTime\":\"12:00\",\"Monday\":0,\"Tuesday\":0,\"Wednesday\":0,\"Thursday\":0,\"Friday\":0,\"Saturday\":0,\"Sunday\":0},"+
    "{\"BeginTime\":\"13:00\",\"EndTime\":\"15:00\",\"Monday\":0,\"Tuesday\":0,\"Wednesday\":0,\"Thursday\":0,\"Friday\":0,\"Saturday\":0,\"Sunday\":1},"+
    "{\"BeginTime\":\"16:00\",\"EndTime\":\"21:00\",\"Monday\":0,\"Tuesday\":2,\"Wednesday\":0,\"Thursday\":0,\"Friday\":0,\"Saturday\":0,\"Sunday\":0}]";

    static String update_setting_parameter="{\"faceSizeToHome\":2,\"recognitionScore\":2,\"recognitionInterval\":1,\"liveDetection\":0,\"liveScore\":0,"+
                "\"strangerRecognition\":1,\"strangerDescription\":\"认证失败\",\"showFull\":0,\"identifySucComeDescription\":\"认证成功\",\"identifySucOutDescription\":\"认证成功\","+
                "\"isShowLivenessFailNote\":1,\"livenessFailDescription\":\"这是照片吗？\",\"isOpenPeak\":0,\"peaks\":[{\"endTime\":\"1:08\",\"startTime\":\"1:02\",\"useTypeIndex\":0},{\"endTime\":\"2:05\",\"startTime\":\"2:02\",\"useTypeIndex\":1},{\"endTime\":\"3:07\",\"startTime\":\"3:04\",\"useTypeIndex\":2}],"+
            "\"anyOpen\":1,\"anyDoor\":[{\"endTime\":\"1:05\",\"startTime\":\"1:02\",\"useTypeIndex\":0},{\"endTime\":\"2:13\",\"startTime\":\"2:02\",\"useTypeIndex\":1},{\"endTime\":\"5:07\",\"startTime\":\"4:08\"," +
            "\"useTypeIndex\":2}], \"isOpenDoor\":0,\"doors\": [{\"endTime\":\"1:03\",\"startTime\":\"1:00\",\"swDoor\":0},{\"endTime\":\"20:04\",\"startTime\":\"19:00\",\"swDoor\":1}], \"speakerVolume\":3,"+
            "\"screenSleepControl\":0, \"isOpenSignalDetection\":0, \"lightControl\":1,\"heart_interval\":2, \"evenings\": [{\"endTime\":\"1:02\",\"startTime\":\"1:00\",\"useTypeIndex\":0},{\"endTime\":\"3:06\"," +
            "\"startTime\":\"3:01\",\"useTypeIndex\":0},{\"endTime\":\"2:02\",\"startTime\":\"2:00\",\"useTypeIndex\":0},{\"endTime\":\"4:09\",\"startTime\":\"4:00\",\"useTypeIndex\":0},{\"endTime\":\"5:08\"," +
            "\"startTime\":\"5:00\",\"useTypeIndex\":0}],\"restartIdnex\":0,\"week\":2,\"systemRestartTime\":\"04:00\",\"inWithOut\":1,\"icPassWord\":\"FFFFFFFFFFFF\",\"systemPassword\":\"8ddcff3a80f4189ca1c9d4d902c3c909\","+
                "\"doorOpenTime\":2}";

    String ssfp="{\"errcode\":0,\"errmsg\":\"succeed\",\"cmd\":1,\"content\":\"{\\\"secret_key\\\":\\\"CveAzyZwYNiRiRYXfEjVG0q3U6gilx+3\\\",\\\"expires_in\\\":1607079945398}\"}";
    static String update_setting_parameter111="{\"doors\": [{\"endTime\":\"1:03\",\"startTime\":\"1:00\",\"swDoor\":0},{\"endTime\":\"20:04\",\"startTime\":\"19:00\",\"swDoor\":1}]}";
    public static void main(String[] args) {
//        mServerSocket(55555);
        ssst();
    }
    private  static void ssst(){
        JFrame window=new JFrame("socket test  12");
        Container container=window.getContentPane();
        container.setBackground(Color.white);
        window.setBounds(0,0,650,800);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font=new Font("",Font.PLAIN,18);
        JButton jButton=new JButton("Initialization data");
        jButton.setBounds(20,20,125,125);
        jButton.setFont(font);
        JButton  jbt1=new JButton("connection");
        jbt1.setBounds(170,20,125,125);
        jbt1.setFont(font);
        JButton  jbloginOut=new JButton("Log out all");
        jbloginOut.setBounds(320,20,125,125);
        jbloginOut.setFont(font);
        JButton  jbreboot=new JButton("Device restart");
        jbreboot.setBounds(470,20,125,125);
        jbreboot.setFont(font);
        JButton  jbremoteopen=new JButton("Open the door remotely");
        jbremoteopen.setBounds(20,160,125,125);
        jbremoteopen.setFont(font);
        JButton  jbUpdateTime=new JButton("Update time");
        jbUpdateTime.setBounds(170,160,125,125);
        jbUpdateTime.setFont(font);
        JButton jbNorma=new JButton("Door status");
        jbNorma.setBounds(320,160,125,125);
        jbNorma.setFont(font);
        JButton jbNorma_data2=new JButton("send data");
        jbNorma_data2.setBounds(470,160,125,125);
        jbNorma_data2.setFont(font);

        JButton jbNorma_key=new JButton("Set key");
        jbNorma_key.setBounds(20,300,125,125);
        jbNorma_key.setFont(font);

        JButton jbNorma_redcord=new JButton("Upload record");
        jbNorma_redcord.setBounds(170,300,125,125);
        jbNorma_redcord.setFont(font);

        JButton jbNorma_dev_info=new JButton("Device Information");
        jbNorma_dev_info.setBounds(320,300,125,125);
        jbNorma_dev_info.setFont(font);

        JButton jbNorma_set_user_zone=new JButton("Set User Zone");
        jbNorma_set_user_zone.setBounds(470,300,125,125);
        jbNorma_set_user_zone.setFont(font);

        JButton jbNorma_set_door_zone=new JButton("Set door Zone");
        jbNorma_set_door_zone.setBounds(20,440,125,125);
        jbNorma_set_door_zone.setFont(font);

        JButton jbNorma_update_setting=new JButton("update setting");
        jbNorma_update_setting.setBounds(170,440,125,125);
        jbNorma_update_setting.setFont(font);

        window.add(jbNorma);
        window.add(jbUpdateTime);
        window.add(jButton);
        window.add(jbt1);
        window.add(jbloginOut);
        window.add(jbreboot);
        window.add(jbremoteopen);
        window.add(jbNorma_data2);
        window.add(jbNorma_key);
        window.add(jbNorma_redcord);
        window.add(jbNorma_dev_info);
        window.add(jbNorma_set_user_zone);
        window.add(jbNorma_set_door_zone);
        window.add(jbNorma_update_setting);
        jbNorma_redcord.addActionListener(t->{
            msgBean.setCmd(0x05);
            UploadRecordCmd uploadRecordCmd=new UploadRecordCmd();
            uploadRecordCmd.setNeedcontinue("1");
            uploadRecordCmd.setHassuccessedrow("0");
            msgBean.setContent(JSON.toJSONString(uploadRecordCmd));
            writeData(JSON.toJSONString(msgBean),outputStream);
        });
        jbNorma_dev_info.addActionListener(t->{
            msgBean.setCmd(0x02);
            msgBean.setContent("");
            writeData(JSON.toJSONString(msgBean),outputStream);
        });
        jbNorma_key.addActionListener(t->{
            msgBean.setCmd(0x13);
            UpdateApp updateApp=new UpdateApp();
            updateApp.setDeviceId("ZRS693JBT012S");
            updateApp.setVersion("2.0.5");
            updateApp.setSignMethod("");
            updateApp.setSign("");
//            updateApp.setUrl("http://8.129.120.70:9000/upload/20210303/1367003888070963200.apk");
            updateApp.setUrl("http://192.168.8.10:60001/HeadPic/20201106/14/app.apk");
            msgBean.setMessageId("112");
//            msgBean.setContent();
//            msgBean.setContent("12345678");
//            QueryStaff queryStaff=new QueryStaff();
////            queryStaff.setType(1);
////            queryStaff.setStaffNo("1111111");
////            queryStaff.setStaffNo("22222222");
//            msgBean.setContent(JSON.toJSONString(updateApp));
            writeData("{\"messageId\":\"1369900460820566016\",\"cmd\":19,\"content\":\"{\\\"sign\\\":\\\"sec\\\",\\\"version\\\":\\\"2.0.5\\\",\\\"deviceId\\\":\\\"ZRS693JBT012S\\\",\\\"url\\\":\\\"http://8.129.120.70:9000/upload/20210311/1369908046970130432.apk\\\",\\\"signMethod\\\":\\\"MD5\\\"}\"}",outputStream);
        });
        jbNorma_data2.addActionListener(t->{
            writeData(synctokenData(msgBean.getContent()),outputStream);
        });
        jbt1.addActionListener(t->{
//                mockClient("192.168.8.46");
            mServerSocket(55555);
        });

        jbloginOut.addActionListener(t->{
            logOutAll(outputStream);
        });

        jButton.addActionListener(t->{
            loadData();

        });
        jbreboot.addActionListener(t->{
            msgBean.setCmd(0x09);
            writeData(JSON.toJSONString(msgBean),outputStream);
        });

        jbremoteopen.addActionListener(t->{
            openTheDoorRemotely(outputStream);
        });
        jbUpdateTime.addActionListener(t->{
            updateTime(outputStream);
        });

        jbNorma.addActionListener(t->{
            normallyOpenWithNormayylCloseCommand(outputStream);
        });

        jbNorma_set_user_zone.addActionListener(t->{
            set_user_time_zone(outputStream);
        });

        jbNorma_set_door_zone.addActionListener(t->{
            set_door_status_time_zone(outputStream);
        });

        jbNorma_update_setting.addActionListener(t->{
            update_setting_parameters(outputStream);
        });

    }

    /**
     * Load personnel information
     */
    private static void loadData(){
        File file=new File("src/file/data.txt");
        if(file.exists()){
            try {
                int length=buffer.length();
                if(length>0){
                    buffer.delete(0,length);
                }
                String str;
                FileInputStream inputStream=new FileInputStream(file);
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                while ((str=bufferedReader.readLine())!=null){
                    buffer.append(str);
                    buffer.append("\n");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JSONObject json=JSON.parseObject(buffer.toString());
        infoList=JSON.parseArray(JSON.toJSONString(json.getJSONArray("list")),TBUserInfo.class);
        infoList=infoList.stream().map(m->{
            String[] faceStr=m.getFacePicture().split("/");
            String imgStr=faceStr[faceStr.length-1];
            File file1=new File("D://yw/socket/"+imgStr);
//            File file1=new File("D://yw/socket/吴文初.jpg");
            m.setBizCode(1);
            if(file1.exists()){
                try {
                    /**
                     * Personnel pictures converted to Base64 format
                     */
                    m.setFacePicture(encodeToString(file1.getPath()).replaceAll("\n","").replaceAll("\r","").replaceAll("\t","").replaceAll(" ",""));
                    m.setAccessTime("80");
//                    System.out.println(encodeToString(file1.getPath()));
//                    System.out.println(encodeToString(file1.getPath()).length()+"  "+p);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                m.setFacePicture("");
            }
            return m;
            /**
             *
             */
        }).collect(Collectors.toList());
        System.out.println(infoList.size());
    }

    /**
     * Convert base64 string to picture
     * @param imgStr		base64 string
     * @param imgFilePath	Image storage path
     * @return
     *
     *
     */
    public static boolean Base64ToImage(String imgStr,String imgFilePath) {

        if (imgStr==null||imgStr.length()==0)
            return false;

        try {
            byte[] b = Base64.getDecoder().decode(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }

            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


    /**
     * 本地图片转换Base64的方法
     *
     * @param imgPath
     */

    private static String ImageToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
//        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        String base64Str=Base64.getEncoder().encodeToString(Objects.requireNonNull(data));
        System.out.println("本地图片转换Base64:" + base64Str);
        return base64Str;
    }

    /**
     * Picture to base64
     * @param imagePath
     * @return
     * @throws IOException
     */
    public static String encodeToString(String imagePath) throws IOException {
        int ssIndex=imagePath.lastIndexOf(".")+1;
        String type=imagePath.substring(ssIndex,imagePath.length());
        BufferedImage image = ImageIO.read(new File(imagePath));
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();
            Base64.Encoder encoder=Base64.getEncoder();
            imageString = encoder.encodeToString(imageBytes);
            imageString.replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t","");
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }



    private static void  mockClient(String ip){
        try {
            Thread thread=new Thread(()->{
                Socket  socket=new Socket();
                SocketAddress address=new InetSocketAddress(ip,60009);
                try {
                    socket.connect(address,10000);
                    inputStream=socket.getInputStream();
                    outputStream=socket.getOutputStream();
                    while (!stop){
                      readBody();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void mServerSocket(int host){
            Thread thread=new Thread(()-> {
                try {
                ServerSocket serverSocket = new ServerSocket(host);
                Socket socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                    while (!stop){
                        if(inputStream.available()>0){
                            readBody();
                        }
                    }
            } catch (IOException e) {
                e.printStackTrace();
            }
            });
            thread.start();
    }


    //Determine the cursor value corresponding to a byte array in another byte array, and specify the starting and ending cursor positions
    public static int getByteIndexOf(byte  sources, byte[] src, int startIndex, int endIndex) {
        if (src == null || src.length == 0) {
            return -1;
        }

        int i;
        for (i = startIndex; i < endIndex; i++) {
            if (sources== src[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Read data
     */
    private static void readBody(){
        OriginalData originalData = new OriginalData();
        ByteBuffer headBuf = ByteBuffer.allocate(1024);
        headBuf.order(ByteOrder.BIG_ENDIAN);
        ByteBuffer bodyLenBuf = ByteBuffer.allocate(7);
        bodyLenBuf.order(ByteOrder.BIG_ENDIAN);
        ByteBuffer footBuf = ByteBuffer.allocate(1);
        footBuf.order(ByteOrder.BIG_ENDIAN);
        try {
            if(tempBuff==null||tempBuff.remaining()==0){
                tempBuff=ByteBuffer.allocate(1024);
                readHeaderFromChannel(tempBuff,tempBuff.capacity());
                tempBuff.flip();
            }
          int headIndex= getByteIndexOf((byte) 0x01,tempBuff.array(),tempBuff.position(),tempBuff.remaining());
            if(headIndex!=-1&&tempBuff.remaining()>(headIndex+1)){
                tempBuff.position(headIndex+1);
                int length = Math.min(tempBuff.remaining(), 7);
                bodyLenBuf.put(tempBuff.array(),tempBuff.position(),length);
                if(length <7){
                    tempBuff=null;
                    readSpcifiedLength(bodyLenBuf,(7-tempBuff.remaining()));
                }else {
                    tempBuff.position(tempBuff.position()+7);
                }
                bodyLenBuf.flip();
                int bodyLength =getBodyLength(bodyLenBuf.array());
                if(bodyLength>0){
                    if(bodyLength>8*1024*1024){
                        throw new ReadException("Need to follow the transmission protocol.\r\n" +
                                "Please check the client/server code.\r\n" +
                                "According to the packet header data in the transport protocol, the package length is " + bodyLength + " Bytes.\r\n" +
                                "You need check your <ReaderProtocol> definition");
                    }else {
                        ByteBuffer bodyBuffer = ByteBuffer.allocate(bodyLength);
                        if(tempBuff!=null&&tempBuff.remaining()>0){
                            int bdlength = Math.min(tempBuff.remaining(), bodyLength);
                            bodyBuffer.put(tempBuff.array(),tempBuff.position(),bdlength);
                            bodyBuffer.position(bdlength);
                            if(bdlength<bodyLength){
                                tempBuff =null;
                                readBodyFromChannel(bodyBuffer);
                            }else {
                                tempBuff.position(tempBuff.position()+bodyLength);
                            }
                        }else {
                            readBodyFromChannel(bodyBuffer);
                        }
                        originalData.setBodyBytes(bodyBuffer.array());
                        if(tempBuff!=null&&tempBuff.remaining()>0){
                            int footlength = Math.min(tempBuff.remaining(), 1);
                            footBuf.put(tempBuff.array(),tempBuff.position(),1);
                            if(footlength<1){
                                tempBuff =null;
                                readfootFromChannel(footBuf,1);
                            }else {
                                tempBuff.position(tempBuff.position()+1);
                            }
                        }else {
                            readfootFromChannel(footBuf,1);
                        }
                        if (footBuf.array() != null && footBuf.array().length == 1 && (footBuf.array()[0] & 0xFF) == 0x04) {
                            System.out.println("数据格式正确");
                            originalData.setmFootBytes(footBuf.array());
                            readData1(originalData.getBodyBytes());
                        }
                    }
                }
            }else {
                tempBuff=null;
            }
        }catch (Exception e){
            ReadException readException = new ReadException(e);
            throw readException;
        }
    }



    private static void readfootFromChannel(ByteBuffer headBuf, int readLength) throws IOException {
        for (int i = 0; i < readLength; i++) {
            byte[] bytes = new byte[1];
            int value = inputStream.read(bytes);
            if (value == -1) {
                return;
            }
            headBuf.put(bytes);
        }
    }


    /**
     * Data received
     * @param bytes
     */
    private static void  readData(byte[] bytes){
        String str=new String(bytes);
        System.out.println(str);

    }
    /**
     * Data received
     * @param bytes
     */
    private static void  readData1(byte[] bytes){
        String str=new String(bytes);
        System.out.println(str);
        MsgBean msgBean=JSON.parseObject(str,MsgBean.class);
        if(msgBean!=null){
            System.out.println(msgBean.getCmd()+"----cmd----");
            switch (msgBean.getCmd()){
                /**
                 * connection
                 */
                case 0x01:
                    AcToken acToken=JSON.parseObject(msgBean.getContent(),AcToken.class);
                        Token token=new Token();
                        token.setExpires_in(System.currentTimeMillis());
                    try {
                        token.setSecret_key(AescbcUtil.encode((acToken.getRandom()+":"+token.getExpires_in())));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    msgBean.setCmd(0x01);
                    msgBean.setContent(JSON.toJSONString(token));
                    msgBean.setErrcode(0);
                    msgBean.setErrmsg("The operation was completely successful");
                    String jsonstr=JSON.toJSONString(msgBean).replaceAll(" ","").replaceAll("\t","").replaceAll("\n","");
                    writeData(jsonstr,outputStream);
                    break;

                case 0x02:
                    System.out.println(msgBean.getContent()+"    ");
                    break;

                case 0x03:
                    writeData(synctokenData(msgBean.getContent()),outputStream);
                    break;

                case 0x04:
                    System.out.println(msgBean.getContent());
                    break;
                case 0x05:
                    System.out.println("0000"+msgBean.getContent());
                  TBDmsOpenRecord tbDmsOpenRecord=JSON.parseObject(msgBean.getContent(),TBDmsOpenRecord.class);
                  System.out.println(tbDmsOpenRecord.getRid()+"   "+tbDmsOpenRecord.toString());
                  UploadRecordCmd uploadRecordCmd=new UploadRecordCmd();
                  uploadRecordCmd.setNeedcontinue("0");
                  uploadRecordCmd.setLastsuccessrowid(tbDmsOpenRecord.getRid());
                  uploadRecordCmd.setHassuccessedrow("1");
                  MsgBean msgBean1=new MsgBean();
                  msgBean1.setCmd(0x05);
                  msgBean1.setContent(JSON.toJSONString(uploadRecordCmd));
                  msgBean1.setErrcode(0);
                  writeData(JSON.toJSONString(msgBean1),outputStream);
                    break;
                case 0x06:
                    System.out.println(msgBean.getContent());
                    break;
                case 0x07:
                    System.out.println(msgBean.getContent());

                    break;
                case 0x08:
                    System.out.println(msgBean.getContent());
                    break;
                case 0x09:
                    System.out.println(msgBean.getContent());
                    break;
                case 0x0A:
                    System.out.println(msgBean.getContent());
                    break;
                case 0x0B:
                    System.out.println(msgBean.getContent());
                    break;
                case 0x0C:
                    System.out.println(msgBean.getContent());
                    break;
                case 0x0D:
                    System.out.println(msgBean.getContent());
                    break;
                case 0x0E:
                    System.out.println(msgBean.getContent());
//                    msgBean.setCmd(16);
//                    msgBean.setContent("{\"speakerVolume\":2,\"heart_interval\":1}");
//                    msgBean.setContent("0xff");
//                    String jsonstr1=JSON.toJSONString(msgBean).replaceAll(" ","").replaceAll("\t","").replaceAll("\n","");
//                    writeData(jsonstr1,outputStream);
                    break;
                case 0x0F:
                    System.out.println(msgBean.getContent());
                    break;
                case 0x10:
                    System.out.println(msgBean.getContent());
                    break;
                case 0x11:
                    if(msgBean.getContent()!=null){
                        System.out.println(AescbcUtil.des3decode(msgBean.getContent()));
                        QrCodeAuth auth=new QrCodeAuth();
                        auth.setAuthFlag(0);
                        auth.setStaffno("324242");
                        auth.setMessage("111111");
                        auth.setRemark("55555");
                        MsgBean msgBean5=new MsgBean();
                        msgBean5.setCmd(0x11);
                        msgBean5.setContent(JSON.toJSONString(auth));
                        msgBean5.setErrcode(0);
                        writeData(JSON.toJSONString(msgBean5),outputStream);
                    }
                    break;
                case 0x13:
                    System.out.println(msgBean.getContent());
                    break;
                case 0x14:
                    System.out.println(msgBean.getContent());
                    break;
            }
        }else {
            System.out.println("json 格式错误");
        }

    }
    /**
     * Send cancel all personnel instructions
     */

    private static void logOutAll(OutputStream o){
        msgBean.setCmd(0x04);
        msgBean.setContent("");
        writeData(JSON.toJSONString(msgBean),o);
    }


    /**
     * Send remote door opening instructions
     */

    private static void openTheDoorRemotely(OutputStream o){

//        AcToken acToken=JSON.parseObject(msgBean.getContent(),AcToken.class);
//        Token token=new Token();
//        long currentTime=getUTCTimeStr(1);
//        token.setExpires_in(currentTime);
//        try {
//            token.setSecret_key(AescbcUtil.encode((100+":"+currentTime)));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        msgBean.setCmd(0x01);
//        msgBean.setContent(JSON.toJSONString(token));
//        msgBean.setErrcode(0);
//        msgBean.setErrmsg("操作完全成功");
//        writeData(JSON.toJSONString(msgBean),outputStream);
        msgBean.setCmd(0x06);
        writeData(JSON.toJSONString(msgBean),o);
    }

    /**
     * Send update time command
     */
    private static void updateTime(OutputStream o){
        msgBean.setCmd(0x07);
        msgBean.setContent(String.valueOf(getUTCTimeStr(0)));
        writeData(JSON.toJSONString(msgBean),o);
    }


    /**
     * Set user time zone
     */

    private static void set_user_time_zone(OutputStream o){
        List<Zone>  userZones=JSON.parseArray(user_time_zone,Zone.class);
        msgBean.setCmd(0x0B);
        msgBean.setContent(JSON.toJSONString(userZones));
//        msgBean.setContent("0xff");
        writeData(JSON.toJSONString(msgBean),o);

    }

    /**
     *Set door status time zone
     */
    private static void set_door_status_time_zone(OutputStream o){
        List<Zone> doorStatusZone=JSON.parseArray(door_status_time_zone,Zone.class);
        msgBean.setCmd(0x10);
//        msgBean.setContent(JSON.toJSONString(doorStatusZone));
        msgBean.setContent("0xff");
        writeData(JSON.toJSONString(msgBean),o);
    }


    /**
     *Update setting parameters
     */
    private static void update_setting_parameters(OutputStream o){
//        APPConfig appConfig=JSON.parseObject(update_setting_parameter,APPConfig.class);
        msgBean.setCmd(0x0D);
//        msgBean.setContent(update_setting_parameter111);
        msgBean.setContent("0xff");
        writeData(JSON.toJSONString(msgBean),o);
    }

    /**
     * Send normally open, normally closed, and normal recognition commands
     */
    private static void  normallyOpenWithNormayylCloseCommand(OutputStream o){
        /**
         * content=0 normal
         * content=1 Normally open
         * content=2 Normally closed
         */
        if(door_status==0){
            door_status=1;
            msgBean.setContent(""+door_status);
            msgBean.setCmd(0x08);
        }else if(door_status==1){
            door_status=2;
            msgBean.setContent(""+door_status);
            msgBean.setCmd(0x08);
        }else {
            door_status=0;
            msgBean.setContent(""+door_status);
            msgBean.setCmd(0x08);
        }
        writeData(JSON.toJSONString(msgBean),o);
    }

    /**
     * Send device restart instruction
     */
    private static void  deviceReboot(OutputStream o){
        msgBean.setCmd(11);
        msgBean.setContent("");
        writeData(JSON.toJSONString(msgBean),o);
    }

    /**
     *Initialization data
     */
    private static String initData(int currenTips) {
        if(infoList.size()>currenTips){
            msgBean.setCmd(3);
            /**
             * Content is the information of the whitelisted person, currentips is the subscript of the person, and infolist is the whitelisted person collection
             */
            msgBean.setContent(JSON.toJSONString(infoList.get(currenTips)));
        }else {
            /**
             *loading finished
             */
            msgBean.setCmd(3);
            msgBean.setContent("");
        }
        return JSON.toJSONString(msgBean);
    }

    /**
     * Incremental data
     */
   static int p=0;
    private static String synctokenData(String tokenId){
        if(tokenId!=null&&tokenId.length()>0&&infoList.size()>0){
            infoList.remove(0);
        }
        if(infoList.size()>0){
            msgBean.setCmd(3);
//            infoList.get(0).setFacePicture("");
            System.out.println(infoList.get(0).getFacePicture().length());
            msgBean.setContent(JSON.toJSONString(infoList.get(0)));
        }else{
            msgBean.setCmd(3);
            msgBean.setContent("");
        }
        System.out.println("\n"+p+" \n");
        return JSON.toJSONString(msgBean);
    }



    /**
     * Get the data length of the package body
     */
    private static int getBodyLength(byte[] header){
        if (header == null || header.length <7) {
            return 0;
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<header.length;i++){
            stringBuilder.append(header[i]&0xFF);
        }
        String lenstr=stringBuilder.toString();
        if(lenstr!=null&&lenstr.length()>0){
            int len=Integer.parseInt(stringBuilder.toString());
          return len;
        }

        return 0;
    }

    /**
     * Read header content
     * @param headBuf
     * @param readLength
     * @throws IOException
     */
    private static void readHeaderFromChannel(ByteBuffer headBuf,int readLength)throws IOException{
            byte[] bytes=new byte[1024];
        System.out.println("读取数据1");
            int values=inputStream.read(bytes);
//        System.out.println("读取数据2");
            if(values==-1){
               return;
            }
            headBuf.put(bytes,0,values);
    }

    private static void readSpcifiedLength(ByteBuffer headBuf,int readLength) throws IOException {
        byte[] bytes=new byte[readLength];
        int values=inputStream.read(bytes);
        if(values==-1){
            return;
        }
        headBuf.put(bytes);
    }


    /**
     *Read package body content
     * @param byteBuffer
     * @throws IOException
     */
    private static void readBodyFromChannel(ByteBuffer byteBuffer)throws  IOException{
        while (byteBuffer.hasRemaining()){
            try {

                byte[] bufArray=new byte[1024];
                int len=inputStream.read(bufArray);
                if(len==-1){
                    break;
                }
                int remaining=byteBuffer.remaining();
                if (len > remaining) {
                    byteBuffer.put(bufArray, 0, remaining);
                    tempBuff = ByteBuffer.allocate(len - remaining);
                    tempBuff.order(ByteOrder.BIG_ENDIAN);
                    tempBuff.put(bufArray, remaining, len - remaining);
                    tempBuff.flip();

                } else {
                    byteBuffer.put(bufArray, 0, len);
                }
            }catch (Exception e){
                throw e;
            }
        }
    }

    /**
     * Send data packet to server
     * @param outputStream
     * @param sendBytes
     */
    private static void sendBody(OutputStream outputStream,byte[] sendBytes){
        /**
         * The total length of a single packet when sent to the server
         */
        int packageSize=1024;
        /**
         * Get the total length of the data packet
         */
        int remainingCount = sendBytes.length;
        ByteBuffer writhBuffer=ByteBuffer.allocate(packageSize);
        writhBuffer.order(ByteOrder.BIG_ENDIAN);
        int index=0;
        while (remainingCount>0){
            int realWriteLength=Math.min(packageSize,remainingCount);
            writhBuffer.clear();
            writhBuffer.rewind();
            writhBuffer.put(sendBytes,index,realWriteLength);
            writhBuffer.flip();
            byte[]  writeArr=new byte[realWriteLength];
            writhBuffer.get(writeArr);
            try {
                outputStream.write(writeArr);
                outputStream.flush();
                index+=realWriteLength;
                remainingCount-=realWriteLength;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    private static void writeData(String s,OutputStream outputStream){
        try {
        if(outputStream!=null){
            sendBody(outputStream,assembly(s));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the total length of the data packet
     * @param strBody
     * @return
     */
    private static byte[]  assembly(String strBody){
        System.out.println(strBody);
        byte[] body;
        body = strBody.getBytes();
        ByteBuffer bb = ByteBuffer.allocate(9 + body.length);
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.put((byte)0x01);
        String len=String.valueOf(body.length);
        StringBuilder builder=new StringBuilder(len);
        while (builder.length()<7){
            builder.insert(0,0);
        }
        char[] bodybuf = builder.toString().toCharArray();
        for (int i=0;i<bodybuf.length;i++){
            System.out.println(bodybuf[i]);
            bb.put((byte) Character.getNumericValue(bodybuf[i]));
        }
        bb.put(body);
        bb.put((byte) 0x04);
        bb.flip();
        return bb.array();
    }





    public static long getUTCTimeStr(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,n);
        TimeZone tz = TimeZone.getTimeZone("GMT");
        cal.setTimeZone(tz);
        return cal.getTimeInMillis();
    }







}
