package interview.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 주어진 배열안의 값들끼리 뺀 값의 절대값이 가장 작은 절대값을 출력
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 *
 * 코딩시간 : 5분
 *
 * @author gwon
 * @history
 *          2021. 2. 27. initial creation
 */
public class MinimumAbsoluteDifferenceInAnArray {

	// 배열의 크기는 10^5이므로 n^2으로는 힘들듯.
	// 근데 그리드 문제이기 때문에 무작정 푸는게 정답일듯한데..n이 너무크다
	// 아니면 정렬해서 앞뒤로 비교만 해도 될듯.
	static int minimumAbsoluteDifference(int[] arr) {
		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			int val = Math.abs(arr[i] - arr[i + 1]);
			if (val < min) {
				min = val;
			}
		}

		return min;
	}

	// 궁금해서 n^2으로 풀어보니 test case 2,3에서 타임리밋
	static int minimumAbsoluteDifference_타임리밋안나는지_궁금(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int val = Math.abs(arr[i] - arr[j]);
				if (val < min) {
					min = val;
				}
			}
		}

		return min;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = minimumAbsoluteDifference(arr);

//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();

//		bufferedWriter.close();

		scanner.close();
	}
}
