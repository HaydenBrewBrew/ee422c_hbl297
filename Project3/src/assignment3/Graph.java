package assignment3;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
	
	/**
	  * Determines if the strings are different by one letter
	  * (CASE SENSITIVE)
	  * @param a is first string
	  * @param b is second string
	  * @return Returns a boolean if a and b are exactly one character off (CASE SENSITIVE)
	  */
	public static boolean isOneOff(String a, String b){
		int diff = 0;
		if(a.length() != b.length()){
			return false;
		}
		for(int i = 0; i < a.length(); i++){
			if(a.charAt(i) != b.charAt(i)){
				diff ++;
			}
		}
		return diff == 1;
	}
	
	/**NOTE:
	 * DOES NOT DEAL WITH MULTIPLE ENTRIES AND IS CASE SENSITIVE
	 * Graph constructor expects a an ArrayList of unique Strings that are all the same case
	 * @param nodes an ArrayList of all the words that will be in this graph
	 */
	Graph(ArrayList<String> nodes){
		// nodes can be a set of strings as well
		for(int i = 0; i < nodes.size(); i++){
			ArrayList<String> edges = new ArrayList<String>();
			for(int j = 0; j < nodes.size(); j++){
				if(isOneOff(nodes.get(i), nodes.get(j))){
					edges.add(nodes.get(j));
				}
				graph.put(nodes.get(i), edges);
			}
		}
	}
	
	/**
	 * Prints the graph to sysout
	 */
	public void print(){
			String[] keys = graph.keySet().toArray(new String[0]);
		    for(String i : keys){
		    	System.out.print(i + ": ");
		    	System.out.println( (graph.get(i)).toString() );
		    }
			
	}
	
	/**
	 * Returns the edge array for a word
	 * @param node is the word whose array will be returned
	 * @return returns the edge array with words that are off by one letter from node
	 */
	public ArrayList<String> getEdges(String node){
		return graph.get(node);
	}


}



