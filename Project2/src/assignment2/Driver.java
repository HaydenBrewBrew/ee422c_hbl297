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
	if((input == "Y")||(input == "N")) {
		System.out.println("Invalid Input Ending Program");
		return;
	}
	if((input == "N")) {
		System.out.println("Ending Program");
		return;
	}
	Game my_Game = new Game(true);
	while(my_Game.roundNumber > 0) {
		input = read.next();
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
	
