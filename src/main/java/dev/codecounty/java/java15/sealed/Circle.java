package dev.codecounty.java.java15.sealed;// In Java 17+

sealed class Shape permits Circle, Square, OtherShape {
}

final class Circle extends Shape {
} // final: cannot be subclassed

//sealed class Square extends Shape permits ColoredSquare {
//} // still sealed

non-sealed class Square extends Shape  {
} // still sealed

non-sealed class OtherShape extends Shape {
    // This class can be extended by anyone
}