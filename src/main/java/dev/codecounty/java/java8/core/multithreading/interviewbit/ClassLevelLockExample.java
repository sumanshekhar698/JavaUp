package dev.codecounty.java.java8.core.multithreading.interviewbit;

public class ClassLevelLockExample
{    
  public void classLevelLockMethod()  
 {       
     synchronized (ClassLevelLockExample.class)  
       {         
            //DO your stuff here       
       }    
 } 
} 