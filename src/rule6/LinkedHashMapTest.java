package rule6;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 7. 8. initial creation
 */
public class LinkedHashMapTest {
	/**
	 * Consistently, the lifetime of a cache item must be determined by the duration of the cache.
	 * The removeEldestEntry(Map.Entry) method of LinkedHashMap may be overridden to impose a policy
	 * for removing stale mappings automatically when new mappings are added to the map.
	 */
	public static void main(String[] args) {
		final int MAX_ENTRIES = 5;
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>() {
			@Override
			public boolean removeEldestEntry(Map.Entry eldest) {
				return size() > MAX_ENTRIES;
			}
		};

		linkedHashMap.put("1", "a");
		linkedHashMap.put("2", "b");
		linkedHashMap.put("3", "c");
		linkedHashMap.put("4", "d");
		linkedHashMap.put("5", "e");
		linkedHashMap.put("6", "f"); /* {1=a} disappear and this item will be added. */

		for (Iterator<String> hashitr = linkedHashMap.values().iterator(); hashitr.hasNext();) {
			System.out.print(hashitr.next() + " ");
		}
	}
}
