import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class details{
    String Name;
    double RegistrationNo;
    int Batch;
    double PhNo;
    String Department;

    void SetDetails(String Name,double RegistrationNo,int Batch,double PhNo,String Department) {
        this.Name = Name;
        this.RegistrationNo = RegistrationNo;
        this.Batch = Batch;
        this.PhNo = PhNo;
        this.Department=Department;
    }
    void display(){
        System.out.println("Name:"+Name);
        System.out.println("Department:"+Department);
        System.out.println("Registration Number:"+ RegistrationNo);
        System.out.println("Batch:"+Batch);
        System.out.println("Phone Number"+ PhNo);
    }
}
class cse extends details{
    String Name;
    double RegistrationNo;
    int Batch;
    double PhNo;
    String Department;
    String Specialization;

    void SetDetails(String Name,double RegistrationNo,int Batch,double PhNo,String Department,String Specialization) {
        this.Name = Name;
        this.RegistrationNo = RegistrationNo;
        this.Batch = Batch;
        this.PhNo = PhNo;
        this.Department=Department;
        this.Specialization=Specialization;
    }
    void display(){
        System.out.println("Name:"+Name);
        System.out.println("Department:"+Department);
        System.out.println("Specialization"+ Specialization);
        System.out.println("Registration Number:"+ RegistrationNo);
        System.out.println("Batch:"+Batch);
        System.out.println("Phone Number"+ PhNo);

    }
}
class biomedical extends details{}
class chemical extends details{}
class eee extends details{}
class ece extends details{}

class aids extends cse{}
class iot extends cse{}
class cyber extends  cse{}

public class university {

    public static void main(String[] args) {

        List<details> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        while (true) {

            System.out.println("(1) Add students");
            System.out.println(("(2) Display details"));
            System.out.println("(3) Exit");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("(1) Computer Science");
                    System.out.println("(2) Biomedical");
                    System.out.println("(3) Chemical");
                    System.out.println("(4) EEE");
                    System.out.println("(5) ECE");
                    System.out.println("Choose your department");
                    int dept = input.nextInt();

                    if (dept == 1) {
                        System.out.println("Enter your Name");
                        input.nextLine();
                        String Name = input.nextLine();
                        System.out.println("Enter your Registration Number");
                        double RegistrationNo = input.nextInt();
                        System.out.println("Enter your batch");
                        int Batch = input.nextInt();
                        System.out.println("Enter your phone number");
                        double PhNo = input.nextInt();





                        System.out.println("(1) AIDS");
                        System.out.println("(2) IOT");
                        System.out.println("(3) CYBER");
                        int cho=input.nextInt();

                        if(cho==1){
                            aids name=new aids();
                            name.SetDetails(Name, RegistrationNo, Batch, PhNo,"Computer Science","AIDS");
                            students.add(name);
                        }
                        else if(cho==2){
                            iot name=new iot();
                            name.SetDetails(Name, RegistrationNo, Batch, PhNo,"Computer Science","IOT");
                            students.add(name);
                        }
                        else if(cho==3){
                            cyber name=new cyber();
                            name.SetDetails(Name, RegistrationNo, Batch, PhNo,"Computer Science","Cyber");
                            students.add(name);
                        }


                    } else if (dept == 2) {
                        System.out.println("Enter your Name");
                        input.nextLine();
                        String Name = input.nextLine();
                        System.out.println("Enter your Registration Number");
                        double RegistrationNo = input.nextInt();
                        System.out.println("Enter your batch");
                        int Batch = input.nextInt();
                        System.out.println("Enter your phone number");
                        double PhNo = input.nextInt();

                        biomedical name = new biomedical();
                        students.add(name);

                        name.SetDetails(Name, RegistrationNo, Batch, PhNo,"Biomedical");
                    } else if (dept == 3) {
                        System.out.println("Enter your Name");
                        input.nextLine();
                        String Name = input.nextLine();
                        System.out.println("Enter your Registration Number");
                        double RegistrationNo = input.nextInt();
                        System.out.println("Enter your batch");
                        int Batch = input.nextInt();
                        System.out.println("Enter your phone number");
                        double PhNo = input.nextInt();

                        chemical name = new chemical();
                        students.add(name);

                        name.SetDetails(Name, RegistrationNo, Batch, PhNo,"Chemical");
                    } else if (dept == 4) {
                        System.out.println("Enter your Name");
                        input.nextLine();
                        String Name = input.nextLine();
                        System.out.println("Enter your Registration Number");
                        double RegistrationNo = input.nextInt();
                        System.out.println("Enter your batch");
                        int Batch = input.nextInt();
                        System.out.println("Enter your phone number");
                        double PhNo = input.nextInt();

                        eee name = new eee();
                        students.add(name);

                        name.SetDetails(Name, RegistrationNo, Batch, PhNo,"EEE");
                    } else if (dept == 5) {
                        System.out.println("Enter your Name");
                        input.nextLine();
                        String Name = input.nextLine();
                        System.out.println("Enter your Registration Number");
                        double RegistrationNo = input.nextInt();
                        System.out.println("Enter your batch");
                        int Batch = input.nextInt();
                        System.out.println("Enter your phone number");
                        double PhNo = input.nextInt();

                        ece name = new ece();
                        students.add(name);

                        name.SetDetails(Name, RegistrationNo, Batch, PhNo,"ECE");
                    } else {
                        System.out.println("Invalid option");
                    }
                    break;
                case 2:
                    for (details s : students) {
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
