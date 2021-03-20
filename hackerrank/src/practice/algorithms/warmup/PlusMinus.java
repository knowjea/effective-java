package practice.algorithms.warmup;

import java.util.Scanner;

/**
 * 양수, 음수, 0 각각 비율
 * https://www.hackerrank.com/challenges/plus-minus/problem
 *
 * 코딩시간 : 3분
 *
 * @author gwon
 * @history
 *          2021. 3. 21. initial creation
 */
public class PlusMinus {
	// Complete the plusMinus function below.
	static void plusMinus(int[] arr) {
		double a = 0;
		double b = 0;
		double c = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				a++;
			} else if (arr[i] < 0) {
				b++;
			} else {
				c++;
			}
		}

		System.out.println(a / arr.length);
		System.out.println(b / arr.length);
		System.out.println(c / arr.length);

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		plusMinus(arr);

		scanner.close();
	}
}
