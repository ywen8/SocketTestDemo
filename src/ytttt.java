
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import sun.misc.BASE64Encoder;
public class ytttt {
//    List  jjjp=new ArrayList();
//    /**
//     * 函数功能描述:修改时间格式后缀
//     * 函数使用场景:处理当后缀为:+8:00时,转换为:+08:00 或 -8:00转换为-08:00
//     * @param subTime
//     * @param sign
//     * @return
//     */
//    private static String changeUtcSuffix(String subTime, String sign){
//        String timeSuffix = null;
//        String[] splitTimeArrayOne = subTime.split("\\" + sign);
//        String[] splitTimeArrayTwo = splitTimeArrayOne[1].split(":");
//        if(splitTimeArrayTwo[0].length() < 2){
//            timeSuffix = "+" + "0" + splitTimeArrayTwo[0] + ":" + splitTimeArrayTwo[1];
//            subTime = splitTimeArrayOne[0] + timeSuffix;
//            return subTime;
//        }
//        return subTime;
//    }
//    /**
//     * 函数功能描述:UTC时间转本地时间格式
//     * @param utcTime UTC时间
//     * @param localTimePattern 本地时间格式(要转换的本地时间格式)
//     * @return 本地时间格式的时间
//     */
//    public static String utc2Local(String utcTime, String localTimePattern){
//        String utcTimePattern = "yyyy-MM-dd HH:mm:ss";
//        String subTime = utcTime.substring(10);//UTC时间格式以 yyyy-MM-dd 开头,将utc时间的前10位截取掉,之后是含有多时区时间格式信息的数据
//
//        //处理当后缀为:+8:00时,转换为:+08:00 或 -8:00转换为-08:00
//        if(subTime.indexOf("+") != -1){
//            subTime = changeUtcSuffix(subTime, "+");
//        }
//        if(subTime.indexOf("-") != -1){
//            subTime = changeUtcSuffix(subTime, "-");
//        }
//        utcTime = utcTime.substring(0, 10) + subTime;
//
//        //依据传入函数的utc时间,得到对应的utc时间格式
//        //步骤一:处理 T
//        if(utcTime.indexOf("T") != -1){
//            utcTimePattern = utcTimePattern + "'T'";
//        }
//
//        //步骤二:处理毫秒SSS
//        if(utcTime.indexOf(".") != -1){
//            utcTimePattern = utcTimePattern + " HH:mm:ss.SSS";
//        }else{
//            utcTimePattern = utcTimePattern + " HH:mm:ss";
//        }
//
//        //步骤三:处理时区问题
//        if(subTime.indexOf("+") != -1 || subTime.indexOf("-") != -1){
//            utcTimePattern = utcTimePattern + "XXX";
//        }
//        else if(subTime.indexOf("Z") != -1){
//            utcTimePattern = utcTimePattern + "'Z'";
//        }
//
//        if("yyyy-MM-dd HH:mm:ss".equals(utcTimePattern) || "yyyy-MM-dd HH:mm:ss.SSS".equals(utcTimePattern)){
//            return utcTime;
//        }
//
//        SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePattern);
//        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
//        Date gpsUtcDate = null;
//        try {
//            gpsUtcDate = utcFormater.parse(utcTime);
//        } catch (Exception e) {
////            logger.error("utcTime converter localTime failed!!!", e);
//            return utcTime;
//        }
//        SimpleDateFormat localFormater = new SimpleDateFormat(localTimePattern);
//        localFormater.setTimeZone(TimeZone.getDefault());
//        String localTime = localFormater.format(gpsUtcDate.getTime());
//        return localTime;
//    }
//    public static String utc2Local(String utcTime, String utcTimePatten, String localTimePatten) {
//        SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePatten);
//        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));//时区定义并进行时间获取
//        Date gpsUTCDate = null;
//        try {
//            gpsUTCDate = utcFormater.parse(utcTime);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return utcTime;
//        }
//        SimpleDateFormat localFormater = new SimpleDateFormat(localTimePatten);
//        localFormater.setTimeZone(TimeZone.getDefault());
//        String localTime = localFormater.format(gpsUTCDate.getTime());
//        return localTime;
//    }
//
//    //判断一个byte数组src，在另一个byte数组source中存在的个数
//    public static int getByteCountOf(byte sources, byte[] src) {
//        if (src == null || src.length == 0) {
//            return 0;
//        }
//        int count = 0;
//        int start = 0;
//        int index = 0;
//        while ((index = getByteIndexOf(sources, src, start)) != -1) {
//            start = index + 1;
//            count++;
//        }
//        return count;
//    }

//
//    //判断一个byte数值在另外一个byte数组中对应的游标值
//    public static int getByteIndexOf(byte sources, byte[] src, int startIndex) {
//        return getByteIndexOf(sources, src, startIndex);
//    }


