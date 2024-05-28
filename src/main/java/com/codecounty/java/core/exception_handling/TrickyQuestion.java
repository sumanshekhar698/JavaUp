package com.codecounty.java.core.exception_handling;

public class TrickyQuestion {

    public static void main(String[] args) throws Exception {


        System.out.println(test());
        try {
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("catch");
            throw new Exception();
        } finally {
            System.out.println("finally");
        }


    }


    static int test() {
        try {
            return 8;
        } catch (Exception e) {
            return 9;
        } finally {
            return 10;//finally block will always execute
        }
    }
}
