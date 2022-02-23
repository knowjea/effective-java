package rule14;

/**
 *
 *
 * @author gwon
 * @history
 *          2022. 2. 23. initial creation
 */
public class Client {
	public static void main(String[] args) {
		PositivePoinWithFinalField point = new PositivePoinWithFinalField(0, 0);

		// final이서 컴파일 에러
		point.x = -5;
		point.y = -10;

	}
}
