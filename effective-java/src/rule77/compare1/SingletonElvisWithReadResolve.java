package rule77.compare1;

import java.io.Serializable;

/**
 * 싱글턴 클래스는 오직 하나의 객체만 생성되게 하는 클래스이다.
 * 만약 Serializable을 구현한다면 readObject에 의해서 새로운 객체가 만들어지므로 싱글턴 클래스가 아니게 된다.
 * 이를 막기 위해 readResolve 메서드를 구현하면 싱글턴 속성을 만족하게 오직 하나의 객체만 반환하게 하면 된다.
 *
 * @author gwon
 * @history
 *          2019. 6. 8. initial creation
 */
public class SingletonElvisWithReadResolve implements Serializable {
	public static final SingletonElvisWithReadResolve INSTANCE = new SingletonElvisWithReadResolve();

	private SingletonElvisWithReadResolve() {

	}

	// 역직렬화가 끝난 후, 해당 메서드가 호출되므로 항상 동일한 객체(싱글턴)을 반환하도록 함.
	private Object readResolve() {
		return INSTANCE;
	}

}
