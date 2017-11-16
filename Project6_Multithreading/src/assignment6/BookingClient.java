/* MULTITHREADING <MyClass.java>
 * EE422C Project 6 submission by
 * Replace <...> with your actual data.
 * <Hayden Lydick>
 * <hbl297>
 * <Student1 5-digit Unique No.>
 * Slip days used: <1>
 * Fall 2017
 */
package assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.lang.Thread;


public class BookingClient {
  /*
   * @param office maps box office id to number of customers in line
   * @param theater the theater where the show is playing
   */
	private ArrayList<BookingOffice> sellers = new ArrayList<BookingOffice>();
	private Map<String, Integer> offices;
	private Theater theatre;
  public BookingClient(Map<String, Integer> office, Theater theater) {
    this.offices = office;
    this.theatre = theater;
  }
  
  public static void main(String[] args) {
	  Map<String, Integer> offices = new HashMap<String, Integer>(){{
		  put("BX1", 10000);
		  put("BX2", 10000);
		  put("BX3", 10000);
	  }};
	  Theater t = new Theater(1000,1000, "Minions II On Ice");
	  BookingClient control = new BookingClient(offices, t);
	  control.simulate();
  }

  
  
  /*
   * Starts the box office simulation by creating (and starting) threads
   * for each box office to sell tickets for the given theater
   *
   * @return list of threads used in the simulation,
   *         should have as many threads as there are box offices
   */
	public List<Thread> simulate() {
		List<Thread> races = new LinkedList<Thread>();
		Set<String> ids = this.offices.keySet();
		int count = 1;
		for(String s : ids) {
			this.sellers.add(new BookingOffice(this.offices.get(s), this.theatre, s, count));
			count += this.offices.get(s);
		}
		for(BookingOffice book: this.sellers) {
			races.add(new Thread(book));
		}
		for(Thread clank : races) {
			clank.start();
		}
		return races;
	}
}
