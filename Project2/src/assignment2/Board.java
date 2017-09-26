package assignment2;

public class Board {

	private static final int default_rounds = 12;
	public int maxrounds;
	private String[] roundResults = new String[maxrounds];;

	public Board(){
		this.maxrounds = default_rounds;
	}

	public Board(int roundnum) {
		this.maxrounds = roundnum;
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
