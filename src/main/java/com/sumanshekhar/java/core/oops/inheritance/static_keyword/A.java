package com.sumanshekhar.java.core.oops.inheritance.static_keyword;

class A {
    public static void display() {
        System.out.println("Inside static method of superclass");
    }
}

class B extends A {
    public void show() {
        // This works - accessing display() by its simple name -
        // meaning it is inherited according to the book.
        display();
        B.display();
    }
}


/*
All methods that are accessible are inherited by subclasses.
The only difference with inherited static (class) methods and inherited non-static (instance)
 methods is that when you write a new static method with the same signature,
 the old static method is just hidden, not overridden.

 https://stackoverflow.com/questions/10291949/are-static-methods-inherited-in-java
 */
