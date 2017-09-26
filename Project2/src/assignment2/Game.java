package assignment2;
import java.util.*;
public class Game {
	
	public int roundNumber; 
	private int codelength;
	private boolean testflag;
	private Peg[] secretCode;
	private String[] roundResults = new String[roundNumber];
	private int height;
	
	public Game(boolean testing) {
		this.testflag = testing;
		this.roundNumber = GameConfiguration.guessNumber;
		this.codelength = GameConfiguration.pegNumber;
		secretCode = this.buildSecretCode(codelength);
	}

	public Peg[] buildSecretCode(int length) {
		Peg[] code = new Peg[length];
		String scode = SecretCodeGenerator.getInstance().getNewSecretCode();
		for(int i = 0; i < length; i++) {
			code[i] = new Peg(scode.charAt(i), i);
		}
		return code;
	}
	
	public boolean runGame() {
		
	}
	
	public Peg[] buildCode(String input) {
		int i = input.length();
		Peg[] code = new Peg[i];
		for(int j = 0; j < i; j++) {
			code[j] = new Peg(input.charAt(j),j);
		}
		return code;
	}
	
	public String checkCode(Peg[] guess) {
		
	}
	
	public void history(int k){
		int i = GameConfiguration.guessNumber - k;
		for(int j = 0; j<i; j ++) {
			System.out.println(roundResults[j]);
		}
		}
}
