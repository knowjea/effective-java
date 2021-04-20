package practice.algorithms.dp;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 이상한 피보나치 구하기
 * https://www.hackerrank.com/challenges/fibonacci-modified/problem
 *
 * 코딩시간 : 10분
 *
 * @author gwon
 * @history
 *          2021. 4. 20. initial creation
 */
public class FibonacciModified {
	/**
	 * 그냥 dp로 하면 됨.
	 * 그런데, int로 리턴하게 되어있는데 정답이 64비트를 넘을 수 있다는건 무슨말이지.
	 *
	 * 결국에 그냥 메소드의 리턴타입을 String으로 바꿔서 제출하니 통과한다. 문제가 잘못된건가..
	 *
	 * 다른 사람들 답을 보니 그냥 다 수정해서 했다.
	 * 와.. 지금 알았는데, 꼭 해커랭크에서 제공하는 메소드방식대로 작성 안해도 되는거였다...!
	 */
	static String fibonacciModified(int t1, int t2, int n) {
		BigInteger arr[] = new BigInteger[n];
		arr[0] = new BigInteger(String.valueOf(t1));
		arr[1] = new BigInteger(String.valueOf(t2));

		for (int i = 2; i < n; i++) {
			arr[i] = arr[i - 2].add(arr[i - 1].multiply(arr[i - 1]));
		}

		return arr[n - 1].toString();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] t1T2n = scanner.nextLine().split(" ");

		int t1 = Integer.parseInt(t1T2n[0]);

		int t2 = Integer.parseInt(t1T2n[1]);

		int n = Integer.parseInt(t1T2n[2]);

		String result = fibonacciModified(t1, t2, n);

		scanner.close();
	}
}
