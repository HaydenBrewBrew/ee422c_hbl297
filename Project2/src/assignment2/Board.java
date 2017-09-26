/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data.
 * Hayden Lydick
 * hbl297
 * Slip days used: <0>
 * Fall 2017
 */
package assignment2;

public class Board {

	private static final int default_rounds = 12;
	public int maxrounds;
	private String[] roundResults;

	public Board(){
		this.maxrounds = default_rounds;
		roundResults = new String[this.maxrounds];
	}

	public Board(int roundnum) {
		this.maxrounds = roundnum;
		roundResults = new String[this.maxrounds];
	}

	public  void history(int roundsleft){
		for(int i = 0; i < (maxrounds - roundsleft); i++){
			System.out.println(roundResults[i]);
			}
	}

	public void storeRoundData(String code, String results, int roundsleft){
		String round = " -> ";
		round = code + round + results;
		roundResults[maxrounds - roundsleft] = round;

	}

}
