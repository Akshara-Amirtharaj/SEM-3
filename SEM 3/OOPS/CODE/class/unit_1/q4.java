package unit_1;

import java.util.Scanner;

class Room{
    String RoomType;
    int RoomArea;
    int RoomNo;
    String ACmachine;

    void setdata(String RoomType, int RoomArea,int RoomNo,String ACmachine){
        this.RoomType=RoomType;
        this.RoomArea=RoomArea;
        this.RoomNo=RoomNo;
        this.ACmachine=ACmachine;
    }

    void displaydata(){
        System.out.println("Room NO:"+RoomNo);
        System.out.println("Room Type:"+RoomType);
        System.out.println("Room Area:"+RoomArea);
        System.out.println("AC Machine:"+ACmachine);
    }

}
public class q4 {
    public static void main(String[] args){
       Scanner input=new Scanner(System.in);
        System.out.println("Enter the Room type:");
        String RoomType=input.next();
        System.out.println("Enter the Room Area:");
        int RoomArea=input.nextInt();
        System.out.println("Enter the Room Number:");
        int RoomNo=input.nextInt();
        System.out.println("Ac Machine : yes or no:");
        String Acmachine=input.next();

        Room room=new Room();
        room.setdata(RoomType,RoomArea,RoomNo,Acmachine);
        room.displaydata();
    }
}
