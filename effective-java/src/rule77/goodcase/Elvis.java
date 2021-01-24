package rule77.goodcase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 싱글턴을 Enum으로 구현하면, 선언된 상수 이외의 다른 객체는 존재할 수 없다는 확실한 보장이 생긴다.
 *
 * @author gwon
 * @history
 *          2019. 6. 16. initial creation
 */
public enum Elvis implements Serializable {
	INSTANCE;

	// Enum이므로 transient 불필요
	private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

	/**
	 * Enum으로 구현되어 있으므로 필요하지 않음
	 * private Object readResolve() {
	 * return INSTANCE;
	 * }
	 */

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Elvis elvis = Elvis.INSTANCE;

		byte[] serialized;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
				oos.writeObject(elvis);
				serialized = baos.toByteArray();
			}
		}

		Object newElvis;
		try (ByteArrayInputStream bais = new ByteArrayInputStream(serialized)) {
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				Object object = ois.readObject();

				newElvis = object;
			}
		}

		// readResovle 메서드가 없어도 JVM에서 항상 같은 인스턴스를 반환
		System.out.println(elvis == newElvis); // true
	}
}
