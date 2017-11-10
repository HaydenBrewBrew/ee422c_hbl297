package assignment5;
/* CRITTERS Critter.java
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Anthony Vrotsos
 * AMV2743
 * <Student1 5-digit Unique No.>
 * Hayden Lydick
 * HBL297
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Fall 2017
 */


import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.lang.Class;
import java.lang.reflect.Constructor;
/* see the PDF for descriptions of the methods and fields in this class
 * you may add fields, methods or inner classes to Critter ONLY if you make your additions private
 * no new public, protected or default-package code or data can be added to Critter
 */


public abstract class Critter {
	private static String myPackage;
	private	static List<Critter> population = new java.util.ArrayList<Critter>();
	private static List<Critter> babies = new java.util.ArrayList<Critter>();
	private boolean hasMoved;
	//private static TreeMap<Coord, LinkedList<Critter>> locations = new TreeMap<Coord, LinkedList<Critter>>();
	
	// Gets the package name.  This assumes that Critter and its subclasses are all in the same package.
	static {
		myPackage = Critter.class.getPackage().toString().split(" ")[1];
	}
	
	private static java.util.Random rand = new java.util.Random();
	public static int getRandomInt(int max) {
		return rand.nextInt(max);
	}
	
	public static void setSeed(long new_seed) {
		rand = new java.util.Random(new_seed);
	}
	
	
	/* a one-character long string that visually depicts your critter in the ASCII interface */
	public String toString() { return ""; }
	
	private int energy = 0;
	protected int getEnergy() { return energy; }
	
	private int x_coord;
	private int y_coord;
	
	/**
	 * Implements torus in horizontal direction
	 * @param steps
	 * @return X Coordinate
	 */
	private final int wrapX(int steps) {
		if((x_coord + steps) < 0) {
			return ((x_coord + steps)%Params.world_width + Params.world_width)%Params.world_width;
		}
		if((x_coord + steps) > (Params.world_width - 1)) {
			return ((x_coord + steps)%Params.world_width + Params.world_width)%Params.world_width;
		}
		else {
			return x_coord += steps;
		}
	}
	
	/**
	 * Implements torus in vertical direction
	 * @param steps
	 * @return Y Coordinate
	 */
	private final int wrapY(int steps) {
		if(y_coord + steps < 0) {
			return ((y_coord + steps)%Params.world_height + Params.world_height)%Params.world_height;
		}
		if((y_coord + steps) > (Params.world_height - 1)) {
			return ((y_coord + steps)%Params.world_height + Params.world_height)%Params.world_height;
		}
		else {
			return y_coord += steps;
		}
	}
	
	/**
	 * Calls WrapX and WrapY to implement walking (moving one step) in given direction
	 * @param direction -  0-7 starting at 0 = east in a CCW manner
	 * 
	 */
	
	protected final void walk(int direction) {
		if(hasMoved == true) {
			energy -= Params.walk_energy_cost;
			return;
		}
		switch (direction) {
		case 0: // move east 1
			x_coord = wrapX(1);
			break;
		case 1: // move northeast 1
			x_coord = wrapX(1);
			y_coord = wrapY(-1);
			break;
		case 2: // move north 1
			y_coord = wrapY(-1);
			break;
		case 3: // move northwest 1
			x_coord = wrapX(-1);
			y_coord = wrapY(-1);
			break;
		case 4: // move west 1
			x_coord = wrapX(-1);
			break;
		case 5: // move southwest 1
			x_coord = wrapX(-1);
			y_coord = wrapY(1);
			break;
		case 6: // move south 1
			y_coord = wrapY(1);
			break;
		case 7: // move southeast 1
			x_coord = wrapX(1);
			y_coord = wrapY(1);
			break;
		}
		energy -= Params.walk_energy_cost;
		hasMoved = true;
	}
	
	/**
	 * Calls WrapX and WrapY to implement running (moving 2 steps) in given direction
	 * @param direction - 0-7 starting at 0 = east in a CCW manner
	 */
	
	protected final void run(int direction) {
		if(hasMoved == true) {
			energy -= Params.run_energy_cost;
			return;
		}
		switch (direction) {
		case 0: // move east 2
			x_coord = wrapX(2);
			break;
		case 1: // move northeast 2
			x_coord = wrapX(2);
			y_coord = wrapY(-2);
			break;
		case 2: // move north 2
			y_coord = wrapY(-2);
			break;
		case 3: // move northwest 2
			x_coord = wrapX(-2);
			y_coord = wrapY(-2);
			break;
		case 4: // move west 2
			x_coord = wrapX(-2);
			break;
		case 5: // move southwest 2
			x_coord = wrapX(-2);
			y_coord = wrapY(2);
			break;
		case 6: // move south 2
			y_coord = wrapY(2);
			break;
		case 7: // move southeast 2
			x_coord = wrapX(2);
			y_coord = wrapY(2);
			break;
		}
		energy -= Params.run_energy_cost;
		hasMoved = true;
	}

