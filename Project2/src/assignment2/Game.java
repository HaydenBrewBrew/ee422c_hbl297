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

	public int roundNumber;
	public int currentRoundleft;
	private int codelength;
	private boolean testflag;
	private Peg[] secretCode;
	public Board myBoard = new Board(GameConfiguration.guessNumber);

	public Game(boolean testing) {
		this.testflag = testing;
		this.roundNumber = GameConfiguration.guessNumber;
		this.codelength = GameConfiguration.pegNumber;
		this.secretCode = buildSecretCode(codelength);
		if(this.testflag) {
			System.out.println("Secret Code: " + getCode(secretCode));
		}
			System.out.println("You Have " + roundNumber + " Guess(es) Left");
	}

	private Peg[] buildSecretCode(int length) {
		Peg[] code = new Peg[length];
		String scode = SecretCodeGenerator.getInstance().getNewSecretCode();
		for(int i = 0; i < length; i++) {
			code[i] = new Peg(scode.charAt(i), i);
		}
		return code;
	}

	public boolean runGame(String input) {
		Peg[] code = this.buildCode(input);
		String temp = this.getCode(code);
		String result = this.compareToSecret(code);
		myBoard.storeRoundData(temp, result, roundNumber);
		if(result.equals("4b_0w")) {
			return true;
		}
		else {System.out.println(result);}
		this.roundNumber--;
		System.out.println("You have " + roundNumber + " guess(es) left.");
		return false;
	}

	public String compareToSecret(Peg[] code1) {
		int b = 0;
		int w = 0;
		int temp;
		char zero = "_".charAt(0);
		Peg[] code = new Peg[codelength];
		for(int i = 0; i < codelength; i++) {
			code[i] = new Peg(secretCode[i].getColor(), i);
		}
		for(int i  = 0; i  < codelength; i++) {
				temp = code[i].pegFeedback(code1[i]);
				if((temp == 1)) {
					b++;
					code[i].changeColor(zero);
				}
			}
		for(int i  = 0; i  < codelength; i++) {
			if(secretCode[i].getColor() != zero) {
			for(int j = 0; (j) < codelength; j++) {
				temp = code[i].pegFeedback(code1[j]);
				if((temp == -1)) {
					w++;
					code[i].changeColor(zero);
					};
				}
			}
			}
		return (Integer.toString(b) + "b_" + Integer.toString(w) + "w");
	}

	public Peg[] buildCode(String input) {
		int i = codelength;
		Peg[] code = new Peg[i];
		for(int j = 0; j < i; j++) {
			code[j] = new Peg(input.charAt(j),j);
		}
		return code;
	}

	public String getCode(Peg[] code) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < codelength; i++) {
			sb.append(code[i].getColor());
		}
		return(sb.toString());
		}

}
