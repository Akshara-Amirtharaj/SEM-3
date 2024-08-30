package unit_1;
import java.util.Scanner;
class Shape{
    void draw(){};
    double calculateArea(){
        return 0;
    };
}

class Circle extends Shape{
    double radius;
    void draw(){
        System.out.println("Circle is drawn");;
    }
    Circle(double radius){
        this.radius=radius;
    }
    double calculateArea(){
        return 3.14*radius*radius;
    }
}

class Cylinder extends Shape{
    double radius;
    double height;

    Cylinder(double radius,double height){
        this.radius=radius;
        this.height=height;
    }
    void draw(){
        System.out.println("Cylinder is drawn");
    }

    @Override
    double calculateArea() {
        return 2*3.14*radius*(radius+height);
    }
}

public class q8 {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        System.out.println("Enter the radius of the circle");
        double circleRadius=input.nextDouble();
        Circle circle= new Circle(circleRadius);
        circle.draw();
        System.out.println("Area of circle is"+circle.calculateArea());

        System.out.println("Enter the radius of cylinder");
        double cylinderRadius=input.nextDouble();
        System.out.println("Enter the height of the cylinder");
        double height=input.nextInt();
        Cylinder cylinder=new Cylinder(cylinderRadius,height);
        cylinder.draw();
        System.out.println("Area of cylinder is"+cylinder.calculateArea());
    }

}
