package com.codecounty.java.core.oops.inheritance.inner_classes;


class OuterClassTricky {
    int x;

    void methodOfOuterClass() {
        System.out.println("From OuterClassTricky");
    }

    //Class as a member
    class InnerClassTricky extends OuterClassTricky {
        //only fields and methods are inherited, but not member Inner Classes
    }

    class InnerClassOne {
        //another class as a member
    }
}


public class TrickyInnerClasExample {
    public static void main(String args[]) {
        //You have to create OuterClass object to access non-static inner class
        OuterClassTricky outer = new OuterClassTricky();
        OuterClassTricky.InnerClassTricky inner = outer.new InnerClassTricky();  //creating object to InnerClass
        System.out.println(inner.x);   //accesiing inherited field x
        inner.methodOfOuterClass();   //accessing inherited method

        inner.new InnerClassOne();
    }

}

/*
Inner class can extend it’s outer class.
 But, it does not serve any meaning.
 Because, even the private members of outer class are available inside the inner class.
 Even though, When an inner class extends its outer class,
 only fields and methods are inherited but not inner class itself.
*/

