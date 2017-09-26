package assignment2;

import java.util.*;

public class Driver {
	 public static void main(String args[]) {
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
	
