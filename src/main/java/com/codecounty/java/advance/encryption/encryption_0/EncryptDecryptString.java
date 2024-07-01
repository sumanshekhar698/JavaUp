package com.codecounty.java.advance.encryption.encryption_0;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncryptDecryptString {

	private static final String UNICODE_FORMAT = "UTF-8";
	private static final String ALGO = "AES";

	public static void main(String[] args) {

		String text = "suman is cool and smart 😈";

		try {
			SecretKey key = generateSecretKey(ALGO);// Advanced Encryption Standard [2001 US]
			System.out.println("\n\nKEY --> " + key);
			Cipher cipher;
			cipher = Cipher.getInstance(ALGO);

			byte[] encryptStringByteArray = encryptString(text, key, cipher);
			String encryptString = new String(encryptStringByteArray);
			System.out.println("\nEncrypted String --> " + encryptString);

//			String decryptString = decryptString(encryptString.getBytes(UNICODE_FORMAT), key, cipher);
			String decryptString = decryptString(encryptStringByteArray, key, cipher);
			System.out.println("\nDecrypted String --> " + decryptString);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static SecretKey generateSecretKey(String encryptionType) {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(encryptionType);
			keyGenerator.init(256);// Optional -> adding more security
			SecretKey myKey = keyGenerator.generateKey();
			return myKey;
		} catch (Exception e) {
			return null;
		}
	}

	public static byte[] encryptString(String dataToEncrypt, SecretKey myKey, Cipher cipher) {
		try {
			byte[] textByte = dataToEncrypt.getBytes(UNICODE_FORMAT);// by default it will pick whatever format the
																		// computer is using, we enterer UTF-8
																		// explicitly for a seam-less consistent
																		// encryption

			cipher.init(Cipher.ENCRYPT_MODE, myKey);// telling the cipher to Encrypt and not decrypt
			byte[] textEncrypted = cipher.doFinal(textByte);
			return textEncrypted;// if we convert byte [] -> String ; String ->byte[] it may not work
		} catch (Exception e) {
			return null;
		}
	}

	public static String decryptString(byte[] dataToDecrypt, SecretKey myKey, Cipher cipher) {
		try {

			cipher.init(Cipher.DECRYPT_MODE, myKey);// telling the cipher to Encrypt and not decrypt
			byte[] textDecrypted = cipher.doFinal(dataToDecrypt);
			return new String(textDecrypted);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
