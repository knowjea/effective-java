package interview.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Comparator 구현해보기
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem
 *
 * 코딩 시간 : 5분 이하
 *
 * @author gwon
 * @history
 *          2021. 2. 6. initial creation
 */
public class Comparator {
	static class Player {
		String name;
		int score;

		Player(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}

	static class Checker implements java.util.Comparator<Player> {
		@Override
		public int compare(Player a, Player b) {
			if (a.score > b.score) {
				return -1;
			} else if (a.score < b.score) {
				return 1;
			} else {
				return a.name.compareTo(b.name);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
}
