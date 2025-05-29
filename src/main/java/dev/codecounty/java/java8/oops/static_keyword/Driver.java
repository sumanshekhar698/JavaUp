package dev.codecounty.java.java8.oops.static_keyword;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee emp1 = new Employee("Sam", 98597854, false, "");
		Employee emp2 = new Employee("Amy", 98556854, false, "");
		Employee emp3 = new Employee("John", 945497854, false, "");

		System.out.println(emp1.sequence);
		System.out.println(emp2.sequence);
		System.out.println(emp3.sequence);
		System.out.println(Employee.sequence);//
		
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp3);
		
		System.out.println(Employee.getCount());//
		
		

	}

}
