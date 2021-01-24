package rule75;

import java.io.Serializable;

/**
 * 논리적으로 사람의 이름을 표현할 때는 문자열로 구성되므로 문자열로 사람의 이름을 표현하는
 * 이 클래스는 기본 직렬화 형식을 그대로 써도 좋다.
 *
 * '@serial' 태그는 Javadoc에서 제공한다.
 * private 필드여도 Serializable을 구현한 클래스면 접근 가능하므로 Javadoc에 표현해야 한다.
 *
 * @author gwon
 * @history
 *          2019. 6. 2. initial creation
 */
public class NameClassGoodUseDefaultSerializedForm implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 성(last name). null이 될 수 없다.
	 *
	 * @serial
	 */
	private String lastName;
	/**
	 * 이름(first name). null이 될 수 없다.
	 *
	 * @serial
	 */
	private String firstName;
	/**
	 * 중간 이름(middle name). null이 될 수 있다.
	 *
	 * @serial
	 */
	private String middleName;
}
