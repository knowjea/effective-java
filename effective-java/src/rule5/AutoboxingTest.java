package rule5;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 7. 1. initial creation
 */
public class AutoboxingTest {

	/**
	 * Autoboxing create new object for calculation.
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Long sum = 0L;
//		long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}

		long end = System.currentTimeMillis();
		System.out.println("Time : " + (end - start) / 1000.0);

		// Long : 9.988
		// long : 0.621

	}
}
