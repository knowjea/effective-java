package rule20;

/**
 *
 *
 * @author gwon
 * @history
 *          2022. 6. 20. initial creation
 */
public class Figure {
	enum Shape {
		RECTANGLE, CIRCLE
	};

	final Shape shape;

	double length;
	double width;

	double redius;

	Figure(double length, double width) {
		this.shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}

	Figure(double redius) {
		this.shape = Shape.CIRCLE;
		this.redius = redius;
	}

	double area() {
		switch (shape) {
		case RECTANGLE:
			return length * width;
		case CIRCLE:
			return Math.PI * (redius * redius);
		default:
			throw new AssertionError();
		}
	}
}
