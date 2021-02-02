package interview.dictionariesAndHashmaps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1 입력받으면, 수를 배열에 insert
 * 2 입력받으면, 수를 찾아 삭제
 * 3 입력받으면, 수만큼 동일한 숫자가 나왔는지, false면 0, true면 1
 * https://www.hackerrank.com/challenges/frequency-queries/problem
 *
 * @author gwon
 * @history
 *          2021. 2. 3. initial creation
 */
public class FrequencyQueries {

	/**
	 *
	 * 아래 방식이 타임아웃 걸려서 생각을 하다가 'Count Triplets' 문제에서 맵을 2개 사용했던 방식이 생각남.
	 * 그래서 카운팅된 수도 맵으로 만들어서 찾을 때 전체순회를 하지 않고, 바로 카운트의 key로 찾아서 해결
	 */
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> resList = new ArrayList<>();

		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> countMap = new HashMap<>();

		for (List<Integer> item : queries) {
			Integer op = item.get(0);
			Integer val = item.get(1);

			if (op == 1) {
				Integer cur = map.getOrDefault(val, 0);
				map.put(val, cur + 1);
				countMap.put(cur + 1, countMap.getOrDefault(cur + 1, 0) + 1);
				countMap.put(cur, countMap.getOrDefault(cur, 0) - 1);
			} else if (op == 2) {
				Integer cur = map.getOrDefault(val, 0);
				if (cur != 0) {
					map.put(val, cur - 1);
					countMap.put(cur - 1, countMap.getOrDefault(cur - 1, 0) + 1);
					countMap.put(cur, countMap.getOrDefault(cur, 0) - 1);
				}
			} else if (op == 3) {
				if (countMap.getOrDefault(val, 0) > 0) {
					resList.add(1);
				} else {
					resList.add(0);
				}
			}

		}

		return resList;
	}

	/**
	 *
	 * 해당 숫자에 대해서 key로 하여 추가하면 val++, 삭제하면 val--
	 * 해당 수만큼 존재하는지 확인하기 위해 map을 전체 순회하여 존재하는지 확인
	 * 전체 순회하기 때문에 타임아웃 걸려버림.
	 */
	static List<Integer> freqQuery_testcase11_timeout(List<List<Integer>> queries) {

		List<Integer> resList = new ArrayList<>();

		Map<Integer, Integer> map = new HashMap<>();
		for (List<Integer> item : queries) {
			int op = item.get(0);
			int val = item.get(1);

			if (op == 1) {
				Integer cur = map.getOrDefault(val, 0);
				map.put(val, cur + 1);
			} else if (op == 2) {
				Integer cur = map.getOrDefault(val, 0);
				if (cur != 0) {
					map.put(val, cur - 1);
				}
			} else if (op == 3) {
				if (map.containsValue(val)) {
					resList.add(1);
				} else {
					resList.add(0);
				}
			}

		}

		return resList;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(
				        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				                .map(Integer::parseInt)
				                .collect(Collectors.toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> ans = freqQuery(queries);

		bufferedWriter.write(
		        ans.stream()
		                .map(Object::toString)
		                .collect(Collectors.joining("\n"))
		                + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
