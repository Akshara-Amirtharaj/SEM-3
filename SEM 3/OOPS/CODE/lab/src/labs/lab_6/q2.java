package labs.lab_6;

import java.util.Scanner;

public class q2 {
    boolean check(String name1,String name2,int k){
        if(name1.length()!=name2.length()){
            return false;
        }
        int[] charcount1= new int[26];
        int[] charcount2= new int[26];

        for(int i=0;i<name1.length();i++){
            charcount1[name1.charAt(i)-'a']++;
            charcount2[name1.charAt(i)-'a']++;
        }
        int difference=0;
        for(int i=0;i<26;i++){
            difference+=charcount1[i]-charcount2[i];
        }
        return difference<=k;
    }
    public static void main(String[] args){


        Scanner input=new Scanner(System.in);
        System.out.println("Enter the string 1:");
        String name1=input.nextLine();
        System.out.println("Enter the string 2:");
        String name2=input.nextLine();
        System.out.println("Enter the value of k:");
        int k=input.nextInt();

        q2 obj=new q2();

        if(obj.check(name1,name2,k)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }

    }

}
