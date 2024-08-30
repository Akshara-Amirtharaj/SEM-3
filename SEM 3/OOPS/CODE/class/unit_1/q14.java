package unit_1;

// Class representing a Person with private fields
class Person {
    // Private fields
    private String name;
    private int age;

    // Constructor to initialize name and age
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for age
    public int getAge() {
        return age;
    }

    // Setter method for age
    public void setAge(int age) {
        if (age > 0) { // Additional check to ensure age is positive
            this.age = age;
        } else {
            System.out.println("Invalid age. Age must be a positive number.");
        }
    }
}

// Main class to demonstrate the usage of getter and setter methods
public class q14{
    public static void main(String[] args) {
        // Creating an object of the Person class
        Person person = new Person("John", 30);

        // Accessing private members using getter methods
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());

        // Modifying private members using setter methods
        person.setName("Jane Doe");
        person.setAge(25);

        // Accessing the modified private members using getter methods
        System.out.println("Updated Name: " + person.getName());
        System.out.println("Updated Age: " + person.getAge());

        // Attempting to set an invalid age
        person.setAge(-5); // This will trigger the validation in the setter
    }
}

