package com.hackerrank.java.medium;

//import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* Cryptographic hash functions are mathematical operations run on digital data;
by comparing the computed hash (i.e., the output produced by executing a hashing algorithm) to a known and expected hash value,
a person can determine the data's integrity. For example,
computing the hash of a downloaded file and comparing the result to a previously published hash result can show whether the download has been modified or tampered with.
 In addition, cryptographic hash functions are extremely collision-resistant; in other words,
it should be extremely difficult to produce the same hash output from two different input values using a cryptographic hash function.
Secure Hash Algorithm 2 (SHA-2) is a set of cryptographic hash functions designed by the National Security Agency (NSA).
It consists of six identical hashing algorithms (i.e., SHA-256, SHA-512, SHA-224, SHA-384, SHA-512/224, SHA-512/256) with a variable digest size.
SHA-256 is a 256-bit (32 byte) hashing algorithm which can calculate a hash code for an input of up to  264-1 bits.
It undergoes  rounds of hashing and calculates a hash code that is a 64-digit hexadecimal number.
Given a string, , print its SHA-256 hash value.

Input Format :-
A single alphanumeric string denoting .
Constraints:
String  consists of English alphabetic letters (i.e.,  and/or decimal digits (i.e.,  through ) only.
*/
public class SHA256 {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
//        MessageDigest md = MessageDigest.getInstance("MD5");


        String str = bufferedReader.readLine();




/*
 long i = 16843009;
        printf ("%02x \n" ,i);

      out:  1010101
      expected:01010101

%x is a format specifier that format and output the hex value.
If you are providing int or long value, it will convert it to hex value.
%02x means if your provided value is less than two digits then 0 will be prepended.
You provided value 16843009, and it has been converted to 1010101 which a hex value.
'x' refers to "integer in hexadecimal format" as opposed to d which is "integer in decimal format".
 Both accept int as a value to be printed. lx and ld both accept long
 Also, %x is for int, but you have a long. Try %08lx instead.
*/

//        System.out.print(DatatypeConverter.printHexBinary(md.digest()).toLowerCase());
        if (str.matches("[a-zA-z0-9]+")) {
            md.update(str.getBytes());

            byte[] digest = md.digest();

            for (byte b : digest) {
                System.out.format("%02x", b);
            }
        }
    }
}
