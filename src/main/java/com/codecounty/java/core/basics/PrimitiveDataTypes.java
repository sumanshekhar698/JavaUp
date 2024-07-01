package com.codecounty.java.core.basics;

public class PrimitiveDataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		bit = 0/1
//		qBit = 0/1/ [0|1]

//		***************** integers *****************
		byte a=9;short b=50;int c=40000;long d=67l;

		short sh=(short)c;// explicit type casting
		System.out.println(sh);

		int test1=046;// 0 Inform is making in to octal
		System.out.println("TEST 1 -->"+test1);

		int test2=0x46A;// 0 Inform is making in to hex
		System.out.println("TEST 2 -->"+test2);

		int test3=0b010101;// 0 Inform is making in to octal
		System.out.println("TEST 2 -->"+test3);

//		***************** decimals/real numbers *****************

		float e=6.5f;double f=6.5;// IEEE format to store

//		***************** character *****************
		char g='d';int x=g;System.out.println(x);// UTF 8
		char rupee='r';// if added UTF character the, java file should also be encoded in character UTF
		x=rupee;// (implicit type casting) char to rupee
		System.out.println(x);int m=c;char exp=(char)m;// explicit type casting [int to char]
		System.out.println(exp);

		m=Integer.MAX_VALUE;exp=(char)m;// explicit type casting
		System.out.println(exp);

//		***************** boolean *****************
		boolean isHarrd=true;isHarrd=false;

	}

}
