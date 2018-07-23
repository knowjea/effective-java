package rule7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 7. 22. initial creation
 */
public class FileReadUtil {
	private static FileInputStream input;

	static {
		try {
			input = new FileInputStream("c:/out.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int readByte() throws IOException {
		return input.read();
	}

	@Override
	protected void finalize() throws Throwable {
		try {
			// Do not do this.
			if (input != null) {
				input.close();
			}
		} finally {
			super.finalize();
		}
	}

}
