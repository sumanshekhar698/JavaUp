package com.codecounty.java.advance.generics;

//a generic class can have multiple type parameters.
public interface Pair<K, V> {
    public K getKey();

    public V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void main(String[] args) {

        /*The code, new OrderedPair<String, Integer>, instantiates K as a String and V as an Integer.
         Therefore, the parameter types of OrderedPair's constructor are String and Integer, respectively.
         Due to autoboxing, it is valid to pass a String and an int to the class.

As mentioned in The Diamond, because a Java compiler can infer the K and V types from the declaration OrderedPair<String, Integer>, these statements can be shortened using diamond notation:*/
        OrderedPair<String, Integer> p1 = new OrderedPair<>("Even", 8);
        OrderedPair<String, String> p2 = new OrderedPair<>("hello", "world");

//        You can also substitute a type parameter (that is, K or V) with a parameterized type (that is, List<String>). For example, using the OrderedPair<K, V> example:
        OrderedPair<String, BoxGenerics<Integer>> p = new OrderedPair<>("primes", new BoxGenerics<Integer>());
    }
}