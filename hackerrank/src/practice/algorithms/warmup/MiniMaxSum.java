package practice.algorithms.warmup;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 리스트중에 하나만 제외하고 모두 다 더했을때 최대값 최소값
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 *
 * 코딩시간 : 5분
 *
 * @author gwon
 * @history
 *          2021. 3. 21. initial creation
 */
public class MiniMaxSum {
	// 다 할필요 없고, 그냥 모두 더하고, 배열중 최대값, 최소값만 빼면됨
	// 10^9 이라는걸 안보고 제출..
	static void miniMaxSum(int[] arr) {
		long sum = Arrays.stream(arr).asLongStream().sum();
		long max = Arrays.stream(arr).asLongStream().max().getAsLong();
		long min = Arrays.stream(arr).asLongStream().min().getAsLong();
		System.out.println((sum - max) + " " + (sum - min));
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = new int[5];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < 5; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		miniMaxSum(arr);

		scanner.close();
	}
}
