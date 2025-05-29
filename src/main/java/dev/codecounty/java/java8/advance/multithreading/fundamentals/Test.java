package dev.codecounty.java.java8.advance.multithreading.fundamentals;

import java.util.HashMap;

public class Test {


    //        ABC(2), DEF(3), GHI(4), JKL(5), MNO(6), PQRS(7), TUV(8), WXYZ(9).
    HashMap<Character, Integer> map = new HashMap<>();

    {
        map.put('A', 2);
        map.put('B', 2);
        map.put('C', 2);

        map.put('D', 3);
        map.put('E', 3);
        map.put('F', 2);

    }

    public static void main(String[] args) {
        int max = maxBlock("abbCCCddBBBBxx");// → 3
        System.out.println(max);
    }

    private static int maxBlock(String str) {

        if (str.length() <= 1)
            return str.length();

        char temChar = str.charAt(0);
        int max = 1;
        int currCount = 1;
        for (int i = 0; i < str.length(); i++) {//abbCCCddBBBxx

            if (temChar == str.charAt(i)) {
                ++currCount;
            } else {
                temChar = str.charAt(i);
                currCount = 1;
            }
            max = Integer.max(currCount, max);
        }

        return max;
    }


    String convert(String str) {

        char x = 'z';


        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                result += str.charAt(i);
            }


        }
        return str;
    }


}




