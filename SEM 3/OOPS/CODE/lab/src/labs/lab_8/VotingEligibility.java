package labs.lab_8;
import java.lang.Exception;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}


public class VotingEligibility{

    public static void checker(String dob) throws InvalidAgeException{
        DateTimeFormatter format= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthdate=LocalDate.parse(dob,format);

        LocalDate currentdate=LocalDate.now();

        int age= Period.between(currentdate,birthdate).getYears();

        if(age<18){
            throw new InvalidAgeException("Under 18");
        }
        else{
            System.out.println("Youre elgible for voting");
        }

    }
    public static void main(String[] args) {

    }
}