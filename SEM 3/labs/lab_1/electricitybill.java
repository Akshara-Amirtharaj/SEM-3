package labs.lab_1;


import java.util.Scanner;

public class electricitybill{
    public static class eb{
        private int consumerNo;
        private String consumerName;
        private int previousMonthReading;
        private int currentMonthReading;
        private String ebConnection;

        public eb(int consumerNo,String consumerName, int previousMonthReading,int currentMonthReading,String ebConnection){
            this.consumerNo=consumerNo;
            this.consumerName=consumerName;
            this.previousMonthReading=previousMonthReading;
            this.currentMonthReading=currentMonthReading;
            this.ebConnection=ebConnection;
        }
    }
    public static double findElectricityBill(String ebConnection, int previousMonthReading,int currentMonthReading){
        int units=previousMonthReading + currentMonthReading;
        double amount;
        if (ebConnection.equals("domestic")){
            if (units<=100){
                amount=units*1;
            }
            else if(units<=200){
                amount=(100*1)+((units-100)*2.50);
            }
            else if(units<=500){
                amount=(100*1)+(100*2.50)+((units-200)*4);
            }
            else{
                amount=(100*1)+(100*2.5)+(300*4)+((units-500)*6);
            }
        }
        else if(ebConnection.equals("commercial")){
            if (units<=100){
                amount=units*2;
            }
            else if(units<=200){
                amount=(100*2)+((units-100)*4.50);
            }
            else if(units<=500){
                amount=(100*2)+(100*4.50)+((units-200)*6);
            }
            else{
                amount=(100*2)+(100*4.5)+(300*6)+((units-500)*8);
            }
        }
        else{
            System.out.println("Invalid chocie");
            return 0;
        }

        return amount;
    }
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        System.out.println("Enter the consumer Number:");
        int consumerNo=input.nextInt();
        System.out.println("Enter the consumer Name:");
        input.nextLine();
        String consumerName=input.nextLine();
        System.out.println("Enter the Previous month reading:");
        int previousMonthReading=input.nextInt();
        System.out.println("Enter the current month reading:");
        int currentMonthReading=input.nextInt();
        System.out.println("Enter the eb connection(domestic or commercial):");
        input.nextLine();
        String ebConnection=input.nextLine();
        eb consumer= new eb(consumerNo,consumerName,previousMonthReading,currentMonthReading,ebConnection);

        System.out.println(findElectricityBill(ebConnection,previousMonthReading,currentMonthReading));
    }

}