private class animal{
     void walk(){
        System.out.println("i can walk");
    }
}

class dog extends animal{
    void bark(){
        System.out.println("i can bark");
    }

}

class puppy extends dog{
    void walk(){
        System.out.println("i cant walk");
    }
}

public class inheriancecon {
    public static void main(String[] args){
        dog dog1=new dog();
        dog1.bark();
        dog1.walk();

        puppy pup=new puppy();
        pup.walk();
        pup.bark();
    }
}
