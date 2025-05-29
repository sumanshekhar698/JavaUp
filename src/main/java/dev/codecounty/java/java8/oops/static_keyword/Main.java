package dev.codecounty.java.java8.oops.static_keyword;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// C
		Student s1 = new Student("Bob");// C6
		Student s2 = new Student("Alice");// C7
		Student s3 = new Student("John");// C8
		Student s4 = new Student("Jane");// C9

		System.out.println(s1.counter);// 10 As it was already incremented while creating Object
//		Student.counter += 1;
		System.out.println(s2.counter);// 10
		System.out.println(s3.counter);// 10
		System.out.println(s4.counter);// 10

		Student s5 = new Student("Mary");// C9
		System.out.println(s5.counter);// 11

		System.out.println(s1);//
		System.out.println(s2);//
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);//

	}

}
