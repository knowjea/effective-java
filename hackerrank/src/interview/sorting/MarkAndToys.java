package interview.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 정해진 돈으로 얼마나 많은 물건을 살 수 있는지
 * https://www.hackerrank.com/challenges/mark-and-toys/problem
 *
 * 코딩 시간 : 5분 이하
 *
 * @author gwon
 * @history
 *          2021. 2. 6. initial creation
 */
public class MarkAndToys {

	// Complete the maximumToys function below.
	static int maximumToys(int[] prices, int k) {
		Arrays.sort(prices);

		int i;
		for (i = 0; i < prices.length; i++) {
			k -= prices[i];
			if (k < 0) {
				return i;
			}
		}

		return i;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] prices = new int[n];

		String[] pricesItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int pricesItem = Integer.parseInt(pricesItems[i]);
			prices[i] = pricesItem;
		}

		int result = maximumToys(prices, k);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
