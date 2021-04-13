package practice.algorithms.warmup;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

/**
 * 타임 포맷 변경
 * https://www.hackerrank.com/challenges/time-conversion/problem
 *
 * @author gwon
 * @history
 *          2021. 3. 21. initial creation
 */
public class TimeConversion {

	// 직접 풀수 있지만, api를 사용해보았다.
	// LocalDateTime은 확실하진 않지만.. 년월일이 없으면 parse할 경우 에러 발생..
	static String timeConversion(String s) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ssa").withLocale(Locale.US);
		LocalDateTime local = LocalDateTime.parse("03/21/2021 " + s, formatter);

		return local.format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString();
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String s = scan.nextLine();

		String result = timeConversion(s);
	}
}
