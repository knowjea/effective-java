package interview.arrays;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * 배열을 오름차순으로 만들기 위하여 최소 swap 수
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 *
 * @author gwon
 * @history
 *          2021. 1. 27. initial creation
 */
public class MinimumSwaps2 {

	static int minimumSwaps(int[] arr) {
		// 현재 인덱스와 같은 값을 찾아서 계속 swap해주면 됨.

		// 해당 값이 현재 위치하고 있는 인덱스 배열 생성
		int idx[] = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			idx[arr[i]] = i + 1;
		}

		int res = 0;

		// 1부터 순서대로 찾으면서 swap하면서 실제 배열과 인덱스배열도 변경
		for (int i = 1; i < arr.length + 1; i++) {
			if (idx[i] != i) {
				res++;
				arr[idx[i] - 1] = arr[i - 1];
				idx[arr[i - 1]] = idx[i];

			}
		}

		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int n = scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		int[] arr = new int[n];
//
//		String[] arrItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int i = 0; i < n; i++) {
//			int arrItem = Integer.parseInt(arrItems[i]);
//			arr[i] = arrItem;
//		}

		int[] arr = new int[4];
		arr[0] = 4;
		arr[1] = 3;
		arr[2] = 1;
		arr[3] = 2;

		int res = minimumSwaps(arr);

//		bufferedWriter.write(String.valueOf(res));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

		scanner.close();
	}
}
