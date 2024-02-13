package com.codecounty.java.core.oops.interfaces.default_methods;

 class Horse {
    public String identifyMyself() {
        return "I am a horse.";
    }
}

interface Flyer {
    default public String identifyMyself() {
        return "I am able to fly.";
    }
}

interface Mythical {
    default public String identifyMyself() {
        return "I am a mythical creature.";
    }
}

public class Pegasus_1 extends Horse implements Flyer, Mythical {
    public static void main(String... args) {
        Pegasus_1 myApp = new Pegasus_1();
        System.out.println(myApp.identifyMyself());
    }
}
/*    Default methods and abstract methods in interfaces are inherited like instance methods.
 However, when the supertypes of a class or interface provide multiple default methods with the same signature,
  the Java compiler follows inheritance rules to resolve the name conflict.
 These rules are driven by the following two principles:
 # Instance methods are preferred over interface default methods.
 # Methods that are already overridden by other candidates are ignored. This circumstance can arise when supertypes share a common ancestor.
 */
//https://docs.oracle.com/javase/tutorial/java/IandI/override.html