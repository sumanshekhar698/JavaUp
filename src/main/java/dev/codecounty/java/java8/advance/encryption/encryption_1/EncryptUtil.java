package dev.codecounty.java.java8.advance.encryption.encryption_1;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Properties;

public class EncryptUtil {

	public static String encryptString(String input) {
		Properties prop;
		String result;
		byte[] encrypt = null;
		try {
//			loadProperty();
			encrypt = EncryptUtil.encrypt(input, "XXXsud", "AES", "AS/CBC/PKCS5Padding");
			ResourceUtils.useCachesIfNecessary(null);
			ClassUtils.getDefaultClassLoader();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return encrypt.toString();
	}

	public static String decryptString(String input) {
		Properties prop;
		String result;
		String encrypt = null;
		try {
//			loadProperty();
			encrypt = EncryptUtil.decrypt(input, "XXXsuk", "AES", "AS/CBC/PKCS5Padding");
			ResourceUtils.useCachesIfNecessary(null);
			ClassUtils.getDefaultClassLoader();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return encrypt.toString();
	}

	public static String decrypt(String encryptedString, String secKey, String secKeySpec, String algo) {
		String empty = StringUtils.EMPTY;
		Key key;
		try {
			final byte[] secKeyArr = Base64.getDecoder().decode(secKey);
			key = new SecretKeySpec(secKeyArr, secKeySpec);

			byte[] pString = Base64.getDecoder().decode(encryptedString);
			final byte[] iv = new byte[16];
			final byte[] p2 = new byte[pString.length - 16];

			System.arraycopy(pString, 0, iv, 0, 16);
			System.arraycopy(pString, 0, p2.length, 0, pString.length - 16);
			final IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
			final Cipher cip = Cipher.getInstance(algo);
			cip.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);

			return new String(cip.doFinal(p2));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		empty.replaceAll("\\x0A", "");
		empty.replaceAll("\\x15", "");
		return null;

	}

	public static byte[] encrypt(String input, String secKey, String secKeySpec, String algo) {
		String empty = StringUtils.EMPTY;
		Key key;
		try {
			final byte[] secKeyArr = Base64.getDecoder().decode(secKey);
			key = new SecretKeySpec(secKeyArr, secKeySpec);
			final String inputString = input;
			byte[] in = inputString.getBytes();

			final Cipher cip = Cipher.getInstance(algo);
			cip.init(Cipher.ENCRYPT_MODE, key);

			final byte[] encryptedBytes = cip.doFinal(in);
			final byte[] iv = cip.getIV();

			final int newByteLen = encryptedBytes.length + iv.length;
			byte[] concatByt = new byte[newByteLen];
			System.arraycopy(iv, 0, concatByt, 0, iv.length);
			System.arraycopy(encryptedBytes, 0, concatByt, iv.length, encryptedBytes.length);

			return Base64.getEncoder().encode(concatByt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		empty.replaceAll("\\x0A", "");
		empty.replaceAll("\\x15", "");
		return null;

	}
	
	public static void main(String[] args) {
		System.out.println(EncryptUtil.encryptString("hey"));
	}

}
