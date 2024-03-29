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
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException();
		}

		this.x = x;
		this.y = y;
	}

}
