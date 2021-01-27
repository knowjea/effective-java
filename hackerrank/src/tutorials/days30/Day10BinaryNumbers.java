package tutorials.days30;

import java.util.Scanner;

/**
 * 10진수를 입력받아, 2진수로 변환했을 때 1이 연속으로 나오는 최대 길이값을 출력
 * https://www.hackerrank.com/challenges/30-binary-numbers/problem
 * 
 * @author gwon
 * @history
 *          2021. 1. 27. initial creation
 */
public class Day10BinaryNumbers {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int max = -1;
		int cnt = 0;
		while (true) {
			int b = n % 2;
			n = n / 2;

			if (b == 1) {
				cnt++;
			} else {
				if (max < cnt) {
					max = cnt;
				}
				cnt = 0;
			}

			if (n == 0) {
				if (max < cnt) {
					max = cnt;
				}
				break;
			}
		}
		System.out.println(max);

		scanner.close();
	}
}
