package rule67;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author gwon
 * @history
 *          2019. 7. 28. initial creation
 */
public class ConcurrentModificationExceptionTest {
	public static List<String> strList = new ArrayList<String>();
	public static Integer a = 1;

	public synchronized static void add() {
		synchronized (a) {
			a = 3;
		}
	}

	public static void main(String[] args) {
//		strList.add("a");
//
//		synchronized (strList) {
//			for (String str : strList) {
//				/**
//				 * 예외 발생
//				 * Exception in thread "main" java.util.ConcurrentModificationException
//				 * at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
//				 * at java.util.ArrayList$Itr.next(ArrayList.java:851)
//				 * atrule67.ConcurrentModificationExceptionTest.main(ConcurrentModificationExceptionTest.java:26)
//				 */
//				ConcurrentModificationExceptionTest.add();
//			}
//		}
		a = 3;
		synchronized (a) {
			add();
			a = 2;
		}

	}
}
