package unit_1;

// Interface named Test
interface Test {
    int square(int x);
}

// Abstract class that partially implements Test
abstract class PartialTest implements Test {
    // This class does not implement the square method, so it's abstract
    public void display() {
        System.out.println("This is a partial implementation of the Test interface.");
    }
}

// Class Arithmetic that implements the Test interface
class Arithmetic extends PartialTest {
    // Implementing the square method
    @Override
    public int square(int x) {
        return x * x;
    }
}


public class q11 {
    public static void main(String[] args) {
        // Creating an object of Arithmetic class
        Arithmetic arithmetic = new Arithmetic();

        // Using the square method
        int result = arithmetic.square(5);

        // Displaying the result
        System.out.println("Square of 5 is: " + result);

        // Displaying the partial implementation message
        arithmetic.display();
    }
}

