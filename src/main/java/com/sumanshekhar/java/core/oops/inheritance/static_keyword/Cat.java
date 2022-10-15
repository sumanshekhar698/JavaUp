package com.sumanshekhar.java.core.oops.inheritance.static_keyword;

class Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }

    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}

//The second class, a subclass of Animal, is called Cat:
public class Cat extends Animal {
    //   @Override
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }

    @Override
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;

//        The Cat class overrides the instance method in Animal and hides the static method in Animal.
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
    }
}
//https://docs.oracle.com/javase/tutorial/java/IandI/override.html


/*    The access specifier for an overriding method can allow more,
      but not less, access than the overridden method.
      For example, a protected instance method in the superclass can be made public,
      but not private, in the subclass.
      You will get a compile-time error if you attempt to change an instance method in
      the superclass to a static method in the subclass,and vice versa.*/
