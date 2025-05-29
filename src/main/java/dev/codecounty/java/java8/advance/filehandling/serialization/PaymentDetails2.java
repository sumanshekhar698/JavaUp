package dev.codecounty.java.java8.advance.filehandling.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PaymentDetails2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5996982419287223281L;// used to verify the crediblity
	/**
	 * In the above example, PaymentDetails class implements Serializable interface.
	 * Now its objects can be converted into stream. The main class implementation
	 * of is showed in the next code.
	 */
//	private static final long serialVersionUID = 1L;
	String benefactor;
	final String clearingHouse = "NPCI";
	int paymentSequence;
	static int counter = 0;
	long money;
	String currency;
	boolean isForexApplicable;

	public PaymentDetails2(String benefactor, long money, String currency, boolean isForexApplicable) {
		super();
		this.benefactor = benefactor;
		this.paymentSequence = ++PaymentDetails2.counter;
		this.money = money;
		this.currency = currency;
		this.isForexApplicable = isForexApplicable;
	}

	@Override
	public String toString() {
		return "PaymentDetails [benefactor=" + benefactor + ", clearingHouse=" + clearingHouse + ", paymentSequence="
				+ paymentSequence + ", money=" + money + ", currency=" + currency + ", isForexApplicable="
				+ isForexApplicable + "]";
	}

	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		money = ois.readLong();
		currency = (String) ois.readObject();
	}

	private void writeObject(ObjectOutputStream oos) throws IOException, ClassNotFoundException {
		oos.writeLong(money);
		oos.writeObject(currency);
	}

}
