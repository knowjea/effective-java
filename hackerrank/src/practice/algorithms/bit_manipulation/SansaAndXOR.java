package practice.algorithms.bit_manipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * 배열이 주어졌을때, 개수를 하나씩 늘리면서 xor 했을때 최종 값
 * https://www.hackerrank.com/challenges/sansa-and-xor/problem
 * 코딩시간 : 15분
 *
 * @author gwon
 * @history
 *          2021. 4. 19. initial creation
 */
public class SansaAndXOR {
	/**
	 * XOR 연산은 교환법칙, 결합법칙 다 되니 순서 상관없음
	 * 그리고 같은 값끼지 XOR하면 0이 됨.
	 * 즉 arr[i] 값이 짝수번 나오면 무시하면 됨.
	 *
	 * 근데 arr의 길이가 짝수이면 모든 arr[i]가 짝수개 나오기 때문에 0임
	 * arr의 길이가 홀수이면 홀수번째만 1개씩 살아남으니, 그것들끼리만 XOR 연산하면 됨.
	 *
	 * @param arr
	 * @return
	 */
	static int sansaXor(int[] arr) {
		if (arr.length % 2 == 0) {
			return 0;
		}

		int res = 0;
		for (int i = 0; i < arr.length; i += 2) {
			res ^= arr[i];
		}

		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

			int result = sansaXor(arr);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
