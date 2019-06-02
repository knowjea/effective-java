package rule13.packageprivate;

import java.math.BigInteger;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 9. 27. initial creation
 */
public class SmallCalculator {

//	public int add(int a, int b) {
//		return PackagePrivateUtil.add(a, b);
//	}
//
//	public int subtract(int a, int b) {
//		return PackagePrivateUtil.add(a, b * -1);
//	}

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

}
