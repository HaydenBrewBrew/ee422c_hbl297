

/** Phase A Driver<laq233> Navigator<hbl297>
 * Phase B <studentB EID><studentA EID>
 */

import java.util.ArrayList;
import java.util.Iterator;
package pMap.phaseA;

/**
 * PMap stands for Paired Map. A map is a collection of key value pairs, e.g.,
 * (1, 2) (2, 3) (3, 4) are all pairs with a key that's a integer and a value
 * that's an integer
 * See the java.util.Map documentation for how these methods are supposed to work
 */
public class PMap {
    private static ArrayList<PEntry> entries = new ArrayList<>();

    public int size(){
        if(entries!=null){
            return entries.size();
        }else{
            return 0;
        }
    }

    public boolean isEmpty() {
        return (entries.size()==0);
    }

    public boolean containsKey(int key) {
        for(PEntry e: entries){
           if(e.getKey() == key){
               return true;
           }
        }
        return false;
    }

    public boolean containsValue(int value) {
        for(PEntry e: entries){
            if(e.getValue() == value){
                return true;
            }
        }
        return false;
    }

    public int get(int key) {
        for(PEntry e: entries){
            if(e.getKey() == key){
                return e.getValue();
            }
        }
        return 0;
    }

    public int put(int key, int value) {
        for(PEntry e: entries){
            if(e.getKey() == key){
                int temp = e.getValue();
                e.setValue(value);
                return temp;
            }
        }
        PEntry newEntry = new PEntry(key,value);
        entries.add(newEntry);
        return 0;
    }

    public int remove(int key) {
        int temp = 0;
        Iterator<PEntry> iter = entries.iterator();
        while (iter.hasNext()) {
            PEntry entry = iter.next();
            if (entry.getKey() == key) {
                temp = entry.getValue();
                iter.remove();
                break;
            }
        }
        return temp;
    }

    //Assumes that an equal number of keys and values are passed
    public void putAll(int[] keys, int[] values) {
        for(int i = 0; i<keys.length; i++){
            put(keys[i],values[i]);
        }
    }

    public void clear() {
        entries.clear();
    }

    public int[] keys() {
        int size = size();
        if(size == 0) {
        	return null;
        }
        int[] keys = new int[size];
        for(int i = 0; i<size; i++){
            keys[i] = entries.get(i).getKey();
        }
        return keys;
    }

    public int[] values() {
        int size = size();
        if(size == 0) {
        	return null;
        }
        int[] values = new int[size];
        for(int i = 0; i<size; i++){
            values[i] = entries.get(i).getValue();
        }
        return values;
    }

    public PEntry[] entrys() {
    	int size = size();
        if(size == 0) {
        	return null;
        }
        PEntry[] values = new PEntry[size];
        for(int i = 0; i<size; i++){
            values[i] = entries.get(i);
        }
        return values;
    }
    	//return (PEntry[]) entries.toArray();
    }

