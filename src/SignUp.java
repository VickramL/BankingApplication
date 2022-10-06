import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignUp {
    private String userName;
    private String password;


    public SignUp(){}
    public SignUp(String userName,String password){
        this.userName = userName;
        this.password = password;
    }
    public boolean signIn(ArrayList<SignUp> signUps){
        System.out.print("Enter your userName : ");
        userName = Start.input.next();
        Start.input.nextLine();
        System.out.print("Enter your password : ");
        password = Start.input.nextLine();
        int count = 0;
        while (true){

            Pattern pattern = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9s])(?=.*[@#$%]).{8,20}$");
            Matcher matcher = pattern.matcher(password);
            if(matcher.matches()){
//                        System.out.println(matcher.find());
                return true;
            }
            else {
//                        System.out.println(matcher.find());
                System.out.println("\nPassword must contains at least 1 number,1 capital letter,1 small letter " +
                        "and" + " 1 special character");
                System.out.println(" Example: \"Password123@\"\n");
                System.out.print("Enter Your Password : ");
                password = Start.input.next();
                Start.input.nextLine();
                count++;
                if(count == 6)
                    return false;
            }
        }


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
//    public String isValidUsername(String username,ArrayList<SignUp> signUps){
//        boolean flag = true;
//        for(SignUp signUp:signUps){
//            if(signUp.getUserName().equals(userName)){
//                System.out.println("UserName Already Exist, Try Another userName ");
//                flag = false;
//                System.out.print("UserName ");
//                username = Start.input.nextLine();
//                isValidUsername(username,signUps);
//            }
//        }
//        if (flag){
//            return username;
//        }
//        else
//            return "";
//    }
}
