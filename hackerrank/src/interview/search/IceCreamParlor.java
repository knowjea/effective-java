package interview.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 비용이 다른 아이스크림 중 두 개를 선택해서 money를 모두 쓸 수 있는 아이스크림 인덱스 출력
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
 *
 * 코딩시간 : 35분
 *
 * @author gwon
 * @history
 *          2021. 3. 2. initial creation
 */
public class IceCreamParlor {
	// n은 5 * 10^4, 이중포문 잘하면 될 듯.
	// 맵에 넣고, 1부터 시작해서 i, money-i 값이 있는지 확인하면 될듯한데....
	static void whatFlavors(int[] cost, int money) {
		Map<Integer, Integer> cnt = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
		Map<Integer, List<Integer>> idx = new HashMap<>();

		for (int i = 0; i < cost.length; i++) {
			Integer val = cnt.get(cost[i]);
			if (val == null) {
				cnt.put(cost[i], 1);

				List<Integer> initList = new ArrayList<>();
				initList.add(i + 1);
				idx.put(cost[i], initList);
			} else {
				cnt.put(cost[i], val + 1);

				idx.get(cost[i]).add(i + 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
			int another = money - entry.getKey();
			if (cnt.get(another) != null) {
				if (another == entry.getKey() && entry.getValue() > 1) {
					int max = Math.max(idx.get(entry.getKey()).get(0), idx.get(entry.getKey()).get(1));
					int min = Math.min(idx.get(entry.getKey()).get(0), idx.get(entry.getKey()).get(1));
					System.out.println(min + " " + max);
				} else {
					int max = Math.max(idx.get(entry.getKey()).get(0), idx.get(another).get(0));
					int min = Math.min(idx.get(entry.getKey()).get(0), idx.get(another).get(0));
					System.out.println(min + " " + max);
				}
				return;
			}
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int money = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] cost = new int[n];

			String[] costItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int costItem = Integer.parseInt(costItems[i]);
				cost[i] = costItem;
			}

			whatFlavors(cost, money);
		}

		scanner.close();
	}
}
