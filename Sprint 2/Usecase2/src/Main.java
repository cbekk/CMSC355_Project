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
    String[][]choise = RequestPrescription();
        for (int i = 0; i < 4; i++) {
            System.out.printf("%-15s", choise[i][0]);
        }
        System.out.println();

        for (int i = 0; i < 4; i++) {
            System.out.printf("%15s", choise[i][1]);
        }
    }
    public static String Userlogin(){
        Scanner Login = new Scanner(System.in);
        String Usernamebase = "1";
        String Passwordbase = "2";
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
    public static String[][] RequestPrescription() {
        Scanner Presinfo = new Scanner(System.in);
        String[][] prescription = new String[4][2];
        prescription[0][0] = "Doctor";
        prescription[1][0] = "Prescription";
        prescription[2][0] = "Status";
        prescription[3][0] = "Action";
        while ((prescription[0][1]== null  ||prescription[0][1].isEmpty())
                || (prescription[1][1]== null||prescription[1][1].isEmpty())) {
            if (prescription[0][1] == null || prescription[0][1].isEmpty()) {
                System.out.println("Enter your Prescription name: ");
                prescription[0][1] = Presinfo.nextLine();
            }
            if (prescription[1][1] == null || prescription[1][1].isEmpty()) {
                System.out.println("Enter your Doctor's name: ");
                prescription[1][1] = Presinfo.nextLine();
            }
            if (prescription[0][1].isEmpty() || prescription[1][1].isEmpty()) {
                System.out.println("Prescription name and/or Doctor name not entered. Please try again. ");
            }
        }
        prescription[2][1] = "Pending";
        prescription[3][1] = "Submitted";
        return prescription;
    }
}
