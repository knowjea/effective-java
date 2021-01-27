package interview.arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 *
 * @author gwon
 * @history
 *          2021. 1. 26. initial creation
 */
public class NewYearChaos {

	static void minimumBribes(int[] q) {
		int res = 0;
		// 어차피 최대 차이가 2이므로 2만큼만 비교하기, 2보다 크면 Too chaotic
		for (int i = q.length - 1; i > 0; i--) {
			for (int j = 0; j < 3; j++) {
				if (q[i - j] == i + 1) {
					res += j;
					if (j == 1) {
						q[i - 1] = q[i];
						q[i] = i + 1;
					} else if (j == 2) {
						q[i - 2] = q[i - 1];
						q[i - 1] = q[i];
						q[i] = i + 1;
					}
					break;
				}

				if (j == 2) {
					System.out.println("Too chaotic");
					return;
				}
			}
		}

		System.out.println(res);

	}

	// 테스트케이스 6,7,8,9 타임아웃..
	static void minimumBribes_timeout_testcase6789(int[] q) {
		int idx[] = new int[q.length + 1];

		// 기존 순서일때 해당하는 사람이 어디에 있는지 인덱스화
		for (int i = 0; i < q.length; i++) {
			int diff = q[i] - (i + 1);
			if (diff > 2) {
				System.out.println("Too chaotic");
				return;
			}

			idx[q[i]] = i + 1;
		}

		int res = 0;
		for (int i = 1; i < idx.length; i++) {
			int diff = idx[i] - i;
			if (diff == 0) {
				continue;
			}

			// 기존 순서와 다른 사람일 경우, 원래 자리로 돌아오게 한 후 현재 그 사람보다 인덱스가 큰 값은 한칸씩 뒤로 밀음
			res += diff;
			for (int j = i; j < idx.length; j++) {
				if (idx[i] > idx[j]) {
					idx[j]++;
				}
			}
		}

		System.out.println(res);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}
