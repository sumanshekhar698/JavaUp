package com.codecounty.java.advance.encryption.encryption_0;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64EncryptionSimple {

	private static final String UNICODE_FORMAT = "UTF-8";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "SUman SHekhar";

		Encoder encoder = Base64.getEncoder();
		Decoder decoder = Base64.getDecoder();
		try {
			String encodeToString = encoder.encodeToString(text.getBytes(UNICODE_FORMAT));
			System.out.println("Simple Encoded Base 64 String ->" + encodeToString);

			byte[] decodedBytes = decoder.decode(encodeToString);
			System.out.println("Simple Decoded Base 64 String ->" + new String(decodedBytes));

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
