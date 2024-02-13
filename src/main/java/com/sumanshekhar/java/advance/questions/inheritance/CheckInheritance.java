package com.sumanshekhar.java.advance.questions.inheritance;


/*Explanation:

Method Overloading, Not Overriding:

The Child class attempts to create a method with the same name test but with a different parameter type (Integer instead of int).
However, in Java, this is considered method overloading, not overriding. Overloaded methods don't replace the inherited method; they create new methods with the same name but different parameter lists.
Static Method Binding:

Java uses static method binding (also called early binding) to determine which method to call at compile time, based on the declared type of the variable.
In this case, the variable c is declared as a Child, but the compiler sees that the test method in the Child class doesn't have a matching signature for an int parameter.
It then looks at the parent class CheckInheritance and finds a matching test method with an int parameter, so it binds the call to that method.
Execution:

At runtime, even though the actual object is a Child, the call to test(1) is already bound to the test(int) method in the CheckInheritance class.
Therefore, the output is "Inside Parent".
Key Points:

To achieve method overriding and call the child's method, the parameter types in both parent and child classes must exactly match.
If you intended for the child's method to be called, make the parameter types consistent in both classes.
Understanding method overloading and overriding, as well as static method binding, is crucial for working with inheritance in Java.*/
public class CheckInheritance {
    public void test(int i) {
        System.out.println("Inside Parent");
    }
    public static void main(String[] args) {
        Child c = new Child();
        Integer x =1;
        int y = 1;
        c.test(x);
        c.test(y);
    }
}


class Child extends CheckInheritance {

    public void test(Integer i) {
        System.out.println("Inside child");//✔️
    }
}