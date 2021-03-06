package interview.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 배열에 각 항목들의 차이가 k가 되는 경우의 수
 * https://www.hackerrank.com/challenges/pairs/problem
 *
 * 코딩시간 : 15분
 *
 * @author gwon
 * @history
 *          2021. 3. 6. initial creation
 */
public class Pairs {
	// n은 10^5 n^2으로 불가능
	// 각 값이 나온 횟수를 맵으로 넣고, 맵을 순회하면서 k가 되려면 필요한 반대의 key가 존재하는지 확인하면 됨
	static int pairs(int k, int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			Integer val = map.get(arr[i]);
			if (val == null) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], val + 1);
			}
		}

		int res = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int a = entry.getKey();
			int b = k + entry.getKey();

			res += Math.min(entry.getValue(), map.getOrDefault(b, 0));
		}

		return res;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = pairs(k, arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
