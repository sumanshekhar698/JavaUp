package dev.codecounty.java.java8.oops.interfaces.default_methods;

interface Animal {
    //    Methods that are already overridden by other candidates are ignored.
    default public String identifyMyself() {
        return "I am an animal.";
    }
}

interface EggLayer extends Animal {
    default public String identifyMyself() {
        return "I am able to lay eggs.";
    }
}

interface FireBreather extends Animal {
}

public class Dragon_2 implements EggLayer, FireBreather {
    public static void main(String... args) {
        Dragon_2 myApp = new Dragon_2();
        System.out.println(myApp.identifyMyself());//"I am able to lay eggs."
//        It will not print "I am an animal." bcz it was overriden via EggLayer
    }
}