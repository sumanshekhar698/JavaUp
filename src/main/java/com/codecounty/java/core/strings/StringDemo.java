package com.codecounty.java.core.strings;
    
    public class StringDemo{
      public static void main(String[] args){
        String username = "Tendulkar";
        int size = username.length();//returns the length of string
        if(size > 8 && size <15){
          char arr[]=username.toCharArray();//converts the string to character array
          int count=0;
          for(char c:arr){
            if(Character.isLetter(c)){//checks each character is a letter or not
            ++count;
          }
        }
        if(count == size){
          System.out.println("valid username");
        }
      }
    }
  }
  
  
