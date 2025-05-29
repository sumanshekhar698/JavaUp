package dev.codecounty.java.java8.core.basics.data_types;

/**
 * This class demonstrates various mathematical edge cases in Java,
 * particularly focusing on integer and floating-point arithmetic
 * and their special behaviors.
 */
public class JavaMathsEdgeCasesExtended {

    public static void main(String[] args) {

        System.out.println("--- Integer Arithmetic Edge Cases ---");

        // Example 1: Integer division by zero
        // This operation throws an ArithmeticException because there's no
        // defined integer representation for the result of division by zero.
        // Uncommenting the line below will cause a runtime error.
        // try {
        //     int resultInt = 9 / 0;
        //     System.out.println("Result of 9 / 0 (int): " + resultInt);
        // } catch (ArithmeticException e) {
        //     System.out.println("Caught ArithmeticException for 9 / 0: " + e.getMessage());
        // }
        System.out.println("Integer division by zero (e.g., 9 / 0) results in an ArithmeticException.");
        System.out.println("This line is commented out to allow the program to run without crashing.");
        System.out.println();

        System.out.println("--- Floating-Point Arithmetic Edge Cases ---");

        // Example 2: Floating-point comparison with 0
        // The integer '0' is promoted to a float '0.0f' for the comparison.
        // Both 0.0f and 0.0 are considered equal.
        System.out.println("Is 0.0f == 0? " + (0.0f == 0)); // Expected: true
        System.out.println("Explanation: Integer 0 is promoted to float 0.0f for comparison.");
        System.out.println();

        // Example 3: Positive Infinity
        // Dividing a positive non-zero floating-point number by 0.0 results in Positive Infinity.
        System.out.println("Result of 9 / 0.0 (double): " + (9 / 0.0)); // Expected: Infinity
        System.out.println("Explanation: Division of a positive finite number by zero results in Positive Infinity.");
        System.out.println();

        // Example 4: Negative Infinity
        // Dividing a negative non-zero floating-point number by 0.0 results in Negative Infinity.
        System.out.println("Result of -9 / 0.0 (double): " + (-9 / 0.0)); // Expected: -Infinity
        System.out.println("Explanation: Division of a negative finite number by zero results in Negative Infinity.");
        System.out.println();

        // Example 5: NaN (Not a Number) from 0/0
        // Dividing 0.0 by 0.0 results in NaN, as the result is indeterminate.
        System.out.println("Result of 0.0 / 0.0 (double): " + (0.0 / 0.0)); // Expected: NaN
        System.out.println("Explanation: 0.0 / 0.0 is an indeterminate form, resulting in NaN.");
        System.out.println();

        // Example 6: NaN from modulo by 0.0
        // The modulo operation with a zero divisor for floating-point numbers also results in NaN.
        System.out.println("Result of 2.0 % 0.0 (double): " + (2.0 % 0.0)); // Expected: NaN
        System.out.println("Explanation: Modulo operation with a zero divisor for floats results in NaN.");
        System.out.println();

        // Example 7: NaN from Math.sqrt(-1)
        // Taking the square root of a negative number results in NaN, as it's not a real number.
        System.out.println("Result of Math.sqrt(-1) (double): " + Math.sqrt(-1)); // Expected: NaN
        System.out.println("Explanation: Square root of a negative number is undefined in real numbers, resulting in NaN.");
        System.out.println();

        System.out.println("--- Checking for Special Floating-Point Values ---");

        double posInf = 9 / 0.0;
        double negInf = -9 / 0.0;
        double notANumber = 0.0 / 0.0;
        double NAN = Double.NaN;

        // Using Double.isInfinite() and Double.isNaN() to check for these special values
        System.out.println("Is " + posInf + " infinite? " + Double.isInfinite(posInf)); // Expected: true
        System.out.println("Is " + negInf + " infinite? " + Double.isInfinite(negInf)); // Expected: true
        System.out.println("Is " + notANumber + " NaN? " + Double.isNaN(notANumber)); // Expected: true
        System.out.println();

        // Important note about NaN comparisons: NaN is not equal to anything, including itself!
        System.out.println("Is NaN == NaN? " + (Double.NaN == Double.NaN)); // Expected: false
        System.out.println("Explanation: NaN is the only value in floating-point arithmetic that is not equal to itself.");
        System.out.println("To check if a value is NaN, always use Double.isNaN() or Float.isNaN().");
    }
}
