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
        try{
            if(age<18){
                throw new InvalidAgeException();
            }
        }
        catch(InvalidAgeException e){
            System.out.println("Underage");
        }
        finally{
            System.out.println("Checking completed");
        }
    }
}
public class q4 {
    
    public static void main(String[] args)throws InvalidAgeException{
        
        Scanner input=new Scanner(System.in);
        System.out.println("Enter your age");
        int age=input.nextInt();
        checker ch=new checker();
        ch.agecheck(age);
        
    input.close();
    }
}
