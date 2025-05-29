package dev.codecounty.java.java8.oops.inheritance.final_keyword;

import java.sql.Date;


public class FinalExamplesWithMethodsDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Student is Parent
		Student student = new Student("Aman", 65, new Date(1955, 12, 22), 123);
		student.setGrade('A');
		student.shoutGrade();

		System.out.println("******************* UpCasting *******************");
		// UpCasting (Child Object to Parent Reference)
		Student unsP = new UniversityStudent("Shaurya", 60, new Date(1955, 12, 22), 124);// Implicit TypeCasting

		unsP.setGrade('A');
		unsP.shoutGrade();
//		unsP.shoutName();//this will not work as the child has started behaving like parent

		UniversityStudent unsC = (UniversityStudent) unsP;// DownCasting to Student | Explicit TypeCasting
//		 DownCasting should be done only when is object is already upCasted
		unsC.shoutGrade();
		unsC.shoutName();// this works now, as this has been downCasted

		// Illegal case of DownCasting
		/*
		 * In UpCasting, we assign a parent class reference to the child object. In
		 * Java, we cannot assign a parent class reference object to the child class
		 * DIRECTLY, but if we perform downCasting, we will not get any compile-time
		 * error. However, when we run it, it throws the "ClassCastException".
		 * [Exception in thread "main" java.lang.ClassCastException]: Now the point is
		 * if downCasting is not possible in Java, then why is it allowed by the
		 * compiler? In Java, some scenarios allow us to perform downCasting. Here, the
		 * subclass object is referred by the parent class.
		 */
		Student s = new Student(null, 0, null, 0);

		if (s instanceof UniversityStudent) {
			System.out.println("4 -> " + true);
			UniversityStudent unsTest = (UniversityStudent) s;
			unsTest.shoutName();
		}

		s = null;
		System.gc();// Calling GC explicitly
		long x = 989l;// 64 bits //2s complement
		float x_ = x;// IEEE

		byte b = (byte) x;
		System.out.println(b);

		byte b2 = Byte.MAX_VALUE;
		System.out.println(b2);
		++b2;
		System.out.println(b2);

//		final / finally / finalize

		if (unsC instanceof UniversityStudent)
			System.out.println("1 -> " + true);
		if (unsC instanceof Student)
			System.out.println("2 -> " + true);
		if (unsC instanceof Object)
			System.out.println("3 -> " + true);

		if (student instanceof UniversityStudent)
			System.out.println("4 -> " + true);

//		if (student instanceof CricketPlayer)
//			System.out.println("4 -> " + true);

	}

	@Override
	protected void finalize() {
		System.out.println("finalize method called");
	}

}
