package dev.codecounty.java.java8.specials.optional_classes;

import java.util.Optional;

public class OptionalClassExample {
	/*
	 * https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Nemesis";
		str = null;

		if (str == null)
			System.out.println("String is null");
		else
			System.out.println(str.length());

		/*
		 * Using Optional Class for implementing the above null Check
		 */

		Optional<String> optional = Optional.ofNullable(str);
		System.out.println(optional.isPresent());// false
		// System.out.println(optional.get());//Exception as optional is empty
		System.out.println(optional.orElse("No value in the object"));// No value in the object

		Optional<String> name = getName();// name returned is not a String rather its an optional
		System.out.println(name.orElse("null returned"));// Realm

	}

	public static Optional<String> getName() {
		String name = "Realm";
		return Optional.ofNullable(name);
	}
}
