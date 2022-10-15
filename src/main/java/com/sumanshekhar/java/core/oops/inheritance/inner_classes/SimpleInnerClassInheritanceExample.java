package com.sumanshekhar.java.core.oops.inheritance.inner_classes;


class Outer {

    class InnerOne {
        int m = 99;
        String s = "Inner String";

        void innerOneMethod() {
            System.out.println("innerOneMethod()");
        }
    }

    class InnerTwo extends InnerOne {
//		class innerTwo extends SomeOtherClass{

    }
}

public class SimpleInnerClassInheritanceExample {

    public static void main(String[] args) {
        Outer o1 = new Outer();
        Outer.InnerTwo i2 = o1.new InnerTwo();//if you want to use InnerTwo directly we have to import it
        i2.innerOneMethod();
    }

}
