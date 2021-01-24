package rule14;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 9. 29. initial creation
 */
public class PositivePointWithPrivateField {
	private double x;
	private double y;

	public PositivePointWithPrivateField(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		// Any action can be performed
		return x;
	}

	public void setX(double x) {
		// Can limit value
		if (x <= 0) {
			throw new IllegalArgumentException();
		}
		this.x = x;
	}

	public double getY() {
		// Any action can be performed
		return y;
	}

	public void setY(double y) {
		// Can limit value
		if (y <= 0) {
			throw new IllegalArgumentException();
		}

		this.y = y;
	}
}
