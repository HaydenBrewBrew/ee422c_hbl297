/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data.
 * Hayden Lydick
 * hbl297
 * Slip days used: <0>
 * Fall 2017
 */
package assignment2;

import java.util.*;

public class Driver {
	 public static void main(String args[]) {
		 boolean testflg = false;
		 if(args.length > 0){
			 if((args[0] == "1")||(args[0].equals("true"))){
				 testflg = true;
			 }
		 }
	String input;
	Scanner read = new Scanner(System.in);
	System.out.println("Welcome to Mastermind");
	while(true) {
	System.out.println("Do you want to play a new game? (Y/N):");
	input = read.next();
	if((input.equals("N"))) {
		System.out.println("Ending Program");
		return;
	}
	if((!input.equals("Y"))) {
		System.out.println("Invalid Input Ending Program");
		return;
	}
	Game my_Game = new Game(true);
	while(my_Game.roundNumber > 0) {
		input = read.next();
		if(input.equals("HISTORY")) {
			my_Game.myBoard.history(my_Game.roundNumber);
			continue;
		}
		boolean result = my_Game.runGame(input);
		if(result) {
			System.out.println("You Win!");
			break;
		}
		if(my_Game.roundNumber == 0) {
			System.out.println("You Lose!");
		}

	}
	}
	 }
}
