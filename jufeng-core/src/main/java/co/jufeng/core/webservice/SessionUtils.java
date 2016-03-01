package co.jufeng.core.webservice;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Random;

public class SessionUtils {
   protected static Log log = LogFactory.getLog(SessionUtils.class.getName());
   protected static final int SESSION_ID_BYTES = 16;
   protected static Random random = null;
   protected static String randomClass = "java.security.SecureRandom";
   protected static String thisHost = null;
   public static synchronized String generateSessionId() {
      byte bytes[] = new byte[SESSION_ID_BYTES];
      getRandom().nextBytes(bytes);
      StringBuffer result = new StringBuffer();
      for (int i = 0; i < bytes.length; i++) {
           byte b1 = (byte) ((bytes[i] & 0xf0) >> 4);
           byte b2 = (byte) (bytes[i] & 0x0f);
           if (b1 < 10) {
               result.append((char) ('0' + b1));
           } else {
               result.append((char) ('A' + (b1 - 10)));
           }
           if (b2 < 10) {
               result.append((char) ('0' + b2));
           } else {
               result.append((char) ('A' + (b2 - 10)));
           }
       }
       return (result.toString());
   }
 
   public static synchronized Long generateSession() {
       return new Long(getRandom().nextLong());
   }
 
   private static synchronized Random getRandom() {
       if (random == null) {
           try {
                Class<?> clazz = Class.forName(randomClass);
                random = (Random) clazz.newInstance();
           } catch (Exception e) {
                random = new java.util.Random();
           }
       }
       return (random);
   }
}