package dev.codecounty.java.java8.core.collections.custom_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PerrsonSortingOn2Params {
    public static void main(String[] args) {
        // Create the collection of people:
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Dan", 4));
        people.add(new Person("Andi", 2));
        people.add(new Person("Bob", 42));
        people.add(new Person("Debby", 3));
        people.add(new Person("Bob", 72));
        people.add(new Person("Barry", 20));
        people.add(new Person("Cathy", 40));
        people.add(new Person("Bob", 40));
        people.add(new Person("Barry", 50));

        // Define chained comparators:
        // Great article explaining this and how to make it even neater:
        // http://blog.jooq.org/2014/01/31/java-8-friday-goodies-lambdas-and-sorting/
        Comparator<Person> comparator = Comparator.comparing(person -> person.age);
//        comparator = comparator.thenComparing(Comparator.comparing(person -> person.age));
        comparator = comparator.thenComparing(person -> person.name);

        // Sort the stream:
        people.stream().sorted(comparator).forEach(System.out::println);
    }


    private static void order(List<Person> persons) {

        Collections.sort(persons, new Comparator<Person>() {

            public int compare(Person p1, Person p2) {

                String x1 = ((Person) p1).name;
                String x2 = ((Person) p2).name;
                int sComp = x1.compareTo(x2);

                if (sComp != 0) {
                    return sComp;
                }

                Integer a1 = ((Person) p1).age;
                Integer a2 = ((Person) p2).age;
                return a1.compareTo(a2);
            }
        });
    }
}
