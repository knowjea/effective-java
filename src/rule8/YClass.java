package rule8;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 8. 21. initial creation
 */
public class YClass {
	public int years;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof YClass) {
			return years == ((YClass) obj).years;
		}
		return false;
	}

	public static void main(String[] args) {
		XClass xClass = new XClass();
		YClass yClass = new YClass();

		xClass.age = 10;
		yClass.years = 10;

		System.out.println(xClass.equals(yClass)); // true
		System.out.println(yClass.equals(xClass)); // false

	}
}
