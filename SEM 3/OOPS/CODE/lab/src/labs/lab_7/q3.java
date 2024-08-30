package akshara.lab_7;
import java.util.*;
public class q3 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        try{
            int[] array= new int[2];
            System.out.println("Enter the value of b:");
            int b=input.nextInt();
            int c=25/b;
            System.out.println(array[3]);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index out of range");
        }
        catch (ArithmeticException e){
            System.out.println("Arithmetic exception has occured");
        }
        catch(Exception e){
            System.out.println("Error has occured");
        }
    }
    
}
