package unit_1;

import java.util.ArrayList;
import java.util.Scanner;

// Class representing an Employee
class Employee {
    // Private fields for encapsulation
    private String name;
    private int employeeId;
    private String department;
    private String designation;
    private String branchOffice = "Codebuzz Limited";

    // Constructor
    public Employee(String name, int employeeId, String department, String designation) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        this.designation = designation;
    }

    // Public methods to access employee details
    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public String getBranchOffice() {
        return branchOffice;
    }

    // Protected method to print the ID card
    protected void printIdCard() {
        System.out.println("----- Employee ID Card -----");
        System.out.println("Branch Office: " + getBranchOffice());
        System.out.println("Name: " + getName());
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Department: " + getDepartment());
        System.out.println("Designation: " + getDesignation());
        System.out.println("----------------------------");
    }
}

// Main class to manage the menu-driven system
public class q12 {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- ID Card Generator Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Print All ID Cards");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    printAllIdCards();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Method to add an employee
    private static void addEmployee() {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Enter designation: ");
        String designation = scanner.nextLine();

        Employee employee = new Employee(name, employeeId, department, designation);
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    // Method to print all ID cards
    private static void printAllIdCards() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
        } else {
            for (Employee employee : employees) {
                employee.printIdCard();
            }
        }
    }
}

