package rule7;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 7. 24. initial creation
 */
public class ManualFinalizerChainingTest {

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		try {
			// do something
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.finalize();
		}
	}

}
