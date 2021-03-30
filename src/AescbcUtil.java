import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * AES加密解密字符串工具类
 * 概述:AES高级加密标准，是对称密钥加密中最流行的算法之一；
 * 工作模式包括:ECB、CBC、CTR、OFB、CFB；
 * 使用范围:该工具类仅支持CBC模式下的:
 * 填充:PKCS7PADDING
 * 数据块:128位
 * 密码（key）:32字节长度（例如:12345678901234567890123456789012）
 * 偏移量（iv）:16字节长度（例如:1234567890123456）
 * 输出:hex
 * 字符集:UTF-8
 * 使用方式:String encrypt = AescbcUtil.encrypt("wy");
 * String decrypt = AescbcUtil.decrypt(encrypt);
 * 验证方式:http://tool.chacuo.net/cryptaes（在线AES加密解密）
 */
public class AescbcUtil {


    /**
     * 加密:对字符串进行加密，并返回十六进制字符串(hex)
     *
     * @return 加密后的十六进制字符串(hex)
     */
    public static String encrypt(byte[] encryptByte, String key) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(encryptByte);
            return byte2HexStr(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    // 密钥(DES加密和解密过程中，密钥长度都必须是8的倍数)
//    private final static String secretKey = "12345678";
//    private final static String secretKey = "Honyar_First_Key";
    private final static String secretKey = "fujicaQWfujicaQWfujicaQW";



    public static String byteToHex(byte b){
        String hex = Integer.toHexString(b & 0xFF);
        if(hex.length() < 2){
            hex = "0" + hex;
        }
        return hex;
    }

    // 加解密统一使用的编码方式
    private final static String encoding = "utf-8";
    public static String encode(String plainText) throws Exception {
        byte[] src = plainText.getBytes(encoding);
        //DESedeKeySpec会帮你生成24位秘钥，key可以是任意长度
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes(encoding));
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
        SecretKey secretKey = factory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] res = cipher.doFinal(src);
        return com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(res);
    }


    // 解密
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = Base64.getDecoder().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }


    public static String  des3decode(String text){
        try{
            DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes(encoding));
            SecretKeyFactory factory=SecretKeyFactory.getInstance("DESede");
            SecretKey secretKey = factory.generateSecret(spec);
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            byte[] bytes = com.sun.org.apache.xerces.internal.impl.dv.util.Base64.decode(text);
            byte[] plain = cipher.doFinal(bytes);
            return new String(plain, "utf-8");
        }catch (Exception e){
            e.printStackTrace();
            System.out.print(e.toString());
        }
        return  null;
    }

    public static String des3Encode(String text){
        try {
            byte[] src = text.getBytes(encoding);
            //DESedeKeySpec会帮你生成24位秘钥，key可以是任意长度
            DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes(encoding));
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
            SecretKey secretKey = factory.generateSecret(spec);
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] res = cipher.doFinal(src);
            //encodeBase64会对字符串3位一组自动补全，因而最后可能会出现 == 或者 =
            return com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(res);
        }catch (Exception e){
            e.printStackTrace();
            System.out.print(e.toString());
        }
        return null;
    }
    /**
     * byte[]转换为十六进制字符串
     *
     * @param bytes 需要转换为字符串的byte[]
     * @return 转换后的十六进制字符串
     */
    public static String byte2HexStr(byte[] bytes) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < bytes.length; n++) {
            stmp = (Integer.toHexString(bytes[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs;
    }

    public static byte[] str2Hexbyte(String str) {
        int strlen=str.length()/2;
        byte[] bytes=new byte[strlen];
        for (int i=0;i<strlen;i++){
            int data = Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16);
            bytes[i]= (byte) data;
        }
        return bytes;
    }

}
