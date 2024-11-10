package model;



public class oddeven {
    public static<t extends Number> void sum(t[] array){
        double oddsum=0,evensum=0;
        for(int i=0;i<array.length;i++){
            if(i%2==0){
                evensum+=array[i].doubleValue();
            }
            else{
                oddsum+=array[i].doubleValue();
            }
        }
        System.out.println("odd sum:"+oddsum);
        System.out.println("even sum:"+evensum);
    }
}
