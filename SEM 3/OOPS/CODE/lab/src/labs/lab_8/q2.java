import java.util.Scanner;
 class AgeUnder18Exception extends Exception{
    public AgeUnder18Exception(){
        super("You're under 18");
    }
}
public class q2 {
    public static void main(String[] args) throws AgeUnder18Exception{
        Scanner input =new Scanner(System.in);

        System.out.println("Enter your DOB(dd/mm/yyyy)");
        String dob=input.next();
        
        //25/05/2006
        voting v=new voting();
        int age=v.checker(dob);
        v.votechecker(age);
        
    }
}
class voting{
    int checker(String dob){
        String sdate=dob.substring(0,2);
        String smonth=dob.substring(3,5);
        String syear=dob.substring(6);

        int date =Integer.parseInt(sdate);
        int month=Integer.parseInt(smonth);
        int year=Integer.parseInt(syear);

        int cdate=6;
        int cmonth=9;
        int cyear=2024;

        int age=0;

        if(month==cmonth){
            if(date<=cdate){
                age=cyear-year;
                return age;
            }
            age=cyear-1-year;
            return age;
        }
        else if(month<cmonth){
            age=cyear-year;
            return age;
        }
        else{
            age=cyear-year-1;
            return age;
        }

    }
    void votechecker(int age) throws AgeUnder18Exception{
        if(age<18){
            throw new AgeUnder18Exception();
        }
        else{
            System.out.println("You're Elgible for voting!");
        }
    }
   
}
