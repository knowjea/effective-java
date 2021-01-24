package rule7.guardian;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 7. 24. initial creation
 */
public class ChildFinalizerGuardianTest extends ParentFinalizerGuardianTest {
	// Child class does not call super.finalize()
	@Override
	protected void finalize() {
		System.out.println("Finalize of class Child");
	}

}
