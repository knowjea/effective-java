package rule5;

/**
 * Avoid creating unnecessary objects
 * (Do not create unnecessary objects)
 *
 * @author gwon
 * @history
 *          2018. 7. 01. initial creation
 */
public class Rule5 {
	public static void main(String[] args) {
		String newStr1 = new String("camel");
		String newStr2 = new String("camel");

		String literalStr1 = "camel";
		String literalStr2 = "camel";

		System.out.println(newStr1 == newStr2); // false
		System.out.println(literalStr1 == literalStr2); // true

//		Boolean bool = new Boolean(true);
		Boolean bool = Boolean.valueOf(true);

	}

}
