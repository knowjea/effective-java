package code.review;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonTest implements Serializable {
	private static final SingletonTest INSTANCE = new SingletonTest();

	private int num = 1;
//	private transient int num = 1;

	private SingletonTest() {

	}

	public static SingletonTest getInstance() {
		return INSTANCE;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	// private Object readResolve() {
//	return INSTANCE;
//}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SingletonTest deserializeSingleton;

		byte[] serializedMember;

		// 직렬화
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
				oos.writeObject(SingletonTest.getInstance());
				serializedMember = baos.toByteArray();
			}
		}

		// 역직렬화
		try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				Object objectMember = ois.readObject();
				deserializeSingleton = (SingletonTest) objectMember;
			}
		}

		System.out.println(deserializeSingleton == SingletonTest.getInstance());
		System.out.println(deserializeSingleton);
		System.out.println(SingletonTest.getInstance());

		deserializeSingleton.setNum(2);

		System.out.println(deserializeSingleton.getNum());
		System.out.println(SingletonTest.getInstance().getNum());
	}

}
