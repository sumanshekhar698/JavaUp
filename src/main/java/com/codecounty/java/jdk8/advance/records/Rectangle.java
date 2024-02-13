package com.codecounty.java.jdk8.advance.records;

import jakarta.validation.constraints.Min;

public final class Rectangle {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double length() {
        return this.length;
    }

    double width() {
        return this.width;
    }

    // Implementation of equals() and hashCode(), which specify
    // that two record objects are equal if they
    // are of the same type and contain equal field values.


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (Double.compare(length, rectangle.length) != 0) return false;
        return Double.compare(width, rectangle.width) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(length);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    // An implementation of toString() that returns a string
    // representation of all the record class's fields,
    // including their names.

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}

record RectangleUsingRecordSIMPLE(double length, double width) {

    //    record Rectangle(double length, double width) {//INNER RECORDS CAN ALSO EXIST
    //        public Rectangle {//Explicit Declaration of constructors

//}
}


//    You can annotate a record class
/*If an annotation is applied to the record class's components, then it also applies to the numerous members in the record class that are declared automatically. In this example, the @Min annotation applies not only to the length and width components, but also to:
The parameters of the canonical constructor
The record class's components
The private fields length and width
The accessor methods length() and width()

You can specify the members to which an annotation applies with the @Target meta-annotation. For example, if @Min is applicable to only field declarations:
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) <===
public @interface Min { }
*/
record RectangleUsingRecord(@Min(0) double length, double width) {


    public RectangleUsingRecord {//Explicit Declaration of constructors
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid dimensions: %f, %f", length, width));
        }
    }


    // Explicit Public accessor method
    public double length() {
        System.out.println("Length is " + length);
        return length;
    }


    // Static field
    static double goldenRatio;
//    You cannot declare instance variables (non-static fields) or instance initializers in a record class.


    // Static initializer
    static {
        goldenRatio = (1 + Math.sqrt(5)) / 2;
    }

    // Static method
    public static Rectangle createGoldenRectangle(double width) {
        return new Rectangle(width, width * goldenRatio);
    }
}

//    You can create a generic record class, for example:
//record Triangle<C extends Coordinate> (C top, C left, C right) { }

//    You can declare a record class that implements one or more interfaces, for example:
//record Triangle<C extends Coordinate> (C top, C left, C right) { }



