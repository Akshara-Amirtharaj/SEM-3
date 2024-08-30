package unit_1;

public class q1 {
    // Declare all primitive data types as class members
    byte defaultByte;
    short defaultShort;
    int defaultInt;
    long defaultLong;
    float defaultFloat;
    double defaultDouble;
    char defaultChar;
    boolean defaultBoolean;

    // Method to display default values
    public void displayDefaultValues() {
        System.out.println("Default value of byte: " + defaultByte);
        System.out.println("Default value of short: " + defaultShort);
        System.out.println("Default value of int: " + defaultInt);
        System.out.println("Default value of long: " + defaultLong);
        System.out.println("Default value of float: " + defaultFloat);
        System.out.println("Default value of double: " + defaultDouble);
        System.out.println("Default value of char: '" + defaultChar + "'");
        System.out.println("Default value of boolean: " + defaultBoolean);
    }

    public static void main(String[] args) {
        // Create an object of DefaultValues
        q1 defaultValues = new q1();

        // Display the default values of all primitive data types
        defaultValues.displayDefaultValues();
    }
}
