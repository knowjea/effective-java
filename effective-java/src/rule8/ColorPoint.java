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
		// Point 객체가 아닐 경우, 항상 false를 리턴
		if (!(obj instanceof Point)) {
			return false;
		}

		// ColorPoint가 아닌 Point 객체일경우, 색상은 비교하지 않고 좌표만 비교
		if (!(obj instanceof ColorPoint)) {
			return obj.equals(this);
		}

		return super.equals(obj) && ((ColorPoint) obj).color == color;
	}

	public static void main(String[] args) {
		Point point = new Point(1, 2);
		ColorPoint redColorPoint = new ColorPoint(point, Color.RED);

		// Symmetry
		System.out.println(point.equals(redColorPoint)); // true
		System.out.println(redColorPoint.equals(point)); // true

		ColorPoint blueColorPoint = new ColorPoint(point, Color.BLUE);

		// Transitivity violation
		System.out.println(redColorPoint.equals(point)); // true
		System.out.println(point.equals(blueColorPoint)); // true
		System.out.println(redColorPoint.equals(blueColorPoint)); // false
	}

}
