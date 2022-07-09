package com.sumanshekhar.java.core.strings.mutable_builder_buffer;

public class InstanceTestForBufferAndString {
	public static void main(String args[]) {
		System.out.println("Hashcode test of String:");
		String str = "java";
		System.out.println(str.hashCode());
		str = str + "language";
		System.out.println(str.hashCode());

		System.out.println("Hashcode test of StringBuffer:");
		StringBuffer sb = new StringBuffer("java");
		System.out.println(sb.hashCode());
		sb.append("language");
		System.out.println(sb.hashCode());
	}
}