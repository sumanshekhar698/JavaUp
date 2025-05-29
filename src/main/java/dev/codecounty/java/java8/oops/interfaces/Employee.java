package dev.codecounty.java.java8.oops.interfaces;

public interface Employee extends PFaccount {

//	variables acts in interfaces
	public static final String COMPANY_NAME = "Geekster";
	int REGN_NO = 79;

	abstract void sayMyName();

	void sayMyId();

// Intrefaces cannot have concrete methods
//	 void bestEmployee() {
//		 
//	 }

	// Check your JDK <8
//	<= 8 It will work
	static void sayDetails() {
		System.out.println("COMPANY ==> " + COMPANY_NAME);
		System.out.println("REGN_NO ==> " + REGN_NO);
	}

	default int sayDetaislAboutRegNoFromDefaultMethod() {
		return REGN_NO;
	}

}

//Interfaces don't have Constructors
//Employee(){
//	
//}
