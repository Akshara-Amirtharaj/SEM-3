package labs.lab_10;

import java.io.File;
import java.text.SimpleDateFormat;

public class q2 {
    public static void main(String[] args) {
        File obj=new File("readfile.txt");
        long last_modified=obj.lastModified();

        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
        String date= sdf.format(last_modified);

        System.out.println(date);
    }
}
