package cn.wangzh.json;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * DES解密工具类
 * 
 * @author WZH
 * @version [109, 2015-12-14]
 */
public class DESUtils
{
    /**
     * 日志
     */
    //private static DebugLog log = LogFactory.getDebugLog(DESUtils.class);
    
    /**
     * DES解密秘钥
     */
    private static String key = "n43XY3Gg";
    
    /**
     * DES解密算法
     * 
     * @param String decryStr
     * @param password key
     * @return String decryResult
     */
    public static String decrypt(String decryStr)
    {
        byte[] decryResult = null;
        byte[] decryByte = null;
        
        try
        {
            decryByte = decryStr.getBytes("UTF-8");
            decryResult = DESUtils.decrypt(Base64.decodeBase64(decryByte), key);
        }
        catch (Exception e)
        {
            //log.error("decryStr is :" + decryStr);
            //log.error("DESUtils decrypt is error ", e);
            return null;
        }
        
        return new String(decryResult);
    }
    
    /**
     * DES加密算法
     * 
     * @param String decryStr
     * @param password key
     * @return String decryResult
     */
    public static String encrypt(String decryStr)
    {
        byte[] decryResult = null;
        byte[] decryByte = null;
        
        try
        {
            decryByte = decryStr.getBytes("UTF-8");
            decryResult = DESUtils.encrypt(decryByte, key);
        }
        catch (Exception e)
        {
            //log.error("decryStr is :" + decryStr);
            //log.error("DESUtils decrypt is error ", e);
            return null;
        }
        
        return new String(Base64.encodeBase64(decryResult));
    }
    
    /**
     * DES加密算法
     * 
     * @param datasource byte[]
     * @param password String
     * @return byte[]
     */
    public static byte[] encrypt(byte[] datasource, String password)
    {
        try
        {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            // 现在，获取数据并加密
            // 正式执行加密操作
            return cipher.doFinal(datasource);
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 解密
     * 
     * @param src byte[]
     * @param password String
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, String password)
        throws Exception
    {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }
}
