package com.codecounty.java.core.collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {

    public static void main(String[] args) {
        String str = "Welcome";

//        TreeMap<Character, Integer> charValueTreeMap = new TreeMap<>(((Map.Entry) o1, (Map.Entry) o2) ->{
//            // Sort map entries in descending order based on values using a lambda expression
//            return Integer.compare(o2.getValue(), o1.getValue());
//        });
//
//        for (int i = 0; i < str.length(); i++) {
//            char ch = Character.toLowerCase(str.charAt(i));
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        System.out.println(map);


    }
}

class CustomComparator implements Comparator<Map.Entry<Character, Integer>> {


    @Override
    public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
        return Integer.compare(e1.getKey(), e2.getKey());
    }
}


//Unnamed Clkass JDK 16
//public static <K, V extends Comparable<V>> Map<K, V>  sortByValues(final Map<K, V> map) {
//    Comparator<K> valueComparator =
//            new Comparator<K>() {
//                public int compare(K k1, K k2) {
//                    int compare =
//                            map.get(k1).compareTo(map.get(k2));
//                    if (compare == 0)
//                        return 1;
//                    else
//                        return compare;
//                }
//            };
//
//    return map;
//}
