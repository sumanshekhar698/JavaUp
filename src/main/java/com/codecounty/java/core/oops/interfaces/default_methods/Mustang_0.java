package com.codecounty.java.core.oops.interfaces.default_methods;

interface Mammal {
    String identifyMyself();
}

class Horses {
    public String identifyMyself() {
        return "I am a horse.";
    }
}

public class Mustang_0 extends Horses implements Mammal {
    public static void main(String... args) {
        Mustang_0 myApp = new Mustang_0();
        System.out.println(myApp.identifyMyself());
    }
}

/*      Inherited instance methods from classes can override abstract interface methods.
        Consider the above interfaces and classes:

        The method Mustang.identifyMyself returns the string I am a horse.
        The class Mustang inherits the method identifyMyself from the class Horse,
        which overrides the abstract method of the same name in the interface Mammal.*/
