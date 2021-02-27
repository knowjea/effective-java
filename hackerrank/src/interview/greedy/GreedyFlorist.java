package interview.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 전형적인 그리드 문제. 문제 설명은 길어서 생략
 * https://www.hackerrank.com/challenges/greedy-florist/problem
 *
 * 코딩시간 : 25분
 *
 * @author gwon
 * @history
 *          2021. 2. 28. initial creation
 */
public class GreedyFlorist {

	// 균등하게 돌면서 나눠가지면 됨
	static int getMinimumCost(int k, int[] c) {
		Arrays.sort(c);

		int res = 0;
		int cnt = 0;
		int pre = 1;
		for (int i = c.length - 1; i >= 0; i--) {
			res += pre * c[i];

			cnt++;
			if (cnt % k == 0) {
				pre++;
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

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int minimumCost = getMinimumCost(k, c);

//		bufferedWriter.write(String.valueOf(minimumCost));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

		scanner.close();
	}
}
