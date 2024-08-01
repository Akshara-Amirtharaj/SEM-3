abstract class computer{
   void display(){
       System.out.println("girg");
   }
}
// object cannot be created for abstract class
class hp extends computer{
    void display(){
        System.out.println("hello hp");
    }
}
public class abs {
    public static void main(String[] args){


        hp obj=new hp();
        obj.display();


    }
}
