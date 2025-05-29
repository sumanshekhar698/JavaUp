package dev.codecounty.java.java8.oops.inheritance.super_keyword;


class Animal {

    String foodHabit;
    String nativePlace;
    int species = 0;
    boolean isEndangered;

    public Animal() {
//		super();
        System.out.println("Animal() called");
    }

    void animalIsEndangered() {
        System.out.println(isEndangered);
    }

}


class Cat extends Animal {

    String weight;
    String species = "default Cat";

    public Cat() {
//		super();
        System.out.println("Cat() called");
    }

    public Cat(String weight, String species) {
        super();
        System.out.println("CAT(weigght, string)");
        this.weight = weight;
        this.species = species;
    }

    void callOutSpecies(String species) {//Specialized
        System.out.println("CAT ----> " + this.species);
    }

//	animalIsEndangered()//inherited
}


public class Lion extends Cat {

    String place;
    String species = "Asiatic";

    public Lion() {
//		super();
        this("While Lion");
//		super("55", "Egyptian Cat");
        System.out.println(this.place);

        System.out.println("Lion() called");
    }

    public Lion(String lion) {
        super();
        System.out.println("Lion(String) called");
    }

    @Override
    void callOutSpecies(String species) {//Overridden Method
        System.out.println(species);//local
        System.out.println(this.species);//current object
        System.out.println(super.species);//super class EVEN IF THE TYPE IS DIFF
//		System.out.println(super.super.species);//super can be used top access direct Parent only
        super.callOutSpecies(species);
//		this.callOutSpecies(species);//recursion
//		callOutSpecies(species);//recursion
    }

    public static void main(String[] args) {

        Lion l1 = new Lion();
//		l1.callOutSpecies("Chinese");

    }

}

/*
    Within a class, a field that has the same name as a field in the superclass hides the superclass's field,
     even if their types are different.
     Within the subclass, the field in the superclass cannot be referenced by its simple name.
     Instead, the field must be accessed through super,
*/


//https://docs.oracle.com/javase/tutorial/java/IandI/hidevariables.html