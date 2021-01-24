package rule76.compare1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 역직렬화를 할 때도 유효성을 체크하는 클래스
 *
 * readObject 메서드가 실질적으로 public 생성자나 마찬가지며, 생성자를 구현할 때와 같은 점에 주의해야 한다.
 * 생성자와 마찬가지로 유효성 검사를 하지 않을 경우, 쉽게 클래스의 유효성을 망가뜨릴 수 있게 된다.
 * readObject에서 public 생성자와 동일한 유효성을 체크하도록 해야 한다.
 *
 * @author gwon
 * @history
 *          2019. 6. 4. initial creation
 */
public class ValidationConstructorClassGoodCase implements Serializable {
	private final Integer notZero;

	// 유효성 체크를 하는 생성자
	public ValidationConstructorClassGoodCase(int num) {
		this.notZero = num;

		// 0일 경우 에러
		if (this.notZero == 0) {
			throw new IllegalArgumentException();
		}
	}

	// compare : 유효성 체크를 하는 역직렬화 readObject
	private void readObject(ObjectInputStream s) throws ClassNotFoundException, IOException {
		s.defaultReadObject();

		// 0일 경우 에러
		if (notZero == 0) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		return "ValidationConstructorClassGoodCase [notZero=" + notZero + "]";
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 1로 객체 생성
		ValidationConstructorClassGoodCase original = new ValidationConstructorClassGoodCase(1);
		System.out.println(original); // ValidationConstructorClassGoodCase [notZero=1]

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
		// compare : readObject의 유효성 체크에 걸려 IllegalArgumentException 발생
		ValidationConstructorClassGoodCase copy;
		try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedBytes)) {
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				Object objectMember = ois.readObject();

				copy = (ValidationConstructorClassGoodCase) objectMember;
			}
		}

		// compare : 도달하지 못함.
		System.out.println(copy);

	}
}
