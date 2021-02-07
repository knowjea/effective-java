package interview.sorting;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 특정 기간동안의 중간값 * 2보다 다음날의 값이 더 큰 경우를 구해라
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 *
 * 코딩시간 : 2시간
 *
 * @author gwon
 * @history
 *          2021. 2. 6. initial creation
 */
public class FraudulentActivityNotifications {
	// 하루가 지날때마다, 지난 값은 소트데이터에서 제거하고, 새로 추가된 값만을 확인하여 소팅된 배열에 넣으면서 체크하면 될 같은데흠
	// 바이너리 서치로 지난 값을 제거하고, 바이너리 인서트로, 새로운 값을 소트된 리스트에 인서트함.
	// testcase 1,3,4에서 계속 wrong answer나서 계속 생각하다가 중간값의 정의가 다른가 해서 보니까... 짝수일 경우 두값의 평균값이라고
	// 한다....!!!
	static int activityNotifications(int[] expenditure, int d) {
		int cnt = 0;

		int[] copy = Arrays.copyOfRange(expenditure, 0, d);
		Arrays.sort(copy);

		List<Integer> list = Arrays.stream(copy).boxed().collect(java.util.stream.Collectors.toList());
		for (int i = 0; i < expenditure.length - d; i++) {
			double median = d % 2 == 1 ? list.get(d / 2) : (list.get(d / 2) + list.get(d / 2 - 1)) / 2.0;
			if (median * 2 <= expenditure[i + d]) {
				cnt++;
			}

			int s = 0, e = d, m;
			while (s < e) {
				m = (s + e) / 2;
				if (expenditure[i] >= list.get(m)) {
					s = m + 1;
				} else {
					e = m;
				}
			}
			list.remove(e - 1);

			s = 0;
			e = d - 1;
			m = 0;
			while (s < e) {
				m = (s + e) / 2;
				if (expenditure[i + d] >= list.get(m)) {
					s = m + 1;
				} else {
					e = m;
				}
			}
			list.add(e, expenditure[i + d]);
		}

		return cnt;
	}

	// 배열의 크기는 2* 10^5, 특정 기간의 배열크기만큼 소트하여 중간 값을 찾으면 타임아웃 날 것같음. 그래도 한번 해보자..
	// testcase 1~5까지 역시나 타임아웃
	static int activityNotifications_timeout(int[] expenditure, int d) {
		int cnt = 0;
		for (int i = 0; i < expenditure.length - d; i++) {
			int[] copy = Arrays.copyOfRange(expenditure, i, d + i);
			Arrays.sort(copy);

			if (copy[d / 2] * 2 <= expenditure[i + d]) {
				cnt++;
			}
		}

		return cnt;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] expenditure = new int[n];

		String[] expenditureItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int expenditureItem = Integer.parseInt(expenditureItems[i]);
			expenditure[i] = expenditureItem;
		}

		int result = activityNotifications(expenditure, d);

//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

		scanner.close();
	}
}
