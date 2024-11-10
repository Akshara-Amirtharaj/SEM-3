package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class reverse {
    public static<t> void rev(t array){
        String str=array.toString();
        StringBuilder reversed= new StringBuilder(str);
        reversed.reverse().toString();
        System.out.println(reversed);
    }

    public static void main(String[] args) {
        int array=12564;
        rev(array);
    }

}
