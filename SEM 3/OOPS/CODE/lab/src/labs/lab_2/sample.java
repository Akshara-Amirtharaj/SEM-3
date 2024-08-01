package labs.lab_2;

import java.util.Scanner;
public class sample{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        while (true){
            int choice;
            System.out.println("(1) Currency converter");
            System.out.println("(2) Distance converter");
            System.out.println("(3) Time converter");
            System.out.println("(4) exit");
            System.out.println("Enter your choice");
            choice=input.nextInt();

            switch (choice){
                case 1:

                    double amount;
                    System.out.println("(1) Dollar to INR");
                    System.out.println("(2) EURO to INR");
                    System.out.println(("(3) yen to INR"));
                    System.out.println("(4) INR to Dollar");
                    System.out.println("(5) INR to EURO ");
                    System.out.println(("(6) INR to yen "));
                    System.out.println("enter your choice");
                    int c=input.nextInt();
                    currency amt =new currency();
                    System.out.println("Enter the amount");
                    amount=input.nextDouble();
                    if(c==1){
                        System.out.println(amt.dollar_to_inr(amount));
                    }
                    else if (c==2){
                        System.out.println(amt.euro_to_inr(amount));
                    }
                    else if (c==3){
                        System.out.println(amt.yen_to_inr(amount));
                    }
                    else if(c==4){
                        System.out.println(amt.inr_to_dollar(amount));
                    }
                    else if(c==5){
                        System.out.println(amt.inr_to_euro(amount));
                    }
                    else if(c==6){
                        System.out.println(amt.inr_to_yen(amount));
                    }
                    else{
                        System.out.println("invalid");
                    }
                    break;

                case 2:
                    int c2;
                    double distance1;
                    System.out.println("(1) Meters to kilometers");
                    System.out.println("(2) miles to kilometer");
                    System.out.println("(3) kilometers to meters");
                    System.out.println("(4) kilometers to miles");
                    System.out.println("Enter your choice");
                    c2=input.nextInt();
                    distance1=input.nextDouble();
                    distance dis=new distance();
                    if(c2==1){
                        System.out.println(dis.meter_km(distance1));
                    }
                    else if(c2==2){
                        System.out.println(dis.miles_km(distance1));
                    }
                    else if(c2==3){
                        System.out.println(dis.km_meter(distance1));
                    }
                    else if(c2==4){
                        System.out.println(dis.km_miles(distance1));
                    }
                    else {
                        System.out.println("invalid");
                    }
                    break;
                case 3:
                    int c3;
                    double time1;
                    time ti=new time();
                    System.out.println("(1) hour to minute");
                    System.out.println("(2) hour to second");
                    System.out.println("(3) minute to hour");
                    System.out.println("(4) second to hour");
                    System.out.println("Enter your choice");
                    c3=input.nextInt();
                    System.out.println("Enter the time:");
                    time1=input.nextDouble();

                    if(c3==1){
                        System.out.println(ti.hour_min(time1));
                    }
                    else if(c3==2){
                        System.out.println(ti.hour_sec(time1));
                    }
                    else if(c3==3){
                        System.out.println(ti.min_hour(time1));
                    }
                    else if(c3==4){
                        System.out.println(ti.sec_hour(time1));
                    }
                    else {
                        System.out.println("invalid");
                    }
                    break;
                case 4:
                    return ;
                default:
                    System.out.println("invalid");
            }
        }
    }
}
