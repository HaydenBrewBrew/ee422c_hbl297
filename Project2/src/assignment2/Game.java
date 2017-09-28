/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data.
 * Hayden Lydick
 * hbl297
 * Slip days used: <0>
 * Fall 2017
 */
package assignment2;
import java.util.*;
import java.lang.String;
public class Game {

	
	public int roundNumber;//rounds left
	private int codelength;//length of codes 
	private boolean testflag;// testing mode flag
	private Peg[] secretCode;
	public Board myBoard = new Board(GameConfiguration.guessNumber);//board to hold the history

	/**
	 * constructor for the game class
	 * @param testing: determine if we enter testing mode or not
	 */

	public Game(boolean testing) {
		this.testflag = testing;
		//use game config file to determine the initial values of the object
		this.roundNumber = GameConfiguration.guessNumber;
		this.codelength = GameConfiguration.pegNumber;
		this.secretCode = buildSecretCode(codelength);
		if(this.testflag) {
			System.out.println("Secret Code: " + getCode(secretCode));
		} //for first round of game
			System.out.println("You Have " + roundNumber + " Guess(es) Left");
	}
	/**
	 * Builds secret code to be guessed by player
	 * @param length: length of code
	 * @return array of peg objects
	 */
	private Peg[] buildSecretCode(int length) {
		Peg[] code = new Peg[length];
		// builds code from the random number generator in SecretCodeGenerator
		String scode = SecretCodeGenerator.getInstance().getNewSecretCode();
		//for loop to cycle though, build and initialize the parts of the array
		for(int i = 0; i < length; i++) {
			code[i] = new Peg(scode.charAt(i), i);
		}
		return code;
	}
	/**
	 * takes input from player and checks/outputs white and black peg code
	 * @param input
	 * @return boolean: if the player guessed correct
	 */
	public boolean runGame(String input) {
		//build peg array off input
		Peg[] code = this.buildCode(input);
		String result = this.compareToSecret(code);
		myBoard.storeRoundData(input, result, roundNumber);
		//checks for win
		if(result.equals("4b_0w")) {
			return true;
		}
		//prints result if failed
		else {System.out.println(result);}
		this.roundNumber--;//decrease round counter
		System.out.println("You have " + roundNumber + " guess(es) left.");//output number of rounds remaining
		return false;
	}
	/**
	 * Compares input code to private secret code 
	 * @param code1: code to compare to secret
	 * @return
	 */
	public String compareToSecret(Peg[] code1) {
		int b = 0;//number of black pegs
		int w = 0;//number of white pegs
		char zero = "_".charAt(0);//replaces when match is found
		Peg[] code = new Peg[codelength];
		//initialize new object array so secret code is not edited
		for(int i = 0; i < codelength; i++) {
			code[i] = new Peg(secretCode[i].getColor(), i);
		}
		//compare to check for black pegs/full matches
		for(int i  = 0; i  < codelength; i++) {
			//if match found replace both locations with a "_", increase b count
				if((code[i].pegFeedback(code1[i]) == 1) && (code[i].getColor() != zero)) {
					b++;
					code[i].changeColor(zero);
					code1[i].changeColor(zero);
				}
			}
		//compare to check for white pegs/color matches
		for(int i  = 0; i  < codelength; i++) {
			//ignores zeros 
			if(secretCode[i].getColor() != zero) {
			//if match found replace both locations with a "_", increase w count
			for(int j = 0; (j) < codelength; j++) {
				if((code[i].pegFeedback(code1[j]) == -1) && (code[i].getColor() != zero)) {
					w++;
					code[i].changeColor(zero);
					code1[i].changeColor(zero);
					};
				}
			}
			}
		//return formated string for output
		return (Integer.toString(b) + "b_" + Integer.toString(w) + "w");
	}

	/**
	 * converts a string to an array of pegs
	 * @param input: code to convert to peg array format
	 * @return
	 */
	public Peg[] buildCode(String input) {
		int i = codelength;
		Peg[] code = new Peg[i];
		//constructs pegs with color and location
		for(int j = 0; j < i; j++) {
			code[j] = new Peg(input.charAt(j),j);
		}
		return code;
	}
	/**
	 * converts array of pegs to a string
	 * @param code: array of pegs to be converted
	 * @return string of code
	 */
	public String getCode(Peg[] code) {
		// stringbuilder object from the java library
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < codelength; i++) {
			sb.append(code[i].getColor());
		}
		return(sb.toString());
		}

}
