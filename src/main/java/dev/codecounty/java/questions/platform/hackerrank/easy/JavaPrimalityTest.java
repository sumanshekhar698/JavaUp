package dev.codecounty.java.questions.platform.hackerrank.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class JavaPrimalityTest {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String n = bufferedReader.readLine();
		BigInteger bigInteger = new BigInteger(n);
		System.out.println((bigInteger.isProbablePrime(1)) ? "prime" : "not prime");

		// When certainty is zero,
		// it is always true

		// When certainty is negative,
		// it is always true

		bufferedReader.close();
	}
}
