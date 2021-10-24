package rule4;

import org.springframework.util.StringUtils;

/**
 * Spring의 StringUtils는 클래스는 객체 생성을 막기 위해 abstract를 클래스로 만들었지만
 * 하위 클래스가 상속받는다면 객체 생성이 가능
 *
 * @author gwon
 * @history
 *          2021. 10. 24. initial creation
 */
public class ChildSpringStringUtils extends StringUtils {

	public static void main(String[] args) {
		StringUtils stringUtils = new ChildSpringStringUtils();

		stringUtils.isEmpty("abc");
	}
}
