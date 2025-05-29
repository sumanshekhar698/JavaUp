package dev.codecounty.java.java8.oops.inheritance.inner_classes;

public class InnerClassInheritanceWithNonStaticModifier {

    public static void main(String[] args) {
        new AnotherClassOne();
        new AnotherClassTwo();
    }
}

class OuterClass {
    static class InnerClassOne {
        //Class as a static member
    }

    class InnerClassTwo {
        //Class as a non-static member
    }


}

//Extending Static inner class or static nested class
class AnotherClassOne extends OuterClass.InnerClassOne {
    //static nested class can be referred by outer class name, so its simple
}

//Extending non-static inner class or member inner class
class AnotherClassTwo extends OuterClass.InnerClassTwo {
    public AnotherClassTwo() {
        new OuterClass().super();
        //accessing super class constructor through OuterClass instance
    }
}

/*
    An inner class can be extended by another class outside of it’s outer class.
    If you are extending static inner class (Static nested class),
    then it is a straight forward implementation.
    If you are extending non-static inner class, then sub class constructor must explicitly call super class constructor using an instance of outer class.
    Because, you can’t access non-static inner class without the instance of outer class.
*/
