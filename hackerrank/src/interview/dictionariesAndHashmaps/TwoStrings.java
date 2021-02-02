package interview.dictionariesAndHashmaps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 두 개의 스트링이 적어도 하나의 문자가 겹치는지, 문자열의 크기는 10^5
 * https://www.hackerrank.com/challenges/two-strings/problem
 *
 * @author gwon
 * @history
 *          2021. 1. 31. initial creation
 */
public class TwoStrings {

	// 10^5이므로 for문 한번으로 해결
	static String twoStrings(String s1, String s2) {
		int[] ascii = new int[255];

		if (s2.length() > s1.length()) {
			String temp = s1;
			s1 = s2;
			s2 = temp;
		}

		for (int i = 0; i < s1.length(); i++) {
			ascii[s1.charAt(i)]++;

			if (i < s2.length()) {
				if (ascii[s2.charAt(i)] > 0) {
					return "YES";
				}
			} else {
				return "NO";
			}
		}

		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			String s2 = scanner.nextLine();

			String result = twoStrings(s1, s2);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
