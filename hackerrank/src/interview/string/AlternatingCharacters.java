package interview.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 문자열이 주어졌을 때, 인접한 문자끼리 중복되지 않도록 하기 위한 최소한의 삭제 횟수
 * https://www.hackerrank.com/challenges/alternating-characters/problem
 *
 * 코딩시간 : 5분
 *
 * @author gwon
 * @history
 *          2021. 2. 21. initial creation
 */
public class AlternatingCharacters {
	/**
	 *
	 * 문자열의 길이는 최대 10^5이므로, 2n정도로 가능할듯함
	 * 근데 그냥 문자열 지울 필요도 없이, 계속 체크해서 카운팅 하면 될듯함
	 */
	static int alternatingCharacters(String s) {
		int res = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				res++;
			}
		}
		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = alternatingCharacters(s);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
