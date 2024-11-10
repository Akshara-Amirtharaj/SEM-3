package labs.lab_9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class q2 {
    public static void main(String[] args)  {

        try{
            File contentfile= new File("contentfile.txt");
            File best_performer=new File("best_performer.txt");
            File low_performer=new File("low_performer.txt");
            FileWriter writer1=new FileWriter(best_performer,true);
            FileWriter writer2=new FileWriter(low_performer,true);
            Scanner reader=new Scanner(contentfile);

            while(reader.hasNextLine()){
                String info=reader.nextLine();
                String[] separateinfo=info.split(" ");
                int mark=Integer.parseInt(separateinfo[1]);

                if(mark>90){
                    writer1.write(info +"\n");
                }
                if(mark<40){
                    writer2.write(info+"\n");
                }
;            }
            reader.close();
            writer1.close();
            writer2.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
