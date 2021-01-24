package code.review;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public enum EnumSingleton {
	INSTANCE;

	private int num = 1;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		EnumSingleton deserializeSingleton;

		byte[] serializedMember;

		// 직렬화
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
				oos.writeObject(EnumSingleton.INSTANCE);
				serializedMember = baos.toByteArray();
			}
		}

		// 역직렬화
		try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				Object objectMember = ois.readObject();
				deserializeSingleton = (EnumSingleton) objectMember;
			}
		}

		System.out.println(deserializeSingleton);
		System.out.println(EnumSingleton.INSTANCE);

		deserializeSingleton.setNum(2);

		System.out.println(deserializeSingleton.getNum());
		System.out.println(EnumSingleton.INSTANCE.getNum());
	}
}
