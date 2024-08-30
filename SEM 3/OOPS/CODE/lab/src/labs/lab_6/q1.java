package labs.lab_6;

import java.util.Scanner;

public class q1 {

    public static void main(String[] args){

        Scanner input=new Scanner(System.in);
        System.out.println("Enter the String:");
        String name=input.nextLine();
        System.out.println("Enter the index:");
        int index=input.nextInt();
        System.out.println("The character at "+index+" position is "+name.charAt(index));

    }
}
