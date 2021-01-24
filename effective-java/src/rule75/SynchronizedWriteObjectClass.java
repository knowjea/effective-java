package rule75;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 객체를 직렬화 할 대는 객체의 상태 전부를 읽는 메서드에 적용할 동기화 수단을 반드시 적용해야 한다.
 *
 * @author gwon
 * @history
 *          2019. 6. 2. initial creation
 */
public class SynchronizedWriteObjectClass implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 모든 메서드를 동기화해서 스레드 안전성을 달성하는 객체가 있다면, 직렬화에도 동기화 사용
	 * 
	 * @param s
	 * @throws IOException
	 */
	private synchronized void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject(); // 객체의 모든 필드가 transient일 때도 호출하는게 좋다.
	}

}
