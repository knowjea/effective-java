package practice.algorithms.implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 단어가 주어졌을때, 그 단어보다 사전순으로 더 뒤에있으면서도 가장 가까운 단어 출력
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 *
 * 코딩시간 : 1시간동안 못품
 *
 * @author gwon
 * @history
 *          2021. 4. 12. initial creation
 */
public class BiggerIsGreater {

	// n = 10^2
	static String biggerIsGreater(String w) {
		int idx = 0;
		for (int i = w.length() - 1; i >= idx; i--) {
			char cur = w.charAt(i);

			for (int j = i - 1; j >= idx; j--) {
				char pre = w.charAt(j);

				if (cur - pre > 0) {
					idx = j + 1;

					StringBuilder sb = new StringBuilder(w);
					sb.setCharAt(j, cur);
					sb.setCharAt(i, pre);

					w = sb.toString();

					break;
				} else if (cur - pre == 0 && i - j > 1) {
					idx = j + 1;
					break;
				}
			}
			if (idx != 0) {
				break;
			}
		}

		if (idx == 0) {
			return "no answer";
		}

		int arr[] = new int[w.length() - idx];
		for (int i = idx; i < w.length(); i++) {
			arr[i - idx] = w.charAt(i);
		}

		Arrays.sort(arr);

		String res = "";
		for (int i = 0; i < idx; i++) {
			res += w.charAt(i);
		}

		for (int i = 0; i < arr.length; i++) {
			res += (char) arr[i];
		}

		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int T = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int TItr = 0; TItr < T; TItr++) {
			String w = scanner.nextLine();

			String result = biggerIsGreater(w);
			System.out.println(result);
		}

		scanner.close();
	}
}
