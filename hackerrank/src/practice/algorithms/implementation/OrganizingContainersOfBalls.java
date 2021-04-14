package practice.algorithms.implementation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 컨테이너 n개에 각각 n개의 타입이있는 공이 랜덤으로 들어있을때, swap을 이용하여 모두 각각의 컨테이너의 같은 타입의 공만 모을 수 있는지 여부
 * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 *
 * 코딩시간 : 30분
 *
 * @author gwon
 * @history
 *          2021. 4. 14. initial creation
 */
public class OrganizingContainersOfBalls {
	/**
	 * 테스트케이스가 좀만 더 있었으면 금방 풀었을 것 같은데, 별로 없어서 좀 생각하는데 오래 걸림
	 * 어떻게든 스왑을 하면되는거고, 그 컨테이너에 공이 있기만 하다면 스왑이 가능.
	 * 따라서 타입에 상관없이 컨테이너에 들어있는 공의 개수와, 타입 각각의 공의 개수만 동일하면 됨.
	 * 따라서 가로의 합과 세로의 합이 나오는 개수가 동일하면 됨.
	 *
	 * @param container
	 * @return
	 */
	static String organizingContainers(int[][] container) {
		Map<Integer, Integer> a = new HashMap<>();
		Map<Integer, Integer> b = new HashMap<>();

		for (int i = 0; i < container.length; i++) {
			int sum = 0;
			for (int j = 0; j < container[i].length; j++) {
				sum += container[i][j];
			}

			int aa = a.getOrDefault(sum, 0);
			a.put(sum, aa + 1);
		}

		for (int i = 0; i < container.length; i++) {
			int sum = 0;
			for (int j = 0; j < container[i].length; j++) {
				sum += container[j][i];
			}

			int bb = b.getOrDefault(sum, 0);
			b.put(sum, bb + 1);
		}

		for (Map.Entry<Integer, Integer> entry : a.entrySet()) {
			int key = entry.getKey();

			int aVal = entry.getValue();
			int bVal = b.getOrDefault(key, -1);

			if (aVal != bVal) {
				return "Impossible";
			}
		}

		return "Possible";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[][] container = new int[n][n];

			for (int i = 0; i < n; i++) {
				String[] containerRowItems = scanner.nextLine().split(" ");
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				for (int j = 0; j < n; j++) {
					int containerItem = Integer.parseInt(containerRowItems[j]);
					container[i][j] = containerItem;
				}
			}

			String result = organizingContainers(container);

		}

		scanner.close();
	}
}
