import java.util.*;

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public void divide(double a, double b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            double result = a / b;
            System.out.println("Division Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}

class ScientificCalculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("--- Scientific Calculator Results ---");
        System.out.println("Addition (int): " + calc.add(10, 5));
        System.out.println("Addition (double): " + calc.add(5.5, 2.3));
        System.out.println("Multiplication (int): " + calc.multiply(4, 3));
        System.out.println("Multiplication (double): " + calc.multiply(4.5, 2.0));

        calc.divide(10, 2);
        calc.divide(10, 0);

        System.out.println("Power (2^3): " + calc.power(2, 3));
    }
}