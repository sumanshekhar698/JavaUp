package dev.codecounty.java.java8.core.strings.mutable_builder_buffer;

public class StringBufferBuilderLiteral {

	public static void main(String[] args) {

		// Immutable STrings
		String s1 = "hello";// Literal
		String s2 = new String(s1);

		String s1new = s1.concat(" world");
		System.out.println(s1new);
		System.out.println(s1);

		if (s1 == s2)
			System.out.println("1 ~> " + true);
		else
			System.out.println("1 ~> " + false);

		if (s1.equals(s2))
			System.out.println(true);
		else
			System.out.println(false);

		// Mutable STring Classes
		StringBuffer sb1 = new StringBuffer("Hello");// MT - Safely
		sb1.append("World");
		System.out.println(sb1);

		StringBuffer sb2 = new StringBuffer("Hello");// MT - Safely
		sb2.append("World");
		System.out.println(sb2);

		if (sb1 == sb2)// comparing ref
			System.out.println(true);
		else
			System.out.println(false);

		if (sb1.equals(sb2))// equals() is no overrided for Buffer or builder comparing ref
			System.out.println(true);
		else
			System.out.println(false);

		if (sb1.toString().equals(sb2.toString()))// comparing value trick
			System.out.println(true);
		else
			System.out.println(false);

	}
}