	// Accepts inputs of the critter to be added to the babies field, and the direction of which to add is 
	//(8 possible ,0->7 range of input). 
	//Sets the child’s energy, x coordinate, and y coordinate, and adds it to the babies list.
	
	/**
	 * 
	 * @param offspring - child of one of the critters
	 * @param direction - 0-7 starting at 0 = east in a CCW manner
	 */

	protected final void reproduce(Critter offspring, int direction) {
	
		if(this.energy < Params.min_reproduce_energy) {
			return;
		}
		offspring.energy = (this.energy)/2;//set offspring energy
		
		if((this.energy % 2) > this.energy/2) {//determines if remainder is high enough to round up
		this.energy = this.energy/2 + 1;
		}
		else{this.energy = this.energy/2;}
		offspring.x_coord = this.x_coord;
		offspring.y_coord = this.y_coord;
		switch(direction) {//determine location of the offspring
		case 0: //east 
			offspring.x_coord = offspring.wrapX(1);
			break;
		case 1: //northeast
			offspring.x_coord = offspring.wrapX(1);
			offspring.y_coord = offspring.wrapY(-1);
			break;
		case 2: //north	
			offspring.y_coord = offspring.wrapY(-1);
			break;
		case 3: //north west
			offspring.x_coord = offspring.wrapX(-1);
			offspring.y_coord = offspring.wrapY(-1);
			break;
		case 4: //west	
			offspring.x_coord = offspring.wrapX(-1);
			break;
		case 5: //south west
			offspring.x_coord = offspring.wrapX(-1);
			offspring.y_coord = offspring.wrapY(1);
			break;
		case 6: //south	
			offspring.y_coord = offspring.wrapY(1);
			break;
		case 7: //south east 
			offspring.x_coord = offspring.wrapX(1);
			offspring.y_coord = offspring.wrapY(1);
			break;
		}
		Critter.babies.add(offspring);//add offspring to list of babies to add next round
	}

	public abstract void doTimeStep();
	public abstract boolean fight(String oponent);
	
	/**
	 * create and initialize a Critter subclass.
	 * critter_class_name must be the unqualified name of a concrete subclass of Critter, if not,
	 * an InvalidCritterException must be thrown.
	 * (Java weirdness: Exception throwing does not work properly if the parameter has lower-case instead of
	 * upper. For example, if craig is supplied instead of Craig, an error is thrown instead of
	 * an Exception.)
	 * @param critter_class_name - name of critter to make
	 * @throws InvalidCritterException - Critter is not defined in this package 
	 */

	//in Phase I, creates 100 Craigs and 25 algae
	//creates a critter based on user input. This function will handle any undefined Critter by throwing an InvalidCritterException to be handled 
	//in the main function. The function will add the new critter to the population once energy, and location are set. 


	public static void makeCritter(String critter_class_name) throws InvalidCritterException {
		Class<?> critterClass;
		Constructor<?> critterConstructor;
		Object possibleCritter;
		try {
			critterClass = Class.forName(myPackage + "." + critter_class_name); // check if class exists
		}
		catch(ClassNotFoundException e) {
			throw new InvalidCritterException(critter_class_name);
		}
		catch(IllegalArgumentException e) {
			throw new InvalidCritterException(critter_class_name);
		}
		catch(NoClassDefFoundError e) {
			throw new InvalidCritterException(critter_class_name);
		}
		try {
			critterConstructor = critterClass.getConstructor(); // check if class has a default constructor
		}
		catch(NoSuchMethodException e) {
			throw new InvalidCritterException(critter_class_name);
		}
		try {
			possibleCritter = critterConstructor.newInstance(); // instantiate object
		}
		catch(Exception e) {
			throw new InvalidCritterException(critter_class_name);
		}
		if(!(possibleCritter instanceof Critter)) { // if the instantiated object is not a Critter, throw error
			throw new InvalidCritterException(critter_class_name);
		}
		// critter init stuff
		Critter newCritter = (Critter) possibleCritter; // cast object to critter
		newCritter.energy = Params.start_energy;
		newCritter.x_coord = getRandomInt(Params.world_width);
		newCritter.y_coord = getRandomInt(Params.world_height);
		population.add(newCritter);
	}
	
