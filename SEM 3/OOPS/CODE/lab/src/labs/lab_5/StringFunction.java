package labs.lab_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

class methods{
    void append(ArrayList<String> s,String name){
        s.add(name);
    }
    void insert(ArrayList<String> s,String name,int pos){
        s.add(pos,name);
    }
    boolean search(ArrayList<String> s,String name){
            if(s.contains(name)){
                return true;
            }
            return false;
    }
    void startswith(ArrayList<String> s, char letter){
        for(String names:s){
            if(letter==names.charAt(0)){
                System.out.println(names);
            }
        }
    }
    void ascending(ArrayList<String> s){
        Collections.sort(s);
        System.out.println(s);
    }
    void descending(ArrayList<String>s){
        Collections.sort(s,Collections.reverseOrder());
        System.out.println(s);
    }
}


public class StringFunction {
    public static void main(String[] args){

        methods func=new methods();
        ArrayList<String> s= new ArrayList<>();
        Scanner input=new Scanner(System.in);

        while(true){

            System.out.println("(1) Append");
            System.out.println("(2) Insert");
            System.out.println("(3) Search");
            System.out.println("(4) Search with starting letter");
            System.out.println("(5) Sorting");
            System.out.println("(6) Exit");
            System.out.println("Enter your choice");
            int choice=input.nextInt();


            switch(choice){
                case 1:
                    System.out.println("Enter the String to append:");
                    String name1=input.next();
                    func.append(s,name1);

                    break;

                case 2:
                    System.out.println("Enter the string to insert");
                    String name2=input.nextLine();
                    System.out.println("Enter the position to insert");
                    int pos=input.nextInt();
                    func.insert(s,name2,pos);
                    break;

                case 3:
                    System.out.println("Enter the String to search:");
                    String name3=input.next();

                    if(func.search(s,name3)){
                        System.out.println("String is found");
                    }
                    else{
                        System.out.println("String not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter the letter to search");
                    char letter= input.next().charAt(0);
                    func.startswith(s,letter);
                    break;

                case 5:
                    System.out.println("(1) Ascending");
                    System.out.println("(2) Descending");
                    System.out.println("Enter your choice:");
                    int c=input.nextInt();

                    if(c==1){
                        func.ascending(s);
                    }
                    else if(c==2){
                        func.descending(s);
                    }
                    else{
                        System.out.println("Enter a valid option");
                    }
                    break;

                case 6:
                    return;

                default:
                    System.out.println("please enter an valid option");
            }
        }
    }
}
