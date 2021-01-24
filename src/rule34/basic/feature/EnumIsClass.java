package rule34.basic.feature;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import rule34.basic.enums.Company;

/**
 *
 *
 * @author gwon
 * @history
 *          2019. 9. 6. initial creation
 */
public class EnumIsClass {
	/**
	 * 1. 열거 타입 자체는 클래스이며, 상수 하나당 자신의 인스턴스를 하나씩 만들어 public static final 필드로 공개함
	 * ex) Company는 클래스이며, 상수(APPLE, SAMSUNG, LG)는 Company 클래스의 public static final 필드임.
	 */
	public static void main(String[] args) {
		Field[] reflectedClass = Company.class.getDeclaredFields();
		for (Field field : reflectedClass) {
			String fieldName = field.getName();
			int mod = field.getModifiers();

			// public static final 여부 확인
			if (Modifier.isPublic(mod) && Modifier.isStatic(mod) && Modifier.isFinal(mod)) {
				System.out.println(fieldName); // APPLE, SAMSUNG, LG 출력
			}
		}
	}
}