    //判断一个byte数值在另外一个byte数组中对应的游标值，指定开始的游标和结束的游标位置
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

    private static List<TBUserInfo> infoList;
    static StringBuffer buffer = new StringBuffer("");


/**
 2      *
 3      * @param key 秘钥
 4      * @param text 需要加密的数据
 5      * @return
 6      * @throws Exception
 7      * 简单了解下 ： DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 8      * 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，较为容易破解。
 9      */
public static String encrypt1(String key,String text) throws  Exception {

                     byte[] src = text.getBytes("utf-8");
                         //DESedeKeySpec会帮你生成24位秘钥，key可以是任意长度
                         DESedeKeySpec spec = new DESedeKeySpec(key.getBytes("utf-8"));
                         SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
                         SecretKey secretKey = factory.generateSecret(spec);
                         Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
                         cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                         byte[] res = cipher.doFinal(src);
                         //encodeBase64会对字符串3位一组自动补全，因而最后可能会出现 == 或者 =
//                        System.out.println(AescbcUtil.byte2HexStr(res));
    return Base64.getEncoder().encodeToString(res);


}


    private static final String Algorithm = "DESede"; // 定义 加密算法,可用

    /**
     * 加密方法
     *
     * @param keybyte
     *            加密密钥，长度为24字节
     * @param src
     *            被加密的数据缓冲区（源）
     * @return
     * @author SHANHY
     * @date 2015-8-18
     */
    public static byte[] encryptMode(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

            // 加密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    // 加解密统一使用的编码方式
    private final static String encoding = "utf-8";

    public static String encode(String plainText, String secretK) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(secretK.getBytes());
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");//DES加密和解密过程中，密钥长度都必须是8的倍数
        SecretKey secretKey = keyFactory.generateSecret(dks);
        // using DES in ECB mode
        Cipher cipher = Cipher.getInstance("DESede/ECB/pkcs5padding");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, sr);
        // 执行加密操作
        byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
        return com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(encryptData);
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
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        System.out.println("本地图片转换Base64:" + encoder.encode(Objects.requireNonNull(data)));
        return encoder.encode(Objects.requireNonNull(data));
    }



    /**
     * Load personnel information
     */
    private static void loadData(){
        File file=new File("src/file/file.txt");
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
        System.out.println(infoList.size());
        infoList=infoList.stream().map(m->{
            String[] faceStr=m.getFacePicture().split("/");
            String imgStr=faceStr[faceStr.length-1];
//            File file1=new File("D://yw/socket/636964544677020564.jpg");
            File file1=new File("D://yw/socket/吴文初.jpg");
            m.setBizCode(1);
            if(file1.exists()){
                try {
                    /**
                     * Personnel pictures converted to Base64 format
                     */
                    m.setFacePicture(ImageToBase64(file1.getPath()));

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
    }

//1595238389
    public static void main(String args[]){
        String  ssfp="01 00 00 00 00 01 03 05 7b 22 65 72 72 63 6f 64 65 22 3a 30 2c 22 65 72 72 6d 73 67 22 3a 22 73 75 63 63 65 65 64 22 2c 22 63 6d 64 22 3a 31 2c 22 63 6f 6e 74 65 6e 74 22 3a 22 7b 5c 22 73 65 63 72 65 74 5f 6b 65 79 5c 22 3a 5c 22 43 76 65 41 7a 79 5a 77 59 4e 69 52 69 52 59 58 66 45 6a 56 47 30 71 33 55 36 67 69 6c 78 2b 33 5c 22 2c 5c 22 65 78 70 69 72 65 73 5f 69 6e 5c 22 3a 31 36 30 37 30 37 39 39 34 35 33 39 38 7d 22 7d 04";
//        loadData();
//        ByteBuffer  byteBuffer=ByteBuffer.allocate(1024);
//        System.out.println(byteBuffer.remaining());
//        byteBuffer.put((byte) 1);
//        System.out.println(byteBuffer.remaining());
//        byteBuffer.put("afasfs".getBytes());
//        System.out.println(byteBuffer.remaining());
//        byteBuffer.flip();
//        System.out.println(byteBuffer.remaining());
//        byteBuffer.position(1);
//        System.out.println(byteBuffer.remaining());
//        System.out.println(4&0xFF);
//        byte[]  sfsfs={0x06, (byte) 0xAB,0x01,0x02,0x03,0x04};
//        System.out.println(getByteIndexOf((byte) 0x01,sfsfs,0,sfsfs.length));
//        Date date=new Date();
//        date.setTime(1598257045621L);
//        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//        System.out.println(dateFormat.format(date));
//        1598257045621
//        System.out.println(utc2Local(dateFormat.format(date),"yyyy-MM-dd'T'HH:mm:ss.SSSZ","yyyy-MM-dd HH:mm:ss"));
//        System.out.println(utc2Local(dateFormat.format(date),"yyyy-MM-dd HH:mm:ss"));
//        byte[] body = "2131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f13131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq121313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131v131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f132131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq121313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131v131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaas2131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq121313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131v131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f132131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq121313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131v131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f132131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq121313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131v131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f1313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq121313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131v131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f13131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f13fsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq1213131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq121313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131v131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq1213131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f1131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq121313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131v131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq1213131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313131f131313131313wefsasafdaasfsfsfsfsq12131313131f131313wefsasafdaasfsfsfsfsq12131313wefsasafdaasfs".getBytes(Charset.defaultCharset());
//        byte  pp[]=new byte[2];
//        pp[0]=0x01;
//        pp[1]=0x04;
//        ByteBuffer byteBuffer=ByteBuffer.allocate(2);
//        byteBuffer.put(pp);
//        byteBuffer.flip();
//        System.out.println(byteBuffer.position());
//        System.out.println(byteBuffer.remaining());
//        System.out.println(byteBuffer.hasRemaining());
//
//        byte[] body= "{\"cmd\":5,\"content\":\"\",\"currenCount\":0,\"totalCount\":0}".getBytes(Charset.defaultCharset());
//        System.out.println(body.length);
//        ByteBuffer bb = ByteBuffer.allocate(9 + body.length);
//        bb.order(ByteOrder.BIG_ENDIAN);
//        bb.put((byte)0x01);
//        System.out.println(bb.position());
//        String len=String.valueOf(body.length);
//        StringBuilder builder=new StringBuilder(len);
//        while (builder.length()<7){
//            builder.insert(0,0);
//        }
//        char[] bodybuf = builder.toString().toCharArray();
//        for (int i=0;i<bodybuf.length;i++){
//            System.out.println(Character.getNumericValue(bodybuf[i]));
//            bb.put((byte) Character.getNumericValue(bodybuf[i]));
//        }
////        Charset cs = Charset.forName("UTF-8");
////        CharBuffer cb = CharBuffer.allocate(bodybuf.length);
////        cb.put(bodybuf);
////        cb.flip();
////        ByteBuffer pp = cs.encode(cb);
////        System.out.println(new String(pp.array()));
////        bb.put(pp.array());
//        bb.put(body);
//        bb.put((byte) 0x04);
//        bb.flip();
//        byte[] strarray=bb.array();
////        byte[] bodybuf = builder.toString().getBytes();
//        System.out.println(strarray.length+"----------"+(strarray[0]&0xFF)+"   "+strarray[7]);




//        ByteBuffer bb = ByteBuffer.allocate(4);
//        bb.order(ByteOrder.BIG_ENDIAN);
//        System.out.println(body.length);
//        bb.putInt(body.length);
//

//        ByteBuffer bba = ByteBuffer.wrap(bb.array());
//        bba.order(ByteOrder.BIG_ENDIAN);
//        System.out.println( bba.getInt());
//        System.out.println((byte)10);
//       for (int i=0;i<byteBuffer.capacity();i++){
//           byteBuffer.put((byte)i);
//       }
//        List<Byte> bb=splitInt(1234);
//        for (int i=0;i<bb.size();i++){
//            System.out.println(bb.get(i)&0Xff);
//        }
//        int p=123456;
//        ByteBuffer byteBuffer=ByteBuffer.allocate(11);
//        char[]  ssfa=String.valueOf(p).toCharArray();
//
//        Charset cs = Charset.forName("UTF-8");
//        CharBuffer bb=CharBuffer.allocate(ssfa.length);
//        bb.put(ssfa);
//        bb.flip();
//        ByteBuffer byteBuffer1=cs.encode(bb);
//        byteBuffer.put(byteBuffer1);
//        byteBuffer.putInt(1321333323);
//        System.out.println(byteBuffer.capacity());
//        byteBuffer.flip();
//        System.out.println(byteBuffer.remaining());
//        byteBuffer.position(6);
//        System.out.println(byteBuffer.getInt());
//        System.out.println(byteBuffer.position());
//            System.out.println((Integer.parseInt(new String(byteBuffer.array(),0,5).trim())));

//        String ljojoqq="12313131";
//        ByteBuffer byteBuffer2=ByteBuffer.wrap(ljojoqq.getBytes());
//        System.out.println(Integer.parseInt(new String(byteBuffer2.array(),0,8).trim()));

//     System.out.println(byteArrayToInt(byteBuffer.array()));
//        afasfsf();
//        String stfff="{\n" +
//                "\t"cmd":1,\n" +
//                "\t"errcode":0,\n" +
//                "\t"errmsg": "操作完全成功。",\n" +
//                "\t"content":\n" +
//                "\t{\n" +
//                "\t\t"devNo":1,\n" +
//               "devName":"一楼东门",\n" +
//               "doorNo":1,\n" +
//               "expires":1591688196606\n" +
//                "}\n" +
//                "}";
//
//
////        System.out.println(getSHA256("1591688196606"));
//        System.out.println(encrypt("123131","fujicaQW"));
//        try {
//            System.out.println("zQvs3ABRPDShACeaVTYcpw==".equalsIgnoreCase("zQvs3ABRPDShACeaVTYcpw=="));
//        try {
//           System.out.println( getUTCTimeStr()+"    "+getUTCTimeStr(0)+"   "+System.currentTimeMillis());
//            String ppp="01 00 00 00 00 01 04 06 7b 22 63 6d 64 22 3a 31 2c 22 63 6f 6e 74 65 6e 74 22 3a 22 7b 5c 22 65 78 70 69 72 65 73 5f 69 6e 5c 22 3a 31 35 39 35 35 38 32 34 31 35 37 38 37 2c 5c 22 73 65 63 72 65 74 5f 6b 65 79 5c 22 3a 5c 22 70 4d 79 33 35 33 5a 2b 50 45 48 4a 4b 4e 48 71 43 71 50 4d 5a 4e 35 55 75 62 38 71 65 58 36 42 5c 22 7d 22 2c 22 65 72 72 63 6f 64 65 22 3a 30 2c 22 65 72 72 6d 73 67 22 3a 22 e6 93 8d e4 bd 9c e5 ae 8c e5 85 a8 e6 88 90 e5 8a 9f 22 7d 04";
//            System.out.println((ppp.replaceAll(" ",",")).split(",").length);
//            byte[] str={01,00,00,00,00,00,03,04,0x7b,22,63,0x6d ,64 ,22 ,0x3a ,32 ,0x2c ,22 ,63 ,0x6f ,0x6e ,74 ,65,0x6e,74,22,0x3a,22,22,0x2c ,22 ,65 ,72 ,72 ,63 ,0x6f ,64 ,65, 22,0x3a ,30 ,0x7d ,04};
//            System.out.println(str.length);


//            File file1=new File("D://yw/socket/636972489046708005.jpg");
//            if(file1.exists()){
//                try {
//                    /**
//                     * Personnel pictures converted to Base64 format
//                     */
//                    System.out.println(encodeToString(file1.getPath()));;
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }else {
//
//            }
//            String  str="1597048802193";
//            Date date=new Date();
//            date.setTime(1597048802193L);
//            DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
//            System.out.println(dateFormat.format(date));
//            System.out.println(UUID.randomUUID().toString());
//           System.out.println("\n"+AescbcUtil.encode("655683:1595380934"));
//            System.out.println(ImageToBase64("D://yw/socket/1602312058422_2.0.4_3.jpg"));
//            String   sfsfd="ABABAgBAAAAAtgAAAGmHBAABAAAA9gEAAA0BAgCAAAAA9gAAAA4BAgCAAAAAdgEAALQDAAAyMDIw";
//            System.out.println(sfsfd.length());
//            byte serect_value[]={0x01,0x01,0x00,0x16,0x01,0x00,0x00,0x01,0x01,0x02,0x01,0x02,0x10,0x00,0x00,0x7f,0x20,0x10,0x01,0x06,0x00,0x20,0x12,0x30,0x18,0x00,(byte)0x9d};
//            System.out.println(AescbcUtil.encode("0101001601000001010201021000007f201001060020123018009d"));
//            System.out.println(AescbcUtil.Decrypt(AescbcUtil.encode("0101001601000001010201021000007f201001060020123018009d"),"Honyar_First_Key"));
//            System.out.println(AescbcUtil.encode("0101001601000001010201021000007f201001060020123018009d"));
//
//            String ssfsf="0101001601000001010201021000007f201001060020123018009d";
//            System.out.println(ssfsf.substring(10,12));
//            byte[]  bytes=AesUtils.encrypt(serect_value,"Honyar_First_Key".getBytes());
//            AesUtils.decrypt(bytes,"Honyar_First_Key".getBytes());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        F/990UrL10HJnzy85sC7KheF5TwkhOo5
//        F/990UrL10HJnzy85sC7KheF5TwkhOo5
//                Fuqk/o3KFc2gCf9/cG7QNg==
//                Fuqk/o3KFc2gCf9/cG7QNg==
//        EFA86AC6AF5B80A5997D6C6B874BB0DA
//            Long random = (long) (1 + Math.random() * (10 - 1 + 1));
//            System.out.println(random);
//            System.out.println(System.currentTimeMillis());
//            System.out.println(System.currentTimeMillis());
//            Thread.sleep(3000);
//            System.out.println(System.currentTimeMillis());
//            System.out.println(getUTCTimeStr(1));
//            System.out.println(1593048475913L-1592962064556L);
//            List<Byte>  pj=new ArrayList<>();
//            byte ppo=12;
//            pj.add(ppo);
//            System.out.println(pj.get(0));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("123456".substring(2,1));

        try {
//            System.out.println(encrypt1("fujicaQWfujicaQWfujicaQW","424275:1607057477519"));
//            System.out.print(ssfp.replaceAll(" ",""));
//            String  ssf="424275:1607057477519";
//            byte[]  ss=new byte[24];
//            for (int i=0;i<24;i++){
//                if(i>=20){
//                    ss[i]=0x04;
//                }else{
//                    ss[i]=ssf.getBytes("utf-8")[i];
//                }
//            }
//            System.out.print(new String(ss));

        } catch (Exception e) {
            e.printStackTrace();
        }
//        34 32 34 32 37 35 3a 31 36 30 37 30 35 37 34 37 37 35 31 39 04 04 04 04
    }
//    1592962064556


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
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    public static String getUTCTimeStr(int n) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,n);
        TimeZone tz = TimeZone.getTimeZone("GMT");
        cal.setTimeZone(tz);
//        format.format(cal.getTime());
        return String.valueOf(cal.getTimeInMillis());// 返回的UTC时间戳
    }


    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;

    /**
     * 得到UTC时间，类型为字符串，格式为"yyyy-MM-dd HH:mm"<br />
     * 如果获取失败，返回null
     * @return
     */
    public static String getUTCTimeStr() {
        StringBuffer UTCTimeBuffer = new StringBuffer();
        // 1、取得本地时间:
        Calendar cal = Calendar.getInstance() ;
        // 2、取得时间偏移量:
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        // 3、取得夏令时差:
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        // 4、从本地时间里扣除这些差量，即可以取得UTC时间:
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        UTCTimeBuffer.append(year).append("-").append(month).append("-").append(day) ;
        UTCTimeBuffer.append(" ").append(hour).append(":").append(minute) ;
        try{

            return UTCTimeBuffer.toString() ;
        }catch(Exception e)
        {
            e.printStackTrace() ;
        }
        return null ;
    }


    private static String getSHA256(String str) {
        MessageDigest messageDigest;
        String encodestr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodestr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodestr;
    }


    //15 转16进制

    /**
     * 将byte转为16进制
     *
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    public static byte[] encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者
            kgen.init(128, new SecureRandom(password.getBytes()));// 利用用户密码作为随机数初始化出
            //加密没关系，SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以解密只要有password就行
            SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥
            byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥，如果此密钥不支持编码，则返回
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化为加密模式的密码器
            byte[] result = cipher.doFinal(byteContent);// 加密
            return result;
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密AES加密过的字符串
     *
     * @param content
     *            AES加密过过的内容
     * @param password
     *            加密时的密码
     * @return 明文
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥
            byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化为解密模式的密码器
            byte[] result = cipher.doFinal(content);
            return result; // 明文
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }


    private static void afasfsf(){
        byte[] body = "1".getBytes();
        ByteBuffer bb = ByteBuffer.allocate(9 + body.length);
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.put((byte)0x01);
        String len=String.valueOf(body.length);
        StringBuilder builder=new StringBuilder(len);

        while (builder.length()<7){
            builder.insert(0,0);
        }
        char[] bodybuf = builder.toString().toCharArray();
        Charset cs = Charset.forName("UTF-8");
        CharBuffer charBuffer = CharBuffer.allocate(bodybuf.length);
        charBuffer.put(bodybuf);
        charBuffer.flip();
        ByteBuffer byteBuffer=cs.encode(charBuffer);
        ByteBuffer bodylenBuf=ByteBuffer.allocate(7);
        bodylenBuf.put(byteBuffer.array());
        bb.put(bodylenBuf.array());
        bb.put(body);
        bb.put((byte) 0x04);
        System.out.println(bb.capacity());
        System.out.println(bb.position());
        System.out.println(bb.get(9));
    }
    /**
     * byte[]转int
     * @param bytes
     * @return
     */
    public static int byteArrayToInt(byte[] bytes) {
        int value = 0;
        // 由高位到低位
        for (int i = 0; i < 7; i++) {
            int shift = (7 - 1 - i) * 8;
            value += (bytes[i] & 0x000000FF) << shift;// 往高位游
        }
        return value;
    }
    private static ArrayList<Byte> splitInt(int a) { //int拆分成四个byte方法
        /**
         * 01100101 01100101 00100111 01011101
         * 直接写一个拆分方法
         */
        byte c = 0;
        ArrayList<Byte> list = new ArrayList<>(4); //将四个byte放进集合
        for(int i=0;i<4;i++) {
            c = (byte) (a>>>8*(3-i));
            list.add(c); //添加数据
        }
        return list;
    }



}
