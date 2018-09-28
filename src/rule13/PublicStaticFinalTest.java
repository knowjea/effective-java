package rule13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 9. 28. initial creation
 */
public class PublicStaticFinalTest {
	public static final int VERSION = 1;

	public static final String[] NUM_LIST = { "1", "2", "3", "4" };

	private static final String[] UNMODIFY_NUM_LIST = { "1", "2", "3", "4" };
	public static final List<String> NUM_LIST_2 = Collections.unmodifiableList(Arrays.asList(UNMODIFY_NUM_LIST));

	private static final String[] CLONE_NUM_LISE = { "1", "2", "3", "4" };

	public static final String[] NUM_LIST_3() {
		return CLONE_NUM_LISE.clone();
	}

	public static void main(String[] args) {
		PublicStaticFinalTest.VERSION = 2; // Not possible because final
		PublicStaticFinalTest.NUM_LIST={"2"}; // Not possible because final

		PublicStaticFinalTest.NUM_LIST[0] = "5"; // Executed. But it should not be changed.

		PublicStaticFinalTest.NUM_LIST_2.get(0) = new String("5"); // Not possible because
		                                                           // unmodifiableList.
	}
}
