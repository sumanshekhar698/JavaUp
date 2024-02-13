package com.codecounty.java.core.strings.mutable_builder_buffer;

class StringBufferExample {
	public static void main(String args[]) {
		StringBuffer sb0 = new StringBuffer("HelloKitty");
		System.out.println(sb0.capacity());// default 16 character but here its sb0.length + 16 = 26
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

		StringBuffer sb1 = new StringBuffer();
		System.out.println(sb1.capacity());// default 16 if created with parameter less constructor
		sb1.append("Hello");
		System.out.println(sb1.capacity());// now 16 because Hello can be easily accommodated
		sb1.append("java is my favourite language");
		System.out.println(sb1.capacity());// now (16*2)+2=34 i.e (old_capacity*2)+2 = (old_capacity+1)*2
		sb1.ensureCapacity(10);//
		System.out.println(sb1.capacity());// 34 -> no change as its ensured capacity is above 10
		sb1.ensureCapacity(50);
		System.out.println(sb1.capacity());// now (34*2)+2 = 70 As it was below ensured capacity 50

		StringBuffer x = new StringBuffer("Hello");
		StringBuffer y = new StringBuffer("Hello");
		String z = "Hello";
		if (x == y)
			System.out.println(true);
		else
			System.out.println(false);// false As both are two independent Heap located objects

		if (x.equals(y))
			System.out.println(true);
		else
			System.out.println(false);// false because equal Method has not been override to compare values as we see
										// in String

//		So how to compare values?
		boolean contentEquals = z.contentEquals(x);
		System.out.println(contentEquals);// true

		if (x.toString().equals(y.toString()))
			System.out.println(true);// true
		else
			System.out.println(false);

	}
}