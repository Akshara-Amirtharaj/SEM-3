package unit_1;

import java.util.ArrayList;
import java.util.Scanner;

public class q7 {
    public static class Pair{
        void MinMax(int[] integers ){
             int min=integers[0];
             int max=integers[0];
             if(integers.length<=0){
                 System.out.println("The list is empty");
             }
             for(int i=0;i<integers.length;i++){
                 if(integers[i]<min){
                     min=integers[i];
                 }
                 if(integers[i]>max){
                     max=integers[i];
                 }
             }
            System.out.println("Minimum element:"+min);
            System.out.println("Maximum element:"+max);
        }
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int n=0;

        System.out.println("Enter the number of integers:");
        n=input.nextInt();
        int[] integers=new int[n];

        for (int i=0;i<n;i++){
            System.out.println("Enter the element 1:");
            integers[i]=input.nextInt();
        }
        Pair pair=new Pair();
        q7 pubclass=new q7();
        q7.Pair inner=new q7.Pair();
        inner.MinMax(integers);
    }
}
