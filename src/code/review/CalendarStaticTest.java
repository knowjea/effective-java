package code.review;

import java.time.LocalTime;
import java.util.Calendar;

//	LoggingUtil 89L :	Calendar calendar = Calendar.getInstance();
//  DateUtil
public class CalendarStaticTest {

	static Calendar calendar;
	static LocalTime localTime;
	static {
		calendar = Calendar.getInstance();
		localTime = LocalTime.now();
	}

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		for (long i = 0; i < 100000000; i++) {
			CalendarStaticTest.testCalendar();
//			CalendarStaticTest.testLocalTime();

		}

		long end = System.currentTimeMillis();
		System.out.println("Time : " + (end - start) / 1000.0);

	}

	public static void testCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.getTimeInMillis();
		calendar.getTimeInMillis();
	}

	public static void testLocalTime() {
//		LocalTime localTime = LocalTime.now();
		localTime.getSecond();
	}

}
