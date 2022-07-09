package com.sumanshekhar.java.jdk8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _01StreamOnAList {

	public static void main(String[] args) {

		int input[] = { 14, 4, 2, 5, 8, 12, 12, 5, 2, 6, 10 };
		double doubleArray[] = { 14, 4, 2, 5, 8, 12, 12, 5, 2, 6, 10 };
		System.out.println(Arrays.toString(doubleArray));
//		List<int[]> list1Array = Arrays.asList(input, input);// list of int integers
		List<Integer> list2 = Arrays.asList(14, 4, 2, 5, 8, 12, 12, 5, 2, 6, 10);

		System.out.println("1.\n");
//		1. Printing the even numbers>5
		Stream<Integer> stream = list2.stream();// Non Primitive -> Stream<Int>
		stream.filter(x -> x % 2 == 0).filter(x -> x > 5).forEach(System.out::println);

//		2. Printing the distinct even numbers>5
		System.out.println("2.\n");
		stream = list2.stream();// parallel stream used for multi-threading processing
		stream.filter(x -> x % 2 == 0).filter(x -> x > 5).distinct().forEach(x -> System.out.println(x + " "));

//		3. Printing the sum using IntStream
		System.out.println("3.\n");
		IntStream stream2 = Arrays.stream(input);// IntStream
		int sum = stream2.sum();
		System.out.println("SUM -> " + sum);

//		4. Printing the max using IntStream
		System.out.println("4.\n");
		stream2 = Arrays.stream(input);// IntStream
		OptionalInt max = stream2.max();// return OptionalInt
		System.out.println("MAX -> " + max + " | " + ((max.isPresent()) ? max.getAsInt() : "null"));

//		5. Printing the min using IntStream
		System.out.println("5.\n");
		stream2 = Arrays.stream(input);// IntStream
		System.out.println("MIN -> " + stream2.min().getAsInt());

//		6. Printing the avg using DoubleStream
		System.out.println("6.\n");
		DoubleStream stream3 = Arrays.stream(doubleArray);// IntStream
		System.out.println("Double AVG -> " + stream3.average().getAsDouble());

//		7. Print the 1st n natural numbers having the digit 'd'
//		We will use infinite streams for this
		System.out.println("7.\n");
		int digit = 7;
		Stream.iterate(1, x -> x + digit).filter(x -> x.toString().contains("" + digit)).limit(10)
				.forEach(x -> System.out.println(" " + x));// Using a limit over infinite stream

//		8. Print the the  Strings from the string array having 'a' and 'c' as 1st and last characters 
//		in lexicographical order
		System.out.println("8.\n");
		String[] inputStrings = { "abc", "cde", "acd", "aec", "xyz", "anc", "abcdc", "abzdc", "aacdc" };

		Arrays.stream(inputStrings).filter(x -> x.startsWith("a") && x.endsWith("c")).sorted()
				.forEach(System.out::print);

//		9. Print the the  avg of Student marks
		System.out.println("9.\n");
		Student[] studentArray = { new Student(801, 89, "Amar"), new Student(802, 76, "Akbar"),
				new Student(803, 99, "Anthony") };// We can also use a collection to store the Student Objects and
													// use
													// stream() to create a stream
		Stream<Student> stream4 = Arrays.stream(studentArray);
		OptionalDouble average = stream4.mapToInt(x -> x.getMarks()).average();
//		mapToInt converts a NonPrimitive  to Primitive  stream 
		System.out.println("AVERAGE of Student marks -> " + average + " | "
				+ ((average.isPresent()) ? average.getAsDouble() : "null"));

//		10. Parse the Student Array as roll:Name in a HashMap and finally print the map
		System.out.println("10.\n");
		Map<Integer, String> collect = Arrays.stream(studentArray)
				.collect(Collectors.toMap(Student::getRoll, Student::getName));
		System.out.println("Student Data -> " + collect);

//		11. Parse the Student Array as Names in a ArrayList and finally print the list
		System.out.println("11.\n");
		System.out.println("Student Data -> " + "TO DO");

//		List<Student> asList = Arrays.asList(studentArray);//Wrong Way
		List<Student> asList = new ArrayList<Student>(Arrays.asList(studentArray));// Right Way

		/*
		 * Arrays.asList() returns a List wrapper around an array. This wrapper has a
		 * fixed size and is directly backed by the array, and as such calls to set will
		 * modify the array, and any other method that modifies the list will throw an
		 * UnsupportedOperationException. To fix this, you have to create a new
		 * modifiable list by copying the wrapper list's contents. This is easy to do by
		 * using the ArrayList constructor that takes a Collection: Collection c = new
		 * ArrayList(Arrays.asList(la));
		 */

		asList.add(new Student(807, 89, "Molly"));
		System.out.println("STUDENT ->" + asList);

		List<Student> listOfStudents = new ArrayList<Student>();
		listOfStudents.add(new Student(807, 89, "Molly"));
		listOfStudents.add(new Student(807, 89, "Annie"));
		listOfStudents.add(new Student(807, 99, "Sam"));
		listOfStudents.add(new Student(807, 76, "Starla"));
		listOfStudents.add(new Student(807, 99, "Victor"));
		Map<Integer, List<Student>> groupedMarks = listOfStudents.stream()
				.collect(Collectors.groupingBy(Student::getMarks));
		System.out.println(groupedMarks);

//		12. Parallel Streaming
		System.out.println("12.\n");
		stream = list2.parallelStream();
		Optional<Integer> findFirst = stream.filter(x -> x % 2 == 0).filter(x -> x > 5).filter(x -> x > 5).findFirst();
		System.out.println(findFirst.toString());

	}
}
