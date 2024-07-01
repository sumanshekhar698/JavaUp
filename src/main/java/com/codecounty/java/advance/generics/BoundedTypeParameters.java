package com.codecounty.java.advance.generics;

public class BoundedTypeParameters<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u) {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        BoundedTypeParameters<Integer> integerBox = new BoundedTypeParameters<Integer>();
        integerBox.set(new Integer(10));
//        integerBox.inspect("some text"); // error: this is still String!
    }

}

class NaturalNumber<T extends Integer> {//In addition to limiting the types you can use to instantiate a generic type,
    // bounded type parameters allow you to invoke methods defined in the bounds:

    private T n;

    public NaturalNumber(T n) {
        this.n = n;
    }

    public boolean isEven() {
        return n.intValue() % 2 == 0;
    }

    // ...
}