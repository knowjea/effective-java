package interview.string;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * 문자열이 주어졌을때, 아래에 해당하는 경우의 조합이 가능한 경우의 수를 출력. 순서는 보장해야 함.
 * 1. 모든 문자가 동일 ex) aaa
 * 2. 가운데 문자만 다르고, 모든 문자열이 동일 ex) aadaa
 * https://www.hackerrank.com/challenges/special-palindrome-again/problem
 *
 * 코딩시간 : 35분
 *
 * @author gwon
 * @history
 *          2021. 2. 21. initial creation
 */
public class SpecialStringAgain {

	// 문자열의 길이는 10^6이므로, 최소 o(n)이어야 할듯한데.. 일단 무식하게 해보기
	// (n^2 -n) / 2 로 해결 완료. 반복문 돌면서 다음 문자가 동일하면 카운트 증가, 만약 다를 경우 대칭이 되는지 판단.
	static long substrCount(int n, String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res++;

			char cur = s.charAt(i);
			for (int j = i + 1; j < s.length(); j++) {
				if (cur == s.charAt(j)) {
					res++;
				} else {
					int cnt = j - i;
					for (int k = j + 1; k <= j + cnt; k++) {
						if (k >= s.length()) {
							break;
						}
						if (cur != s.charAt(k)) {
							break;
						}

						if (k == j + cnt) {
							res++;
						}
					}
					break;
				}

			}
		}

		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		long result = substrCount(n, s);

//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();

//		bufferedWriter.close();

		scanner.close();
	}
}
