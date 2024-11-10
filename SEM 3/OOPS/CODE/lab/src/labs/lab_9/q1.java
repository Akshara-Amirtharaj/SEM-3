package labs.lab_9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        try {
            // Ensure file names are correct
            File readfile = new File("readfile.txt");
            File writefile = new File("writefile.txt");

            // Initialize the Scanners
            Scanner reader = new Scanner(readfile);

            Scanner input = new Scanner(System.in);

            ArrayList<String> details = new ArrayList<>();

            // Read username and password from the file
            for (int i = 0; i < 2; i++) {
                String content = reader.nextLine();
                details.add(content);
            }
            reader.close();  // Close reader to free resources

            // Prompt for username and password
            System.out.print("Enter your username: ");
            String username = input.next();

            System.out.print("Enter the password: ");
            String password = input.next();
            input.nextLine();  // Consume leftover newline

            // Check if username and password match
            if (username.equals(details.get(0)) && password.equals(details.get(1))) {
                try (FileWriter writer = new FileWriter(writefile, true)) {
                    System.out.print("Enter the content you want to write: ");
                    String content = input.nextLine();

                    writer.write(content + System.lineSeparator());  // Write with newline
                    System.out.println("Successfully written content to the file.");
                } catch (IOException e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                }
            } else {
                System.out.println("Mismatch: Invalid username or password.");
            }

            input.close();  // Close input scanner to free resources

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();  // Print stack trace for debugging
        }
    }
}
