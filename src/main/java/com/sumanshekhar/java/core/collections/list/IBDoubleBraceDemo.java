package com.sumanshekhar.java.core.collections.list;
import java.util.HashSet;
import java.util.Set;
 
public class IBDoubleBraceDemo{
   public static void main(String[] args){
       Set<String> stringSets = new HashSet<String>()
       {
           {
               add("set1");
               add("set2");
               add("set3");
           }
       };
       
       stringSets.add("");
       
       doSomething(stringSets);
   }
 
   private static void doSomething(Set<String> stringSets){
       System.out.println(stringSets);
   }
}