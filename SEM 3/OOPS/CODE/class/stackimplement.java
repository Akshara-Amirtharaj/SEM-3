import java.util.Scanner;

class Stack{
    int[] s=new int[10];
    int tos;
    boolean push(int num){
        if (tos==s.length-1){
            return false;
        }
        s[++tos]=num;
        return true;
    }

    int pop(){
        if(tos==-1){
            return -1;
        }
        int element=s[tos];
        tos--;
        return element;
    }

    void peek(){
        if(tos==-1){
            System.out.println("the stack is empty");
        }
        else{
            System.out.println(s[tos]);
        }
    }
    Stack(){
        tos=-1;
    }
}
public class stackimplement {
    public static void main(String[] args){
    Stack s1=new Stack();
    Scanner input=new Scanner(System.in);
    while(true){
        System.out.println("(1) Push");
        System.out.println("(2) Pop");
        System.out.println("(3) Peek");
        System.out.println("(4) Exit");
        int choice=input.nextInt();

        switch (choice){
            case 1:
                System.out.println("Enter the number to insert");
                int num=input.nextInt();
                if(s1.push(num)){
                    System.out.println("Number is inserted successfully");
                }
                else{
                    System.out.println("Stack is full");
                }
                break;

            case 2:
                int r=s1.pop();
                if(r==-1){
                    System.out.println("Stack is empty");
                }
                else{
                    System.out.println(r+"is popped successfully");
                }
                break;

            case 3:
                s1.peek();
                break;

            case 4:
                System.out.println("program has exited");
                return;
        }
    }
    }
}
