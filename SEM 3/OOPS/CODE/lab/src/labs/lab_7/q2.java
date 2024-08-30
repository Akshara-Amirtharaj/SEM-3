package akshara.lab_7;
import java.util.*;
class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
    public InvalidAgeException(){
        super("Underage");
    } 
}
class checker{
    void agecheck(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException();
        }
        else{
            System.out.println("You're eligible for voting");
        }
    }
}
public class q2 {
    
    public static void main(String[] args)throws InvalidAgeException{
        
        Scanner input=new Scanner(System.in);
        System.out.println("Enter your age");
        int age=input.nextInt();
        checker ch=new checker();
        ch.agecheck(age);
        
    input.close();
    }
}
