package rule10;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 9. 2. initial creation
 */
public class PhoneNumberWithHashCode {
	private final int areaCode;
	private final int prefix;
	private final int lineNumber;

	public PhoneNumberWithHashCode(int areaCode, int prefix, int lineNumber) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNumber = lineNumber;
	}

	@Override
	public String toString() {
		return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
	}

	public static void main(String[] args) {
		PhoneNumberWithHashCode p1 = new PhoneNumberWithHashCode(111, 654, 7009);

		System.out.println(p1);
	}

}
