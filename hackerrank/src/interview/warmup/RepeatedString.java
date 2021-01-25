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
public class RepeatedString {
	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		long cnt = 0;

		// 문자열의 길이가 n 보다 길다면, n번 길이만큼 for문 돌아서 구하면 됨.
		int len = s.length();
		if (n < s.length()) {
			len = (int) n;
		}

		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == 'a') {
				cnt++;
			}
		}

		// n번 길이만큼 for문 돌아서 구하면 됨
		if (n < s.length()) {
			return cnt;
		}

		// 문자열의 길이가 n보다 작다면, n을 문자열의 길이로 나눈 몫 만큼 곱하고, 나머지 값만큼 for문 돌아서 구하면 됨
		long tot = (n / s.length()) * cnt;
		for (int i = 0; i < n % s.length(); i++) {
			if (s.charAt(i) == 'a') {
				tot++;
			}
		}

		return tot;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
