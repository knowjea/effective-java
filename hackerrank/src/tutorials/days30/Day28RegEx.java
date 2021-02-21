package tutorials.days30;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @gmail.com 으로 끝나는 이메일을 가진 사람의 이름을 정렬해서 출력
 *            https://www.hackerrank.com/challenges/30-regex-patterns/problem
 *
 * @author gwon
 * @history
 *          2021. 2. 21. initial creation
 */
public class Day28RegEx {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		List<String> list = new ArrayList<>();
		for (int NItr = 0; NItr < N; NItr++) {
			String[] firstNameEmailID = scanner.nextLine().split(" ");

			String firstName = firstNameEmailID[0];
			String emailID = firstNameEmailID[1];

			if (emailID.contains("@gmail.com")) {
				list.add(firstName);
			}
		}

		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}

		});

		for (String str : list) {
			System.out.println(str);
		}

		scanner.close();
	}
}
