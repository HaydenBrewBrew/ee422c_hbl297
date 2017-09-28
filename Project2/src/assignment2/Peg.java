package assignment2;

public class Peg {
	//peg class to be used in array to store secret code
	private char color;//color of the peg 0 if no color
	private int location;//location of peg in array -1 if not in array
	
	//constructor for no input
	public Peg() {
		this.color = 0;
		this.location = -1; 
	}
	//constructor for only color
	public Peg(char c) {
		this.color = c;
		this.location = -1;
	} 
	//constructor for input and location
	public Peg(char c, int i) {
		this.color = c;
		this.location = i;
	}
	//get function for color
	public char getColor() {
		return color;
	}
	//changes color 
	public void changeColor(char x) {
		this.color = x;
	}
	//sees if same color in two pegs
	public boolean equals(Peg test) {
		if(this.color == test.color) {
			return true;
		}
		return false;
	}
	//used to test true equivalence in the pegs
	/*
	 * Peg input compared against
	 * 0 output if not same loc or color
	 * 1 output if same loc and color
	 * -1 output if different loc same color
	 */
	public int pegFeedback(Peg test) {
		if(this.equals(test) && (this.location == test.location)) {
			return 1;
		}
		if(this.equals(test) && (this.location != test.location)) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
