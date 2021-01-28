package interview.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * a b k를 여러번 입력받는데, a인덱스에서 b인덱스까지 k값만큼 계속 더함. 최종적으로 가장 큰 값은?
 * https://www.hackerrank.com/challenges/crush/problem
 *
 * @author gwon
 * @history
 *          2021. 1. 27. initial creation
 */
public class ArrayManipulation {

	// 교집합의 수가 가장 큰 값을 출력하면 될 것 같다고 생각했지만, k의 값이 랜덤하므로, 교집합의 수와는 상관 없을 것 같음..
	// 어차피 계속 축적되는거니, 교집합을 구하고 플러스로 지금의 k값이 축적된 값보다 높은지 확인하면?
	// k값으로 소트..... 소트하는데만해도 비용..그래도 한번 해보자..
	// 아마 이게 알고리즘중에 기법 하나인데.. Long.. 어쩌고저쩌고.. 진짜 모르겠으면 검색해보자

	// 검색해서 풀음. prefix sum (누적합)을 이용해야 함......!

	static long arrayManipulation(int n, int[][] queries) {
		long arr[] = new long[n + 1];

		for (int i = 0; i < queries.length; i++) {
			arr[queries[i][0] - 1] += queries[i][2];
			arr[queries[i][1]] -= queries[i][2];
		}

		long max = Long.MIN_VALUE;
		long tot = 0;
		for (int i = 0; i < arr.length; i++) {
			tot += arr[i];
			if (tot > max) {
				max = tot;
			}
		}

		return max;
	}

	static long arrayManipulation_timeout2(int n, int[][] queries) {
		Arrays.sort(queries, Comparator.comparingInt(arr -> arr[2]));

		long max = -1;
		for (int i = 0; i < queries.length; i++) {
			int left = queries[i][0];
			int right = queries[i][1];
			long tot = queries[i][2];

			for (int j = i + 1; j < queries.length; j++) {
				int curLeft = queries[j][0];
				int curRight = queries[j][1];
				if (curLeft <= left && curRight <= left && curLeft <= right && curRight <= right) {

				} else if (curLeft <= left && curRight >= left && curLeft <= right && curRight <= right) {
					left = curRight;
					tot += queries[j][2];
				} else if (curLeft <= left && curRight >= left && curLeft <= right && curRight >= right) {
					tot += queries[j][2];
				} else if (curLeft >= left && curRight >= left && curLeft <= right && curRight <= right) {
					left = curLeft;
					right = curRight;
					tot += queries[j][2];
				} else if (curLeft >= left && curRight >= left && curLeft <= right && curRight >= right) {
					left = curLeft;
					tot += queries[j][2];
				} else {

				}
			}

			if (tot > max) {
				max = tot;
			}
		}

		return max;
	}

	// 일단 n이 10^7이므로, 이중포문으로 하면 타임아웃 날 것임. (두시간동안 안풀려서, 이중포문으로 해봤지만 역시나 타임아웃)
	static long arrayManipulation_timeout(int n, int[][] queries) {
		long max = -1;
		int[] arr = new int[n + 1];
		for (int i = 0; i < queries.length; i++) {
			for (int j = queries[i][0]; j <= queries[i][1]; j++) {
				arr[j] += queries[i][2];
				if (max < arr[j]) {
					max = arr[j];
				}
			}
		}

		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[][] queries = new int[m][3];

		for (int i = 0; i < m; i++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowItems[j]);
				queries[i][j] = queriesItem;
			}
		}

		long result = arrayManipulation(n, queries);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
