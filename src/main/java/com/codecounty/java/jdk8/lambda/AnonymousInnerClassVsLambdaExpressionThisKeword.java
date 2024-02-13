package com.codecounty.java.jdk8.lambda;

public class AnonymousInnerClassVsLambdaExpressionThisKeword {
	int x = 999;

	public static void main(String[] args) {

		
		Subject subject = new Subject();
		System.out.println("***AnonymousInnerClass***");
		subject.play1();//AnonymousInnerClass
		System.out.println("***λ Expression***");
		subject.play2();//λ Expression
		

	}
}

class Subject {
	int x = 999;
	//AnonymousInnerClass: this. refers to inner class object
	void play1() {

		Intref i1 = new Intref() {
			// AnonymousInnerClass Implementation
			int x = 888;// Instance Variables of Inner class

			@Override
			public void m1() {
				System.out.println(x);//888 Ultimately will point to inner class instance variable
				System.out.println(this.x);// 888
				System.out.println(Subject.this.x);// 999 to access outer class object[instance variables]
			}
		};

		i1.m1();
	}
	
	//λ Expression : this. refers to outer class object and also we cannot declare a instance variable inside λ
	void play2() {
		Intref i1=()->{
			int x=777;//local variable for λ Expression
			System.out.println(x);//777

			System.out.println(this.x);//999 this. is referring to outer class Object
		};
		i1.m1();
	}
	
}

@FunctionalInterface
interface Intref {

	public void m1();
}
