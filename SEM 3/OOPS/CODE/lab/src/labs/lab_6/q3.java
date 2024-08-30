package labs.lab_6;

import java.util.LinkedList;
import java.util.Scanner;

public class q3 {

    void insert(LinkedList<String> l1,String name){
        l1.add(name);
    }

    boolean delete(LinkedList<String> l1){
        if(l1.isEmpty()){
            return false;
        }
        l1.remove();
        return true;
    }

    void display(LinkedList<String> l1){
        if(l1.isEmpty()){
            System.out.println("The list is empty");
        }
        else {
            System.out.println(l1);
        }
    }
    public static void main(String[] args){
        LinkedList<String> l1=new LinkedList<>();
        Scanner input=new Scanner(System.in);


        q3 obj=new q3();
        while(true){
            System.out.println("(1) Insert");
            System.out.println("(2) Delete");
            System.out.println("(3) Display");
            System.out.println("(4) Exit");
            System.out.println("Enter your choice");
            int choice=input.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the String to add:");
                    String name=input.next();
                    obj.insert(l1,name);
                    break;

                case 2:
                    if(obj.delete(l1)){
                        System.out.println("Element is deleted succesfully");
                    }
                    else{
                        System.out.println("The list is already empty");
                    }
                    break;

                case 3:
                    obj.display(l1);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Please enter a valid option");
            }
        }

    }

}
