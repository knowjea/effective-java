package interview.search;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * 기계마다 하나의 아이템을 만드는데 필요한 소요일이 존재. goal 갯수만큼 아이템을 만드려면 며칠이 지나야 하는가?
 * https://www.hackerrank.com/challenges/minimum-time-required/problem
 *
 * 코딩시간 : 1시간 해도 못품
 *
 * @author gwon
 * @history
 *          2021. 3. 6. initial creation
 */
public class MinimumTimeRequired {

	// Complete the minTime function below.
	static long minTime(long[] machines, long goal) {

		double tot = 0;
		for (int i = 0; i < machines.length; i++) {
			tot += (double) 1 / (double) machines[i];
		}

		double a = goal / tot;
		long b = (long) (goal / tot);

		if (a - b > 0.000000000000001) {
			return (long) (goal / tot) + 1;
		} else {
			return (long) (goal / tot);
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nGoal = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nGoal[0]);

		long goal = Long.parseLong(nGoal[1]);

		long[] machines = new long[n];

		String[] machinesItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			long machinesItem = Long.parseLong(machinesItems[i]);
			machines[i] = machinesItem;
		}

		long ans = minTime(machines, goal);

		scanner.close();
	}
}
