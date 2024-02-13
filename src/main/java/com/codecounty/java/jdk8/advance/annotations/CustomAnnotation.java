package com.codecounty.java.jdk8.advance.annotations;


import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})// TYPE, METHOD, CONSTRUCTOR, FIELD
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
    int age() default 0;//single valued annotation if passing one value

    String name() default "blank name";//multi valued annotation if passing more thsn one value
}

/*
-Annotation methods can’t have parameters.
-Annotation methods return types are limited to primitives, String, Enums, Annotation or array of these.
-Java Annotation methods can have default values.
-Annotations can have meta annotations attached to them.
 Meta annotations are used to provide information about the annotation.
 */

@CustomAnnotation(name = "Suman", age = 25)
class Sample {

}

class Main {
    public static void main(String[] args) {
        Sample sample = new Sample();
//        Class<? extends Sample> aClass = sample.getClass();
        Class aClass = sample.getClass();//get the clas
        System.out.println(sample.getClass().getSimpleName());
        Annotation annotation = aClass.getAnnotation(CustomAnnotation.class);
        System.out.println(annotation.toString());

        CustomAnnotation cAno = (CustomAnnotation)annotation;
        System.out.println(cAno.age());
        System.out.println(cAno.name());
    }
}