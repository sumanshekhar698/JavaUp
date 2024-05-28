package com.codecounty.java.advance.questions;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class MinStack {
    ArrayDeque<Pair> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        //List of num
        int x;
        //no of digits
        String str = "abcdcfghijha";
//        str = "abcdca";
        String longestUniqueSubStr = findLongestUniqueSubStr(str);
        System.out.println(longestUniqueSubStr);

    }

    private static String findLongestUniqueSubStr(String str) {

        if (str.length() <= 1)
            return str;
        HashSet<Character> set = new HashSet<>();

        int maxLen = Integer.MIN_VALUE;
        String result = "";


        int i = 0, j = 1;
        set.add(str.charAt(0));
//        set.add(str.charAt(1));

        while (j < str.length() && i < j) {
            System.out.println(result);
            char ch = str.charAt(j);
            if (!set.contains(ch)) {
                ++j;
                set.add(ch);
            } else {
                while (str.charAt(i) != ch) {
                    set.remove(str.charAt(i));

                    ++i;

                }
//                ++i;//first non-duplicate character
                set.remove(str.charAt(i));
            }


            if ((j - i + 1) > maxLen) {
                maxLen = (j - i + 1);
                result = str.substring(i, j );

            }

        }
        return result;

    }


    static class Pair {
        int val;
        int minTillThatPoint;


        public Pair(int val, int minTillThatPoint) {
            this.val = val;
            this.minTillThatPoint = minTillThatPoint;
        }
    }


}
