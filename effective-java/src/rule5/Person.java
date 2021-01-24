package rule5;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 7. 1. initial creation
 */
public class Person {
	private final Date birthDate;

	private static final Date BOOM_START;
	private static final Date BOOM_END;

	public Person(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * The static initializer block is called only once.
	 */
	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = gmtCal.getTime();

		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = gmtCal.getTime();
	}

	/**
	 * Do this
	 */
	public boolean isBabyBoomerDoThis() {
		return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
	}

	/**
	 * Do not do this.
	 * This method creates four objects repeatedly unnecessarily each time it is called.
	 */
	public boolean isBabyBoomer() {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomStart = gmtCal.getTime();

		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomEnd = gmtCal.getTime();

		return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
	}

}
