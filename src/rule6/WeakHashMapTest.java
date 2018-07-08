package rule6;

import java.util.WeakHashMap;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 7. 8. initial creation
 */
public class WeakHashMapTest {

	/**
	 * We put object reference into a cache and forget that we put it there.
	 * To solve this problem we often implement caches using WeakHaspMap.
	 * A WeakHashMap will automatically remove value when its key is no longer referenced.
	 */
	public static void main(String[] args) {
		// If you use String object for key, this test case not happen.
		// String always remain a strong reference because String is stored in memory by the JVM.

		WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<Integer, String>();

		Integer key = new Integer(1);
		weakHashMap.put(key, "1");
		key = null;

		// If GC is generated, the output changes to {}.
		while (true) {
			System.out.println(weakHashMap);
			System.gc();
			if (weakHashMap.size() == 0) {
				break;
			}
		}

		System.out.println("End");
	}
}
