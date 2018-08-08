package cn.wangzh.AES;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class AESTestDecrypt
{
    public static void main(String[] args) {
        
        String content =
            "t5AD84vtt8xdVlSPKc90v6q+ps3lu1GBfEBZZzc5Pjv+Fe+/HZNGRQY5EUYdANZkgUOjxlTCyszVJKF8CP1LskyH1O6tXXf/hWHzi10Q8SSWW+6eyWNASrGq0v146T/joFhAhkgPzUiSY+1cK6r66x8ZwCf9mbuXXOVyqSAiSlEX7QiFK6TYH/64vkvDb0baS6R/Osa/usMGuR849fXLjCou27DIJOpzQZVItfp/tbNpEkbt4+IDNSqK90OExCmI81YTSRtcQcC01urHc6DdhJBRzS5evS3KkwsiKAhklesc4jxkiq4aGys+9HbfF563HaieeQ3uFrbAJzVCCg0TvwR6SnA86SQ4whrYJVCNcGAVSCOmDZTuVdjcWKrjjMSiExva/JRMs6QscdLJT8vrcTHDllTsjX0yhw79TghSbCfpXmRBj0umtnfMpJ39ZEjlnoa8twBUprdos9Dk7l2+Y92DaD3krDVdIBh2DxHzVTayrlkVvpI0overygRTK6ZgooubFGYERgOVChLiTh1rysqLsPU1H68iJjM7qXd9mS243ikKM3MRPEQcqVZiHPM5td6UjqcVnziIpVUO8RuWjmbCKY+U6g3J/FAEbtCVn7pgOihqAb7mAdcdZexRRW2pI4lANTaDBehJepa0fJfPvr/Qm9VuO1Gt0j+cyIl4HfY5zz3elSQMvCFdwiile7KvfcNxHW69bbMPOM30lCjGsKCu1T0Y7zqvnJ5ZFKG8RUNeTqCIPpywSfgWbfpz9uuEN17UaZ90PbfHTcXYuNvIxVesPRMna9aR3ukwgA0Y8AdE4CQTC1LSNdZodLoSYIGkH29Ln0/Z6C3B4i9Td7X4wSMyuUEBO1uCURuLz4CfnQmNTzvO/3UqmgzRu67R5lDAXUp2iq7BFs/bFvvmZH6SqQLR/AEz46ZSv7VOsSW6bpVtN18Iu8yJCiiVQTy0hTvGiY0PnvAZKTKmcAY5vgLxw7jGizmaqoWD5bvmUqdXEemTLogEnDh7eXkLS1hesaopunrhoRpAhDeHB7O0bIBaLbrGCpL4KbHqwEk6tih1ctsZN6fFcpeCTWkRcZmH3u9t";
        String key = "40000033101";
        
        String sign = null;
        try
        {
            sign = URLDecoder.decode(decrypt(content, key), "utf-8");
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("sign: " + sign);
    }
    
    /**
     * 对key进行MD5加密
     *
     * @return key
     * @throws NoSuchAlgorithmException
     */
    private static byte[] toMD5(String key) {
        MessageDigest md = null;
        try
        {
            md = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e)
        {
            
            return null;
        }
        md.update(key.getBytes());
        byte b[] = md.digest();
        
        return b;
    }
    
    /**
     * AES解密
     *
     * @param sSrc
     * @param mKey
     * @return originalString
     * @author wzh
     */
    public static String decrypt(String sSrc, String mKey) {
        String originalString = "";
        byte[] encrypted1 = null;
        try
        {
            encrypted1 = Base64.getDecoder().decode(sSrc);
            byte[] raw = toMD5(mKey);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] original = cipher.doFinal(encrypted1);
            originalString = new String(original);
            
        }
        catch (Exception e)
        {
            originalString = "BadPaddingException";
            e.printStackTrace();
        }
        return originalString;
    }
}
