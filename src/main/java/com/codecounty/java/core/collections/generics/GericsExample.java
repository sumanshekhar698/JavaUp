package com.codecounty.java.core.collections.generics;

import com.codecounty.java.core.oops.encapsulation.Bird2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GericsExample {
	public static void main(String[] args) {

		int[] x = { 5, 7, 7 };
		System.out.println(Arrays.toString(x));// Inheriting

		ArrayList arrayList = new ArrayList();
		arrayList.add("Suman");
		arrayList.add(1);
		arrayList.add(true);
		arrayList.add(new Bird2(0, "Toucan", "Colorfull", true));

		ArrayList<Bird2> arrayListWithGenerics = new ArrayList<Bird2>();
		arrayListWithGenerics.add(new Bird2(1, "Parrot", "Green", false));
//		arrayListWithGenerics.add(1);//this will give error as we are using Generics

		/*
		 * The add() method takes arguments of type E, the element type of the
		 * collection. When the actual type parameter is ?, it stands for some unknown
		 * type. Any parameter we pass to add would have to be a subtype of this unknown
		 * type. Since we don't know what type that is, we cannot pass anything in. The
		 * sole exception is null, which is a member of every type.
		 */
		Collection<?> c = new ArrayList<String>();
//		c.add(new Object()); // Compile time error
		
		
		ArrayList l=new ArrayList<Object>();
		
		List<?> m = l;
		l.add("yellow");
		Object object = m.get(0);
		System.out.println(object);
		
		/*
		 * On the other hand, given a List<?>, we can call get() and make use of the
		 * result. The result type is an unknown type, but we always know that it is an
		 * object. It is therefore safe to assign the result of get() to a variable of
		 * type Object or pass it as a parameter where the type Object is expected.
		 */

	}

}
