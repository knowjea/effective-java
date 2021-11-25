package rule8;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 8. 21. initial creation
 */
public class XClass {
	public int age;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof XClass) {
			return age == ((XClass) obj).age;
		}

		// X 클래스는 Y 클래스와도 비교를 한다.
		if (obj instanceof YClass) {
			return age == ((YClass) obj).years;
		}
		return false;
	}

}
