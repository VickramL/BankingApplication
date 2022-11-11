import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HomePage {
    static Scanner input = new Scanner(System.in);
    String[] admin = new String[2];
    ArrayList<SignUp> signUps = new ArrayList<>();
    HomePage(){
        signUps.add(new SignUp("vikram","Maxstuart2@",new Account("vikram",30001231,
                "8825663983","viky@gmail.com","male",600)));
        signUps.add(new SignUp("manigandan","Mani@1234",new Account("Manigandan",30001232,
                "8825374683","Mani@gmail.com","male",1300)));
        signUps.add(new SignUp("ravi","Password@123",new Account("Ravi Anandh",30001233,
                "9674537846","ravi24@gmail.com","male",3000)));
        for(SignUp signUp: signUps){
            Account account = signUp.getAccount();
            double amount = account.getBalance();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            account.transaction.add("" + formatter.format(date) + "  Credited Rs. + " + amount);
        }
    }

   public void start(){
       while (true){
           System.out.println("\t\t****** SBI ******\n\n");
           System.out.println("[1]. Admin\n[2]. New User\n[3]. Existing User\n[4]. Exit\n");

           int userInput = Validation.inputInt();

           switch (userInput){
               case 1 : {
                   if(isValidAdmin(new String[]{"manager@sbi","Sbi@3640"}))
                       new Account().adminView(signUps);
                   break;
               }
               case 2 : {
                   SignUp signUp = new SignUp();
                   if(signUp.signIn(signUps)){
                       System.out.println("\t\t***** successfully Signed up ******\n");
                       signUps.add(signUp);
                   }
                   else
                       System.out.println("sorry, you exceed the limit...\nTry Again Later\n");
                   break;
               }
               case 3 : {
                   isValidAccount(signUps);
                   break;
               }
               case 4 :{
                   System.out.println("\t\t****** Thank you!!! ******");
                   System.exit(0);
               }
               default:{
                   System.out.println("Invalid Input");
                   break;
               }
           }
       }
   }
   private void isValidAccount(ArrayList<SignUp> signUps){
       System.out.println("\t\t****** Login ******\n\n");

       System.out.print("UserName : ");
       String userName = input.next();
       System.out.print("Password : ");
       input.nextLine();
       String password = input.nextLine();
       boolean flag = true;
       for(SignUp signUp:signUps){
           if(signUp.getUserName().equals(userName) && signUp.getPassword().equals(password)){

               System.out.println("\t\t****** Login Successfully ******\n");
               signUp.getAccount().accountInformation(signUps);
               flag = false;
               break;

           }
       }
       if(flag){
           System.err.println("Invalid Username or Password !!!");
       }

   }
    private boolean isValidAdmin(String [] admin){
        System.out.println("\t\t****** Login ******\n\n");

        System.out.print("UserName : ");
        String userName = input.next();
        System.out.print("Password : ");
        input.nextLine();
        String password = input.nextLine();
//        boolean flag = true;
        if(admin[0].equals(userName) && admin[1].equals(password)){
            System.out.println("\t\t****** Login Successfully ******\n");
            return true;
        }
        else {
            System.err.println("Invalid Username or Password !!!");
            return false;
        }
    }

}
