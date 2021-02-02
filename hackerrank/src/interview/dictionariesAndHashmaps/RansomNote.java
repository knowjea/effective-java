package interview.dictionariesAndHashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * magazine 리스트에 note 리스트 모든 값들이 포함되어 있는지 체크
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 *
 * @author gwon
 * @history
 *          2021. 1. 31. initial creation
 */
public class RansomNote {

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < magazine.length; i++) {
			if (map.containsKey(magazine[i])) {
				int cnt = map.get(magazine[i]);
				map.put(magazine[i], cnt + 1);
			} else {
				map.put(magazine[i], 1);
			}

			if (i < note.length) {
				if (map.containsKey(note[i])) {
					int cnt = map.get(note[i]);
					map.put(note[i], cnt - 1);
				} else {
					map.put(note[i], -1);
				}
			}
		}

		for (int i = 0; i < note.length; i++) {
			int cnt = map.get(note[i]);
			if (cnt < 0) {
				System.out.println("No");
				return;
			}
		}

		System.out.println("Yes");
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}
