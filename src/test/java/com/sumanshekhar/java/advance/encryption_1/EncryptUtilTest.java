package com.sumanshekhar.java.advance.encryption_1;

import org.junit.Test;

public class EncryptUtilTest {

	@Test
	public void test() {
		String encryptString = EncryptUtil.encryptString("Suman");
		System.out.println(encryptString);
	}
}
