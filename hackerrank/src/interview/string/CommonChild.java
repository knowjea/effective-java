package interview.string;

import java.io.IOException;
import java.util.Scanner;

/**
 * 동일한 길이의 문자열 2개를 입력받았을 때, 문자를 삭제하면서 가장 길고 같게 만들 수 있는 문자열의 최대 길이
 * ex) HARRY, SALLY => AY 이니 답은 2
 *
 * https://www.hackerrank.com/challenges/common-child/problem
 *
 * 코딩시간 : 1시간
 *
 * @author gwon
 * @history
 *          2021. 2. 21. initial creation
 */
public class CommonChild {
	/**
	 * LCS문제인거는 느낌이 왔었는데, LCS 6년전에 배웠어서 기억은 안난다..
	 *
	 */
	static int commonChild(String s1, String s2) {

	}

	/**
	 *
	 * 두 문자열의 길이가 최대 10^3 * 5자 이므로, 무식하게 삼중 포문으로 아슬아슬하게 가능할 것 같음
	 * 테스트케이스 여러개 실패.. 무조건 있다고 같다고 포함하면 뒤에거에 영향을 줌..
	 */
	static int commonChild_Wrong_Answer(String s1, String s2) {
		int max = -1;
		for (int i = 0; i < s1.length(); i++) {
			int res = 0;
			int idx = 0;
			for (int j = i; j < s1.length(); j++) {
				char cur = s1.charAt(j);

				for (int k = idx; k < s2.length(); k++) {
					if (cur == s2.charAt(k)) {
						res++;
						idx = k + 1;
						break;
					}
				}
			}

			if (max < res) {
				max = res;
			}
		}

		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s1 = scanner.nextLine();

		String s2 = scanner.nextLine();

		int result = commonChild(s1, s2);

//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

		scanner.close();
	}
}
