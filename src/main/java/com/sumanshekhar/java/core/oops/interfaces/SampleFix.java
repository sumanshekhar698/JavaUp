package com.sumanshekhar.java.core.oops.interfaces;

public class SampleFix {

	A a;
	B b;

	int play1() {
		a = new A() {

			@Override
			public int play() {
				System.out.println("play() of A");
				return 0;
			}
		};
		return a.play();

	}

	String play2() {

		b = new B() {

			@Override
			public String play() {
				System.out.println("play() of B");
				return "";
			}
		};

		return b.play();

	}

}
