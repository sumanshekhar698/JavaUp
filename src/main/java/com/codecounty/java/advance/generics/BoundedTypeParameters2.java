package com.sumanshekhar.java.advance.generics;

public class BoundedTypeParameters2<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static <T> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
//            if (e > elem)// compiler error,
            /*The implementation of the method is straightforward,
            but it does not compile because the greater than operator (>) applies only to primitive types such
            as short, int, double, long, float, byte, and char. You cannot use the > operator to compare objects.
            To fix the problem, use a type parameter bounded by the Comparable<T> interface:*/
            ++count;
        return count;
    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {//FIXURE
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
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

