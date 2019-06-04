package rule75.compare;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 링크드리스트로 문자열의 리스트를 표현하는 클래스이다.
 * 이 클래스를 기본 직렬화 형식으로 직렬화 할 경우 모든 연결 리스트 항목과 항목 간 양방향 연결 구조를 모두 직렬화해야 한다. 따라서
 * 1. 너무 많은 공간을 필요로 할 수 있다. (네트워크 속도, 디스크 저장 문제 발생가능)
 * 2. 너무 많은 시간을 소비하는 문제가 생길 수 있다.
 * 3. 스택 오버플로가 발생할 수 있다.
 *
 *
 *
 * 하지만, 이 클래스를 논리적으로만 생각한다면 문자열을 순서대로 저장한 배열이다. 따라서 기본 직렬화 형식이 아닌 사용자 지정 직렬화를 구현해서 직렬화하는 것이 좋다.
 *
 * @author gwon
 * @history
 *          2019. 6. 2. initial creation
 */
public class StringListClassNotGoodUseDefaultSerializedForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private int size = 0;
	private Entry head = null;

	private static class Entry implements Serializable {
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
	 * 기본 직렬화 형식을 사용해서 테스트해본 결과, 3482번째에서 스택 오버플로 발생
	 */
	public static void main(String[] args) throws IOException {
		StringListClassNotGoodUseDefaultSerializedForm stringList =
		        new StringListClassNotGoodUseDefaultSerializedForm();

		for (int i = 0; i < 5000; i++) {
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
