class Calculator {

    // Addition Overloading
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    // Subtraction Overloading
    int subtract(int a, int b) {
        return a - b;
    }

    double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication Overloading
    int multiply(int a, int b) {
        return a * b;
    }

    double multiply(double a, double b) {
        return a * b;
    }

    // Division with Exception Handling
    double divide(double a, double b) {
        try {
            if (b == 0) {
                throw new ArithmeticException();
            }
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");
            return 0;
        }
    }

    // Scientific Functions
    double squareRoot(double n) {
        return Math.sqrt(n);
    }

    double power(double base, double exp) {
        return Math.pow(base, exp);
    }

    double sin(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    double cos(double angle) {
        return Math.cos(Math.toRadians(angle));
    }
}

public class ScientificCalculatorProfessional {
    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println("Addition (int): " + calc.add(5, 10));
        System.out.println("Addition (double): " + calc.add(5.5, 2.3));

        System.out.println("Subtraction: " + calc.subtract(20, 5));

        System.out.println("Multiplication: " + calc.multiply(4, 6));

        System.out.println("Division: " + calc.divide(25, 5));

        // Exception Handling Demo
        calc.divide(10, 0);

        System.out.println("Square Root of 81: "
                + calc.squareRoot(81));

        System.out.println("2^5 = "
                + calc.power(2, 5));

        System.out.println("sin(30) = "
                + calc.sin(30));

        System.out.println("cos(60) = "
                + calc.cos(60));
    }
}
