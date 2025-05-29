package dev.codecounty.java.java8.core.exception_handling;

class ShrutiAditya {
	String person1;
	String person2;
	String person3;
	public ShrutiAditya(String person1, String person2, String person3) {
		super();
		this.person1 = person1;
		this.person2 = person2;
		this.person3 = person3;
	}

}

public class ThrowableCatching {

	public static void main(String[] args) {

		try {
			while (true) {
				ShrutiAditya shrutiAditya = new ShrutiAditya("Aditya", "Shruti", "Prateek");
			}

		} catch (Throwable t) {
			System.out.println(t.getMessage());
			System.out.println("CATCH");
		} finally {
			System.out.println("EXIT");
		}

	}

}
