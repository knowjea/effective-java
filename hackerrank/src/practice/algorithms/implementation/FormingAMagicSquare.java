package practice.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

/**
 * 3x3 배열을 1~9 하나씩 있도록 하고, 가로, 세로, 대각선으로 더했을때 합이 15되도록 변경할 때, 변경 값 차이 합 최소값
 *
 * https://www.hackerrank.com/challenges/magic-square-forming/problem
 *
 * 코딩시간 : 35분
 *
 * @author gwon
 * @history
 *          2021. 3. 30. initial creation
 */
public class FormingAMagicSquare {
	/**
	 * 풀기전
	 * 방향만 다를뿐이지, 값은 정해져있으니.. 값을 모두 구해서 차이 최소값을 구하기..
	 * 이렇게 푸는게 아닐거 같은데.. 정답이긴 하다.
	 */

	/**
	 * 풀고나서 찾아보니 대부분의 코드가 이렇다. Discussions도 보니 이렇게 푸는게 정답이라고 한다.
	 * 결국 저 매직 스퀘어 8개의 정답을 구하는게 이 문제의 핵심이라고 한다.
	 * 근데 만약 n*n이면 어떻게 해야하는건가. 생각해보면 결국 저 매직스퀘어도 코딩으로 구할 수 있을것 같다.
	 * 일부 정답 코드에서는 직접 저 해답을 구하는 로직은 만든 사람도 있다.
	 */

	static int[][][] res =
	        {
	                { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } },
	                { { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } },
	                { { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } },
	                { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } },
	                { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } },
	                { { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } },
	                { { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } },
	                { { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } }
	        };

	static int formingMagicSquare(int[][] s) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < 8; i++) {
			int cnt = 0;
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					cnt += Math.abs(res[i][j][k] - s[j][k]);
				}
			}

			if (cnt < min) {
				min = cnt;
			}
		}

		return min;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int[][] s = new int[3][3];

		for (int i = 0; i < 3; i++) {
			String[] sRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int sItem = Integer.parseInt(sRowItems[j]);
				s[i][j] = sItem;
			}
		}

		int result = formingMagicSquare(s);

		scanner.close();
	}
}
