package com.sumanshekhar.java.jdk8.advance.records;


import java.time.LocalDate;


public record Person(String name, LocalDate birthday, String city) {//introduced in Java 14

}
