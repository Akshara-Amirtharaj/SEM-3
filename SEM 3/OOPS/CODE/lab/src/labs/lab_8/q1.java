import java.util.*;

class EvenIDAgeLessThan30 extends Exception {
    EvenIDAgeLessThan30(String message) {
        super(message);
    }
}

class OddIDAgeMoreThan30 extends Exception {
    OddIDAgeMoreThan30(String message) {
        super(message);
    }
}

class party {

    // Make ArrayLists static to persist across all instances
    static ArrayList<Integer> hall1ages = new ArrayList<>();
    static ArrayList<Integer> hall2ages = new ArrayList<>();
    static ArrayList<Integer> hall3ages = new ArrayList<>();
    
    int emp_id;
    int age;

    party(int emp_id, int age) {
        this.emp_id = emp_id;
        this.age = age;
    }

    void allotHall() throws EvenIDAgeLessThan30, OddIDAgeMoreThan30 {
        if ((emp_id % 2 == 0) && (age < 30)) {
            System.out.println("Welcome to party hall 1!");
            hall1ages.add(age);
        } else if ((emp_id % 2 != 0) && (age > 30)) {
            System.out.println("Welcome to party hall 2!");
            hall2ages.add(age);
        } else {
            System.out.println("Welcome to party hall 3!");
            hall3ages.add(age);
        }
    }

    void findaverage() {
        if (hall1ages.isEmpty()) {
            System.out.println("Hall 1: No employees");
        } else {
            double hall1avg = 0;
            for (Integer age : hall1ages) {
                hall1avg += age;
            }
            System.out.println("Hall 1 average age: " + hall1avg / hall1ages.size());
        }

        if (hall2ages.isEmpty()) {
            System.out.println("Hall 2: No employees");
        } else {
            double hall2avg = 0;
            for (Integer age : hall2ages) {
                hall2avg += age;
            }
            System.out.println("Hall 2 average age: " + hall2avg / hall2ages.size());
        }

        if (hall3ages.isEmpty()) {
            System.out.println("Hall 3: No employees");
        } else {
            double hall3avg = 0;
            for (Integer age : hall3ages) {
                hall3avg += age;
            }
            System.out.println("Hall 3 average age: " + hall3avg / hall3ages.size());
        }
    }
}

public class q1 {
    public static void main(String[] args) throws EvenIDAgeLessThan30, OddIDAgeMoreThan30 {

        Scanner input = new Scanner(System.in);
        boolean addemployee = true;

        while (addemployee) {
            try {
                System.out.println("Enter your Id:");
                int emp_id = input.nextInt();
                System.out.println("Enter your age:");
                int age = input.nextInt();

                party p = new party(emp_id, age);
                p.allotHall();
                p.findaverage();

                System.out.println("Do you want to add another employee? (yes/no)");
                String answer = input.next();
                addemployee = answer.equalsIgnoreCase("yes");
            } catch (EvenIDAgeLessThan30 | OddIDAgeMoreThan30 e) {
                System.out.println("Exception: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Exception has occurred");
            }
        }

        input.close();
    }
}
