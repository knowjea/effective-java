package rule13.nested;

import java.math.BigInteger;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 9. 27. initial creation
 */
public class SmallCalculator {

	public int add(int a, int b) {
		BigInteger first = intToBigInteger(a);
		BigInteger second = intToBigInteger(b);

		return PackagePrivateUtil.add(first, second).intValue();
	}

	public int subtract(int a, int b) {
		BigInteger first = intToBigInteger(a);
		BigInteger second = intToBigInteger(-b);

		return PackagePrivateUtil.add(first, second).intValue();
	}

	private BigInteger intToBigInteger(int num) {
		return new BigInteger(String.valueOf(num));
	}

	private static class PackagePrivateUtil {
		public static BigInteger add(BigInteger a, BigInteger b) {
			return a.add(b);
		}
	}
}
