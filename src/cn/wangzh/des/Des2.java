package cn.wangzh.des;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Hex;

public class Des2
{
    private static String key = "123#Abcd";
    
    public static void main(String[] args)
    {
        String msg = "hello world";
        System.out.println("加密前："+msg);
        byte[] encryptBytes = desEncrypt(msg.getBytes(), key, null);
//        System.out.println("加密后："+ new BASE64Encoder().encode(encryptBytes));
        System.out.println("加密后："+ Hex.encodeHex(encryptBytes));
        String deMsgBytes = desDecrypt(encryptBytes, key, null);
        System.out.println("解密后："+new String(deMsgBytes));
    }
    
    /**
     * DES加密
     *
     * @param data 加密数据
     * @param key 密钥
     * @return 返回加密后的数据
     */
    public static byte[] desEncrypt(byte[] data, String key, String charset)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            byte[] k = charset == null || charset.trim().isEmpty() ? key.getBytes() : key.getBytes(charset);
            SecretKeyFactory keySecret = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keySecret.generateSecret(new DESKeySpec(k));
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(k));
            return cipher.doFinal(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * DES解密
     *
     * @param data 解密数据
     * @param key 密钥
     * @return 返回解密后的数据
     */
    public static String desDecrypt(byte[] data, String key, String charset)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            byte[] k = charset == null || charset.trim().isEmpty() ? key.getBytes() : key.getBytes(charset);
            SecretKeyFactory keySecret = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keySecret.generateSecret(new DESKeySpec(k));
            cipher.init(Cipher.DECRYPT_MODE,
                secretKey,
                new IvParameterSpec(k));
            if (charset == null || charset.trim().isEmpty())
            {
                return new String(cipher.doFinal(data));
            }
            return new String(cipher.doFinal(data), charset);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
