package dev.codecounty.java.java8.advance.encryption.encryption_0;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class AES {

	private static final String ALGORITHM = "AES";
	private static final byte[] keyValue = "123456DFD5K34567".getBytes();// 16 digit secret key must

	public static void main(String args[]) throws Exception {
		Key key = generateKey();
		String encriptValue = encrypt("YOUR_SECRETE_KEY", key);
		decrypt(encriptValue, key);

	}

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGORITHM);
		return key;
	}

	public static String encrypt(String valueToEnc, Key key) throws Exception {

		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key);

		byte[] encValue = cipher.doFinal(valueToEnc.getBytes());
		byte[] encryptedByteValue = new Base64().encode(encValue);
		System.out.println("Encrypted Value :: " + new String(encryptedByteValue));

		return new String(encryptedByteValue);
	}

	public static String decrypt(String encryptedValue, Key key) throws Exception {
		// Key key = generateKey();
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key);

		byte[] decodedBytes = new Base64().decode(encryptedValue.getBytes());

		byte[] enctVal = cipher.doFinal(decodedBytes);

		System.out.println("Decrypted Value :: " + new String(enctVal));
		return new String(enctVal);
	}

}