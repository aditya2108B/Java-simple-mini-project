import java.util.Random;
import java.util.Scanner;

public class StonePaperScissorsGame{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Variables to store user/system input and results
        String result, systemin, userin;
        String[] matchresult = new String[100];
        String[] user = new String[100]; 
        String[] Systemin = new String[100];  
        
        int i = 0;  // Index for storing game outcomes
        int userchoice,useravg=0,systemavg=0;

        // Main loop for multiple rounds
        while (true) {
            // Input validation for user choice
            do {
                System.out.println("Enter your choice\n0. Stone\n1. Paper\n2. Scissors : ");
                userchoice = sc.nextInt();
                if (userchoice >= 3 || userchoice < 0) {
                    System.out.println("Please enter a valid choice (0, 1, or 2): ");
                }
            } while (userchoice >= 3 || userchoice < 0);

            // Randomly generate system's choice (0 for Stone, 1 for Paper, 2 for Scissors)
            int randomIntBound = rand.nextInt(3);

            // Store user's choice
            switch (userchoice) {
                case 0:
                    userin = "Stone";
                    System.out.println("You chose: Stone");
                    break;
                case 1:
                    userin = "Paper";
                    System.out.println("You chose: Paper");
                    break;
                case 2:
                    userin = "Scissors";
                    System.out.println("You chose: Scissors");
                    break;
                default:
                    userin = "";
            }

            // Store system's choice
            switch (randomIntBound) {
                case 0:
                    systemin = "Stone  ";
                    System.out.println("System chose: Stone");
                    break;
                case 1:
                    systemin = "Paper";
                    System.out.println("System chose: Paper");
                    break;
                case 2:
                    systemin = "Scissors";
                    System.out.println("System chose: Scissors");
                    break;
                default:
                    systemin = "";
            }

            // Determine the result and store it
            if ((userchoice == 0 && randomIntBound == 2) ||
                (userchoice == 1 && randomIntBound == 0) ||
                (userchoice == 2 && randomIntBound == 1)) {
                result = "YOU WIN";
                useravg++;
            } else if (userchoice == randomIntBound) {
                result = "MATCH TIED";
            } else {
                result = "SYSTEM WINS";
                systemavg++;
            }

            // Display the result of the current round
            System.out.println(result);

            // Store the choices and result in arrays
            user[i] = userin;
            Systemin[i] = systemin;
            matchresult[i] = result;
            i++;  // Increment the index for next round

            // Ask if user wants to continue or stop
            System.out.println("Do you want to stop or continue? \n1.continue \n2. Stop");
            int ch = sc.nextInt();
            if (ch == 2) {
                break;
            }
        }

        // Display the history of the game
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println("\n\t\t\t\tGame History\t\t\t\t\t\t\t\t\t");
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println("Round\t\t\tUserchoice\t\t\tSystemchoice\t\t\tresult ");
        System.out.println("_____________________________________________________________________________________________________");
        for (int j = 0; j < i; j++) {
            
            System.out.println((j+1) + "\t\t\t" + user[j] + "\t\t\t" + Systemin[j] + "\t\t\t" + matchresult[j]);
            System.out.println("_____________________________________________________________________________________________________");
        }
        if(useravg>systemavg){
            System.out.println("overall you win ");
        }else if(useravg<systemavg){
            System.out.println("overall System win ");
        }else{
            System.out.println("overall match tied ");
        }
 
    }
}
