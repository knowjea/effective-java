package tutorials.days30;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 *
 * @author gwon
 * @history
 *          2021. 1. 25. initial creation
 */
public class Day8Map {
	public static void main(String[] argh) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String name = in.next();
			int phone = in.nextInt();
			// Write code here

			map.put(name, phone);
		}
		while (in.hasNext()) {
			String s = in.next();
			// Write code here
			if (map.containsKey(s)) {
				System.out.println(s + "=" + map.get(s));
			} else {
				System.out.println("Not found");
			}
		}
		in.close();
	}
}
