import java.util.Scanner;

/**
 * receives a base number from user
 * calculates that numbers factorial
 * asks the user if they want to go again
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class LabFour {
    private static boolean doAgain = false;
    private static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        long factorial;
        int baseNum;
        final int MIN_NUM = 1;
        final int MAX_NUM = 10;

        do {
            System.out.print("Please enter a number from 1 to 10: ");
            baseNum = scnr.nextInt();

            if(baseNum < MIN_NUM || MAX_NUM < baseNum ) { // if it's not within range
                doAgain = true;
                System.out.println("This is not a number between " + MIN_NUM + " and " + MAX_NUM + "!");
                continue;
            } else { // input is a number within the correct range
                factorial = 1;

                for (int i = 2; i <= baseNum; i++) {
                    factorial *= i;
                }
                System.out.println("Your factorial: " + factorial);
            }

            checkInput();
        } while(doAgain);

    }
    /**
     * asks user if they want to continue and then checks their input
     * for yes, no, a test result, or an incorrect input
     */
    private static void checkInput() {
        boolean correctInput;
        String userContinueCheck;

        do {
            // collects input the first character (a-z regardless of case)
            // switches to lowercase
            System.out.print("Would you like to go again? (y/n): ");
            userContinueCheck = scnr.next();

            if(userContinueCheck.matches("[y]\\S*")) { // answer is 'yes'
                correctInput = true;
                doAgain = true;
            } else if (userContinueCheck.matches("[n]\\S*")) { // answer is 'n'
                correctInput = true;
                doAgain = true;
            }
            else { // answer is something else
                System.out.println("Incorrect input, please try again!");
                correctInput = false;
            }
        }
        // only repeats if user input y or n
        while(!correctInput);
    }
}
