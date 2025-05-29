package dev.codecounty.java.java8.oops.constructors;

public class MessengerConstructorChaining {

	int noOfMessages = 0;
	String msg;

	// Constructor Chaining
	public MessengerConstructorChaining(int noOfMessages, String msg) {
//		super();
		this(noOfMessages);
		System.out.println("Constructor of Messenger called [2]");

		this.noOfMessages = noOfMessages;
		this.msg = msg;
	}

	public MessengerConstructorChaining() {
		System.out.println("Constructor of Messenger called [0]");
	}

	public MessengerConstructorChaining(int x) {
		this();
		System.out.println("Constructor of Messenger called [1]");
	}

	/*
	 * @return String
	 * @param No Parameter
	 */
	@Override
	public String toString() {
		return "SUPERMAN Messenger [noOfMessages=" + noOfMessages + ", msg=" + msg + "]";
	}
	

}
