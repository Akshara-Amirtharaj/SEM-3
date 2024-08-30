
package akshara.lab_7;
import java.util.*; 

public class q1 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n=input.nextInt();

        try{
            int[] array=new int[n];
           }
        catch(Exception e){
            System.out.println("Negative number is passed");
            System.out.println(e.getClass());
        }
    }
}
