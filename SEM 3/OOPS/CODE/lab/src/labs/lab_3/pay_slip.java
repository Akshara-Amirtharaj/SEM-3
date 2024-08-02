package labs.lab_3;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Employee{
    String Emp_name;
    int Emp_id;
    String Address;
    String Mail_id;
    double Mobile_no;
    double BasicPay;

    double DA(double BasicPay){
        return 0.97*BasicPay;
    }
    double HRA(double BasicPay){
        return 0.10*BasicPay;
    }
    double PF(double BasicPay){
        return 0.12*BasicPay;
    }
    double SCF(double BasicPay){
        return 0.01*BasicPay;
    }

    void set_details(String Emp_name, int Emp_id, String Address, String Mail_id, double Mobile_no, double BasicPay){
        this.Emp_name=Emp_name;
        this.Emp_id=Emp_id;
        this.Address=Address;
        this.Mail_id=Mail_id;
        this.Mobile_no=Mobile_no;
        this.BasicPay=BasicPay;
    }

    void display(){
        System.out.println("Employee Details:"+Emp_name);
        System.out.println("Employee ID"+ Emp_id);
        System.out.println("Address:"+ Address);
        System.out.println(("Mail ID"+Mail_id));
        System.out.println("Mobile No:"+Mobile_no);
        System.out.println("Dearness Allowance:"+DA(BasicPay));
        System.out.println("House Rent Allowance"+ HRA(BasicPay));
        System.out.println("Provident Fund:"+PF(BasicPay));
        System.out.println("Staff Club Fund"+SCF(BasicPay));
        System.out.println("Basic pay"+BasicPay);
    }
}

class Programmer extends Employee{
    double BasicPay;
}
class AssistantProfessor extends Employee{
    double BasicPay;
}
class AssociateProfessor extends Employee{
    double BasicPay;
}
class Professor extends  Employee{
    double BasicPay;
}
public class pay_slip {
    public static void main(String[] args){

        List<Employee> ListEmployees = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        while (true) {

            System.out.println("(1) Add Employee");
            System.out.println(("(2) Display details"));
            System.out.println("(3) Exit");
            int choice = input.nextInt();

            switch (choice){

                case 1:

                    System.out.println("(1) Programmer");
                    System.out.println("(2) Assistant Professor");
                    System.out.println("(3) Associate Professor");
                    System.out.println("(4) Professor");
                    System.out.println("(5) Enter your choice");
                    int ch=input.nextInt();

                    if (ch==1){
                        input.nextLine();
                        System.out.println("Enter the name of the employee");
                        String name=input.nextLine();
                        System.out.println("Enter the Address");
                        String Address=input.nextLine();
                        System.out.println("Enter the Mail ID");
                        String MailID=input.nextLine();
                        System.out.println("Enter Employee ID");
                        int emp_id=input.nextInt();
                        System.out.println("Enter the phone number");
                        double PhNo=input.nextDouble();
                        System.out.println("Enter the basic pay");
                        double BasicPay=input.nextDouble();

                        Programmer prog=new Programmer();
                        prog.set_details(name,emp_id,Address,MailID,PhNo,BasicPay);
                        ListEmployees.add(prog);
                    }
                    else if (ch==2){
                        input.nextLine();
                        System.out.println("Enter the name of the employee");
                        String name=input.nextLine();
                        System.out.println("Enter the Address");
                        String Address=input.nextLine();
                        System.out.println("Enter the Mail ID");
                        String MailID=input.nextLine();
                        System.out.println("Enter Employee ID");
                        int emp_id=input.nextInt();
                        System.out.println("Enter the phone number");
                        double PhNo=input.nextDouble();
                        System.out.println("Enter the basic pay");
                        double BasicPay=input.nextDouble();

                        AssistantProfessor prog=new AssistantProfessor();
                        prog.set_details(name,emp_id,Address,MailID,PhNo,BasicPay);
                        ListEmployees.add(prog);

                    }
                    else if (ch==3){
                        input.nextLine();
                        System.out.println("Enter the name of the employee");
                        String name=input.nextLine();
                        System.out.println("Enter the Address");
                        String Address=input.nextLine();
                        System.out.println("Enter the Mail ID");
                        String MailID=input.nextLine();
                        System.out.println("Enter Employee ID");
                        int emp_id=input.nextInt();
                        System.out.println("Enter the phone number");
                        double PhNo=input.nextDouble();
                        System.out.println("Enter the basic pay");
                        double BasicPay=input.nextDouble();

                        AssociateProfessor prog= new AssociateProfessor();
                        prog.set_details(name,emp_id,Address,MailID,PhNo,BasicPay);
                        ListEmployees.add(prog);
                    }
                    else if(ch==4){
                        input.nextLine();
                        System.out.println("Enter the name of the employee");
                        String name=input.nextLine();
                        System.out.println("Enter the Address");
                        String Address=input.nextLine();
                        System.out.println("Enter the Mail ID");
                        String MailID=input.nextLine();
                        System.out.println("Enter Employee ID");
                        int emp_id=input.nextInt();
                        System.out.println("Enter the phone number");
                        double PhNo=input.nextDouble();
                        System.out.println("Enter the basic pay");
                        double BasicPay=input.nextDouble();

                        Professor prog=new Professor();
                        prog.set_details(name,emp_id,Address,MailID,PhNo,BasicPay);
                        ListEmployees.add(prog);
                    }
                    else{
                        System.out.println("Invalid option");
                    }
                    break;

                case 2:
                    for (Employee s : ListEmployees) {
                        s.display();
                        System.out.println("--------------------");
                    }
                    break;

                case 3:
                    return ;
                default:
                    System.out.println("Please enter valid option");


            }

        }

    }
}


