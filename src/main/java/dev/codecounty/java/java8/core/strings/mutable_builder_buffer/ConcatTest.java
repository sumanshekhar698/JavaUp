package dev.codecounty.java.java8.core.strings.mutable_builder_buffer;

public class ConcatTest {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		StringBuffer sb = new StringBuffer("Java");
		for (int i = 0; i < 10000; i++) {
			sb.append(" is intriguing");
		}
		System.out.println("Time taken by StringBuffer: " + (System.nanoTime() - startTime) + "ms");
		startTime = System.nanoTime();
		
		StringBuilder sb1 = new StringBuilder("Java");
		for (int i = 0; i < 10000; i++) {
			sb1.append(" is intriguing");
		}
		System.out.println("Time taken by StringBuilder: " + (System.nanoTime() - startTime) + "ms");
	}
}