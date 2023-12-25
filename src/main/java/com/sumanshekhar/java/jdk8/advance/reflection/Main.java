package com.sumanshekhar.java.jdk8.advance.reflection;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        // Get Class using reflection
        Class<?> concreteClass = ConcreteClass.class;
        concreteClass = new ConcreteClass(5).getClass();
        try {
            // below method is used most of the times in frameworks like JUnit
            //Spring dependency injection, Tomcat web container
            //Eclipse auto completion of method names, hibernate, Struts2 etc.
            //because ConcreteClass is not available at compile time
            concreteClass = Class.forName("com.sumanshekhar.java.jdk8.advance.reflection.ConcreteClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(concreteClass.getCanonicalName()); // prints com.sumanshekhar.java.jdk8.advance.reflection.ConcreteClass

//for primitive types, wrapper classes and arrays
        Class<?> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName()); // prints boolean

        Class<?> cDouble = Double.TYPE;
        System.out.println(cDouble.getCanonicalName()); // prints double

        Class<?> cDoubleArray = Class.forName("[D");
        System.out.println(cDoubleArray.getCanonicalName()); //prints double[]

        Class<?> twoDStringArray = String[][].class;
        System.out.println(twoDStringArray.getCanonicalName()); // prints java.lang.String[][]


        Class<?> superClass = Class.forName("com.sumanshekhar.java.jdk8.advance.reflection.ConcreteClass").getSuperclass();
        System.out.println(superClass); // prints "class com.journaldev.reflection.BaseClass"
        System.out.println(Object.class.getSuperclass()); // prints "null"
        System.out.println(String[][].class.getSuperclass());// prints "class java.lang.Object"
    }
}
