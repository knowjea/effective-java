package interview.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 배열이 주어졌을 떄, k개만 뽑아서 배열을 만들고, max(새로운배열) - min(새로운배열) 의 값이 최소인 값 출력
 * ex) 배열 = [10,100,300,200,1000,20,30], k = 3일때 >>> max(10,20,30) - min(10,20,30) = 30 - 10 = 20
 *
 * https://www.hackerrank.com/challenges/angry-children/problem
 *
 * 코딩시간 : 2시간
 * 
 * @author gwon
 * @history
 *          2021. 2. 28. initial creation
 */
public class MaxMin {

	// 드디어 성공!!!!!!!!!!!!!!!!!
	// 오름차순으로 소트하는건 맞았는데 다시 손으로 코딩해보니 생각이 팍 나버림
	// 오름차순으로 소트하고, 하나씩 증가시키면서, 최소값과 최대값 차이 쭉 구하면 됨
	static int maxMin(int k, int[] arr) {
		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i + k - 1 < arr.length; i++) {
			int val = arr[i + k - 1] - arr[i];
			if (min > val) {
				min = val;
			}
		}

		return min;
	}

	// 한번 반복 돌면서, 서로 옆의 값끼리 차이를 구하고, 그 차이값을 저장.
	// 그리고나서 그거로 오름차순으로 소팅하고 첫번쨰부터 k번까지 더하면 될것같음..
	// 실패!.. 16은 패스했다..
	// 생각해보면 이것도 중간에 다른 차이가 작은게 있을 수도 있어서 그게 계산됨.
	static int maxMin_testcase_0_1_15_16_pass(int k, int[] arr) {
		Arrays.sort(arr);

		int[] diff = new int[arr.length];

		for (int i = 0; i < arr.length - 1; i++) {
			diff[i] = arr[i + 1] - arr[i];
		}

		Arrays.sort(diff);

		int res = 0;
		for (int i = 0; i < k; i++) {
			res += diff[i];
		}

		return res;
	}

	// n은 10^5 n^2으로 하면 타임리밋 뜰 듯.
	// 흠.. 소트해서 그냥 가장 작은 수부터 뽑아서 하면 되지 않을까.
	// 실패! 당연하다. 중간에 더 작은 차이가 있을 수 있음
	static int maxMin_testcase_0_1_15_pass(int k, int[] arr) {
		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}

			if (max < arr[i]) {
				max = arr[i];
			}
		}

		return max - min;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int k = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			int arrItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			arr[i] = arrItem;
		}

		int result = maxMin(k, arr);

//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

		scanner.close();
	}
}
