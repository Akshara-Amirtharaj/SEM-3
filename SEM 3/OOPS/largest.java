public class largest {
    public static void main(String[] args){

    
       int[] numbers={1,34,5,34,6};
       int max=findlargest(numbers);
       System.out.println("The largest number is:" + max);

        
    }
    public static int findlargest(int[] numbers){
        int largest=numbers[0];

        for(int i=0;i<numbers.length;i++)
        {
            if (numbers[i]>largest){
                largest=numbers[i];
            }
        }
        return largest;  
    }
}
