package interview.greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 전형적인 그리드 알고리즘 문제. 냅색 문제랑 비슷 한듯
 * https://www.hackerrank.com/challenges/luck-balance/problem
 *
 * 코딩 시간 : 10분
 *
 * @author gwon
 * @history
 *          2021. 2. 27. initial creation
 */
public class LuckBalance {
	// n은 10^2이므로 시간복잡도 생각하지 않아도 됨.
	// 중요하지 않은 컨테스트는 무조건 더하기
	// 중요한 컨테스트는 큰값부터 더하고, 작은 값은 빼기
	static int luckBalance(int k, int[][] contests) {
		List<Integer> oneList = new ArrayList<>();

		int res = 0;
		for (int i = 0; i < contests.length; i++) {
			if (contests[i][1] == 1) {
				oneList.add(contests[i][0]);
			} else {
				res += contests[i][0];
			}
		}

		oneList.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -Integer.compare(o1, o2);
			}
		});

		for (int i = 0; i < oneList.size(); i++) {
			if (i < k) {
				res += oneList.get(i);
			} else {
				res -= oneList.get(i);
			}
		}

		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[][] contests = new int[n][2];

		for (int i = 0; i < n; i++) {
			String[] contestsRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 2; j++) {
				int contestsItem = Integer.parseInt(contestsRowItems[j]);
				contests[i][j] = contestsItem;
			}
		}

		int result = luckBalance(k, contests);

//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

		scanner.close();
	}
}
