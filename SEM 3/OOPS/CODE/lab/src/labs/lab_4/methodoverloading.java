package labs.lab_4;

class addition{
    void sum(int num1,int num2){
        System.out.println("The sum of 2 numbers is:"+num1+num2);
    }
    void sum(int num1,int num2,int num3){
        System.out.println("The sum of 3 numbers is:"+num1+num2+num3);
    }
}
public class methodoverloading {
    public static void main(String[] args){
        addition add=new addition();
        add.sum(4,5,6);
        add.sum(4,5);
    }
}
