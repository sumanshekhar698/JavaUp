package com.codecounty.java.core.multithreading.interviewbit;

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