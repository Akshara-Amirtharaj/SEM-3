package labs.lab_4;

class animal{
    void display(){
        System.out.println("In the parent class");
    }
}

class dog extends animal{
    void display(){
        System.out.println("in the subclass");
    }
}
public class methodoverriding {
    public static void main(String[] args){
        dog puppy=new dog();
        puppy.display();
    }
}
