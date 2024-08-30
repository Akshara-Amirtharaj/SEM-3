package unit_1;

class Family {
    // Private field to store the mobile number
    private String mobileNumber;

    // Constructor to initialize the mobile number
    public Family(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    // Public method to display the mobile number (only accessible within the class)
    public void displayMobileNumber() {
        System.out.println("Family Mobile Number: " + mobileNumber);
    }
}
  public class q13 {
    public static void main(String[] args) {
        // Creating a Family object with a private mobile number
        Family myFamily = new Family("123-456-7890");

        // Accessing the mobile number within the Family class
        myFamily.displayMobileNumber();

        // Trying to access the mobile number directly will result in a compilation error
        // System.out.println(myFamily.mobileNumber); // This line would cause an error
    }
}

