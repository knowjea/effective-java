package rule7.guardian;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 7. 24. initial creation
 */
public class ParentFinalizerGuardianTest {

	public static void main(final String[] args) throws Exception {
		doIt();
		System.gc();
	}

	private final Object guardian = new Object() {
		@Override
		protected void finalize() throws Throwable {
			System.out.println("Finalize of class Parent in guardian");
			doFinalize();
		}
	};

	private void doFinalize() {
		System.out.println("Do Something");
	}

	public static void doIt() {
		ChildFinalizerGuardianTest c = new ChildFinalizerGuardianTest();
		System.out.println(c);
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize of class Parent in finalize");
		super.finalize();
	}
}
