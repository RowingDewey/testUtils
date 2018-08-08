package cn.wangzh.des;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DesTest
{
    public static void main(String[] args)
    {
        String password = "123#Abcd";
        String decryStr = "3d518daea941120d72fe3488f5d27a64";
        String encryStr = "hello world";
        
        System.out.println("加密前=" + encryStr);
        String encryptBytes = encrypt(encryStr, password);
        System.out.println("加密后=" + encryptBytes);
        String deMsgBytes = decrypt(encryptBytes, password);
        System.out.println("解密后=" + deMsgBytes);
        
    }
    
    public static String decrypt(String decryStr, String password)
    {
        byte[] decryResult = null;
        byte[] decryByte = null;
        
        try
        {
            decryByte = decryStr.getBytes("utf-8");
            decryResult = decrypt(decryByte, password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        
        return new String(decryResult);
    }
    
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
    
    public static String encrypt(String encrypt, String password)
    {
        byte[] encryResult = null;
        byte[] encryByte = null;
        try
        {
            try
            {
                encryByte = encrypt.getBytes("utf-8");
                encryResult = encrypt(encryByte, password);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        return new String(encryResult);
    }
    
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

}
