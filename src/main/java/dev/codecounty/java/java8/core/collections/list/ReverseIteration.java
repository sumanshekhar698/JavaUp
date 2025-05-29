package dev.codecounty.java.java8.core.collections.list;

import java.util.*;

public class ReverseIteration {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(5);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(17);
        arrayList.add(733);
        arrayList.add(71);

//        1::
        ArrayList<Integer> clone = (ArrayList<Integer>) arrayList.clone();
        Collections.reverse(clone);
        System.out.println(clone);


        // 2::Generate an iterator. Start just after the last element.
        ListIterator li = arrayList.listIterator(arrayList.size());

// Iterate in reverse.
        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }

        // 3::
        for (Integer num : new ReverseIterator<Integer>(arrayList)) {
            System.out.print(num + " ");
        }
    }
}

class ReverseIterator<T> implements Iterator<T>, Iterable<T> {

    private final List<T> list;
    private int position;

    public ReverseIterator(List<T> list) {
        this.list = list;
        this.position = list.size() - 1;
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return position >= 0;
    }

    @Override
    public T next() {
        return list.get(position--);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}


class ReversedIterator<T> implements Iterable<T> {

    private List<T> list;

    public ReversedIterator(List<T> list) {
        this.list = list;
    }

    //Iterator provided to clients of this class
    @Override
    public Iterator<T> iterator() {

        // Every time an iterator is requested we
        // define a new ListIterator that will be used to
        // iterate the list in the reverse order
        final ListIterator<T> iterator = list.listIterator(list.size());

        // The iterator returned to the caller will
        // work based on the ListIterator
        return new Iterator<T>() {

            // hasNext() and next() methods call in fact
            // the reverse operations in ListIterator

            @Override
            public boolean hasNext() {
                return iterator.hasPrevious();
            }

            @Override
            public T next() {
                return iterator.previous();
            }

            @Override
            public void remove() {
                iterator.remove();
            }

        };

    }
}