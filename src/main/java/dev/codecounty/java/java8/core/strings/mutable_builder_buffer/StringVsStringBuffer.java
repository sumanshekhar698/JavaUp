package dev.codecounty.java.java8.core.strings.mutable_builder_buffer;

public class StringVsStringBuffer {

	public static void main(String[] args) {

		/*
		 * DECLARATION FOR THE STRINGs
		 */
		
		// Objects Created +=increment
		String a1 = new String("$ugar");
		// HEAP-->+1 || SCP -->+1
		String a2 = new String("$ugar");
		// HEAP-->+2 || SCP -->1
		String a3 = "$ugar";
		// HEAP-->2 || SCP -->1
		String a4 = "$ugar";
		// HEAP-->2 || SCP -->1
		
		
		
		
		String b1 = new String("Mehreen");
		// HEAP-->1{Mehreen} || SCP -->+1 || Garbage --> 0
		b1.concat("Firdaus");//any object created at runtime is in  Heap
		// HEAP-->1 {Mehreen}|| SCP -->+2 || Garbage --> 1{MehreenFirdaus}
		b1 = b1.concat("Mehrooz");
		// HEAP-->1 {MehreenMehrooz}|| SCP -->+3 || Garbage --> 2 {MehreenFirdaus, Mehreen}

		/* CONCATINATION */
		System.out.println("*********CONCATINATION**********");
		System.out.println("CONCATINATION\n");
		String string = new String("Billy");
//		Once a String is created, no new change are entertained [immutability]
		string.concat(" Jeans");// A new object BillyJeans is created without assigned to any ref
		// so it's--->Garbaged & string="Billy" will remain assigned
		System.out.println(string);// Billy

//		String is immutable and we cannot change anything, but through the concat methods we can create new String objects
		String stringConcat = string.concat(" Jeans");
		System.out.println(stringConcat);// Billy

		StringBuffer stringBuffer = new StringBuffer("Morning");
		StringBuffer appendStringBuffer = stringBuffer.append(" Angel");// .append() returns the same mutated-obj ref
																		// but we don't need to
																		// store, we can mutate the same
		System.out.println(stringBuffer);// Morning Angel
		System.out.print("Comparing String Buffer refs ");
		System.out.println(stringBuffer == appendStringBuffer);

		/* COMPARISIONS */
		System.out.println("*********COMPARISIONS**********");
		System.out.println("COMPARISION\n");
		String s1 = new String("Billy");
		String s2 = new String("Billy");
		StringBuffer sb1 = new StringBuffer("Morning");
		StringBuffer sb2 = new StringBuffer("Morning");

//		== always compares obj-refs
		System.out.println(s1 == s2);// false
		System.out.println(s1.equals(s2));// true equals() overridden for string class for content comparison
		System.out.println(sb1 == sb2);// false [ref comparison]
		System.out.println(sb1.equals(sb2));// false [ref comparison as its just inherited]

	}
}
