/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Spring 2017
 */


package assignment3;
import java.util.*;
import java.io.*;

public class Main {

	// static variables and constants only here.

	public static void main(String[] args) throws Exception {

		Scanner kb;	// input Scanner for commands
		PrintStream ps;	// output file
		// If arguments are specified, read/write from/to files instead of Std IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps);			// redirect output to ps
		} else {
			kb = new Scanner(System.in);// default from Stdin
			ps = System.out;			// default to Stdout
		}
		initialize();
		//ArrayList<String> Dict = new ArrayList<String>(makeDictionary());
		//Graph g = new Graph(Dict);
		ArrayList<String> input;//parse(kb);
		//if(input.isEmpty()) {
		//	return;
		//}
		input = getWordLadderBFS("WORST", "WUSHU");
		input.stream().forEach(System.out::println);
		

		//ArrayList<String> DFSReturn = new ArrayList<String>();
		//DFSReturn = getWordLadderDFS("words", "tests");

		//input.stream().forEach(System.out::println);
		//ArrayList<String> edges = g.getEdges(input.get(0));
		//edges.stream().forEach(System.out::println);
		// TODO methods to read in words, output ladder
	}

	public static void initialize() {

		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests.  So call it
		// only once at the start of main.
	}

	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of Strings containing start word, rungs, and end word.
	 * If command is /quit, return empty ArrayList.
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		ArrayList<String> input = new ArrayList<String>();
		for(int i = 0; i<2; i++){
		String in = keyboard.next();
		if(in.equals("/quit")){
			input.clear();
			return (input);//returns empty array
		}
		input.add(in.toUpperCase());//adds items and converts to correct case
		}
		return input;
		}

	private static ArrayList<String> DFSHelper(String start, String end, ArrayList<String> found, ArrayList<String> ret, Graph dictionary){
		if(start == null || end == null){
			return null;
		}
		found.add(start);
		if(start.equals(end)){
			ret.add(start);
			return ret;
		}
		else{
			for(String i : dictionary.getEdges(start)){
				if(!found.contains(i)){
					// recursion here
				}
			}
		}
		// TODO
		return null;
	}

	public static ArrayList<String> getWordLadderDFS(String start, String end) {
    	ArrayList<String> found = new ArrayList<String>();	// list of found words
		ArrayList<String> ret = new ArrayList<String>(); 	// a list to be returned
		ArrayList<String> Dict = new ArrayList<String>(makeDictionary());
		Graph dictionary = new Graph(Dict);
		return DFSHelper(start, end, found, ret, dictionary);

	}

    public static ArrayList<String> getWordLadderBFS(String start, String end) {
		ArrayList<String> Dict = new ArrayList<String>(makeDictionary());
		HashMap<String, String> parents = new HashMap<String, String>();
		Graph g = new Graph(Dict);
    	ArrayList<String> found = new ArrayList<String>();
    	found.add(start);
    	parents.put(start, null);
    	Queue<String> q = new LinkedList<String>();// = new AbstractQueue<String>();
    	q.add(start);
    	ArrayList<String> edges;
    	while(q.peek()!=null) {
    		String head = q.remove();
    		if(head.equals(end)) {//ends loop if end found
    			ArrayList<String> output = new ArrayList<String>();
    			String search = end;//head of search back to top
    			while(parents.get(search)!= null){//while the current head is not the start
    				 output.add(0,parents.get(search));//adds the current head to output array
    				 search = parents.get(search);//sets the new head as the current head's parent
    			}
    			return(output);//may be reversed opps
    		}
    		edges = g.getEdges(head);
    		for(String edge : edges) {//makes parents for all the edges
    			if(!found.contains(edge)) {//if the nodes has not been found before
    			if(parents.get(edge) != null) {//if the node doesnt have a parent
    			parents.put(edge, head);//adds parent for the edge
    			}
    			found.add(edge);//adds the edge to found
    			q.add(edge);//adds all the edges to the  queue
    		}
			}
    	}

		return null; // replace this line later with real return
	}

	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}

	public static void printLadder(ArrayList<String> ladder) {

	}
	// TODO
	// Other private static methods here
}
