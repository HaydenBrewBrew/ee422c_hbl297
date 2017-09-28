/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data.
 * Hayden Lydick
 * hbl297
 * Slip days used: <0>
 * Fall 2017
 */
package assignment2;
//Board class to store round data
public class Board {

	private static final int default_rounds = 12;//rounds number used of no input 
	public int maxrounds;//rounds to use in functions
	private String[] roundResults;//array of strings for all of the input data
	
	//constructor with no input
	public Board(){
		// use defaultrounds if no input
		this.maxrounds = default_rounds;
		roundResults = new String[this.maxrounds];
	}
	//constructor with input
	public Board(int roundnum) {
		//use input for total rounds
		this.maxrounds = roundnum;
		roundResults = new String[this.maxrounds];
	}
	
	/**
	 * outputs inputs and black/white pegs from all rounds
	 * @param roundsleft: number of rounds remaining in the game
	 */
	public  void history(int roundsleft){
		for(int i = 0; i < (maxrounds - roundsleft); i++){//max - rounds left = number of rounds passed
			System.out.println(roundResults[i]);//output the round information 
			}
	}
	/**
	 * stores round data in the array
	 * @param code: input code 
	 * @param results: black/white pegs string
	 * @param roundsleft: rounds remaining in the game
	 */
	public void storeRoundData(String code, String results, int roundsleft){
		String round = " -> ";
		round = code + round + results;//format string to store in array
		roundResults[maxrounds - roundsleft] = round;//store array in current round index (round counting starts at 0)

	}

}
