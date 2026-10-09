import java.util.Scanner;

public class UserInfoLab {
    public static void main(String[] args) {
        // Part 1
        // Create a Scanner for keyboard input
        // Ask the user to enter their first and last name and pass these
        // values to the generateUsername method and save the returned result.
        Scanner scan = new Scanner(System.in);
        String first, last;

        System.out.print("Can you please enter your first name?\t");
        first = scan.nextLine();

        System.out.print("Can you please enter your last name?\t");
        last = scan.nextLine();

        System.out.println("Username: "+ generateUsername(first, last)+ '\n');
        String user = generateUsername(first, last);
        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        // The validatePassword method will check if the password meets the criteria:
        String password;

        System.out.print("Can you please enter your password?\t");

        password = scan.nextLine();
        boolean valPass = validatePassword(password);
        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.
        String creditNum = "";
        if(valPass){
            System.out.print("What is your credit card number?\t");
            creditNum = scan.nextLine();
        }
        creditNum = maskCreditCard(creditNum);
        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing
        if(!(creditNum.equals("N/A"))&& valPass){
            System.out.println("\nFinal details:");
            System.out.println("Username: \t" + user);
            System.out.println("Credit card: \t" + creditNum);;
        }

    }

    public static String generateUsername(String firstName, String lastName) {
        String result = "";
        if(firstName.length() < 3|| lastName.length() < 3){
            if(firstName.length() < 3){
                result += firstName;
            }
            else{
                result += firstName.substring(0, 3);
            }
            if(lastName.length()<3){
                result += lastName;
            }
            else{
                result += lastName.substring(0, 3);
            }
        }
        else{
            result += firstName.substring(0, 3);
            result += lastName.substring(0, 3);
        }

        result = result.toLowerCase();
        return result;
    }
    public static boolean validatePassword(String password) {
        int count=0;
        boolean contUpper = true, eightLong = true;
        boolean contDig = containsDigit(password);

        for(int i = 0; i< password.length(); i++){
            String letter= password.substring(i,i+1);
            if(letter.equals(letter.toUpperCase())){
                count++;
            }
        }

        if(password.length() < 8) {
            eightLong = false;
            System.out.println("Password is not 8 characters long.");
        }
        if(count == 0){
            contUpper = false;
            System.out.println("Password does not contain an Upper Case Letter.");
        }
        if(!contDig){
            System.out.println("Password does not contain a digit.");
        }

        if(!(contDig && contUpper && eightLong)){
            return false;
        }
        else{
            System.out.println("Valid password. Checking Credit Card");
        }
        return true;
    }
    public static String maskCreditCard(String creditCardNumber) {
        String result = "";
        if(allDigits(creditCardNumber) && creditCardNumber.length() == 16){
            for(int i = 1; i<= 3; i++){
                result += "**** ";
            }
            result += creditCardNumber.substring(12);
        }
        else{
            result = "N/A";
        }
        return result;
    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
