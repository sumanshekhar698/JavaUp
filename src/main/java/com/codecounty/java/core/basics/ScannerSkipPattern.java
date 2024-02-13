package com.codecounty.java.core.basics;

import java.util.Scanner;

public class ScannerSkipPattern {

    public static void main(String[] args) {
//        String str1 = "Java scanner skip tutorial";
//        Scanner scan = new Scanner(str1);
//        scan.skip(Pattern.compile(".ava"));

//        while(scan.hasNext()){
            //Skipping first occurrence of the Pattern
//            scan.skip(Pattern.compile(".ava"));
//            System.out.println(scan.next());
//        }

//        String str2 = "Java scanner skip tutorial";
//        Scanner sc = new Scanner(str);
//        scan.skip("Java");


        String str = "JavaTpoint 102 131 150 123 suman";
        //Initialize Scanner object
        Scanner scan = new Scanner(str);
        //Initialize the String pattern
        String pattern = "[a-zA-Z]*";
        //Printing the tokenized Strings
        while(scan.hasNext()){
            //Skipping first occurrence of the Pattern
            scan.skip(pattern);
            System.out.println(scan.next());
        }
//        scan.close();
    }
}
