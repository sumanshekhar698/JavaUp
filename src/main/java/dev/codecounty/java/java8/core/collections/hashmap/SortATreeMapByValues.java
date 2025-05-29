package dev.codecounty.java.java8.core.collections.hashmap;

import java.util.*;

public class SortATreeMapByValues {

    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        map.put("A", 3);
        map.put("B", 2);
        map.put("C", 1);

        System.out.println(map);
        // prints "{A=3, B=2, C=1}"
        System.out.println(entriesSortedByValues(map));

        SortedSet<Map.Entry<String, Integer>> entries = entriesSortedByValues(map);
        // prints "[C=1, B=2, A=3]"
    }

    static <K, V extends Comparable<? super V>>
    SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<>(
                (e1, e2) -> {
                    int res = e1.getValue().compareTo(e2.getValue());
                    return res != 0 ? res : 1;
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}
