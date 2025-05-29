package dev.codecounty.java.questions.interview.collections;
//https://docs.oracle.com/javase/7/docs/api/java/util/Set.html
import java.util.HashSet;
import java.util.Set;
/*
* HashSet elements (just like HashMap keys) are supposed to be immutable
* If you update them (in ways that affect equals or hashCode), then things break
* In this particular case, you end up with a Person in a hash bucket that does not match its hash code anymore,
*  so that it will not be found when inserting potential new elements (and checking for duplicates).
* It will still be returned when iterating over all elements (so that it does show up in the printout).
*
* */
class Person {

    private String fName;
    private String lName;

    Person(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
//getters & setters

    @Override
    public int hashCode() {
        return (int) fName.hashCode() * lName.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Person)) return false;

        Person other = (Person) o;
        if (!this.fName.equals(other.fName)) return false;
        if (!this.lName.equals(other.lName)) return false;

        return true;
    }
}

public class HashSetDuplicateTest {
    public static void main(String[] args) {
        Set<Person> pSet = new HashSet<Person>();

        Person p1 = new Person("John", "Doe");
        pSet.add(p1);
        p1.setfName("Jane");

        Person p2 = new Person("Jane", "Doe");
        pSet.add(p2);

        for (Person p : pSet) {
            System.out.println(p.getfName() + " " + p.getlName());
        }
    }
}