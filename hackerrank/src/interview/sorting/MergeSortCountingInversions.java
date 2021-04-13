package interview.sorting;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * 오름차순으로 정렬할 때 swap의 수
 * https://www.hackerrank.com/challenges/ctci-merge-sort/problem
 *
 * 코딩 시간 : 3시간 후 검색
 *
 * @author gwon
 * @history
 *          2021. 2. 7. initial creation
 */
public class MergeSortCountingInversions {

	// 문제 이름처럼 머지 소트를 이용하면 된다는데, 까먹었다. 결국엔 검색해봄
	static long countInversions(int[] arr) {
		int res = 0;

		return res;
	}

	// 오른쪽에 자기보다 작은 수의 개수를 구하면 됨
	// 근데 n(n-1)이라 아래 코드보다 더 타임아웃 걸릴줄 알았는데 testcase 5를 통과함
	static long countInversions_timeout2(int[] arr) {
		int res = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					res++;
				}
			}
		}

		return res;
	}

	// 한번 swap하면 다시 뒤로 몇칸 가서 다시 하는 방법.
	// testcase 4,5,7,8,9,11,12, 13 타임아웃
	static long countInversions_timeout(int[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				res++;
				int temp = arr[i + 1];
				arr[i + 1] = arr[i];
				arr[i] = temp;

				if (i - 2 >= -1) {
					i -= 2;
				} else {
					i--;
				}
			}
		}

		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] arr = new int[n];

			String[] arrItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}

			long result = countInversions(arr);

//			bufferedWriter.write(String.valueOf(result));
//			bufferedWriter.newLine();
		}

//		bufferedWriter.close();

		scanner.close();
	}
}
