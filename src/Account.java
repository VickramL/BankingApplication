import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Account {
    private String userName;
    private long accountNumber;
    private String mobileNumber;
    private final String IFSC = "SBIN0046";
    private String email;
    private String gender;
    private double balance;
    private static long accountNumberGenerator  = 30001234;
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> transaction = new ArrayList<>();

    Account(){
        this.accountNumber = accountNumberGenerator++;
    }
    public void accountInformation(Account account, ArrayList<Account> accounts){

        while (true){
            System.out.println("\t\t****** Options ******\n\n");
            System.out.print("[1]. Create Account\n[2]. Withdraw\n[3]. Deposit\n[4]. Transaction History\n" +
                    "[5]. Account Details\n[6]. View Balance\n[7]. Exit\n\n");
            int userInput = Validation.inputInt();

            switch (userInput){

                case 1 : {
                    createAccount();
                    accounts.add(account);
                    System.out.println("\t\t****** Your Account Created Successfully ******\n");
                    break;
                }
                case 2 : {
                    withdraw(account);
                    break;
                }
                case 3 : {
                    deposit(account);
                    break;
                }
                case 4 : {
                    transactionHistory(transaction);
                    break;
                }
                case 5 : {
                    accountDetails(account);
                    break;
                }
                case 6 : {
                    if(account.mobileNumber != null) {
                        System.out.println("Available Balance : " + account.balance);
                    }
                    else
                        System.err.println("You Don't have Account yet.\n create Account ASP");
                    break;
                }
                case 7 : {
                    System.out.println("\t\t****** Thank you ! ******\n");
                    System.exit(0);
                }
                default:{
                    System.err.println("Invalid Input");
                    break;
                }
            }
        }
    }




    public void createAccount(){
        System.out.println("\t\t****** Create Account ******\n\n");
        System.out.print("Name : ");
        userName = scanner.nextLine();
        mobileNumber = Validation.isValidMobileNumber();
        System.out.print("\nEmail : ");
        email = Validation.isValidEmail();
        System.out.println("\nGender : ");
        System.out.println("[1]. Male\n[2]. Female\n[3]. Others\n");
        int userInput = Validation.inputInt();
        boolean flag = true;
        while (flag) {
            switch (userInput) {
                case 1: {
                    gender = "male";
                    System.out.println("Male");
                    flag = false;
                    break;
                }
                case 2: {
                    gender = "female";
                    System.out.println("Female");
                    flag = false;
                    break;
                }
                case 3: {
                    gender = "other";
                    System.out.println("Others");
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Invalid input ");
                    System.out.println("[1]. Male\n[2]. Female\n[3]. Others\n");
                    userInput = Validation.inputInt();
                    break;
                }

            }
        }
        System.out.println("Deposit Initial Amount Minimum Rs.500");
        balance = Validation.isDouble();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        transaction.add(""+formatter.format(date)+"  Credited Rs. + "+balance);
        System.out.println("Your Account Number is "+Account.accountNumberGenerator);

    }

    public void withdraw(Account account){
        System.out.println("\t\t****** Withdraw ******\n\n");
        if(account.mobileNumber != null){
            double amount = Validation.isValidAmount();
            if (account.balance < amount) {
                System.out.println("Insufficient Fund!!!");
            } else {
                System.out.println("Withdraw successful");
                account.balance = account.balance - amount;
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                transaction.add("" + formatter.format(date) + " Debited Rs. - " + amount);
                System.out.println("Available Balance " + account.balance);
            }
        }
        else
            System.err.println("You Don't have Account yet.\n create Account ASP");
    }

    public void deposit(Account account){
        System.out.println("\t\t****** Deposit ******\n\n");
        if(account.mobileNumber != null) {
            double amount = Validation.isValidAmount();
            if (amount < 100) {
                System.out.println("Minimum Deposit Amount is Rs. 100 ");
                deposit(account);
            } else {
                account.balance += amount;
                System.out.println("Deposited Successfully");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                transaction.add("" + formatter.format(date) + "  Credited Rs. + " + amount);
                System.out.println("Available Balance " + account.balance);
            }
        }
        else
            System.err.println("You Don't have Account yet.\n create Account ASP");
    }
    public void transactionHistory(ArrayList<String> transaction){

        if(transaction.size() == 0){
            System.err.println("No Transaction Yet");
            return;
        }
        System.out.println("\t\t****** Transaction History ******\n\n");
        for(String val:transaction){
            System.out.println(val);
        }
        System.out.println("\nAvailable Balance " + balance);
    }

    public void accountDetails(Account account) {
        if (account.mobileNumber != null) {
            System.out.println("\t\t****** Account Details ******\n");
            System.out.printf("%-15s:  %s\n", "Name", account.userName);
            System.out.printf("%-15s:  %d\n", "Account Number", account.accountNumber);
            System.out.printf("%-15s:  %s\n", "Mobile Number", account.mobileNumber);
            System.out.printf("%-15s:  %s\n", "IFSC", account.IFSC);
            System.out.printf("%-15s:  %s\n", "Email", account.email);
            System.out.printf("%-15s:  %s\n", "Gender", account.gender);
            System.out.printf("%-15s:  %s\n\n", "Account Balance", account.balance);

        }
        else {
            System.err.println("You Don't have Account yet.\n create Account ASP");
        }
    }

}
