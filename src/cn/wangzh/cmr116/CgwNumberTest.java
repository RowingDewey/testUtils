package cn.wangzh.cmr116;

import java.security.MessageDigest;

public class CgwNumberTest {

        public static void main(String... args)
        {
            String tabSuffix = getOraHash("40001191019", 64);
            System.out.println(tabSuffix);
        }
        public static  String getOraHash(String routeFieldValue, int partition)
        {
            try
            {
                byte input[] = routeFieldValue.getBytes("UTF-8");
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update(input, 0, input.length);
                byte[] md = md5.digest();
        
                int hash24 = ((md[0] & 0x7f)) << 24;
                int hash16 = (md[1] & 0xff) << 16;
                int hash8 = (md[2] & 0xff) << 8;
                int hash = md[3] & 0xff;
                int result = (hash24 | hash16 | hash8 | hash) % partition;
                return String.valueOf(result + 1);
            }
            catch (RuntimeException e) 
            {
            }
            catch (Exception e1)
            {
            }
            return "1";
        }
    
}
