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
public class PeriodGood implements Serializable {
	// compare : 방어적 복사를 위해 final 제거 됨
	private Date start;
	private Date end;

	public PeriodGood(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());

		if (this.start.compareTo(this.end) > 0) {
			throw new IllegalArgumentException();
		}
	}

	// 유효성 체크를 하는 역직렬화 readObject
	private void readObject(ObjectInputStream s) throws ClassNotFoundException, IOException {
		s.defaultReadObject();

		// compare : private 필드를 모두 방어적으로 복사해서 해당 참조값이 변경되도 어떠한 영향이 없도록 함.
		start = new Date(start.getTime());
		end = new Date(end.getTime());

		if (this.start.compareTo(this.end) > 0) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		return "Period [start=" + start + ", end=" + end + "]";
	}

}
