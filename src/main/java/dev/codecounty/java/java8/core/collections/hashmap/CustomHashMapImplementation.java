package dev.codecounty.java.java8.core.collections.hashmap;

import dev.codecounty.java.java8.core.collections.list.Student;

import java.util.HashMap;
import java.util.LinkedList;

public class CustomHashMapImplementation {

    private LinkedList<HashMapNode>[] bucket;//Array of (LinkedList of HashMapNode)

    public CustomHashMapImplementation() {
        bucket = new LinkedList[10000];//Instantiating the array
        for (int i = 0; i < 10000; i++) {
            bucket[i] = new LinkedList<>();//Adding the LinkedList to each position
        }
    }

    public void put(int key, int value) {
        int bucket_index = hash_function(key); // key index from our hash fn
        int index = indexInLinkedListForCollision(key, bucket_index); //value index

        if (index == -1) {
            //means we have to create new node and insert it
            HashMapNode<Integer> node = new HashMapNode<Integer>(key, value);
            if (bucket[bucket_index] != null)//extra safety check
                bucket[bucket_index].add(node);
        } else {//It means we have the existing key so we will update its value
            HashMapNode<Integer> node = null;
            if (bucket[bucket_index] != null) {
                node = bucket[bucket_index].get(index);
                node.value = value;//update the value for existing key
            }
        }
    }


    public int get(int key) {
        int bucket_index = hash_function(key); // key index
        int index = indexInLinkedListForCollision(key, bucket_index); //value index

        if (index == -1)
            return -1;
        else
            return (int) bucket[bucket_index].get(index).value;
    }

    public boolean remove(int key) {
        int bucket_index = hash_function(key); // key index
        int index = indexInLinkedListForCollision(key, bucket_index); //value index
        if (index != -1) {
            bucket[bucket_index].remove(index);
            return true;
        }
        return false;
    }

    private int hash_function(int key) {
        return Integer.hashCode(key) % bucket.length;//Custom Hash Fn
    }

    /*
        We return -1 in case of no collision happens else we want the
        index of the collided element in the linked
    */
    private int indexInLinkedListForCollision(int key, int bucket_index) {
        int list_index = 0;
        if (bucket[bucket_index] != null)//Extra Safety Check
            for (HashMapNode<Integer> node : bucket[bucket_index]) {

                if (node.key == key)
                    return list_index;
                list_index++;
            }
        return -1;
    }

    public static void main(String[] args) {
        HashMap<Student, Integer> objectObjectHashMap = new HashMap<>();
        Student suman = new Student("Suman");
        System.out.println(suman.hashCode());
        suman.regNo = "Suman Shekhar";
        objectObjectHashMap.put(suman, 67);
        System.out.println(objectObjectHashMap.get(suman));

        suman.regNo = "The Suman SHekhar";
        System.out.println(suman.hashCode());
        System.out.println(objectObjectHashMap.get(suman));


    }
}

class Element {
    String key;

}

class HashMapNode<Integer> {
    Integer key;
    Integer value;


    HashMapNode(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
