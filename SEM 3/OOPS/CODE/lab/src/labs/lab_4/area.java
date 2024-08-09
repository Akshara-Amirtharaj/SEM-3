package labs.lab_4;

import java.util.Scanner;

abstract class Shape{
     int dimension1;
     int dimension2;
     abstract void printArea();
}

class Rectangle extends Shape{

    Rectangle(int length,int breadth){
        this.dimension1=length;
        this.dimension2=breadth;
    }

    void printArea(){
        System.out.println("The area of the rectangle is"+ dimension2*dimension1);
    }


}
class Triangle extends Shape{

    Triangle(int height,int width){
        this.dimension1=height;
        this.dimension2=width;
    }

    void printArea(){
        System.out.println("The area of the triangle is"+0.5 * dimension2*dimension1);
    }
}
class Circle extends  Shape{

    Circle(int radius){
        this.dimension1=radius;
        this.dimension2=0;
    }

    void printArea(){
        System.out.println("The area of circle is"+ Math.PI*dimension1);
    }
}
public class area {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("(1) Rectangle");
        System.out.println("(2) Triangle");
        System.out.println("(3) Circle");
        System.out.println("select the shape to find its area");
        int choice=input.nextInt();

        if(choice==1){
            System.out.println("Enter the length:");
            int length=input.nextInt();
            System.out.println("Enter the breadth:");
            int breadth=input.nextInt();
            Rectangle shape=new Rectangle(length,breadth);
            shape.printArea();
        }

        else if(choice==2){
            System.out.println("Enter the height:");
            int height=input.nextInt();
            System.out.println("Enter the width");
            int width=input.nextInt();
            Triangle shape=new Triangle(height,width);
            shape.printArea();
        }
        else if(choice==3){
            System.out.println("Enter the radius");
            int radius=input.nextInt();
            Circle shape=new Circle(radius);
            shape.printArea();
        }
        else{
            System.out.println("Invalid Option!");
        }
    }
}
