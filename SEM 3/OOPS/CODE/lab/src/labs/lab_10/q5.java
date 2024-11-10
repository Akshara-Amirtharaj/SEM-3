package labs.lab_10;

import java.io.File;

public class q5 {
    public static void main(String[] args) {
        File obj=new File("readfile.txt");
        if(obj.canRead()){
            System.out.println("Readable");
        }
        else{
            System.out.println("Not readable");
        }
    }
}
