package rule75.compare;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 문자열 리스트는 그저 리스트에 담기는 문자열의 순서이다.
 * 따라서 논리적으로 필요한 데이터만 직렬화하고, 역직렬화한다.
 *
 * '@serialData' 태그는 Javadoc에서 제공한다.
 * private 메서드여도 Serializable을 구현한 클래스면 접근 가능하므로 Javadoc에 표현해야 한다.
 *
 * @author gwon
 * @history
 *          2019. 6. 2. initial creation
 */
public class StringListClassGoodUseUserSerializedForm implements Serializable {
	private static final long serialVersionUID = 1L;

	// transient를 사용하여 필요없는 값은 직렬화에서 제외
	private transient int size = 0;
	private transient Entry head = null;

	// Serializable 구현하지 않음
	private static class Entry {
		String data;
		Entry next;
		Entry previous;
	}

	public void add(String data) {
		size++;

		if (head == null) {
			head = new Entry();
			head.data = data;
		} else {
			Entry newEntry = new Entry();
			newEntry.data = data;
			head.next = newEntry;
			newEntry.previous = head;
			head = newEntry;
		}

	}

	/**
	 * 사용자 지정 직렬화
	 *
	 * @serialData 리스트의 크기가 먼저 기록되고, 그 다음에는 모든 문자열이 순서대로 기록된다.
	 * @param s
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject(); // 객체의 모든 필드가 transient일 때도 호출하는게 좋다.
		s.writeInt(size);

		for (Entry e = head; e != null; e = e.next) {
			s.writeObject(e.data);
		}
	}

	/**
	 * 사용자 지정 역직렬화
	 *
	 *
	 * @param s
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject(); // 객체의 모든 필드가 transient일 때도 호출하는게 좋다.

		int numElements = s.readInt();
		for (int i = 0; i < numElements; i++) {
			add((String) s.readObject());
		}
	}

	/**
	 * 사용자 지정 직렬화 형식을 사용해서 테스트해본 결과, 스택 오버플로 발생하지 않음
	 */
	public static void main(String[] args) throws IOException {
		StringListClassGoodUseUserSerializedForm stringList =
		        new StringListClassGoodUseUserSerializedForm();

		for (int i = 0; i < 1000000; i++) {
			System.out.println(i);
			stringList.add(String.valueOf(i));

			byte[] serializedMember;
			try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
				try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
					oos.writeObject(stringList);
					serializedMember = baos.toByteArray();
				}
			}

		}
	}
}
