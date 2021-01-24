package rule9;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 8. 28. initial creation
 */
public class Rule9 {
	public static void main(String[] args) {
		Object obj = new Object();
		System.out.println(obj.hashCode());
		System.out.println(System.identityHashCode(obj));

		String str = "aa";
		str.hashCode();
	}
}
