package rule7;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 7. 23. initial creation
 */
public class TryCatchFinally {
	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = new FileInputStream("c:/out.txt");
		try {
			// do somgting
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fileInputStream.close();
		}
	}
}
