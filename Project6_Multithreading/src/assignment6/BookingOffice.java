package assignment6;

import assignment6.Theater.Seat;

public class BookingOffice implements Runnable {
	private int customers;
	private Theater T;
	private String ID;
	private int min;
	public BookingOffice(int customers, Theater t, String ID, int min) {
		this.customers = customers;
		this.T = t;
		this.ID = ID;
		this.min = min;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < customers; i++) {
		synchronized(T){
		Seat s = T.bestAvailableSeat();
			if(s != null) {
				//s.setTaken(true);
				//System.out.println(this.ID);
				T.printTicket(ID, s, min);
				this.min++;
			}
			else {
				if(T.isFull()) {
					break;
				}
				System.out.println("Sorry, we are sold out!");
				T.setFull(true);
			}
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			System.out.println("NOPE");
			e.printStackTrace();
		}
		}
	}

}
