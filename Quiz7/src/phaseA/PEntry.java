

/** Phase A Driver<laq233> Navigator<hbl297>
 * Phase B <laq233><hbl297>
 */

package pMap.phaseA;

/**
 * Map.Entry, assume that the key and value are both integers.
 */
public class PEntry {
    private int key;
    private int value;

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setKey(int key){
        this.key = key;
    }

    public void setValue(int value){
        this.value = value;
    }

    public PEntry(int key, int value){
        setKey(key);
        setValue(value);
    }

}
