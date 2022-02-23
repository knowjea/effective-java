package rule14;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 9. 29. initial creation
 */
public class PositivePoinWithFinalField {
	public final double x;
	public final double y;

	public PositivePoinWithFinalField(double x, double y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException();
		}

		this.x = x;
		this.y = y;
	}
}
