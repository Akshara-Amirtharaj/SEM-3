package unit_1;

import java.util.Scanner;

public class q10 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter string 1:");
        String string1=input.next();
        System.out.println("Enter string 2:");
        String string2=input.next();

        if(string1.equals(string2)){
            System.out.println("Both the strings are equal");
        }
        else{
            System.out.println("Not equal");
        }
    }
}
