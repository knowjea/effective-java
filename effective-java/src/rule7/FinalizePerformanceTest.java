package rule7;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 7. 23. initial creation
 */

public class FinalizePerformanceTest {

	/**
	 * TODO Implement performance test case for finalize
	 */
	public static void main(String[] args) {
		long start = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			new FinalizePerformanceTest();
		}
		long end = System.nanoTime();
		System.out.println("time: " + (end - start));

	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

}
