package rule77.badcase;

import java.io.Serializable;

/**
 * readResolve를 구현한다면 해당 클래스의 모든 객체 필드는 기본 자료형으로 하거나 아니면 transient로 선언해 직렬화에 포함하지 말아야한다.
 * 그렇지 않으면 악의적인 사용자는 규칙 76과 비슷한 공격으로 readResovle에서 반환하는 객체가 아닌 readObject에서 반환하는 객체를 얻을 수 있다.
 * 이 클래스는 싱글턴이고 readResovle를 구현했으나 transient로 선언하지 않은 객체 참조 필드가 있다.
 *
 * @author gwon
 * @history
 *          2019. 6. 8. initial creation
 */
public class SingletonElvisWithReadResolveButNotTransient implements Serializable {
	public static final SingletonElvisWithReadResolveButNotTransient INSTANCE =
	        new SingletonElvisWithReadResolveButNotTransient();

	private SingletonElvisWithReadResolveButNotTransient() {

	}

	// transient를 선언하지 않음.
	private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

	// 역직렬화가 끝난 후, 해당 메서드가 호출되므로 항상 동일한 객체(싱글턴)을 반환하도록 함.
	private Object readResolve() {
		return INSTANCE;
	}

}
