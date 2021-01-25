package interview.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 *
 * @author gwon
 * @history
 *          2021. 1. 26. initial creation
 */
public class SalesbyMatch {
	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		int[] res = new int[101];
		int cnt = 0;

		for (int i = 0; i < ar.length; i++) {
			res[ar[i]]++;
			if (res[ar[i]] % 2 == 0) {
				cnt++;
			}
		}

		return cnt;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
