package tutorials.days30;

import java.util.Scanner;

/**
 *
 * 이 문제랑 동일 = https://www.hackerrank.com/challenges/2d-array/problem
 * https://www.hackerrank.com/challenges/30-2d-arrays/problem
 *
 * @author gwon
 * @history
 *          2021. 1. 28. initial creation
 */
public class Day11TowDArray {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = 0; j < arr[i].length - 2; j++) {
				int tot = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
				        + arr[i + 1][j + 1]
				        + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

				if (max < tot) {
					max = tot;
				}
			}
		}

		System.out.println(max);
		scanner.close();
	}
}
