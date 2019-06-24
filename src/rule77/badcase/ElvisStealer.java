package rule77.badcase;

import java.io.IOException;
import java.io.Serializable;

import rule77.Rule77;

/**
 *
 *
 * @author gwon
 * @history
 *          2019. 6. 8. initial creation
 */
public class ElvisStealer implements Serializable {
	static SingletonElvisWithReadResolveButNotTransient impersonator;
	private SingletonElvisWithReadResolveButNotTransient payload;

	private Object readResolve() {
		impersonator = payload;

		return new String[] { "A Fool Such as I" };
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		SingletonElvisWithReadResolveButNotTransient elvis = (SingletonElvisWithReadResolveButNotTransient) Rule77
		        .deserialize(Rule77.serialize(SingletonElvisWithReadResolveButNotTransient.INSTANCE));

	}
}
