package rule3;

/**
 * Eager initialization을 사용한 싱글톤 방식이라고도 한다.
 * 1. 클래스가 로드하게 되면 바로 객체를 생성한다. 만약 해당 싱글톤 클래스가 객체를 생성하는데 많은 시간과 비용이 발생한다면, 애플리케이션이 로드되는데 오래 걸리는 문제가
 * 있을 수 있다.
 * 2. 리플렉션을 사용한다면 생성자가 private여도 호출할 수 있다. 생성자가 두 번 호출되면 예외를 던지도록 처리하여 방어할 수 있다.
 * 3. 싱글턴 클래스가 Serializeable이 가능하다면 역직렬화 때마다 새로운 객체가 생성된다. 나중에 포스팅할 내용을 미리 포스팅하여 설명하자면 아래와 같다.
 *
 * @author gwon
 * @history
 *          2021. 10. 20. initial creation
 */
public class GetInstanceSingleton {
	private static final GetInstanceSingleton INSTANCE = new GetInstanceSingleton();

	private GetInstanceSingleton() {}

	public static GetInstanceSingleton getInstance() {
		return INSTANCE;
	}

	public void hello() {
		System.out.println("hello");
	}
}
