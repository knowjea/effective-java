package rule3;

/**
 * Lazy Holder는 JVM 클래스 로더의 동작 방식을 이용하여 Lazy Initialization를 만족하면서, 동기화 문제도 해결한다.
 * 1. LazyHoladerSingleton은 static 필드가 없기 때문에, 즉 초기화할 것이 없으므로 아주 빠르게 클래스가 로드된다.
 * 2. LazyHolder는 LazyHolder가 실행되기 전까지는 로드가 되지 않는다.
 * 3. 어디선가 LazyHoladerSingleton.getInstance()를 호출하면 LazyHolder를 로드를 수행하고 초기화를 진행한다.
 * 4. LazyHolder가 로드되면서 static 필드인 INSTANCE를 초기화할 때는 JVM 원리상 동시에 수행할 수 없다.
 * 5. 따라서 LazyHolder는 멀티스레드에서도 안전하게 LazyHolderSingleton의 생성자를 호출하여 초기화를 완료한다.
 *
 * @author gwon
 * @history
 *          2020. 5. 24. initial creation
 */
public class LazyHolderSingleton {
	private LazyHolderSingleton() {};

	private static class LazyHolder {
		static final LazyHolderSingleton INSTANCE = new LazyHolderSingleton();
	}

	public static LazyHolderSingleton getInstance() {
		return LazyHolder.INSTANCE;
	}
}
