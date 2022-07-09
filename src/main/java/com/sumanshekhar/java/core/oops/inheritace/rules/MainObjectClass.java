package com.sumanshekhar.java.core.oops.inheritace.rules;


import java.sql.Date;

public class MainObjectClass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Student jack = new Student("Jack", 56, new Date(1975, 6, 24), 6574);
        Student daniel = new Student("Daniel", 46, new Date(1965, 6, 24), 6575);
        System.out.println(jack);// hexadecimal address
        System.out.println(jack.toString());// hexadecimal address VVI
        System.out.println(jack.hashCode());
        System.out.println(daniel.hashCode());


        Student student = new Student("Jill", 56, new Date(1975, 6, 24), 6574);
        System.out.println(student);


//	 jack.clone();

    }

}
