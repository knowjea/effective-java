package interview.dictionariesAndHashmaps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 입력 받은 문자열에 대해서 anagrammatic 구하기. 문자열의 길이는 최대 100
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 *
 * @author gwon
 * @history
 *          2021. 1. 31. initial creation
 */
public class SherlockAndAnagrams {
	static int sherlockAndAnagrams(String s) {
		int arr[][] = new int[101][101];
		for (int i = 0; i < s.length(); i++) {
			String str = s.substring(i, s.length());
			for (int j = 0; j < str.length(); j++) {
				arr[i][str.charAt(j) - 'a']++;
			}
		}

		int res = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				for (int k = 0; k <= 'z' - 'a'; k++) {
					if (arr[i][k] != arr[j][k]) {
						break;
					}

					if (k == 'z' - 'a') {
						res++;
					}
				}
			}
		}

		return res;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		sherlockAndAnagrams("abba");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = sherlockAndAnagrams(s);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
