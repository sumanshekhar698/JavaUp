package dev.codecounty.java.java8.specials.optional_classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupedAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        ArrayList<ArrayList<String>> result = findGroupAnagrams(strs);

//        Output: [["bat"],["nat", "tan"],["ate", "eat", "tea"]]



/*        Example 1:

        Input: head = [1,2,3,4,5]

        Output: [3,4,5]

        Explanation: The middle node of the list is node 3.

        Example 2:

        Input: head = [1,2,3,4,5,6]

        Output: [4,5,6]*/


        Node head = null;
        middleOfLinkedList(head);
    }

    private static void middleOfLinkedList(Node head) {

        Node slow = head;
        Node fast = head;
        Node dummy = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }//slow exactly at the mid

        while (slow.next != null) {
            System.out.println(slow.data + " => ");

        }

//        MANAGER
//        SELECT

//        SELECT MAX SALARY
//        FROM MANGER
//        SORT
//        LIMIT 2


    }

    private static ArrayList<ArrayList<String>> findGroupAnagrams(String[] strs) {

//        dic = {};
//        for word in strs:
//            for
//                for
//              if dic.co(sortedWord)
//            dic.put(sorttedKey,


        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String word : strs) {
            String[] split = word.split("");
            Arrays.sort(split);
            String splitedSortedString = split.toString();

            if (map.containsKey(splitedSortedString)) {
                map.get(splitedSortedString).add(word);
            } else {
                ArrayList<String> groupedAnagramWords = new ArrayList<>();
                groupedAnagramWords.add(word);
//                map
            }


        }

        return null;


    }

    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
