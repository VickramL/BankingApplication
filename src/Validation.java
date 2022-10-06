import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validation {

    public static int inputInt(){
//        Scanner scanner = new Scanner(System.in);
        try {
            int value = Start.input.nextInt();
            return value;
        }catch (Exception e){
            System.err.println("Input Contains Only numbers");
            Start.input.nextLine();
        }
        return 0;
    }
    public static String isValidMobileNumber(){
        System.out.print("\nMobile Number : ");
        Start.input.nextLine();
        try {
            String mobileNumber = Start.input.nextLine();
            Pattern pattern = Pattern.compile("^\\d{10}$");
            Matcher matcher = pattern.matcher(mobileNumber);
            if(matcher.find()) {
                return mobileNumber;
            }else {
                throw new Exception("InvalidMobileNumberException");
            }
        }catch (Exception e){
            System.err.println("Invalid Mobile Number !!! ");
            System.out.print("\nMobile Number : ");
            Start.input.nextLine();
        }
        return "";
    }

    public static String isValidEmail() {
        boolean flag = true;

        while (flag) {
            //System.out.print("Enter email (will be set as default email):");
            String email = Start.input.nextLine();
            String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(email);
            if (m.matches())
                return email;
            else {
                System.err.println("Invalid email try again !!! ");
                System.out.print("\nEmail : ");
            }
        }
        return "";
    }

    public static double isDouble(){
        System.out.print("Amount : ");
        try {
            double amount = Start.input.nextDouble();
            if(amount <500){
                System.out.println("Minimum Deposit Amount is 500 ");
                isDouble();
            }else {

                return amount;
            }
        }catch (Exception e){
            System.err.println("Invalid Input ");
            Start.input.nextLine();
            isDouble();
        }
        return 0;
    }

    public static double isValidAmount(){
        System.out.print("Enter Amount : ");
        try {
            double amount = Start.input.nextDouble();
            return amount;
        }catch (Exception e){
            System.err.println("Invalid input");
            isValidAmount();
        }
        return 0;
    }
}
