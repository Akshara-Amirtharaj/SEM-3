package unit_1;

class q5 {
    // Static variable
    static int staticVariable;

    // Static block
    static {
        System.out.println("Static block executed.");
        staticVariable = 5;
    }

    // Static method
    static void staticMethod() {
        System.out.println("Static method called.");
        System.out.println("Static variable: " + staticVariable);
    }

    // Non-static method to show the difference
    void nonStaticMethod() {
        System.out.println("Non-static method called.");
    }

    // Main method
    public static void main(String[] args) {
        // Accessing static method and variable without creating an instance
        q5.staticMethod();

        // Accessing non-static method requires an instance
        q5 demo = new q5();
        demo.nonStaticMethod();

        // Static variable can be accessed directly using the class name
        System.out.println("Accessing static variable directly: " + q5.staticVariable);
    }
}

