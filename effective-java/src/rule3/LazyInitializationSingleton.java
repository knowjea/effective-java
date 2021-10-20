package rule3;

/**
 * Lazy initialization 싱글톤
 * Lazy Initialization은 INSTANCE 필드에 바로 초기화하지 않고 getInstance()를 최초로 호출될 때 객체를 생성하는 방식이다. 따라서 호출되지
 * 않는다면 객체 생성이 미루어지므로 애플리케이션이 로드되는데 부담이 없다.
 * 하지만 여러 쓰레드가 동시에 getInstance()를 호출할 경우 객체가 두 번 이상 호출될 수 있는 위험이 존재한다. 이를 방지하기 위해 getInstance()에
 * synchronized 키워드를 사용하여 해결할 수 있지만, 해당 싱글톤이 자주 사용된다면 효율적이지 않다.
 * 따라서 이를 해결하는 방법이 Lazy Holder이다.
 *
 * @author gwon
 * @history
 *          2021. 10. 20. initial creation
 */
public class LazyInitializationSingleton {
	private static LazyInitializationSingleton INSTANCE;

	private LazyInitializationSingleton() {}

	public static LazyInitializationSingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LazyInitializationSingleton();
		}
		return INSTANCE;
	}

	public void hello() {
		System.out.println("hello");
	}
}
