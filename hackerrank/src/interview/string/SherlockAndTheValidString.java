package interview.string;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 문자열이 주어졌을때, 모든 문자의 개수가 동일할 경우, true 그렇지 않으면 false. 단 하나의 문자를 삭제할 수 있음.
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 *
 * 코딩시간 : 40분
 *
 * @author gwon
 * @history
 *          2021. 2. 21. initial creation
 */
public class SherlockAndTheValidString {
	/**
	 *
	 * 문자열의 길이는 10^5.
	 * 배열에 나온 문자의 개수를 구한 후, 검사해보면 될듯 함
	 * 풀긴 풀었는데......너무 억지로 풀었다. 다른 사람들은 어떻게 풀었는지 봐보자.
	 * 소름돋게 나랑 똑같이 푼사람이 있다. => https://numgos.tistory.com/38
	 * 뭐지.. 다른사람들도 다 똑같다.. 이게 정말 최선인건가............
	 * 이 문제는 String쪽 분류보다는 Dictionaries And Hashmaps 쪽 분류같음.
	 */
	static String isValid(String s) {
		int[] arr = new int[200];

		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i)]++;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 'a'; i <= 'z'; i++) {
			if (arr[i] == 0) {
				continue;
			}

			Integer val = map.get(arr[i]);
			if (val == null) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], val + 1);
			}
		}

		if (map.size() == 1) {
			return "YES";
		}

		if (map.size() > 2) {
			return "NO";
		}

		Set<Integer> set = map.keySet();
		Object[] key = set.toArray();
		if (Math.abs((Integer) key[0] - (Integer) key[1]) == 1) {
			if (map.get(key[0]) == 1 || map.get(key[1]) == 1) {
				return "YES";
			}
		}

		if ((Integer) key[0] == 1 && map.get(key[0]) == 1) {
			return "YES";
		}

		if ((Integer) key[1] == 1 && map.get(key[1]) == 1) {
			return "YES";
		}

		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		String result = isValid(s);

//		bufferedWriter.write(result);
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

		scanner.close();
	}
}
