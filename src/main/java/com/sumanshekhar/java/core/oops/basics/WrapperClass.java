package com.sumanshekhar.java.core.oops.basics;

public class WrapperClass {

	public static void main(String[] args) {

		String name = "rishav";
//		Primitive Variables
		int number = 10;
		boolean isSad = false;
//		Wrapping int to an Integer Object
		Integer integer = new Integer(10);

//		Wrapping boolean  to an Boolean Object
		Boolean boolean1 = new Boolean(true);

		byte by = 8;
		int p = by;

		// Generally You cannot fit a higher space data in lower space [Bucket - Mug
		// Analogy]
//		int m = 8;
//		byte c=m;

//		Here we have exception as long[64bit] is getting stored in float[32 bit], 
//		The reason is that both have different storing algorithms, and floating numbers is  getting stored using higher efficiency IEEE algo
		long lon = Long.MAX_VALUE;
		float fl = lon;
		System.out.println(fl);

		byte b = 10;
		short s = 20;
		int i = 30;
		long l = 40;
		float f = 50.0F;
		double d = 60.0D;
		char c = 'a';
		boolean b2 = true;

		// Autoboxing: Converting primitives into objects
		// With this mechanism So no need of "new" keyword
		Byte byteobj = b;
		Short shortobj = s;
		Integer intobj = i;
		Long longobj = l;
		Float floatobj = f;
		Double doubleobj = d;
		Character charobj = c;
		Boolean boolobj = b2;

		// Unboxing: Converting Objects to Primitives Automatically , again no use of
		// "new" keyword
		byte bytevalue = byteobj;
		short shortvalue = shortobj;
		int intvalue = intobj;
		long longvalue = longobj;
		float floatvalue = floatobj;
		double doublevalue = doubleobj;
		char charvalue = charobj;
		boolean boolvalue = boolobj;

	}

}
