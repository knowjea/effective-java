package practice.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * A배열에서 B배열이 존재여부 확인
 *
 * https://www.hackerrank.com/challenges/the-grid-search/problem
 * 코딩시간 : 40분
 *
 * @author gwon
 * @history
 *          2021. 4. 19. initial creation
 */
public class TheGridSearch {

	/**
	 * n = 10^3 이고, 결국엔 n^4까지 나올수 있는 문제인거 같은데
	 * 일단 풀어보자.
	 *
	 * 시간초과 안나고 해결은 된다. 흠.. String 클래스의 힘인건지
	 * 아니면 테스트케이스가 간단한건지..
	 *
	 */
	static String gridSearch(String[] G, String[] P) {
		int idx = -1;
		for (int i = 0; i < G.length;) {
			// G에서 P가 있는지 indexOf로 확인.
			idx = G[i].indexOf(P[0], idx + 1);
			int lastIdx = 0;

			// 존재하면 아래부분도 쭉 확인.
			if (idx >= 0) {
				lastIdx = idx + P[0].length();
				for (int j = 1; j < P.length; j++) {
					if (i + j > G.length) {
						break;
					}

					if (!G[i + j].substring(idx, lastIdx).equals(P[j])) {
						break;
					}

					if (j == P.length - 1) {
						return "YES";
					}
				}
			}

			// 현재 실패했어도 뒤에 동일한 문자가 있을 수 있는지 없는지 확인하고, 현재줄을 재처리할지 여부
			if (idx == -1) {
				i++;
			}
		}

		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String[] RC = scanner.nextLine().split(" ");

			int R = Integer.parseInt(RC[0]);

			int C = Integer.parseInt(RC[1]);

			String[] G = new String[R];

			for (int i = 0; i < R; i++) {
				String GItem = scanner.nextLine();
				G[i] = GItem;
			}

			String[] rc = scanner.nextLine().split(" ");

			int r = Integer.parseInt(rc[0]);

			int c = Integer.parseInt(rc[1]);

			String[] P = new String[r];

			for (int i = 0; i < r; i++) {
				String PItem = scanner.nextLine();
				P[i] = PItem;
			}

			String result = gridSearch(G, P);

		}

		scanner.close();
	}
}
