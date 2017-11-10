/** Phase A Driver<laq233> Navigator<hbl297>
 * Phase B <studentB EID><studentA EID>
 */
package pMap.phaseA;

import org.junit.Test;

public class PMapTest {

	@Test
	public void test1() {
		PMap pmap = new PMap();
		pmap.put(0, 1);
		pmap.put(1, 2);
		pmap.put(2, 3);
		System.out.println(pmap.size());
		int[] keys = pmap.keys();
		for (int i : keys) {
			System.out.print(i+" ");
		}
		System.out.println();
		int[] values = pmap.values();
		for (int i : values) {
			System.out.print(i+" ");
		}
		System.out.println(pmap.size());
	}

	// TODO add more test cases to test all implemented methods
	@Test
	public void test2() {
		PMap pmap = new PMap();
		pmap.put(0,1);
		pmap.put(2, 3);
		pmap.put(1, 2);
		System.out.println(pmap.size());
		assert(pmap.size() == 3);
		pmap.clear();
		assert(pmap.size() == 0);
		pmap.put(100, 100);
		assert(pmap.size() == 1);
		assert(pmap.put(100, 10) == 100);
		pmap.clear();
		assert((pmap.keys() == null) && (pmap.values() == null));
	}
	
	@Test
	public void test3() {
		PMap pmap = new PMap();
		pmap.put(0,1);
		pmap.put(2, 3);
		pmap.put(2, 2);
		PEntry[] entry = pmap.entrys();
		assert(entry.length == 2);
		assert(entry[1].getValue()==2);
		pmap.clear();
		assert(true == pmap.isEmpty());
	}
	
	@Test
	public void test4() {
		PMap pmap = new PMap();
		assert(pmap.isEmpty());
		pmap.put(0,1);
		assert(pmap.containsKey(0));
		assert(pmap.containsValue(1));
		assert(!pmap.containsKey(1));
		pmap.put(0, 2);
		assert(!pmap.containsValue(1));
		assert(pmap.containsValue(2));
	}
}
