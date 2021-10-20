package rule3;

/**
 * 리플렉션, 직렬화를 위한 방어 로직을 작성하기 귀찮다면 Enum을 사용하는 것도 좋은 방법이다.
 * Enum은 직렬화가 자동으로 처리되며, 리플렉션을 통한 공격에도 안전하다.
 * 
 * @author gwon
 * @history
 *          2021. 10. 20. initial creation
 */
public enum EnumSingleton {
	INSTANCE;

	public void hello() {
		System.out.println("hello");
	}
}
