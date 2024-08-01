interface father{
    int age=58;
    void display();
}
interface mother{
    void talk();
}

class child implements father,mother{
    public void display(){
        int age=2;
        System.out.println(age);
    }
    public void talk(){
        System.out.println("im talking");
    }
}

class son extends child{

}

public class inter {
    public static void main(String[] args){
        child son=new child();
        son.talk();
        son.display();
    }
}
