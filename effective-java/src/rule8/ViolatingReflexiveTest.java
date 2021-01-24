package rule8;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 7. 29. initial creation
 */
public class ViolatingReflexiveTest {
	int i;

	public static void main(String[] args) {
		ViolatingReflexiveTest test = new ViolatingReflexiveTest();
		test.i = 1;

		System.out.println(test.equals(test));
	}

	@Override
	public boolean equals(Object obj) {
		return ((ViolatingReflexiveTest) obj).i < this.i;
	}
}
