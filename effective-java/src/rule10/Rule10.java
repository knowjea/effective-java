package rule10;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 9. 2. initial creation
 */
public class Rule10 {
	public static void main(String[] args) {
		new Object().toString();

		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");

		System.out.println(map.toString()); // {key1=value1, key2=value2}

		System.out.println(new Date().toString()); // Mon Dec 13 23:46:32 KST 2021
	}
}
