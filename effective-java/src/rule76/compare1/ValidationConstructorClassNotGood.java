package rule76.compare1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 유효성을 파괴하는 클래스
 *
 * readObject 메서드가 실질적으로 public 생성자나 마찬가지며, 생성자를 구현할 때와 같은 점에 주의해야 한다.
 * 생성자와 마찬가지로 유효성 검사를 하지 않을 경우, 쉽게 클래스의 유효성을 망가뜨릴 수 있게 된다.
 * 기본 직렬화를 사용해서 readObject를 구현하지 않을 경우, 악의적인 사용자는 바이트스트림을 조작하여 데이터의 유효성을 파괴한다.
 *
 *
 * @author gwon
 * @history
 *          2019. 6. 4. initial creation
 */
public class ValidationConstructorClassNotGood implements Serializable {
	private final Integer notZero;

	// 유효성 체크를 하는 생성자
	public ValidationConstructorClassNotGood(int num) {
		this.notZero = num;

		// 0일 경우 에러
		if (this.notZero == 0) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		return "ValidationConstructorClassNotGood [notZero=" + notZero + "]";
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 1로 객체 생성
		ValidationConstructorClassNotGood original = new ValidationConstructorClassNotGood(1);
		System.out.println(original); // ValidationConstructorClassNotGood [notZero=1]

		// 직렬화
		byte[] serializedBytes;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
				oos.writeObject(original);
				serializedBytes = baos.toByteArray();
			}
		}

		/**
		 * 이 클래스를 직렬화 할 경우, 가장 마지막 byte의 값이 nonZero 값이다.
		 * nonZero을 0으로 변경 (유효성 파괴)
		 */
		serializedBytes[serializedBytes.length - 1] = 0x00;

		// 역직렬화
		ValidationConstructorClassNotGood copy;
		try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedBytes)) {
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				Object objectMember = ois.readObject();

				copy = (ValidationConstructorClassNotGood) objectMember;
			}
		}

		// nonZero 값이 0으로 변경됨을 확인
		System.out.println(copy); // ValidationConstructorClassNotGood [notZero=0]

	}
}
