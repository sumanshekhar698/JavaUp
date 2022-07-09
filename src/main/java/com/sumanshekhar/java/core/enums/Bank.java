package com.sumanshekhar.java.core.enums;
 enum Designation{
    CEO(2),GeneralManager(4),RegionalManager(20),BranchManager(30);
    private int noofEmployees;
    Designation(int noofEmployees)
    {
      this.noofEmployees=noofEmployees;
    }
    public int getNoofEmployees(){
      return noofEmployees;
    }
  }
 
 
  class Bank{
    public void reportees(Designation designation){
      System.out.println(designation.getNoofEmployees());
    }
    public static void main(String[] args){
      Bank bank=new Bank();
      bank.reportees(Designation.CEO);
    }
  }