package com.codecounty.java.core.oops.inheritance.inner_classes;


class OuterClassSample {
    int x;

    void methodOfOuterClass() {
        System.out.println("From OuterClassSample");
    }

    //Class as a member
    class InnerClass {
        int y;
    }
}

class AnotherClass extends OuterClassSample {
    //Only fields and methods are inherited.
    // To use inner class properties,
    //it's inner class must extend inner class of it's super class
    class AnotherInnerClass extends InnerClass {
        //Inner Class of AnotherClass extends Inner Class of OuterClass
    }
}


public class IsInnerClassesAlsoInherited {

    public static void main(String args[]) {
        AnotherClass anotherClass = new AnotherClass();  //creating AnotherClass Object
        System.out.println(anotherClass.x);    //accessing inherited field x from OuterClass
        anotherClass.methodOfOuterClass();    //calling inherited method from OuterClass
        //Using the properties of InnerClass
        AnotherClass.AnotherInnerClass anotherInnerClass = anotherClass.new AnotherInnerClass();
        //creating object to AnotherInnerClass
        System.out.println(anotherInnerClass.y);  //accessing inherited field y from InnerClass

    }
}

/*
    When an outer class is extended by it’s sub class,
    Member inner classes will not be inherited to sub class.
    To use inner class properties inside the sub class of outer class,
    sub class must also have an inner class and that inner class must extend inner class of the outer class
*/
