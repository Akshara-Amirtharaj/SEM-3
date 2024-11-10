package labs.lab_11;

class weatherthread extends Thread{
    String message;

    weatherthread(String message){
        this.message=message;
    }

    public void run() {
        try {
            for(int i=0; i<5;i++){
                System.out.println(message+ "-"+ getName());
                weatherthread.sleep(1000);
            }
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
public class q1 {
    public static void main(String[] args) {
        weatherthread thread1=new weatherthread("Today is hot, humid, and sunny");
        weatherthread thread2=new weatherthread("Today is hot, humid, and sunny");

        thread1.start();
        thread2.start();
    }
}
