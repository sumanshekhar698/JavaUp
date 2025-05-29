package dev.codecounty.java.questions.platform.hackerrank.easy;

import java.util.ArrayList;
import java.util.Scanner;

public class HackerRankArrayListOfArrayListQuestion {

    //	https://www.hackerrank.com/challenges/java-arraylist/problem
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int noOfLines = sc.nextInt();
//		ArrayList<Integer>[] a;


//		Input Of Data Part 1: Enriching of data structure
        ArrayList<ArrayList<Integer>> mainArrayList = new ArrayList();// 2D Dynamic Jagged ArrayList
        mainArrayList.get(-1);
        for (int i = 0; i < noOfLines; i++) {
            int elementInAnArrayList = sc.nextInt();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < elementInAnArrayList; j++) {
                temp.add(sc.nextInt());
            }
            mainArrayList.add(temp);
        }

//		Input Of Data Part 2: Enriching ore data structure [99/100]

        int queries = sc.nextInt();

        for (int i = 0; i < queries; i++) {

            try {
                int x = sc.nextInt();
                int y = sc.nextInt();
                Integer foundElement = mainArrayList.get(x - 1).get(y - 1);
                System.out.println(foundElement);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }

        sc.close();//

    }

}
