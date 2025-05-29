package dev.codecounty.java.java8.specials.interfaces.functional_inteface.predefined.consumer;

import java.util.function.BiConsumer;

public class BiConsumers {
    public static void main(String[] args) {
        int currentSalary = 80000;
        int incrementBonus = 10000;

        Emp e1 = new Emp();
        e1.salary = currentSalary;
        System.out.println(e1.salary);

        BiConsumer<Emp, Integer> newSalaryApplier = (e, bonus) -> e.salary += bonus;
        newSalaryApplier.accept(e1, incrementBonus);
        System.out.println(e1.salary);
    }
}

class Emp {
    int salary;
}
