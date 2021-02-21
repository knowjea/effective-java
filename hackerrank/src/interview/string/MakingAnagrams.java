package interview.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 두 문자열이 주어졌을때, 두 문자열을 Anagrams으로 만들기 위하여 삭제해야 하는 문자 수
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
 *
 * 코딩시간 : 5분
 *
 * @author gwon
 * @history
 *          2021. 2. 21. initial creation
 */
public class MakingAnagrams {
	// Anagrams은 문자의의 개수만 맞으면 됨
	// 문자의 개수 차이만큼 더하면 정답
	// 문자열의 최대 길이는 10^4이니 2 * 10^4으로 쉽게 끝내보자.
	static int makeAnagram(String a, String b) {
		int[] cnt = new int[200];

		for (int i = 0; i < a.length(); i++) {
			cnt[a.charAt(i)]++;
		}

		for (int i = 0; i < b.length(); i++) {
			cnt[b.charAt(i)]--;
		}

		int res = 0;
		for (int i = 'a'; i <= 'z'; i++) {
			res += Math.abs(cnt[i]);
		}

		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String a = scanner.nextLine();

		String b = scanner.nextLine();

		int res = makeAnagram(a, b);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
