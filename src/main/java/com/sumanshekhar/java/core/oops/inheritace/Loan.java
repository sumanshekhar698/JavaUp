package com.sumanshekhar.java.core.oops.inheritace;
class Loan {
  double calculateEMI(double principal) {
     double simpleInterest = (principal*8.5*5) / 100;
     double emi = (simpleInterest+principal)/5;
     return emi;
  }
}

class HomeLoan extends Loan{
               
  double calculateEMI(double principal){
  
    double emi = super.calculateEMI(principal); //To invoke parent class method super keyword is used
    int additionaltax = 300;
    emi= emi + additionaltax;
    return emi;
  }
}