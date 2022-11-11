import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignUp {
    private String userName;
    private String password;

    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public SignUp() {
    }

    public SignUp(String userName, String password, Account account) {
        this.userName = userName;
        this.password = password;
        this.account = account;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean signIn(ArrayList<SignUp> signUps) {
        account = new Account();
        account.createAccount();
        System.out.println("\n\t\t ****** Create UserName and Password ******\n\n");
        boolean flag = true;
        while (flag) {
            System.out.print("Enter your userName : ");
            userName = HomePage.input.next();
            HomePage.input.nextLine();
            flag = false;
            for (SignUp signUp : signUps) {
                if (signUp.getUserName().equals(userName)) {
                    System.out.println("This UserName is Already Exist : \n");
                    flag = true;
                    break;
                }
            }
        }
        System.out.print("Enter your password : ");
        password = HomePage.input.nextLine();
        int count = 0;
        while (true) {

            Pattern pattern = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9s])(?=.*[@#$%]).{8,20}$");
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()) {

                return true;
            } else {

                System.out.println("\nPassword must contains at least 1 number,1 capital letter,1 small letter " +
                        "and" + " 1 special character");
                System.out.println(" Example: \"Password123@\"\n");
                System.out.print("Enter Your Password : ");
                password = HomePage.input.next();
                HomePage.input.nextLine();
                count++;
                if (count == 6)
                    return false;
            }
        }


    }


}