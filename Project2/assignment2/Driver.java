/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data.
 * Hayden Lydick
 * hbl297
 * Slip days used: <0>
 * Fall 2017
 */
package assignment2;
import java.util.*;
//Driver class to control and run the came as well as control most IO
public class Driver {
	//main function
	 public static void main(String args[]) {
		 // accepts input to control the test state for the game, this checks for it
		 boolean testflg = false;
		 if(args.length > 0){
			 if((args[0].equals("1"))||(args[0].equals("true"))){
				 testflg = true;
			 }
		 }
		 //create input variable and the scanner object to access the console
	String input;
	Scanner read = new Scanner(System.in);
	System.out.println("Welcome to Mastermind.");
	while(true) {//infinite while loop to break by command only
	System.out.println("Do you want to play a new game? (Y/N):");
	input = read.next();
	//checks whether to play
	if((input.equals("N"))) {
		break;
	}
	//checks for valid input
	if((!input.equals("Y"))) {
		System.out.println("Invalid Input Ending Program");
		break;
	}
	//initialize game
	Game my_Game = new Game(testflg);
	System.out.println("You have " + my_Game.roundNumber + " guess(es) left.");
	//main game loop until win or lose
	while(my_Game.roundNumber > 0) {
		System.out.println("Enter guess:");
		input = read.next();//read input
		//checks for history command
		if(input.equals("HISTORY")) {
			my_Game.myBoard.history(my_Game.roundNumber);
			System.out.println("You have " + my_Game.roundNumber + " guess(es) left.");
			continue;
				}
		//Check for valid, upper case all guess
		if((input.length() != GameConfiguration.pegNumber) || !(isInPossibleChoices(input))){
			System.out.println("INVALID_GUESS");
			System.out.println("You have " + my_Game.roundNumber + " guess(es) left.");
			continue;
		}
		//passes input to game object
		boolean result = my_Game.runGame(input);
		//check for win
		if(result) {
			System.out.println("You win!");
			System.out.println();
			break;
		}
		//check for end of round
		if(my_Game.roundNumber == 0) {
			System.out.println("You lose! The pattern was " + my_Game.getSecretCode());
			break;
		}
		System.out.println("You have " + my_Game.roundNumber + " guess(es) left.");//output number of rounds remaining

	}
	}
	//close scanner to stop IO leaks
	read.close();
	 }
	 //checks if a string is all uppercase
	 public static boolean isInPossibleChoices(String s){
		 //checks each array value individually and returns on if not in possible inputs
		 int check;
		 for(int i = 0; i < s.length(); i++) {
			 check = 0;// intialize to zero at each new input char
			 for(int j = 0; j < GameConfiguration.colors.length; j++) {
		 	if(GameConfiguration.colors[j].charAt(0) == s.charAt(i)){
				check++;//increment if found in possible inputs
			}
			}
		 	if(check <= 0) {
		 		return false;//return false if no matches found 
			}
	 }
	 return true;
}
}
