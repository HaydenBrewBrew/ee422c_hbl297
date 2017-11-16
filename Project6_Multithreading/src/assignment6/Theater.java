// insert header here
package assignment6;

import java.util.LinkedList;
import java.util.List;

public class Theater {
	/*
	 * Represents a seat in the theater
	 * A1, A2, A3, ... B1, B2, B3 ...
	 */
	private boolean full;
	
	
	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}
	
	
	static class Seat {
		private int rowNum;
		private int seatNum;
		//private boolean taken;
		
		public Seat(int rowNum, int seatNum) {
			this.rowNum = rowNum;
			this.seatNum = seatNum;
		}

		public int getSeatNum() {
			return seatNum;
		}

		public int getRowNum() {
			return rowNum;
		}
		@Override
		public String toString() {
			return( getAlphaConv(rowNum) + Integer.toString(seatNum));
		}
		
		private String getAlphaConv(int row) {
			String rowA = "";
			while(row > 0) {
				row--;
				int r = row % 26;
				char d = (char) (r + 97);
				rowA = d + rowA;
				row = (row - r) / 26;
			}
			return(rowA.toUpperCase());
		}
	}

  /*
	 * Represents a ticket purchased by a client
	 */
	static class Ticket {
		private String show;
		private String boxOfficeId;
		private Seat seat;
	  private int client;
	  private int width = 31;
	  private int height = 6;
		public Ticket(String show, String boxOfficeId, Seat seat, int client) {
			this.show = show;
			this.boxOfficeId = boxOfficeId;
			this.seat = seat;
			this.client = client;
		}

		public Seat getSeat() {
			return seat;
		}

		public String getShow() {
			return show;
		}

		public String getBoxOfficeId() {
			return boxOfficeId;
		}

		public int getClient() {
			return client;
		}

		@Override
		public String toString() {
		//top and bottom of box		
		String[] tick = {"","","","","",""};	
		for(int i = 0; i < width; i++) {
			tick[0] = tick[0] + "-";
			tick[height - 1] = tick[height - 1] + "-";
		}
		tick[0] = tick[0] + System.lineSeparator();
		tick[height - 1] = tick[height -1] + System.lineSeparator();
		
		for(int i = 1; i<height - 1; i++) {
			tick[i] = "|";
			tick[i] = tick[i] + " ";
		}
		//show row
		tick[1] = tick[1] + "Show: ";
		tick[1] = tick[1] + show;
		while(tick[1].length() < (tick[0].length() - 3)) {
			tick[1] = tick[1] + " ";
		}
		tick[1] = tick[1] + "|";
		tick[1] = tick[1] + System.lineSeparator();
		
		tick[2] = tick[2] + "Box Office ID: ";
		tick[2] = tick[2] + boxOfficeId;
		while(tick[2].length() < (tick[0].length() - 3)) {
			tick[2] = tick[2] + " ";
		}
		tick[2] = tick[2] + "|";
		tick[2] = tick[2] + System.lineSeparator();
		
		tick[3] = tick[3] + "Seat: ";
		tick[3] = tick[3] + seat.toString();
		while(tick[3].length() < (tick[0].length() - 3)) {
			tick[3] = tick[3] + " ";
		}
		tick[3] = tick[3] + "|";
		tick[3] = tick[3] + System.lineSeparator();
		
		tick[4] = tick[4] + "Client: ";
		tick[4] = tick[4] + Integer.toString(client);
		while(tick[4].length() < (tick[0].length() - 3)) {
			tick[4] = tick[4] + " ";
		}
		tick[4] = tick[4] + "|";
		tick[4] = tick[4] + System.lineSeparator();
		String out = "";
		for(int i = 0; i < height; i++) {
			out = out + tick[i];
		}
		return out;
		}
	}
	private String show;
	private Seat[][] seats;
	private int numRows;
	private int seatsPRow;
	
	
	
	public Theater(int numRows, int seatsPerRow, String show) {
		this.show = show;
		this.seatsPRow = seatsPerRow;
		this.numRows = numRows;
	}

	/*
	 * Calculates the best seat not yet reserved
	 *
 	 * @return the best seat or null if theater is full
   */
	private int bestSeatRow = 1;
	private int bestSeatnum = 1;
	public Seat bestAvailableSeat() {
		if(bestSeatRow <= numRows ) {
		Seat s = new Seat(this.bestSeatRow,this.bestSeatnum);
		bestSeatnum++;
		bestSeatnum %= this.seatsPRow + 1;
		if(bestSeatnum == 0) {
			bestSeatnum++;
			bestSeatRow++;
		}
		return(s);
		}
		return null;
	}

	/*
	 * Prints a ticket for the client after they reserve a seat
   * Also prints the ticket to the console
	 *
   * @param seat a particular seat in the theater
   * @return a ticket or null if a box office failed to reserve the seat
   */
	public Ticket printTicket(String boxOfficeId, Seat seat, int client) {
		Ticket t = new Ticket(this.show, boxOfficeId, seat, client);
		this.transactions.add(t);
		System.out.println(t.toString());
		return t;
	}
	private List<Ticket> transactions = new LinkedList<Ticket>();
	/*
	 * Lists all tickets sold for this theater in order of purchase
	 *
   * @return list of tickets sold
   */
	public List<Ticket> getTransactionLog() {
		return transactions;
	}

	
}
