package unit_1;

import java.util.Scanner;

public class q15 {
    // Method to check if str2 can be obtained by rotating str1 exactly 2 places
    public static boolean isRotatedByTwoPlaces(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        // Clockwise rotation: Remove the last two characters and prepend them to the front
        String clockwiseRotation = str1.substring(str1.length() - 2) + str1.substring(0, str1.length() - 2);

        // Anticlockwise rotation: Remove the first two characters and append them to the end
        String anticlockwiseRotation = str1.substring(2) + str1.substring(0, 2);

        // Check if str2 matches either of the rotations
        return str2.equals(clockwiseRotation) || str2.equals(anticlockwiseRotation);
    }

    public static void main(String[] args) {
        // Test cases
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the string 1:");
        String str1 = input.next();
        System.out.println("Enter the string 2:");
        String str2 = input.next();

        if (isRotatedByTwoPlaces(str1, str2)) {
            System.out.println(str2 + " can be obtained by rotating " + str1 + " by exactly 2 places.");
        } else {
            System.out.println(str2 + " cannot be obtained by rotating " + str1 + " by exactly 2 places.");
        }

    }
}
