package rule76.compare2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author gwon
 * @history
 *          2019. 6. 4. initial creation
 */
public class PeriodNotGood implements Serializable {
	private final Date start;
	private final Date end;

	public PeriodNotGood(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());

		if (this.start.compareTo(this.end) > 0) {
			throw new IllegalArgumentException();
		}
	}

	// 유효성 체크를 하는 역직렬화 readObject
	private void readObject(ObjectInputStream s) throws ClassNotFoundException, IOException {
		s.defaultReadObject();

		if (this.start.compareTo(this.end) > 0) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		return "Period [start=" + start + ", end=" + end + "]";
	}

}
