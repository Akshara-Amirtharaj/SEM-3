package unit_1;

public class q2 {

    public static void main(String[] args) {
        // Increment and Decrement Operators
        int a = 5;
        System.out.println("Initial value of a: " + a);
        a++; // Increment operator
        System.out.println("After increment, value of a: " + a);
        a--; // Decrement operator
        System.out.println("After decrement, value of a: " + a);

        // Bitwise Complement Operator
        int b = 10;
        System.out.println("Initial value of b: " + b);
        int bitwiseComplement = ~b; // Bitwise complement operator
        System.out.println("Bitwise complement of b: " + bitwiseComplement);

        // Arithmetic Operators
        int c = 15;
        int d = 4;
        System.out.println("c + d = " + (c + d)); // Addition
        System.out.println("c - d = " + (c - d)); // Subtraction
        System.out.println("c * d = " + (c * d)); // Multiplication
        System.out.println("c / d = " + (c / d)); // Division
        System.out.println("c % d = " + (c % d)); // Modulus

        // Relational Operators
        System.out.println("c == d: " + (c == d)); // Equal to
        System.out.println("c != d: " + (c != d)); // Not equal to
        System.out.println("c > d: " + (c > d));   // Greater than
        System.out.println("c < d: " + (c < d));   // Less than
        System.out.println("c >= d: " + (c >= d)); // Greater than or equal to
        System.out.println("c <= d: " + (c <= d)); // Less than or equal to

        // Bitwise Operators
        int e = 3;  // 0011 in binary
        int f = 6;  // 0110 in binary
        System.out.println("e & f = " + (e & f));  // Bitwise AND
        System.out.println("e | f = " + (e | f));  // Bitwise OR
        System.out.println("e ^ f = " + (e ^ f));  // Bitwise XOR

        // Conditional (Ternary) Operator
        int g = 7;
        String result = (g % 2 == 0) ? "Even" : "Odd"; // Conditional operator
        System.out.println("g is " + result);
    }
}

