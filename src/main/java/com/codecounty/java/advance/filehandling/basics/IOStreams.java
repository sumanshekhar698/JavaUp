package com.codecounty.java.advance.filehandling.basics;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class IOStreams {

    public static void main(String[] args) {
        String s = "xyz";
        byte[] b = s.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        for (int i = 0; i < 2; i++) {
            int res;
            while ((res = bais.read()) != -1) {
                if (i == 0)
                    System.out.println(Character.toUpperCase((char) res));
                baos.write(res);
            }
            System.out.println(baos);
        }
    }
}
