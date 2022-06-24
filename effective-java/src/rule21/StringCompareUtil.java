package rule21;

/**
 *
 *
 * @author gwon
 * @history
 *          2022. 6. 25. initial creation
 */
public class StringCompareUtil {

	/**
	 * 일반 문자열 비교
	 */
	public static int compare(String s1, String s2) {
		return s1.compareTo(s2);
	}

	/**
	 * 문자열 길이를 이용한 비교
	 */
	public static int compareLength(String s1, String s2) {
		return s1.length() - s2.length();
	}

}
