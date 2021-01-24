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
		long start = System.currentTimeMillis();
		FinalizePerformanceTest finalizePerformanceTest = new FinalizePerformanceTest();
		finalizePerformanceTest = null;

		System.gc();

		long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start) / 1000.0);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("test");
		// TODO Auto-generated method stub
		super.finalize();
	}

}
