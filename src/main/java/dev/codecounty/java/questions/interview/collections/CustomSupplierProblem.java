package dev.codecounty.java.questions.interview.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CustomSupplierProblem {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};

        CustomSupplier<Integer> integerCustomSupplyer = new CustomSupplier<Integer>(list);
        System.out.println(integerCustomSupplyer.get());
        System.out.println(integerCustomSupplyer.get());
        System.out.println(integerCustomSupplyer.get());
        System.out.println(integerCustomSupplyer.get());


    }
}

class CustomSupplier<T> implements Supplier<T> {

    List<T> list;
    int pointer;

    public CustomSupplier(List<T> list) {
        this.list = list;
        this.pointer = 0;
    }

    @Override
    public T get() {

        if (pointer >= list.size())
            pointer = 0;


        return this.list.get(pointer++);
    }
}

