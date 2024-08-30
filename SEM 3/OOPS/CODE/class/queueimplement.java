import java.util.ArrayList;
import java.util.Scanner;

class Queue{
    ArrayList<Integer> q=new ArrayList<>();
    boolean enqueue(int num){
        q.add(num);
        return true;
    }

    int dequeue() {
        if (q.isEmpty()) {
            return -1;
        } else {
            return q.removeFirst();
        }
    }
    void peek(){
            if(q.isEmpty()){
                System.out.println("Queue is empty");
            }
            else{
                System.out.println(q.getFirst());
            }
        }

}
public class queueimplement {
    public static void main(String[] args){
        Queue q1=new Queue();
        Scanner input=new Scanner(System.in);
        while(true){
            System.out.println("(1) Enqueue");
            System.out.println("(2) Dequeue");
            System.out.println("(3) Peek");
            System.out.println("(4) Exit");
            int choice=input.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the number to insert");
                    int num=input.nextInt();
                    if(q1.enqueue(num)){
                        System.out.println("Number is inserted successfully");
                    }
                    else{
                        System.out.println("Queue is full");
                    }
                    break;

                case 2:
                    int r=q1.dequeue();
                    if(r==-1){
                        System.out.println("Queue is empty");
                    }
                    else{
                        System.out.println(r+" is dequeued successfully");
                    }
                    break;

                case 3:
                    q1.peek();
                    break;

                case 4:
                    System.out.println("program has exited");
                    return;
            }
        }
    }

}
