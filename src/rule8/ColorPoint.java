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
public class ColorPoint extends Point {
	private final Color color;

	public ColorPoint(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}

	public ColorPoint(Point point, Color color) {
		super(point);
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point)) {
			return false;
		}

		if (!(obj instanceof ColorPoint)) {
			return obj.equals(this);
		}

		return super.equals(obj) && ((ColorPoint) obj).color == color;
	}

	public static void main(String[] args) {
		Point point = new Point(1, 2);
		ColorPoint colorPoint = new ColorPoint(point, Color.RED);

		// Symmetry
		System.out.println(point.equals(colorPoint)); // true
		System.out.println(colorPoint.equals(point)); // true

		ColorPoint blueColorPoint = new ColorPoint(point, Color.BLUE);

		// Transitivity violation
		System.out.println(colorPoint.equals(point)); // true
		System.out.println(point.equals(blueColorPoint)); // true
		System.out.println(colorPoint.equals(blueColorPoint)); // false
	}

}
