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
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof PhoneNumberWithHashCode)) {
			return false;
		}

		PhoneNumberWithHashCode phoneNumber = (PhoneNumberWithHashCode) obj;

		// Since lineNumber may be the most different, check first.
		return phoneNumber.lineNumber == lineNumber && phoneNumber.prefix == prefix
		        && phoneNumber.areaCode == phoneNumber.areaCode;
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 31 * result + areaCode;
		result = 31 * result + prefix;
		result = 31 * result + lineNumber;

		return result;
	}

	public static void main(String[] args) {
		Map<PhoneNumberWithHashCode, String> map = new HashMap<PhoneNumberWithHashCode, String>();

		PhoneNumberWithHashCode p1 = new PhoneNumberWithHashCode(1, 2, 3);
		PhoneNumberWithHashCode p2 = new PhoneNumberWithHashCode(1, 2, 3);

		System.out.println(p1.equals(p2)); // true

		map.put(p1, "Phone");

		System.out.println(map.get(p1)); // Phone
		System.out.println(map.get(p2)); // Phone

		System.out.println(p1.hashCode()); // 507473
		System.out.println(p2.hashCode()); // 507473
	}

}
