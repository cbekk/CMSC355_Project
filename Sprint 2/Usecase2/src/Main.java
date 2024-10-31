
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
    String result = Userlogin();
    System.out.println(result);
    String SelectedOption = Purpose();
    System.out.println(SelectedOption);
    String[][]answer = Doyouhavehistory();
    if (answer == null){
        System.out.println("You have no history of prescriptions.");
    }
    else {
        DisplayPresciption(answer);
    }
    String[][] choise = RequestPrescription();
    DisplayPresciption(choise);
    Recievedbydoc(choise);
    Approvedbydoc(choise);
    }
    public static String Userlogin(){
        Scanner Login = new Scanner(System.in);
        String Usernamebase = "1";
        String Passwordbase = "2";
        String username = "";
        String password = "";
        int usernum;
        int passnum;
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
        String selection;
        Scanner Option = new Scanner(System.in);
        System.out.println("Would you like to:\nreview prescriptions\nreview doctors\nRequest Prescription ");
        selection = Option.nextLine();// Ask group what they want to happen if request prescription isn't selected
        return selection;
    }
    public static String[][] Doyouhavehistory(){
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        String[][] history = null;
        if (randomNumber == 1){
            history = new String[2][4];
            history[0][0] = "Doctor";
            history[0][1] = "Prescription";
            history[0][2] = "Status";
            history[0][3] = "Actions";
            history[1][0] = "George Henderson";
            history[1][1] = "Doxcil";
            history[1][2] = "Accepted";
            history[1][3] = "View Details";
        }
            return history;

    }
    public static String[][] RequestPrescription() {
        Scanner Presinfo = new Scanner(System.in);
        Scanner Presnumber = new Scanner(System.in);
        boolean checker = false;
        int numberPres = 0;
        while (!checker) {
            System.out.println("Enter the number of prescriptions you want to request: ");
            try{
                numberPres = Presnumber.nextInt();
                checker = true;
            }catch(InputMismatchException e){
            System.out.println("Please enter a valid number");
            Presnumber.nextLine();
            }
        }
        String[][] prescription = new String[numberPres+1][4];
        prescription[0][0] = "Prescription";
        prescription[0][1] = "Doctor";
        prescription[0][2] = "Status";
        prescription[0][3] = "Actions";
        for(int i = 1; i <= numberPres; i++) {
            for (int j = 0; j < 1; j++) {
            while ((prescription[i][j] == null || prescription[i][j].isEmpty())
                    || (prescription[i][j+1] == null || prescription[i][j+1].isEmpty())) {
                if (prescription[i][j] == null || prescription[i][j].isEmpty()) {
                    System.out.println("Enter your Prescription name: ");
                    prescription[i][j] = Presinfo.nextLine();
                }
                if (prescription[i][j+1] == null || prescription[i][j+1].isEmpty()) {
                    System.out.println("Enter your Doctor's name: ");
                    prescription[i][j+1] = Presinfo.nextLine();
                }
                if (prescription[i][j].isEmpty() || prescription[i][j+1].isEmpty()) {
                    System.out.println("Prescription name and/or Doctor name not entered. Please try again. ");
                }
            }
        }
            }
        for (int i =1; i <= numberPres; i++){
            prescription[i][2] = "Pending";
            prescription[i][3] = "View Details";
        }
        return prescription;
    }
    public static void DisplayPresciption(String[][] prescription) {
        for (int i = 0; i < prescription.length; i++) {
            for (int j = 0; j < prescription[0].length; j++) {
                if (i > 0 && j == 1) {
                    System.out.print(prescription[i][j] + "          ");
                }
                else if (i > 0 && j == 0){
                    System.out.print(prescription[i][j] + "   ");
                }
                else if (i > 0 && j == 2){
                    System.out.print(prescription[i][j] + "  ");
                }
                else{
                    System.out.print(prescription[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public static void Recievedbydoc(String[][] prescription){
        Random random = new Random();
        Random random2 = new Random();
        int randomnum = 0;
        int randomnum2 =0;
        while (randomnum2 == randomnum) {
            randomnum = random.nextInt(2);
            randomnum2 = random2.nextInt(2);
            if (randomnum == randomnum2) {
                System.out.println("There was an error. Prescription not received.");
            } else {
                System.out.println("prescription received!");
            }
        }
    }
    public static void Approvedbydoc(String[][] prescription){
        Random random = new Random();
        Random random2 = new Random();
        int randomnum = 0;
        int randomnum2 =0;
        while (randomnum2 == randomnum) {
            randomnum = random.nextInt(2);
            randomnum2 = random2.nextInt(2);
            if (randomnum == randomnum2) {
                System.out.println("Prescription not approved.");
            } else {
                System.out.println("Prescription approved!");
            }
        }
    }

}
