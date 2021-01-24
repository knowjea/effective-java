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
public class PhoneNumber {
	private final int areaCode;
	private final int prefix;
	private final int lineNumber;

	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNumber = lineNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof PhoneNumber)) {
			return false;
		}

		PhoneNumber phoneNumber = (PhoneNumber) obj;

		// Since lineNumber may be the most different, check first.
		return phoneNumber.lineNumber == lineNumber && phoneNumber.prefix == prefix
		        && phoneNumber.areaCode == phoneNumber.areaCode;
	}

	public static void main(String[] args) {
		Map<PhoneNumber, String> map = new HashMap<PhoneNumber, String>();

		PhoneNumber p1 = new PhoneNumber(1, 2, 3);
		PhoneNumber p2 = new PhoneNumber(1, 2, 3);

		System.out.println(p1.equals(p2)); // true

		map.put(p1, "Phone");

		System.out.println(map.get(p1)); // Phone
		System.out.println(map.get(p2)); // null

		System.out.println(p1.hashCode()); // 366712642
		System.out.println(p2.hashCode()); // 1829164700
	}

}
