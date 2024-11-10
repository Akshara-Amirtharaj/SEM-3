package labs.lab_10;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class q3 {
    public static void main(String[] args) {
        File obj=new File("akshara.txt");
        obj.renameTo(new File("aksh"));
    }
}
