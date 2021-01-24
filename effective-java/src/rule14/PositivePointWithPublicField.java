package rule14;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 9. 29. initial creation
 */
public class PositivePointWithPublicField {
	// Can not limit value
	public double x;
	public double y;

	public PositivePointWithPublicField(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
