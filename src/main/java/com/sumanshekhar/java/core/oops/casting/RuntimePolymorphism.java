package com.sumanshekhar.java.core.oops.casting;

import java.util.ArrayList;

public class RuntimePolymorphism extends ParentRuntimePolymorphism {

	public static void main(String[] args) {
		ParentRuntimePolymorphism childRuntimePolymorphism = new RuntimePolymorphism();
		childRuntimePolymorphism.talk();
		ArrayList<Integer> sample = new ArrayList<Integer>();
		sample.add(5);
		sample.add(6);
		sample.add(7);

		
	}

	public void talk() {
		super.talk();
		System.out.println("Shouting");
	}
}

class ParentRuntimePolymorphism {
	final int x;

	public ParentRuntimePolymorphism() {
		super();
		this.x = 6;

	}

	public void talk() {
		System.out.println("Talking");
	}

}
