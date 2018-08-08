package cn.wangzh.des;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/****************************************
 * @name DESUtil
 * @since 2015-7-6
 ***************************************/
public class DESUtil
{
    
    private DESUtil()
    {
    }
    
    private static String encode = "UTF-8";
    
    /**
     */
    private static String toHexString(final byte b[])
    {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++)
        {
            String plainText = Integer.toHexString(0xff & b[i]);
            if (plainText.length() < 2)
                plainText = "0" + plainText;
            hexString.append(plainText);
        }
        return hexString.toString();
    }
    
    /**
     */
    private static byte[] fromHexString(final String s)
    {
        final byte[] result = new byte[s.length() / 2];
        for (int i = 0, j = 0; i < result.length; i++, j += 2)
            result[i] = (byte)Integer.parseInt(s.substring(j, j + 2), 16);
        return result;
    }
    
    /**
     */
    public static String encrypt(String key, String plaintext)
    {
        
        String cryptograph = "";
        
        try
        {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(key.getBytes(encode));
            DESKeySpec desKey = new DESKeySpec(key.getBytes(encode));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);
            byte[] encryptData = cipher.doFinal(plaintext.getBytes(encode));
            cryptograph = toHexString(encryptData);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return cryptograph;
    }
    
    /**
     */
    public static String decrypt(String key, String cryptograph)
    {
        
        String plaintext = "";
        
        try
        {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(key.getBytes(encode));
            DESKeySpec desKey = new DESKeySpec(key.getBytes(encode));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            cipher.init(Cipher.DECRYPT_MODE, securekey, iv);
            byte[] decryptData = fromHexString(cryptograph);
            plaintext = new String(cipher.doFinal(decryptData), encode);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return plaintext;
    }
    
    public static void main(String[] args)
    {
        String key = "123#Abcd";
        String msg = "{\"mobileNo\": \"13980863213\",\"amount\": \"1\",\"payDate\": \"20170814\",\"goodsId\": \"商品\",\"trace\": \"123456789\",\"merId\": \"123\"}";
        System.out.println("加密前："+msg);
        String encodeStr = encrypt(key, msg);
        System.out.println("加密后："+ encodeStr);
        System.out.println("解密后："+ decrypt(key, encodeStr));
    }
    
    // 类
    public static String getMD5(String comeString)
    {
        
        String s = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};// 用来将字节转换成16进制表示的字符
        byte sources[] = comeString.getBytes();
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sources);
            byte tmp[] = md.digest();// MD5 的计算结果是一个 128 位的长整数，
            // 用字节表示就是 16 个字节
            char str[] = new char[16 * 2];// 每个字节用 16 进制表示的话，使用两个字符，所以表示成 16
            // 进制需要 32 个字符
            int k = 0;// 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++)
            {// 从第一个字节开始，对 MD5 的每一个字节// 转换成 16
                // 进制字符的转换
                byte byte0 = tmp[i];// 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];// 取字节中高 4 位的数字转换,// >>>
                // 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf];// 取字节中低 4 位的数字转换
            }
            
            s = new String(str);// 换后的结果转换为字符串
            
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return s;
    }
    
}
