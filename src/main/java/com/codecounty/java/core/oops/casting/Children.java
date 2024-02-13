package com.codecounty.java.core.oops.casting;

class Parent1{
    protected int num = 1;
    
    Parent1(){
        System.out.println("Parent class default constructor.");
    }
    
    Parent1(String x){
        System.out.println("Parent class parameterised constructor.");
    }
    
    public void foo(){
        System.out.println("Parent class foo!");
    }
}

public class Children extends Parent1{
    private int num = 2;
    
    Children(){
//        System.out.println("Child class default Constructor");
        
        super();    // to call default parent constructor
//        super("Call Parent");    // to call parameterised constructor.
    }
    
    void printNum(){
        System.out.println(num);
        System.out.println(super.num); //prints the value of num of parent class
    }
    
    @Override
    public void foo(){
        System.out.println("Parent class foo!");
//        new KeywordAnalyserImplementation();
        super.foo();    //Calls foo method of Parent class inside the Overriden foo method of Child class.
    }
}
