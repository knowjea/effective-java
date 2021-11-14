package rule7;

/**
 *
 *
 * @author gwon
 * @history
 *          2021. 11. 14. initial creation
 */
public class BClass extends AClass {
	// Child class does not call super.finalize()
	@Override
	protected void finalize() {
		System.out.println("Finalize of class Child");
	}

	public static void main(final String[] args) throws Exception {
		doIt();
		System.gc();
	}

	public static void doIt() {
		BClass c = new BClass();
		System.out.println(c);
	}
}
