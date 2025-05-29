package dev.codecounty.java.java8.core.basics;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		byte num = sc.nextByte();//  byte short int long
		sc.nextLine();
		String arr[] = new String[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextLine();//  next() no flushing problem
			//nextLine
		}
		System.out.println(Arrays.toString(arr));

		sc.close();

	}

}
