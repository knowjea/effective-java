package rule7;

/**
 *
 *
 * @author gwon
 * @history
 *          2021. 11. 14. initial creation
 */
public class AClass {

	private final Object guardian = new Object() {
		@Override
		protected void finalize() throws Throwable {
			System.out.println("Finalize of class Parent in guardian");
			myClose();
		}
	};

	private void myClose() {
		System.out.println("Do Something");
	}

}
