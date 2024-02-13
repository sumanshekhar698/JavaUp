package com.codecounty.java.jdk8.advance.records;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//https://docs.oracle.com/en/java/javase/15/serializable-records/index.html
public class Serialize {
    public static void main(String... args) throws Exception {
        try (var fos = new FileOutputStream("serial.data");
             var oos = new ObjectOutputStream(fos)) {
            oos.writeObject(new RangeClass(100, 1));
            oos.writeObject(new RangeRecord(100, 1));
        }
    }
}


class Deserialize {
    public static void main(String... args) throws Exception {
        try (var fis = new FileInputStream("serial.data");
             var ois = new ObjectInputStream(fis)) {
            System.out.println(ois.readObject());
            System.out.println(ois.readObject());
        }
    }
}