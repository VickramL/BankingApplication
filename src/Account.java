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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    Scanner scanner = new Scanner(System.in);
    ArrayList<String> transaction = new ArrayList<>();

    Account(){
        this.accountNumber = ++accountNumberGenerator;
    }
    Account(String userName,long accountNumber,String mobileNumber,String email,String gender,double balance){
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.gender = gender;
        this.balance = balance;
    }
    public void accountInformation(ArrayList<SignUp> signUps){

        while (true){
            System.out.println("\t\t****** Options ******\n");
            System.out.print("\n[1]. Withdraw\n[2]. Deposit\n[3]. Money Transfer\n[4]. Transaction History\n" +
                    "[5]. Account Details\n[6]. View Balance\n[7]. Back\n[8]. Exit\n\n");
            int userInput = Validation.inputInt();

            switch (userInput){

                case 1 : {
                    withdraw();
                    break;
                }
                case 2 : {
                    deposit();
                    break;
                }
                case 3 : {
                    moneyTransfer(signUps);
                    break;
                }
                case 4 : {
                    transactionHistory(transaction);
                    break;
                }
                case 5 : {
                    accountDetails();
                    break;
                }
                case 6 : {
                    if(this.mobileNumber != null) {
                        System.out.println("Available Balance : " + this.balance);
                    }
                    else
                        System.err.println("You Don't have Account yet.\n create Account ASP");
                    break;
                }
                case 7:{
                    return;
                }
                case 8 : {
                    System.out.println("\t\t****** Thank you ! ******\n");
                    System.exit(0);
                }
                default:{
                    System.out.println("Invalid Input");
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
                    System.out.println("Male\n");
                    flag = false;
                    break;
                }
                case 2: {
                    gender = "female";
                    System.out.println("Female\n");
                    flag = false;
                    break;
                }
                case 3: {
                    gender = "other";
                    System.out.println("Others\n");
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
        this.balance = Validation.getBalance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        transaction.add(""+formatter.format(date)+"  Credited Rs. + "+balance);
        System.out.println(this.balance);
        System.out.println("\t\t****** Your Account Created Successfully ******");
        System.out.println("\t\t****** Your Account Number is "+(Account.accountNumberGenerator)+" ******\n");

    }

    public void withdraw(){
        System.out.println("\t\t****** Withdraw ******\n\n");
        if(this.mobileNumber != null){
            double amount = Validation.isValidAmount();
            if (this.balance < amount) {
                System.out.println("Insufficient Fund!!!");
            } else {
                System.out.println("Withdraw successful");
                this.balance = this.balance - amount;
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                transaction.add("" + formatter.format(date) + " Debited Rs. - " + amount);
                System.out.println("Available Balance " + this.balance+"\n");
            }
        }
        else
            System.err.println("You Don't have Account yet.\n create Account ASP");
    }

    public void deposit(){
        System.out.println("\t\t****** Deposit ******\n\n");
        if(this.mobileNumber != null) {
            double amount = Validation.isValidAmount();
            if (amount < 100) {
                System.out.println("Minimum Deposit Amount is Rs. 100 ");
                deposit();
            } else {
                this.balance += amount;
                System.out.println("Deposited Successfully");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                transaction.add("" + formatter.format(date) + "  Credited Rs. + " + amount);
                System.out.println("Available Balance " + this.balance);
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
        System.out.println("\nAvailable Balance " + this.balance);
    }

    public void accountDetails() {
        if (this.mobileNumber != null) {
            System.out.println("\t\t****** Account Details ******\n");
            System.out.printf("%-15s:  %s\n", "Name", this.userName);
            System.out.printf("%-15s:  %d\n", "Account Number", this.accountNumber);
            System.out.printf("%-15s:  %s\n", "Mobile Number", this.mobileNumber);
            System.out.printf("%-15s:  %s\n", "IFSC", this.IFSC);
            System.out.printf("%-15s:  %s\n", "Email", this.email);
            System.out.printf("%-15s:  %s\n", "Gender", this.gender);
            System.out.printf("%-15s:  %s\n\n", "Account Balance", this.balance);

        }
        else {
            System.err.println("You Don't have Account yet.\n create Account ASP");
        }
    }

    public void adminView(ArrayList<SignUp> signUps){
        while (true){
            System.out.println("\t\t****** HOME ******\n");
            System.out.println("[1]. Accounts\n[2]. Back\n[3]. Exit\n\n");
            int userInput = Validation.inputInt();

            switch (userInput){
                case 1 : {
                    userAccounts(signUps);
                    break;
                }
                case 2 : {
                    return;
                }
                case 3 : {
                    System.out.println("\t\t****** Thank You ******");
                    System.exit(0);
                }
                default:{
                    System.out.println("Invalid Input");
                    break;
                }
            }
        }
    }
    public void userAccounts(ArrayList<SignUp> signUps){
        System.out.println("+_____________________________________________________________________________________________+");
        System.out.printf("| %-15s| %-17s| %-17s| %-20s| %-15s|","Name","Account Number","Mobile Number","Email","Balance");
        System.out.println("\n+_____________________________________________________________________________________________+");
        for (SignUp signUp:signUps){
            Account account = signUp.getAccount();
            System.out.printf("| %-15s| %-17d| %-17s| %-20s| %-15.2f|\n",account.getUserName(),account.getAccountNumber(),
                    account.getMobileNumber(),account.getEmail(),account.getBalance());
        }
        System.out.println("+_____________________________________________________________________________________________+\n");
    }

    public void moneyTransfer(ArrayList<SignUp> signUps){
        long AccountNumber = Validation.inputLong();
        if(AccountNumber == accountNumber){
            System.out.println("\nSelf Transfer is Not Allowed\n");
            return;
        }
        boolean flag = true;
        for (SignUp signUp:signUps){
            Account account = signUp.getAccount();
            if(account.getAccountNumber() == AccountNumber){
                flag = false;
                System.out.println("Account Holder Name : "+account.getUserName());
                System.out.println("[1]. Continue\n[2]. Cancel\n");
                int userInput = Validation.inputInt();
                if(userInput == 1){
                    double amount = Validation.isValidAmount();
                    if(this.balance>=amount){
                        account.setBalance(account.getBalance()+amount);
                        this.balance -= amount;
                        System.out.println("Available Balance : Rs."+this.balance);
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Date date = new Date();
                        transaction.add("" + formatter.format(date) + " Transferred Rs. - " + amount);
                        account.transaction.add("" + formatter.format(date) + " By Transferred Rs. + " + amount);
                        System.out.println("\t\t****** Transaction Successful ******\n");
                        break;
                    }
                    else
                    {
                        System.out.println("Insufficient Fund");
                        break;
                    }
                }
                else if(userInput == 2) {
                    System.out.println("\t\t****** Transaction Cancelled ******\n");
                    return;
                }
                else {
                    System.out.println("Invalid Input");
                    return;
                }
            }
        }
        if(flag)
            System.out.println("Invalid Account Number");
    }



}
