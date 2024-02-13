package com.codecounty.java.core.oops.inheritance.final_keyword;

//public class UseCase extends FianlKeywordExample{
public class UseCase {

	final int x;// Only place where uninitialized final instance variable can exist with the
				// help of declaration in constructor

	public UseCase(int x) {
		super();
		this.x = x;
	}

}
