package assignment6;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import assignment6.Theater.Seat;
import assignment6.Theater.Ticket;

public class Tests {

	@Test
	public void test() {
		Seat s = new Seat(1,1);
		Ticket t = new Ticket("Test", "111", s, 1 );
		System.out.println(t.toString());
	}

	@Test
	public void test2() {
		 Map<String, Integer> offices = new HashMap<String, Integer>(){{
			  put("BX1", 100);
			  put("BX2", 100);
			  put("BX3", 100);
		  }};
		  Theater t = new Theater(53,10, "Avatar");
		  BookingClient control = new BookingClient(offices, t);
		  control.simulate();
		  System.out.println(t.getTransactionLog().size());
		
	}
}
