package labs.lab_10;

import java.io.File;

public class q4 {
    public static void main(String[] args) {
        File obj = new File("C:/Users/aksha/OneDrive - SSN Trust/Desktop/AKSHARA/COLLEGE/SEM 3/OOPS/CODE/lab/idk/aksh");

        if (obj.exists()) {
            System.out.println("Directory already exists.");
        } else {
            if (obj.mkdirs()) {
                System.out.println("Directory created successfully.");
            } else {
                System.out.println("Failed to create directory. Check the path and permissions.");
            }
        }
    }
}
