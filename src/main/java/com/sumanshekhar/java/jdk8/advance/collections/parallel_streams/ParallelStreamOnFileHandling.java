package com.sumanshekhar.java.jdk8.advance.collections.parallel_streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

// Main class 
// ParallelStreamTest 
public class ParallelStreamOnFileHandling {

    // Main driver method 
    public static void main(String[] args) throws IOException {

        String path ="src/main/resources/txt/sample.txt";
        // Creating a File object 
        File fileName = new File(path);

        // Create a Stream of string type 
        // using the lines() method to 
        // read one line at a time from the text file 
        Stream<String> text = Files.lines(fileName.toPath());

        // Creating parallel streams using parallel() method 
        // later using forEach() to print on console 
        text.parallel().forEach(System.out::println);

        // Closing the Stream 
        // using close() method 
        text.close();
    }
} 