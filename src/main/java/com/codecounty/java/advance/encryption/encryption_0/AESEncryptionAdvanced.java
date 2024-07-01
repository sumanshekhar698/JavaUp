package com.codecounty.java.advance.encryption.encryption_0;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class AESEncryptionAdvanced {

	private static final String UNICODE_FORMAT = "UTF-8";
	private static final String ALGO = "AES";
//	private final static byte[] secretKey = "1234567891234567".getBytes();// 16 char String must

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String text = "SUman SHekhar";
		byte[] secretKey = "1234567891234567".getBytes(UNICODE_FORMAT);// 16 char String must

		Key generateKey = generateKey(secretKey, ALGO);
		String encryptString = encryptString(text, generateKey, ALGO);
//		String encrypt = encrypt(text, generateKey);
		String decrypt = decrypt(encryptString, generateKey);
		System.out.println("\n\nEND");
	}

	public static Key generateKey(byte[] secretKey, String algo) {
		try {
//			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, algo);
			Key key = new SecretKeySpec(secretKey, algo);
			return key;
		} catch (Exception e) {
			return null;
		}
	}

	public static String encryptString(String dataToEncrypt, Key myKey, final String ALGO)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, UnsupportedEncodingException {

		Cipher cipher = Cipher.getInstance(ALGO);
		cipher.init(Cipher.ENCRYPT_MODE, myKey);// telling the cipher to Encrypt [1] and not decrypt [2]

		byte[] textByte = dataToEncrypt.getBytes(UNICODE_FORMAT);// by default it will pick whatever format the
		// computer is using, we enterer UTF-8
		// explicitly for a seam-less consistent
		// encryption
		byte[] textEncrypted = cipher.doFinal(textByte);

//		Encoder encoder = java.util.Base64.getEncoder();
//		byte[] encodedTextEncrypted = encoder.encode(textEncrypted);
		byte[] encodedTextEncrypted = new Base64().encode(textEncrypted);

		String fianlencodedTextEncryptedString = new String(encodedTextEncrypted);
		System.out.println("\n Encoded String ---> " + fianlencodedTextEncryptedString);

		return fianlencodedTextEncryptedString;// if we convert byte [] -> String ; String ->byte[] it may not work
	}

	public static String decrypt(String encryptedValue, Key key) throws Exception {
		// Key key = generateKey();
		Cipher cipher = Cipher.getInstance(ALGO);
		cipher.init(Cipher.DECRYPT_MODE, key);

		byte[] decodedBytes = new Base64().decode(encryptedValue.getBytes(UNICODE_FORMAT));
		byte[] decttVal = cipher.doFinal(decodedBytes);

		System.out.println("\nDecrypted Value ::---> " + new String(decttVal));
		return new String(decttVal);
	}

}
