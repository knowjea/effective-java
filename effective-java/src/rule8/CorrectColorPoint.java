package rule8;

import java.awt.Color;
import java.awt.Point;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 8. 26. initial creation
 */
public class CorrectColorPoint {
	// Point를 상속하지 않고 필드로 구성하였다.
	private final Point point;
	private final Color color;

	public CorrectColorPoint(int x, int y, Color color) {
		this.point = new Point(x, y);
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
		// 1.
		if (obj == this) {
			return true;
		}
		// 2.
		if (!(obj instanceof CorrectColorPoint)) {
			return false;
		}
		// 3.
		CorrectColorPoint cp = (CorrectColorPoint) obj;

		// 4.
		return cp.point.equals(point) && cp.color.equals(color);
	}
}
