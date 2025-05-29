package dev.codecounty.java.java8.advance.generics;

public class MultipleBounds<T extends X & A & B & C> {//XX is a class and rest are interfaces
    //A type variable with multiple bounds is a subtype of all the types listed in the bound.
    // If one of the bounds is a class, it must be specified first.

    public static void main(String[] args) {

    }

}

interface A {

}

interface B {

}

interface C {

}

class X {

}

class Y {

}
