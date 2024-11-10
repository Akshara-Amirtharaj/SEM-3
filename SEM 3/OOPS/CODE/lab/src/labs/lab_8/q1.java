package labs.lab_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// User-defined exceptions
class EvenIDAgeLessThan30Exception extends Exception {
    EvenIDAgeLessThan30Exception(String message) {
        super(message);
    }
}

class OddIDAgeMoreThan30Exception extends Exception {
    OddIDAgeMoreThan30Exception(String message) {
        super(message);
    }
}

class Party {

    // Static lists to store employee ages for each hall
    static List<Integer> hall1Ages = new ArrayList<>();
    static List<Integer> hall2Ages = new ArrayList<>();
    static List<Integer> hall3Ages = new ArrayList<>();

    int empId;
    int age;

    // Constructor to initialize employee details
    Party(int empId, int age) {
        this.empId = empId;
        this.age = age;
    }

    // Method to allot employees to their respective halls
    void allotHall() throws EvenIDAgeLessThan30Exception, OddIDAgeMoreThan30Exception {
        if (empId % 2 == 0 && age < 30) {
            // Throw exception if employee with even ID and age < 30
            throw new EvenIDAgeLessThan30Exception("You are not allowed in hall 2 or hall 3");
        } else if (empId % 2 != 0 && age > 30) {
            // Throw exception if employee with odd ID and age > 30
            throw new OddIDAgeMoreThan30Exception("You are not allowed in hall 1 or hall 3");
        } else if (empId % 2 == 0) {
            // Allot to hall 1
            System.out.println("Welcome to the party in Hall 1!");
            hall1Ages.add(age);
        } else if (empId % 2 != 0) {
            // Allot to hall 2
            System.out.println("Welcome to the party in Hall 2!");
            hall2Ages.add(age);
        } else {
            // Allot to hall 3 (for remaining cases)
            System.out.println("Welcome to the party in Hall 3!");
            hall3Ages.add(age);
        }
    }

    // Method to find and print average ages for all halls
    void findAverages() {
        try {
            System.out.println("Hall 1 average age: " + calculateAverage(hall1Ages));
            System.out.println("Hall 2 average age: " + calculateAverage(hall2Ages));
            System.out.println("Hall 3 average age: " + calculateAverage(hall3Ages));
        } catch (Exception e) {
            System.out.println("An error occurred while calculating averages: " + e.getMessage());
        }
    }

    // Helper method to calculate the average age of a hall
    private double calculateAverage(List<Integer> ages) {
        if (ages.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int age : ages) {
            sum += age;
        }
        return (double) sum / ages.size();
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean addEmployee = true;

        while (addEmployee) {
            try {
                System.out.print("Enter Employee ID: ");
                int empId = input.nextInt();

                System.out.print("Enter Employee Age: ");
                int age = input.nextInt();

                // Create a Party object and allot the employee to a hall
                Party p = new Party(empId, age);
                p.allotHall();

                // Print the average ages of all halls
                p.findAverages();

            } catch (EvenIDAgeLessThan30Exception | OddIDAgeMoreThan30Exception e) {
                // Catch user-defined exceptions and print the message
                System.out.println("Exception: " + e.getMessage());
            } catch (InputMismatchException e) {
                // Handle invalid input
                System.out.println("Invalid input. Please enter a valid number.");
                input.next(); // Clear the invalid input
            } catch (Exception e) {
                // Handle any other unexpected exceptions
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }

            System.out.print("Do you want to add another employee? (yes/no): ");
            String answer = input.next();
            addEmployee = answer.equalsIgnoreCase("yes");
        }

        input.close();
    }
}
