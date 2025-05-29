package dev.codecounty.java.java8.oops.casting;

class Parent {
	String name = "default";

	@Override
	public String toString() {
		return "Parent [name=" + name + "]";
	}

	// A method which prints the data of the parent class
	void showMessage() {
		System.out.println("Parent method is called");
	}
}

// Child class   
class Child extends Parent {
	int age;
	String name = "child default";

//	@Override
//	public String toString() {
//		return "Child [age=" + age + "]";
//	}

	// Performing overriding
	@Override
	void showMessage() {
		System.out.println("Child method is called");
	}
}

public class Downcasting {

	public static void main(String[] args) {
		Parent p = new Child();
		System.out.println(p);
		p.name = "Shubham";
		System.out.println(p);
		p.showMessage();


		// Performing Downcasting Implicitly
//		 Child c = new Parent(); // it gives compile-time error

		// Performing Downcasting Explicitly
		Child c = (Child) p;

		c.age = 18;
		System.out.println(c.name);
		System.out.println(c.age);
		c.showMessage();
	}
}