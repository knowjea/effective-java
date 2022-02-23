package rule14;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 9. 29. initial creation
 */
public class PositivePointWithPublicField {
	public double x;
	public double y;

	public PositivePointWithPublicField(double x, double y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException();
		}

		this.x = x;
		this.y = y;
	}
}
