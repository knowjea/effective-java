package interview.dictionariesAndHashmaps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 연속 3개의 등비수열 경우의 수를 구하기
 * https://www.hackerrank.com/challenges/count-triplets-1/problem
 *
 * @author gwon
 * @history
 *          2021. 1. 31. initial creation
 */
public class CountTriplets {

	/**
	 * 3시간동안 하다가 못풀어서 포기! 답을 봐버렸다.
	 * 맵을 하나만 만들어서 풀려고 하니까 그 생각에 갇혀서 풀 수가 없었음.
	 * 맵을 2개 만들어서 하나는 첫번째 맵은 첫번째 배수일 경우, 두번째 맵은 두번째 배수일 경우의 수를 넣는다고 하면 쉽게 생각할 수 있음.
	 *
	 */
	static long countTriplets(List<Long> arr, long r) {
		Map<Long, Long> map1 = new HashMap<>();
		Map<Long, Long> map2 = new HashMap<>();

		Long res = 0L;
		for (int i = 0; i < arr.size(); i++) {
			Long key = arr.get(i);

			res += map2.getOrDefault(key, 0L);

			if (map1.containsKey(key)) {
				map2.put(key * r, map2.getOrDefault(key * r, 0L) + map1.get(key));
			}

			map1.put(key * r, map1.getOrDefault(key * r, 0L) + 1);
		}

		return res;
	}

	static long countTriplets_testcase6_10_wrong_answer(List<Long> arr, long r) {
		long res = 0;

		// 트리맵으로 소트하면서, 동일한 숫자의 대해서 카운팅
		Map<Long, Long> map = new TreeMap<>();
		for (int i = 0; i < arr.size(); i++) {
			if (map.containsKey(arr.get(i))) {
				long cnt = map.get(arr.get(i));
				map.put(arr.get(i), cnt + 1);
			} else {
				map.put(arr.get(i), (long) 1);
			}
		}

		// 배수가 1일 경우, 자기자신에 대해서 3개 뽑는경우이므로 nC3 조합
		if (r == 1) {
			for (Map.Entry<Long, Long> item : map.entrySet()) {
				long cnt = item.getValue();
				res += (cnt * (cnt - 1) * (cnt - 2)) / 6;
			}

			return res;
		}

		// 소트되어있으므로, 하나씩 배수만큼 2번 곱해서 세개의 배수가 만들어지는지 확인하고,
		// 결과는 각각의 배수가 존재하는 수만큼 곱해서 결과를 더함.
		for (Map.Entry<Long, Long> item : map.entrySet()) {
			long cnt = item.getValue();
			for (int i = 1; i < 3; i++) {
				Long next = map.get(item.getKey() * (long) Math.pow(r, i));
				if (next != null) {
					cnt *= next;
				} else {
					break;
				}

				if (i == 2) {
					res += cnt;
				}
			}
		}

		return res;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nr[0]);

		long r = Long.parseLong(nr[1]);

		List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
		        .map(Long::parseLong)
		        .collect(Collectors.toList());

		long ans = countTriplets(arr, r);

		bufferedWriter.write(String.valueOf(ans));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

}
