package dev.codecounty.java.java8.core.collections.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class IteratorOnMap {

    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "London");
        hashMap.put(2, "Berlin");
        hashMap.put(3, "Bangalore");
        String result;
        ArrayList<String> values = new ArrayList<String>(hashMap.values());
        List<String> collect = values.stream().filter(x -> x.equals("London")).collect(Collectors.toList());
        System.out.println(collect.get(0));

        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");
        Iterator<String> it1 = myMap.keySet().iterator();
        while (it1.hasNext()) {

            String key = it1.next();
            System.out.println("Map Value:" + myMap.get(key));

            if (key.equals("2")) {
                myMap.put("1", "4");
            }
        }
        System.out.println(myMap);


    }

}
