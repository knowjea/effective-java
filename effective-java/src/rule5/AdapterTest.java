package rule5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 7. 1. initial creation
 */
public class AdapterTest {

	/**
	 *
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "val1");
		Set<String> keyset1 = map.keySet();
		System.out.println("keyset1 : " + keyset1);

		map.put("key2", "val2");
		Set<String> keyset2 = map.keySet();
		System.out.println("keyset1 : " + keyset1);
		System.out.println("keyset2 : " + keyset2);

		// keyset1 and keyset2 is equal

	}

}
