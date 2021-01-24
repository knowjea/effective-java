package rule15;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 9. 30. initial creation
 */
public class Rule15 {
	public static void main(String[] args) {
		String a = "abc";
		String b = "abc";
		System.out.println(a == b); // true

		String c = new String("abc");
		String d = new String("abc");
		System.out.println(c == d); // false
	}

}
