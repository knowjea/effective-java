package practice.algorithms.warmup;

import java.util.Scanner;

/**
 * 계단 만들기
 * https://www.hackerrank.com/challenges/staircase/problem
 *
 * 코딩시간 : 5분
 *
 * @author gwon
 * @history
 *          2021. 3. 21. initial creation
 */
public class Staircase {
	static void staircase(int n) {
		String str = "";
		for (int i = 0; i < n; i++) {
			str += " ";
		}

		StringBuffer sb = new StringBuffer(str);
		for (int i = 0; i < n; i++) {
			sb.setCharAt(n - 1 - i, '#');
			System.out.println(sb);
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		staircase(n);

		scanner.close();
	}
}
