package dev.codecounty.java.java8.advance.generics;

//A generic type is a generic class or interface that is parameterized over types. The following Box class will be modified to demonstrate the concept.


public class Box {
    //    https://docs.oracle.com/javase/tutorial/java/generics/rawTypes.html
    private Object object;

    /*Since its methods accept or return an Object, you are free to pass in whatever you want,
     provided that it is not one of the primitive types. There is no way to verify, at compile time,
     how the class is used. One part of the code may place an Integer in the box and expect to get Integers out of it,
     while another part of the code may mistakenly pass in a String, resulting in a runtime error.*/
    public void set(Object object) {
        this.object = object;
    }

    public Object get() {
        return object;
    }

    public static void main(String[] args) {
        BoxGenerics<Integer> integerBox1 = new BoxGenerics<Integer>();


        /*In Java SE 7 and later, you can replace the type arguments required to invoke the constructor
         of a generic class with an empty set of type arguments (<>) as long as the compiler can determine,
         or infer, the type arguments from the context. This pair of angle brackets, <>,
         is informally called the diamond.
        For example, you can create an instance of Box<Integer> with the following statement:*/
        BoxGenerics<Integer> integerBox2 = new BoxGenerics<>();
        BoxGenerics integerBox2_1 = integerBox2;
        integerBox2_1.set(5);// warning: unchecked invocation to set(T)

        BoxGenerics integerBox3 = new BoxGenerics<>();//If the actual type argument is omitted, you create a raw type of Box<T>:
    }
}
/*The most commonly used type parameter names are:

E - Element (used extensively by the Java Collections Framework)
K - Key
N - Number
T - Type
V - Value
S,U,V etc. - 2nd, 3rd, 4th types
You'll see these names used throughout the Java SE API and the rest of this lesson.*/

/**
 * Generic version of the Box class.
 *
 * @param <T> the type of the value being boxed
 */
class BoxGenerics<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

/*
A generic class is defined with the following format:
class name<T1, T2, ..., Tn> { */
/* ... *//*
 }
The type parameter section, delimited by angle brackets (<>), follows the class name. It specifies the type parameters (also called type variables) T1, T2, ..., and Tn.
To update the Box class to use generics, you create a generic type declaration by changing the code "public class Box" to "public class Box<T>". This introduces the type variable, T, that can be used anywhere inside the class.*/
