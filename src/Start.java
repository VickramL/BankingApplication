import java.util.ArrayList;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Start {
    static Scanner input = new Scanner(System.in);
    ArrayList<SignUp> signUps = new ArrayList<>();

    ArrayList<Account> accounts = new ArrayList<>();
//    private String username;
//    private String password;
   public void start(){
       signUps.add(new SignUp("vikram","Maxstuart2@"));
       Account account = new Account();
       while (true){
           System.out.println("\t\t****** SBI ******\n\n");
           System.out.println("[1]. Sign Up\n[2]. Login\n[3]. Exit\n");

           int userInput = Validation.inputInt();

           switch (userInput){
               case 1 : {

                   SignUp signUp = new SignUp();
                   if(signUp.signIn(signUps)){
                       System.out.println("\t\t***** successfully Signed up ******\n");
                       signUps.add(signUp);
                   }
                   else
                       System.out.println("sorry, you exceed the limit...\nTry Again Later\n");
                   break;
               }
               case 2 : {

                   if(isValidAccount(signUps))
                       account.accountInformation(account,accounts);
                   else
                       System.err.println("Invalid Username or Password !!!");


                   break;
               }
               case 3 :{
                   System.out.println("\t\t****** Thank you!!! ******");
                   System.exit(0);
               }
           }
       }
   }
   public static boolean isValidAccount(ArrayList<SignUp> signUps){
       System.out.println("\t\t****** Login ******\n\n");

       System.out.print("UserName : ");
       String userName = input.next();
       System.out.print("Password : ");
       input.nextLine();
       String password = input.nextLine();

       for(SignUp signUp:signUps){
           if(signUp.getUserName().equals(userName) && signUp.getPassword().equals(password)){
               System.out.println("\t\t****** Login Successfully ******\n");
               return true;
           }
       }
       return false;
   }
}
