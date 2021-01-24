package rule7;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 7. 23. initial creation
 */
public class ExceptionInFinalizeTest {

	public static void main(String[] args) throws Throwable {
		ExceptionInFinalizeTest exceptionInFinalizeTest = new ExceptionInFinalizeTest();
		exceptionInFinalizeTest = null;

		// System.gc does not guarantee finalize, but generally works fine.
		System.gc();
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("The finalize method start");

		// Exceptions are ignored.
		System.out.println(2 / 0);

		super.finalize();

		System.out.println("The finalize method end");
	}
}
