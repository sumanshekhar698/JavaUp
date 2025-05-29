package dev.codecounty.java.java8.core.collections.list;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListToArrayConversion {
    public static void main(String[] args) {

//        Case 1
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(32);
        arrayList.add(67);
        arrayList.add(98);
        arrayList.add(100);

        System.out.println("ArrayList: " + arrayList + " size -> " + arrayList.size());

        // Get the array of the elements of the ArrayList using toArray() method
        Object[] arr = arrayList.toArray();
        System.out.println("len of array -> " + arr.length + "| hash ->" + arr.hashCode());
        System.out.println("Elements of ArrayList" + " as Array: " + Arrays.toString(arr));
        System.out.println("len of array -> " + arr.length + "| hash ->" + arr.hashCode());


//        Case 2
/*        Exception: The first overload of this method throws no exceptions.
          However, the second overload throws following exceptions:
          #ArrayStoreException: if the runtime type of the specified array is not a supertype of the runtime type of every element in this list.
          #NullPointerException if the specified array is null*/
        System.out.println("\n\nCase 2 with overloaded toArray()\n");

        // Get the array of the elements
        // of the ArrayList
        // using toArray(T[]) method
//        Integer arrPre[] = new Integer[1]; //if the length is small that of arraylist
//        then a new Array will be created and assigne to the same variable
        Integer arrPre[] = new Integer[arrayList.size()];
        System.out.println("len of array -> " + arrPre.length + "| hash ->" + arrPre.hashCode());
//        arrPre = arrayList.<Integer>toArray(null);
        arrPre = arrayList.<Integer>toArray(arrPre);
        System.out.println("Elements of ArrayList" + " as Array: " + Arrays.toString(arrPre));
        System.out.println("len of array -> " + arrPre.length + "| hash ->" + arrPre.hashCode());

    }
}
