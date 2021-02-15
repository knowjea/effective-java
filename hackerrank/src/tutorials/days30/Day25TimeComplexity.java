package tutorials.days30;

import java.util.Scanner;

/**
 *
 * 소수인지 판별하기. 이 문제의 주제는 시간복잡도. 즉 반복문으로 다 나눠보지말고, 뭔가 다른 방법으로 구하라.
 * https://www.hackerrank.com/challenges/30-running-time-and-complexity/problem
 *
 * @author gwon
 * @history
 *          2021. 2. 15. initial creation
 */
public class Day25TimeComplexity {

	// 왜 기억이 나는지는 모르겠지만 소수는 제곱근까지만 for문 하면됨.
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be
		 * named Solution.
		 */

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();

			if (num == 1) {
				System.out.println("Not prime");
				continue;
			}

			boolean check = false;
			for (int j = 2; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					System.out.println("Not prime");
					check = true;
					break;
				}
			}

			if (!check) {
				System.out.println("Prime");
			}

		}
	}
}
