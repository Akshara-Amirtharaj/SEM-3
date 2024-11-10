package labs.lab_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {

        String path="C:/Users/aksha/OneDrive - SSN Trust/Desktop/AKSHARA/COLLEGE/SEM 3/OOPS/CODE/lab/readfile.txt";
        try{
        File obj=new File("C:/Users/aksha/OneDrive - SSN Trust/Desktop/AKSHARA/COLLEGE/SEM 3/OOPS/CODE/lab/readfile.txt");
        if(obj.exists()){
            System.out.println("File exists");

            Scanner reader=new Scanner(obj);
            while(reader.hasNextLine()){
                System.out.println(reader.nextLine());
            }
        }
        else{
            System.out.println("File doesnt exist in the given path");
        }
    }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
