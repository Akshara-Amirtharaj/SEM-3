package model;

public class palindrome{

    public static<t> boolean check(t array){
        String str=array.toString();

        int left=0;
        int right=str.length()-1;

        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String array="";
        if(check(array)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }

    }
}