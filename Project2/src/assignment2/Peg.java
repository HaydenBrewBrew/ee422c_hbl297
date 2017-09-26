package assignment2;

public class Peg {
	private char color;
	private int location;
	
	public Peg() {
		this.color = 0;
		this.location = 0; 
	}
	public Peg(char c) {
		this.color = c;
		this.location = 0;
	} 
	
	public Peg(char c, int i) {
		this.location = i;
	}
	
	public char getColor() {
		return color;
	}
	
	public boolean equals(Peg test) {
		if(this.color == test.color) {
			return true;
		}
		return false;
	}
	
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
