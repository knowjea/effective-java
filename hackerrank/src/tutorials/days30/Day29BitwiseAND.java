package tutorials.days30;

import java.util.Scanner;

/**
 * N개의 숫자끼리 서로 &연산자를 해서 나오는 값중 K 값보다 작으면서 최대 값
 * https://www.hackerrank.com/challenges/30-bitwise-and/problem
 *
 * @author gwon
 * @history
 *          2021. 2. 21. initial creation
 */
public class Day29BitwiseAND {
	private static final Scanner scanner = new Scanner(System.in);

	// n은 10^3이므로, 이중포문으로도 가능
	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String[] nk = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nk[0]);
			int k = Integer.parseInt(nk[1]);

			int max = -1;
			for (int i = 1; i <= n; i++) {
				for (int j = i + 1; j <= n; j++) {
					int val = i & j;
					if (val < k && max < val) {
						max = val;
					}
				}
			}

			System.out.println(max);

		}

		scanner.close();
	}
}
