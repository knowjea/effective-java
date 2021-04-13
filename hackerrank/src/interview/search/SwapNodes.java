package interview.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 바이너리 트리에 swap기능이 있는데, swap할때마다 중위순환 값 출력
 *
 * https://www.hackerrank.com/challenges/swap-nodes-algo/problem
 *
 * 코딩시간 : 10시50분
 *
 * @author gwon
 * @history
 *          2021. 3. 2. initial creation
 */
public class SwapNodes {
	// 이진트리 오랜만에 해본다.. 일단 짜보자..
	// 배열로 짜려니 swap이 좀 걸린다.
	static int[][] swapNodes(int[][] indexes, int[] queries) {
		int bt[] = new int[3000];
		int res[][] = new int[queries.length][3000];

		bt[0] = 1;
		for (int i = 0; i < indexes.length; i++) {
			bt[i * 2 + 1] = indexes[i][0];
			bt[i * 2 + 2] = indexes[i][1];
		}

		for (int i = 0; i < queries.length; i++) {
			int n = queries[i];

			int t = n;
			while (t <= 512) {
				int length = t;
				int leftIdx = t * 2 - 1;

				int tempArray[] = Arrays.copyOfRange(bt, leftIdx, leftIdx + length);
				System.arraycopy(bt, leftIdx + length, bt, leftIdx, length);
				System.arraycopy(tempArray, 0, bt, leftIdx + length, length);

				t *= 2;
			}
			List<Integer> list = new ArrayList<>();
			inOrder(bt, 0, list);

			res[i] = list.stream().mapToInt(v -> v).toArray();
		}

		return res;
	}

	static void inOrder(int[] array, int count, List<Integer> list) {
		if (count >= array.length || array[count] <= 0) {
			return;
		}
		inOrder(array, 2 * count + 1, list);

		list.add(array[count]);
		inOrder(array, 2 * count + 2, list);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(scanner.nextLine().trim());

		int[][] indexes = new int[n][2];

		for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
			String[] indexesRowItems = scanner.nextLine().split(" ");

			for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
				int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
				indexes[indexesRowItr][indexesColumnItr] = indexesItem;
			}
		}

		int queriesCount = Integer.parseInt(scanner.nextLine().trim());

		int[] queries = new int[queriesCount];

		for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
			int queriesItem = Integer.parseInt(scanner.nextLine().trim());
			queries[queriesItr] = queriesItem;
		}

		int[][] result = swapNodes(indexes, queries);

//		for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
//			for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
//				bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));
//
//				if (resultColumnItr != result[resultRowItr].length - 1) {
//					bufferedWriter.write(" ");
//				}
//			}
//
//			if (resultRowItr != result.length - 1) {
//				bufferedWriter.write("\n");
//			}
//		}
//
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();
	}
}
