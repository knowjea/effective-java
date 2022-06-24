package rule21;

/**
 *
 *
 * @author gwon
 * @history
 *          2022. 6. 25. initial creation
 */
public class LengthStringCompare implements Comparator<String> {

	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}

}
