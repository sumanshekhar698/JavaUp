package com.codecounty.java.advance.oops.design_patterns.creational.singelton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, IOException, CloneNotSupportedException {
        PrimeMinister pm = PrimeMinister.getInstance("Narendra Modi", "BJP");
        System.out.println(pm);
        System.out.println(pm.getName());
        System.out.println(pm.getParty());

        PrimeMinister pm1 = PrimeMinister.getInstance("Rahul Gandhi", "Congress");
        System.out.println(pm1.getName());
        System.out.println(pm1.getParty());
        System.out.println(pm1);

        //Break the singleton pattern using reflection API
//        Constructor<PrimeMinister>[] declaredConstructors = (Constructor<PrimeMinister>[]) PrimeMinister.class.getDeclaredConstructors();
//        System.out.println(declaredConstructors.length);
//        declaredConstructors[0].setAccessible(true);
//        PrimeMinister clonedPM1 = declaredConstructors[0].newInstance();
//        System.out.println(clonedPM1);
//
//        declaredConstructors[1].setAccessible(true);
//        PrimeMinister clonedPM2 = declaredConstructors[1].newInstance("Amit Shah", "BJP");
//        System.out.println(clonedPM2);




        //Enums are inherently serializable, and the serialization mechanism is guaranteed to produce 100% identical objects
        //Enums are inherently thread safe
        PrimeMinisterENUM pmEnum = PrimeMinisterENUM.INSTANCE;
        pmEnum.setName("Putin");
        System.out.println(pmEnum.hashCode());

        //Break the singleton ENUM pattern using reflection API
//        Constructor<PrimeMinisterENUM> declaredConstructorsFromENUM = PrimeMinisterENUM.class.getDeclaredConstructor();//NoSuchMethodException
//        PrimeMinisterENUM clonedPM1 = declaredConstructorsFromENUM.newInstance();
//        System.out.println(clonedPM1);


        System.out.println("Breaking a Singleton pattern using Serialization and Deserialization");
        //Breaking a Singleton pattern using Serialization and Deserialization
        File file = new File("singleton.ser");
        file.deleteOnExit();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        try {
            System.out.println(pm.hashCode());
            oos.writeObject(pm);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        PrimeMinister deserializedPM = null;
        try (
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            deserializedPM = (PrimeMinister) ois.readObject();
            System.out.println(deserializedPM.hashCode());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        PrimeMinister clonedPM3 =(PrimeMinister) pm.clone();
        System.out.println(clonedPM3.hashCode())    ;


    }
}
