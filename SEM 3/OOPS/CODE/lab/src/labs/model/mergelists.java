package model;

import java.util.ArrayList;
import java.util.List;

public class mergelists {
    public static <t> void merge(List<t> list1,List<t> list2){
        ArrayList<t> mergedlist=new ArrayList<>(list1);
        mergedlist.addAll(list2);
        System.out.println("Merged List:"+mergedlist);
    }

    public static void main(String[] args) {
        List<Integer> lst1= List.of(1,2,3);
        List<Integer> lst2= List.of(4,4);
        merge(lst1,lst2);
    }
}