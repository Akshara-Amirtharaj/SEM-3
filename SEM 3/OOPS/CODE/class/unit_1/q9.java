package unit_1;

import java.util.ArrayList;
import java.util.Scanner;

// Base Class for all University Staff
abstract class UniversityStaff {
    private String name;
    private int age;
    private String department;

    // Constructor
    public UniversityStaff(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Getter and Setter methods for encapsulation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Abstract method to be implemented by subclasses
    public abstract void performDuties();
}

// Teaching Staff Class Hierarchy
class TeachingStaff extends UniversityStaff {
    private String designation;

    // Constructor
    public TeachingStaff(String name, int age, String department, String designation) {
        super(name, age, department);
        this.designation = designation;
    }

    // Getter and Setter
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    // Overriding the abstract method
    @Override
    public void performDuties() {
        System.out.println(getName() + " is teaching in the " + getDepartment() + " department as a " + designation);
    }
}

// Non-Teaching Staff Class Hierarchy
class NonTeachingStaff extends UniversityStaff {
    private String role;

    // Constructor
    public NonTeachingStaff(String name, int age, String department, String role) {
        super(name, age, department);
        this.role = role;
    }

    // Getter and Setter
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Overriding the abstract method
    @Override
    public void performDuties() {
        System.out.println(getName() + " is working in the " + getDepartment() + " department as " + role);
    }
}

// Main Class with Menu
public class q9 {
    private static ArrayList<UniversityStaff> staffList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- University Structure Management System ---");
            System.out.println("1. Add Teaching Staff");
            System.out.println("2. Add Non-Teaching Staff");
            System.out.println("3. Display All Staff");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addTeachingStaff();
                    break;
                case 2:
                    addNonTeachingStaff();
                    break;
                case 3:
                    displayAllStaff();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Method to add teaching staff
    private static void addTeachingStaff() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Enter designation (Teaching Assistant, Assistant Professor, Associate Professor, Professor): ");
        String designation = scanner.nextLine();

        TeachingStaff teachingStaff = new TeachingStaff(name, age, department, designation);
        staffList.add(teachingStaff);
        System.out.println("Teaching staff added successfully.");
    }

    // Method to add non-teaching staff
    private static void addNonTeachingStaff() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Enter role (Administrative Staff, HR Staff): ");
        String role = scanner.nextLine();

        NonTeachingStaff nonTeachingStaff = new NonTeachingStaff(name, age, department, role);
        staffList.add(nonTeachingStaff);
        System.out.println("Non-teaching staff added successfully.");
    }

    // Method to display all staff
    private static void displayAllStaff() {
        if (staffList.isEmpty()) {
            System.out.println("No staff found!");
        } else {
            for (UniversityStaff staff : staffList) {
                System.out.println("\nStaff Details:");
                System.out.println("Name: " + staff.getName());
                System.out.println("Age: " + staff.getAge());
                System.out.println("Department: " + staff.getDepartment());

                if (staff instanceof TeachingStaff) {
                    System.out.println("Designation: " + ((TeachingStaff) staff).getDesignation());
                } else if (staff instanceof NonTeachingStaff) {
                    System.out.println("Role: " + ((NonTeachingStaff) staff).getRole());
                }

                System.out.println("Duties: ");
                staff.performDuties();
            }
        }
    }

}