	/**
	 * Gets a list of critters of a specific type.
	 * @param critter_class_name What kind of Critter is to be listed.  Unqualified class name.
	 * @return List of Critters. - List of the critter of the type MyPackage.critter_class_name
	 * @throws InvalidCritterException - Critter not in package
	 */
	//getinstances obtains a List of Critters of a specified type. If the string passed into the function is not a 
	//defined class or an instance of Critter, the function will throw the InvalidCritterException, to be handled in 
	//the main function. 
	public static List<Critter> getInstances(String critter_class_name) throws InvalidCritterException {
		List<Critter> result = new java.util.ArrayList<Critter>();
		Class<?> critterClass;
		try{
			critterClass = Class.forName(myPackage + "." + critter_class_name);
		}
		catch(ClassNotFoundException e) {
			throw new InvalidCritterException(critter_class_name);
		}
		catch(IllegalArgumentException e) {
			throw new InvalidCritterException(critter_class_name);
		}
		for(int i = 0; i<population.size(); i++) {
			if(population.get(i).getClass() == critterClass) {//same objects should point to the same class object
				result.add(population.get(i));
			}
		}
		return result;
	}
	
	/**
	 * Prints out how many Critters of each type there are on the board.
	 * @param critters List of Critters.
	 */
	public static void runStats(List<Critter> critters) {
		System.out.print("" + critters.size() + " critters as follows -- ");
		java.util.Map<String, Integer> critter_count = new java.util.HashMap<String, Integer>();
		for (Critter crit : critters) {
			String crit_string = crit.toString();
			Integer old_count = critter_count.get(crit_string);
			if (old_count == null) {
				critter_count.put(crit_string,  1);
			} else {
				critter_count.put(crit_string, old_count.intValue() + 1);
			}
		}
		String prefix = "";
		for (String s : critter_count.keySet()) {
			System.out.print(prefix + s + ":" + critter_count.get(s));
			prefix = ", ";
		}
		System.out.println();
		
	}
	
	/* the TestCritter class allows some critters to "cheat". If you want to 
	 * create tests of your Critter model, you can create subclasses of this class
	 * and then use the setter functions contained here. 
	 * 
	 * NOTE: you must make sure that the setter functions work with your implementation
	 * of Critter. That means, if you're recording the positions of your critters
	 * using some sort of external grid or some other data structure in addition
	 * to the x_coord and y_coord functions, then you MUST update these setter functions
	 * so that they correctly update your grid/data structure.
	 */
	static abstract class TestCritter extends Critter {
		protected void setEnergy(int new_energy_value) {
			super.energy = new_energy_value;
		}
		
		protected void setX_coord(int new_x_coord) {
			super.x_coord = new_x_coord;
		}
		
		protected void setY_coord(int new_y_coord) {
			super.y_coord = new_y_coord;
		}
		
		protected int getX_coord() {
			return super.x_coord;
		}
		
		protected int getY_coord() {
			return super.y_coord;
		}
		

		/*
		 * This method getPopulation has to be modified by you if you are not using the population
		 * ArrayList that has been provided in the starter code.  In any case, it has to be
		 * implemented for grading tests to work.
		 */
		protected static List<Critter> getPopulation() {
			return population;
		}
		
		/*
		 * This method getBabies has to be modified by you if you are not using the babies
		 * ArrayList that has been provided in the starter code.  In any case, it has to be
		 * implemented for grading tests to work.  Babies should be added to the general population 
		 * at either the beginning OR the end of every timestep.
		 */
		protected static List<Critter> getBabies() {
			return babies;
		}
	}

