package com.sumanshekhar.java.core.collections.generics;

import java.util.ArrayList;
import java.util.Collection;

public class GenericMethod {

	public static void main(String[] args) {

		Integer[] x = { 4, 78, 34 };
		GenericMethod.fromArrayToCollection(x, new ArrayList<Integer>());

		Object[] oa = new Object[100];
		Collection<Object> co = new ArrayList<Object>();
		// T inferred to be Object
		fromArrayToCollection(oa, co);

		String[] sa = new String[100];
		Collection<String> cs = new ArrayList<String>();
		// T inferred to be String
		fromArrayToCollection(sa, cs);

		// ** T inferred to be Object
		fromArrayToCollection(sa, co);
		
		Integer[] ia = new Integer[100];
		Float[] fa = new Float[100];
		Number[] na = new Number[100];
		Collection<Number> cn = new ArrayList<Number>();

		// T inferred to be Number
		fromArrayToCollection(ia, cn);//Parents will be preferred

		// T inferred to be Number
		fromArrayToCollection(fa, cn);

		// T inferred to be Number
		fromArrayToCollection(na, cn);

		// T inferred to be Object
		fromArrayToCollection(na, co);//Parents will be preferred

//		fromArrayToCollection(na, cs);// compile-time error

	}

	static void fromArrayToCollection1(Object[] a, Collection<?> c) {
		for (Object o : a) {
//			c.add(o); // compile-time error {you cannot just shove objects into a collection of unknown type.}
		}

		ArrayList<Integer> x = (ArrayList) c;
		x.add(1);// this is possible
	}

	static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
		for (T o : a) {
			c.add(o); // Correct
		}
	}
}
