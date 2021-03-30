import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyTest {


    public static boolean isBefore(Date one, Date two) {
        Calendar calendarOne = Calendar.getInstance();
        calendarOne.setTime(one);
        Calendar calendarTwo = Calendar.getInstance();
        calendarTwo.setTime(two);
        return calendarOne.before(calendarTwo);
    }


    public static boolean isAfter(Date one, Date two) {
        Calendar calendarOne = Calendar.getInstance();
        calendarOne.setTime(one);
        Calendar calendarTwo = Calendar.getInstance();
        calendarTwo.setTime(two);
        return calendarOne.after(calendarTwo);
    }

    public static void main(String aaa[]){
        try {
//            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//            System.out.println(isBefore(new Date(System.currentTimeMillis()),simpleDateFormat.parse("2021-02-21 10:23:12")));
//            System.out.println(isAfter(new Date(System.currentTimeMillis()),simpleDateFormat.parse("2021-02-20 12:00:00")));

        }catch (Exception e){

        }
            String  ssfp="fd7ea3f762c1char12021-02-21 10:23:12char12022-04-23 12:00:00char1jjlsss";
//            System.out.println(AescbcUtil.des3Encode(ssfp));
            String  str=AescbcUtil.des3Encode(ssfp);
////            String str_value=AescbcUtil.des3decode(str);
//            System.out.println(1+"char1"+str);
            String new_str=0+"char1"+str;
            System.out.println(new_str);
//        0char1vszO8SQOa+IwXXtJ8vb3N4zuQ/qXi74M8QabhR86nYEMdMElYZ63mzcg/4yTr0vghUSU2DqBerfhpb2tzTXboGiag3yFjmA2
//            System.out.println(new_str.substring(new_str.indexOf("char1")+5));
//            String ssafp="{\"anyDoor\":[{\"useTypeIndex\":0,\"choose\":false}],\"heart_interval\":2,\"usePwdOpenDoor\":false,\"inWithOut\":0,\"faceSizeToHome\":1,\"liveDetection\":1,\"icPassWord\":\"FFFFFFFFFFFF\",\"screenSleepControl\":0,\"ip\":\"192.168.8.10\",\"livenessFailDescription\":\"\",\"peaks\":[{\"useTypeIndex\":0,\"choose\":false}],\"sw_remote_debug\":1,\"doors\":[{\"swDoor\":true,\"choose\":false}],\"systemRestartTime\":\"04:00\",\"openQrcodeSacan\":true,\"speakerVolume\":0,\"evenings\":[{\"useTypeIndex\":0,\"choose\":false}],\"liveScore\":1,\"lightControl\":3,\"updateCheckIdnex\":0,\"openDoorPaw\":\"\",\"restartIdnex\":0,\"recognitionScore\":2,\"recognitionInterval\":\"0\",\"systemPassword\":\"8ddcff3a80f4189ca1c9d4d902c3c909\",\"anyOpen\":false,\"doorOpenTime\":2,\"updateCheckTime\":\"02:00\",\"identifySucComeDescription\":\"\",\"comFourIndex\":3,\"identifySucOutDescription\":\"\",\"week\":0,\"comOneIndex\":3,\"strangerDescription\":\"\",\"strangerRecognition\":1,\"showFull\":0,\"standbyScreenTime\":2,\"openDoor\":false}";

//            System.out.println(ssafp.replaceAll("false","0").replaceAll("true","1"));
//            if(new_str.contains("char1")){
//               if (new_str.charAt(0)=='0'){
//                   String values[] =new_str.split("char1");
//                   if(values!=null){
//                       if(Integer.valueOf(values[0])==0){
//                           String secretValue = AescbcUtil.des3decode(new_str.substring(new_str.indexOf("char1")+5,new_str.length()));
//                           System.out.println(secretValue);
//
//                       }
//                   }
//                }
//            }else {
//
//            }
//        String ssff="1";
//        int len=ssff.getBytes().length;
//        for (int i=0;i<len;i++){
//            System.out.println(ssff.getBytes()[i]);
//        }
    }
}