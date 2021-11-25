package rule8;

import java.awt.Color;
import java.awt.Point;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 8. 24. initial creation
 */
public class NotSymmetryColorPoint extends Point {
	private final Color color;

	public NotSymmetryColorPoint(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
		// ColorPoint 객체가 아닐 경우, 항상 false이다.
		if (!(obj instanceof NotSymmetryColorPoint)) {
			return false;
		}

		return super.equals(obj) && ((NotSymmetryColorPoint) obj).color == color;
	}

	public static void main(String[] args) {
		Point point = new Point(1, 2);
		NotSymmetryColorPoint colorPoint = new NotSymmetryColorPoint(1, 2, Color.RED);

		// Symmetry
		System.out.println(point.equals(colorPoint)); // true
		System.out.println(colorPoint.equals(point)); // false
	}
}