	/**
	 * Clear the world of all critters, dead and alive
	 * Clears the world of all Critters in the population and babies
	 * Also clear babies
	 */
	public static void clearWorld() {
		population.clear();
		babies.clear();
	}
	/**
	 * Makes all Critters in world do their TimeSteps
	 * Puts first critter encountered at a specific coordinate into HashMap
	 * Subsequent critters at that location get put in list of fighters
	 * Iterate through fighters list and resolve encounters
	 * Subtract Rest Energy
	 * Refresh the algae
	 * Add all babies
	 * Remove dead critters
	 * Reset hasMoved boolean 
	 */
	public static void worldTimeStep() {
		Map<String, Critter> Locations = new HashMap<String, Critter>();
		List<Critter> fighters = new java.util.ArrayList<Critter>();
		for(Critter crit : population) {
			crit.doTimeStep();
			String coord = "" + crit.x_coord + "," + crit.y_coord + "";
			if(!Locations.containsKey(coord)) {
			Locations.put(coord,  crit);
			continue;
			}
			fighters.add(crit);
		}
		
		Iterator<Critter> fighter = fighters.iterator();
		while(fighter.hasNext()) {
			Critter first = fighter.next();
			String key = "" + first.x_coord + "," + first.y_coord + "";
			
			if(!Locations.containsKey(key)) {
				Locations.put(key, first);
			}
			else {
			Critter second = Locations.get(key);
			
			int oldX = first.x_coord; int oldY = first.y_coord;
			boolean firstFight = first.fight(second.toString());
			boolean firstSamePlace = (first.x_coord == oldX && first.y_coord == oldY);
			
			if(!firstSamePlace) {
				String newKey = "" + first.x_coord + "," + first.y_coord + "";
				if(Locations.containsKey(newKey) && Locations.get(newKey).energy > 0) {
					first.x_coord = oldX; first.y_coord = oldY;
					firstSamePlace = true;
				}
				else {
					Locations.put(newKey, first);
				}
			}
			
			oldX = second.x_coord; oldY = second.y_coord;
			boolean secondFight = second.fight(first.toString());
			boolean secondSamePlace = second.x_coord == oldX && second.y_coord == oldY;
			
			if(!secondSamePlace) {
				String newKey = "" + second.x_coord + "," + second.y_coord + "";
				if(Locations.containsKey(newKey) && Locations.get(newKey).energy > 0) {
					Locations.remove(key);
					second.x_coord = oldX; second.y_coord = oldY;
					secondSamePlace = true;
				}
				else {
					Locations.put(newKey, second);
				}
			}
			
			boolean stillAlive = first.energy > 0 && second.energy > 0;
			if(stillAlive && firstSamePlace && secondSamePlace) {
				Critter winner, loser;
				int firstRoll = (firstFight ? 1:0) * getRandomInt(first.energy);
				int secondRoll = (secondFight ? 1:0) * getRandomInt(second.energy);
				
				if(firstRoll == secondRoll) {
					winner = first;
					loser = second;
				}
				else if (firstRoll > secondRoll) {
					winner = first;
					loser = second;
				}
				else {
					winner = second;
					loser = first;
				}
				winner.energy += loser.energy/2;
				population.remove(loser);
				if(second == loser) {
					Locations.remove(key, loser);
				}
			}
		}
	}
		// subtract rest energy
		for(Critter current : population) {
			current.energy -= Params.rest_energy_cost;
		}
		// algae
		for(int algae = 0; algae < Params.refresh_algae_count; algae++) {
			Algae algAdd = new Algae();
			algAdd.setEnergy(Params.start_energy);
			algAdd.setX_coord(getRandomInt(Params.world_width));
			algAdd.setY_coord(getRandomInt(Params.world_height));
			population.add(algAdd);
		}
		
		// babies
		population.addAll(babies);
		babies.clear();
		
		int i = 0;
		while(i < population.size()) {
			if(population.get(i).energy <= 0) {
				population.remove(i);
			}
			else {
					i++;
			}
		}
		
		for(Critter crit : population) {
			crit.hasMoved = false;
		}
		
	
}
	/**
	 * Displays the Critter World
	 */
	public static void displayWorld() {
		String [][] world = new String[Params.world_width + 2][Params.world_height + 2];
		for (int i = 0; i < Params.world_width + 2; i++) {
			for (int j = 0; j < Params.world_height + 2; j++) {
				if ((i==0 && j == 0) 
						|| (i == (Params.world_width + 1) && j == 0) 
						|| i == 0 && j == (Params.world_height + 1) 
						|| i == (Params.world_width + 1) && j ==(Params.world_height + 1)) {
					world[i][j] = "+";
				}
				else if (i == 0) {
					world[i][j] = "-";
				}
				else if (i == (Params.world_width+1)){
					world[i][j] = "-";
				}
				else if (j == 0) {
					world[i][j] = "|";
				}
				else if (j == (Params.world_height+1)) {
					world[i][j] = "|";
				}
				else {
					world[i][j] = " ";
				}
			}
		}
		for(Critter crit : population) {
			world[crit.x_coord+1][crit.y_coord+1] = crit.toString();
		}
		for (int i = 0; i < Params.world_width + 2; i++) {
			for (int j = 0; j < Params.world_height + 2; j++) {
				System.out.print(world[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
}