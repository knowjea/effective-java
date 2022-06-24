package rule21;

/**
 *
 *
 * @author gwon
 * @history
 *          2022. 6. 25. initial creation
 */
public class NormalStringCompare implements Comparator<String> {

	public int compare(String s1, String s2) {
		return s1.compareTo(s2);
	}

}
