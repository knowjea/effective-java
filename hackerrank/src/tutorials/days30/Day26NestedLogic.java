package tutorials.days30;

import java.util.Scanner;

/**
 * 연체비 구하기 조건이 세가지 있음
 * https://www.hackerrank.com/challenges/30-nested-logic/problem
 *
 * @author gwon
 * @history
 *          2021. 2. 16. initial creation
 */
public class Day26NestedLogic {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be
		 * named Solution.
		 */

		Scanner sc = new Scanner(System.in);

		String start = sc.nextLine();
		String end = sc.nextLine();

		String[] starts = start.split(" ");
		String[] ends = end.split(" ");

		int startD = Integer.parseInt(starts[0]);
		int startM = Integer.parseInt(starts[1]);
		int startY = Integer.parseInt(starts[2]);
		int endD = Integer.parseInt(ends[0]);
		int endM = Integer.parseInt(ends[1]);
		int endY = Integer.parseInt(ends[2]);

		if (startY - endY > 0) {
			System.out.println(10000);
			return;
		} else if (startY - endY < 0) {
			System.out.println(0);
			return;
		}

		if (startM - endM > 0) {
			System.out.println((startM - endM) * 500);
			return;
		} else if (startM - endM < 0) {
			System.out.println(0);
			return;
		}

		if (startD - endD > 0) {
			System.out.println((startD - endD) * 15);
		} else {
			System.out.println(0);
		}
	}

}
