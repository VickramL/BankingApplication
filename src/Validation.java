import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validation {

    public static int inputInt(){
        try {
            int value = HomePage.input.nextInt();
            return value;
        }catch (Exception e){
            System.out.println("Input Contains Only numbers");
            HomePage.input.nextLine();
        }
        return 0;
    }
    public static String isValidMobileNumber(){
        HomePage.input.nextLine();
        while (true) {
                System.out.print("\nMobile Number : ");
                String mobileNumber = HomePage.input.nextLine();
                Pattern pattern = Pattern.compile("^[0-9]{10}$");
                Matcher matcher = pattern.matcher(mobileNumber);
                if (matcher.find()) {
                    return mobileNumber;
                } else {
                    System.out.println("\nInvalid Mobile Number");
                }
        }
    }

    public static String isValidEmail() {
        boolean flag = true;

        while (flag) {
            //System.out.print("Enter email (will be set as default email):");
            String email = HomePage.input.nextLine();
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

    public static double getBalance(){
       while (true) {
           try {
               System.out.print("Amount : ");
               double amount = HomePage.input.nextDouble();
               if (amount < 500) {
                   System.out.println("\nMinimum Deposit Amount is 500 ");
               } else {
                   return amount;
               }
           } catch (Exception e) {
               System.out.println("\nInvalid Input ");
               HomePage.input.next();
           }
       }

    }

    public static double isValidAmount(){
        while (true) {
            try {
                System.out.print("Enter Amount : ");
                double amount = HomePage.input.nextDouble();
                return amount;
            } catch (Exception e) {
                System.out.println("\nInvalid input\n");
                HomePage.input.next();

            }
        }
    }

    public static long inputLong(){
        while (true) {
            try {
                System.out.print("Enter Account Number : ");
                long amount = HomePage.input.nextLong();
                return amount;
            } catch (Exception e) {
                System.out.println("\nInvalid input\n");
                HomePage.input.next();

            }
        }
    }
}
