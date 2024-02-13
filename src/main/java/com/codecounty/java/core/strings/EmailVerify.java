package com.codecounty.java.core.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailVerify {
public static void main(String[] args) {
	String s = "bla bla <abc@gmail.com> && mail:emily@gmail.com";
//    Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(s);
	Matcher m = Pattern.compile("[a-zA-Z_.+-]+@[a-zA-Z-]+\\.[a-zA-Z-.]+").matcher(s);
    
    while (m.find()) 
    {
        System.out.println(m.group());
    }
}
}
