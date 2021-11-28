package rule9;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 9. 2. initial creation
 */
public class PhoneNumberOnlyAreaCode {
	private final int areaCode;
	private final int prefix;
	private final int lineNumber;

	public PhoneNumberOnlyAreaCode(int areaCode, int prefix, int lineNumber) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNumber = lineNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof PhoneNumberOnlyAreaCode)) {
			return false;
		}

		PhoneNumberOnlyAreaCode phoneNumber = (PhoneNumberOnlyAreaCode) obj;

		// Since lineNumber may be the most different, check first.
		return phoneNumber.lineNumber == lineNumber && phoneNumber.prefix == prefix
		        && phoneNumber.areaCode == phoneNumber.areaCode;
	}

	@Override
	public int hashCode() {
		return areaCode;
	}

	public static void main(String[] args) {
		Map<PhoneNumberOnlyAreaCode, String> map = new HashMap<PhoneNumberOnlyAreaCode, String>();

		PhoneNumberOnlyAreaCode p1 = new PhoneNumberOnlyAreaCode(1, 2, 3);
		PhoneNumberOnlyAreaCode p2 = new PhoneNumberOnlyAreaCode(1, 2, 3);

		System.out.println(p1.equals(p2)); // true

		map.put(p1, "Phone");

		System.out.println(map.get(p1)); // Phone
		System.out.println(map.get(p2)); // Phone

		System.out.println(p1.hashCode()); // 1
		System.out.println(p2.hashCode()); // 1
	}
}
