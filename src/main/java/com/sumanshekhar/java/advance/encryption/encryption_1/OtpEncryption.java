package com.sumanshekhar.java.advance.encryption.encryption_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class OtpEncryption {

	/*
	 * https://searchsecurity.techtarget.com/definition/one-time-pad TODO
	 * Auto-generated method stub OTP encryption is an encryption tech that cannot
	 * be cracked
	 */

	/*
	 * It requires a oneTime pre shared key, and the key is of same size or longer
	 * than the data being sent Plain text is paired with a random secret key,OTP We
	 * will use ACII from 32 ' ' to 126 '~' becuse pior to this are symbols with
	 * special meaning
	 */

	/*
	 * In cryptography, a one-time pad is a system in which a private key generated
	 * randomly is used only once to encrypt a message that is then decrypted by the
	 * receiver using a matching one-time pad and key. Messages encrypted with keys
	 * based on randomness have the advantage that there is theoretically no way to
	 * "break the code" by analyzing a succession of messages. Each encryption is
	 * unique and bears no relation to the next encryption so that some pattern can
	 * be detected. With a one-time pad, however, the decrypting party must have
	 * access to the same key used to encrypt the message and this raises the
	 * problem of how to get the key to the decrypting party safely or how to keep
	 * both keys secure.
	 */

	private Scanner sc;
	private Random random;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private String line;
	private char[] letters;
	private char[] secret;

	public OtpEncryption() {
		super();
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
		random = new Random();
		list = new ArrayList();
		shuffledList = new ArrayList();
		character = ' ';
		newKey();
		askQuestion();

	}

	private void askQuestion() {

		while (true) {
			System.out.println("********************************************************************************");
			System.out.println("What opertaion do you want to do");
			System.out.println("Enter (N)ewKey , (G)etKey , (E)ncrypt , (D)ecrypt , (Q)uit");
			char response = Character.toUpperCase(sc.nextLine().charAt(0));
			switch (response) {
			case 'N':
				this.newKey();
				break;

			case 'G':
				this.getKey();
				break;

			case 'E':
				this.encrypt();
				break;

			case 'D':
				this.decrypt();
				break;

			case 'Q':
				System.exit(0);
				break;
				
			default:
				System.out.println("Not a valid choice");
				break;
			}
		}
	}

	private void newKey() {

	}

	private void getKey() {

	}

	private void encrypt() {

	}

	private void decrypt() {

	}

	private void quit() {

	}
}
