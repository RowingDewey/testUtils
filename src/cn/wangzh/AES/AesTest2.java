package cn.wangzh.AES;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;

public class AesTest2 {
	public static void main(String[] args) {
		String content = "5s2T9pIRyZKQaW53lnot8HKs/YekiHwGdiIaQB2zxoTuZVLedrutSxkFd+KZ15w79e+aWqRo9tRs"
				+ "nwR4MCSqC+lST1dc02QJxDLjnBCqvBjnYDTA9Me982pkZWvvqBSnYkubVjSCx2x0CoJyGYy/b/tp"
				+ "w6vwwNCGO7o4zPEv7gWoDyOG1SN801b+m8H33DJrHArW/0FOGnMGt5qY4pp2X9lrhmGyuZjb05AQ"
				+ "1DrtDTREJ+61vjyaXf0IiWS4MNcv8lKlDHIOyzs05TNORt7Rc5/qrraIW080LT5WLsD8O0nnOz/j"
				+ "QkwgErjqwWxUHun5egY8nzc5uvUhRRcxVSI/NXwlCbd2k54BTtGVmX12icrddXh"
				+ "laQ+9G2X8jrqr"
				+ "/qORDIdmFtWe8NP3G4DbNzeqpvKbD1HHTTtL/taoVt2QlgIwh5LwD62unNa2B0ef97QuesZHYTg0"
				+ "TmuvOVWPw/yD3c3wBDyWBU0sb6WbQZnUvE3ajXzviVaUjBTPrfQdJ8D6cDOWab8Dxi8I/Gn4f72N"
				+ "jz3az8DVevNkASGFB5LEiXuQi0UvI47UymVxIoASv9hVQXS+wj966sPF1tbbnpsn3UYt5DYyR8x9"
				+ "5s1R2ZQN1FHtvcYhH2cTrys5H87sUa7s";
		String identifyid = "40000700251";
		try {
			// System.out.println("加密前： " + content);
			// System.out.println("加密后：" + aesEncrypt(content, identifyid));
			System.out.println("解密后： " + aesDecrypt(content, identifyid));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean isEmpty(String str) {
		boolean isempty = ((str == null) || (str.trim().length() == 0));
		return isempty;
	}

	/**
	 * AES解密
	 * 
	 * @param encryptBytes
	 *            待解密的byte[]
	 * @param decryptKey
	 *            解密密钥
	 * @return 解密后的String
	 * @throws Exception
	 */
	public static String aesDecryptByBytes(byte[] encryptBytes,
			String decryptKey) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, new SecureRandom(decryptKey.getBytes()));

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey()
				.getEncoded(), "AES"));
		byte[] decryptBytes = cipher.doFinal(encryptBytes);

		return new String(decryptBytes);
	}

	/**
	 * 将base 64 code AES解密
	 * 
	 * @param encryptStr
	 *            待解密的base 64 code
	 * @param decryptKey
	 *            解密密钥
	 * @return 解密后的string
	 * @throws Exception
	 */
	public static String aesDecrypt(String encryptStr, String decryptKey)
			throws Exception {
		return AesTest2.isEmpty(encryptStr) ? null : aesDecryptByBytes(
				base64Decode(encryptStr), decryptKey);
	}

	/**
	 * base 64 decode
	 * 
	 * @param base64Code
	 *            待解码的base 64 code
	 * @return 解码后的byte[]
	 * @throws Exception
	 */
	public static byte[] base64Decode(String base64Code) throws Exception {
		return AesTest2.isEmpty(base64Code) ? null : new BASE64Decoder()
				.decodeBuffer(base64Code);
	}

}
