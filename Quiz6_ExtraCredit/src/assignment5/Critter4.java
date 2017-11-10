package assignment5;

public class Critter4 extends Critter{
	private boolean hatched; // hatched or not hatched
	private static int hatchTimer = 6;	// time to hatch
	private int count; // countdown to hatch
	private int cycleCount; // reproduction cycle
	private int age;
	
	/**
	 * Constructor, starts unhatched, default count, default cycleCount, age 0
	 */
	public Critter4() {
		hatched = false;
		count = hatchTimer;
		cycleCount = 0;
		age = 0;
	}
	
	/**
	 * does nothing if unhatched
	 * if hatched, cyclically walks and reproduces and ages
	 */
	@Override
	public void doTimeStep() {
		if(count <= 0 && hatched == false) {
			hatched = true;
			return;
		}
		if(!hatched) {
			count--;
			return;
		}
		
		if(cycleCount % hatchTimer != 0) {
			cycleCount++;
			walk(Critter.getRandomInt(8));
		}
		else {
			while(this.getEnergy() > 40) {
			Critter4 kid = new Critter4();
			kid.count = this.age % hatchTimer;
			reproduce(kid,Critter.getRandomInt(8));
			}
		}
		age += 1;
		return;
		
	}
	/**
	 * fights if hatched
	 */
	@Override
	public boolean fight(String oponent) {
		if(!hatched) {return false;}
		if(hatched) {return true;}
		return false;
	}
	
	@Override
	public String toString() {
		return "4";
	}
	/**
	 * Prints averages for hatched, eggs, timeleft to hatch, turns since hatch, and age
	 * @param crit4 - list of Critter4 
	 */
	public static void runStats(java.util.List<Critter> crit4) {
		int totalhatched = 0;
		int totaleggs = 0;
		int totalAge = 0;
		int hatchtimeleft = 0;
		int turncounter = 0;
		for(Object h : crit4 ) {
			Critter4 c4 = (Critter4) h;
			if(c4.hatched) {
				totalhatched++;
				turncounter += c4.cycleCount;
				totalAge += c4.age;
			}
			else{ 
			totaleggs++;
			hatchtimeleft += c4.count;
			}
		}
		int averageturncounter = turncounter/crit4.size();
		int averagehatchtimeleft = hatchtimeleft/crit4.size();
		int averageAge = totalAge/crit4.size();
		System.out.print("" + crit4.size() + " total Hatch(s)    ");
		System.out.print("" + totalhatched + "Total Hatched   ");
		System.out.print("" + totaleggs +"Total Eggs   ");
		System.out.print("" + averagehatchtimeleft + "Average Hatch Time Left   ");
		System.out.print("" + averageturncounter + "Average Turns Since Hatch   ");
		System.out.println("" + averageAge + "Average Age");
	}

}
