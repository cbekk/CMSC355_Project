//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    String result = Userlogin();
    System.out.println(result);
    String SelectedOption = Purpose();
    System.out.println(SelectedOption);
    String[] choise = RequestPrescription();
        System.out.println(Arrays.toString(choise));
    }
    public static String Userlogin(){
        Scanner Login = new Scanner(System.in);
        String Usernamebase = "Botime";
        String Passwordbase = "Goodfries";
        String username = "";
        String password = "";
        int usernum = 0;
        int passnum = 0;
        while (!Usernamebase.equals(username) || !Passwordbase.equals(password)) {
            usernum = 0;
            passnum = 0;
            System.out.println("Enter your username: ");
             username = Login.nextLine();
            System.out.println("Enter your password: ");
             password = Login.nextLine();
            if (!username.equalsIgnoreCase(Usernamebase)) {
                usernum = 1;
            }
            if (!password.equals(Passwordbase)) {
                passnum = 1;
            }
            int decidingnum = passnum + usernum;
            if(decidingnum == 0){
                System.out.println("You are logged in!");
            }
            else{
                System.out.println("Username or password incorrect. Please try again.");
            }
        }
        return "successful";
    }
    public static String Purpose(){
        String selection = "";
        Scanner Option = new Scanner(System.in);
        System.out.println("Would you like to:\nreview prescriptions\nreview doctors\nRequest Prescription ");
        selection = Option.nextLine();
        return selection;
    }
    public static String[] RequestPrescription(){
        String[] prescription = new String[2];
        prescription[0] = "Medication A"; // Assigning values
        prescription[1] = "Medication B";
        return prescription;
    }
}