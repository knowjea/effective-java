package rule77;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import rule77.compare1.SingletonElvis;
import rule77.compare1.SingletonElvisWithReadResolve;

/**
 * 개체 통제가 필요하다면 readResovle 대신 enum 자료형을 이용하라
 *
 * readResovle는 readObject 메서드 후에 호출되는 메서드로 readObject에서 만들어낸 객체를 다른 것으로 대체할 수 있게 한다.
 * 만약 readResolve를 구현한다면 해당 클래스의 모든 객체 필드는 기본 자료형으로 하거나 아니면 transient로 선언해 직렬화에 포함하지 말아야한다.
 * 그렇지 않으면 악의적인 사용자는 규칙 76과 비슷한 공격으로 readResovle에서 반환하는 객체가 아닌 readObject에서 반환하는 객체를 얻을 수 있다.
 *
 * @author gwon
 * @history
 *          2019. 6. 8. initial creation
 */
public class Rule77 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		testNotReadResolve();
		testWithReadResolve();
	}

	public static void testNotReadResolve() throws ClassNotFoundException, IOException {
		// 싱글턴으로 미리 구현된 동일한 객체만 사용 가능
		SingletonElvis elvis = SingletonElvis.INSTANCE;

		// 직렬화 후, 역직렬화
		SingletonElvis newElvis = (SingletonElvis) deserialize(serialize(elvis));

		System.out.println(elvis == newElvis); // false
	}

	public static void testWithReadResolve() throws ClassNotFoundException, IOException {
		// 싱글턴으로 미리 구현된 동일한 객체만 사용 가능
		SingletonElvisWithReadResolve elvis = SingletonElvisWithReadResolve.INSTANCE;

		// 직렬화 후, 역직렬화
		SingletonElvisWithReadResolve newElvis = (SingletonElvisWithReadResolve) deserialize(serialize(elvis));

		System.out.println(elvis == newElvis); // true
	}

	/**
	 * 직렬화
	 *
	 *
	 * @param object
	 * @return
	 * @throws IOException
	 */
	public static byte[] serialize(Object object) throws IOException {
		byte[] serialized;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
				oos.writeObject(object);
				serialized = baos.toByteArray();
			}
		}

		return serialized;
	}

	/**
	 * 역직렬화
	 *
	 *
	 * @param serialized
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deserialize(byte[] serialized) throws IOException, ClassNotFoundException {
		try (ByteArrayInputStream bais = new ByteArrayInputStream(serialized)) {
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				Object object = ois.readObject();

				return object;
			}
		}
	}
}
