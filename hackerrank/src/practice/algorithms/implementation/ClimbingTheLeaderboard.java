package practice.algorithms.implementation;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 공동 순위가 존재하는 랭크 시스템에서 새로운 점수가 들어올 때, 그 사람의 순위는?
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 *
 * 코딩시간 : 20분
 *
 * @author gwon
 * @history
 *          2021. 3. 31. initial creation
 */
public class ClimbingTheLeaderboard {
	/**
	 * n과 m은 2 * 10^5
	 * 쉬운느낌인데 정답률이 55퍼센트....
	 * 중복 순위는 그냥 리스트에서 제거하고, 바이너리 서치로 하면 되는거 아닌가?
	 * ranked는 내림차순으로 주어지고, player는 오름차순으로 주어짐. 그럼 굳이 바이너리 서치하지 않아도 될듯
	 */

	/**
	 * 정답률이 왜 55퍼센트 문제인지 모르겠다.
	 */
	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		List<Integer> distinctRanked = ranked.stream().distinct().collect(Collectors.toList());

		List<Integer> res = new ArrayList<>();

		int idx = 0;
		for (int i = distinctRanked.size() - 1; i >= 0; i--) {
			if (idx >= player.size()) {
				break;
			}
			Integer cur = player.get(idx);

			if (cur < distinctRanked.get(i)) {
				res.add(i + 2);
				idx++;
				i++;
			} else if (cur == distinctRanked.get(i)) {
				res.add(i + 1);
				idx++;
				i++;
			}
		}

		for (int i = 0; i < player.size() - idx; i++) {
			res.add(1);
		}

		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
		        .map(Integer::parseInt)
		        .collect(toList());

		int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
		        .map(Integer::parseInt)
		        .collect(toList());

		List<Integer> result = ClimbingTheLeaderboard.climbingLeaderboard(ranked, player);

		bufferedReader.close();
	}
}
