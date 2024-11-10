package labs.lab_11;

import java.util.ArrayList;

public class q4 {
    public static <t extends Number> void sum(t[] array){
        int oddsum=0;
        int evensum=0;
        for(t element:array){

            if((element.intValue() % 2) == 0){
                evensum+=element.intValue();
            }
            else{
                oddsum+=element.intValue();
            }
        }
        System.out.println("Sum of odd numbers:"+oddsum);
        System.out.println("Sum of even numbers:"+evensum);
    }


    public static void main(String[] args) {
       Integer[] array={1,2,3,4,5,5,6,5};

        sum(array);
    }
}
