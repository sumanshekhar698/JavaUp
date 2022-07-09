package com.sumanshekhar.java.core.strings.mutable_builder_buffer;

class StringBuilderExample {
	public static void main(String args[]) {
		StringBuilder sb0 = new StringBuilder("Hello ");
		StringBuffer sb1 = new StringBuffer("Hello ");
		StringBuilder sb3 = new StringBuilder("Hello ");

		System.out.println(sb0.capacity());// default 16 character but here its sb0.length + 16 = 22
		sb0.append("Java");
		System.out.println(sb0);

		sb0.insert(1, "Java");
		System.out.println(sb0);

		sb0.replace(1, 3, "Coffee");
		System.out.println(sb0);

		sb0.delete(1, 3);
		System.out.println(sb0);

		sb0.reverse();
		System.out.println(sb0);

		if (sb3.toString().equals(sb1.toString()))
			System.out.println(true);// true
		else
			System.out.println(false);

	}
}