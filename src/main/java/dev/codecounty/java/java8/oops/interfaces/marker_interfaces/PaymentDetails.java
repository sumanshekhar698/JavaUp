package dev.codecounty.java.java8.oops.interfaces.marker_interfaces;

import java.io.Serializable;

public class PaymentDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5996982419287223281L;//used to verify the crediblity
	/**
	 * In the above example, PaymentDetails class implements Serializable interface. Now
	 * its objects can be converted into stream. The main class implementation of is
	 * showed in the next code.
	 */
//	private static final long serialVersionUID = 1L;
	transient String benefactor;
	transient final String clearingHouse="NPCI";//no use of trasient here
//	transient final String clearingHouse;//but transient is applicable here
	int paymentSequence;
	static int counter = 0;
	long money;
	String currency;
	boolean isForexApplicable;

	public PaymentDetails(String benefactor, long money, String currency, boolean isForexApplicable) {
		super();
		this.benefactor = benefactor;
		this.paymentSequence = ++PaymentDetails.counter;
		this.money = money;
		this.currency = currency;
		this.isForexApplicable = isForexApplicable;
//		this.clearingHouse = "NPCI";
	}

	@Override
	public String toString() {
		return "PaymentDetails [benefactor=" + benefactor + ", clearingHouse=" + clearingHouse + ", paymentSequence="
				+ paymentSequence + ", money=" + money + ", currency=" + currency + ", isForexApplicable="
				+ isForexApplicable + "]";
	}




	
}
