package rule34.basic.feature;

import rule34.basic.enums.Company;

/**
 *
 *
 * @author gwon
 * @history
 *          2019. 9. 6. initial creation
 */
public class EnumImpl {
	/**
	 * 4.
	 * - Object 메서드들을 높은 품질로 구현.
	 * int 상수를 사용할 경우 의미를 표현하는 문자열을 출력하기가 어렵다. 열거 타입은 toString 메서드를 이용하여 적합한 문자열 출력한다.
	 *
	 * - Comparable, Serializable 구현.
	 * 직렬화 형태도 웬만큼 변형을 가해도 문제없이 동작하게끔 구현함
	 *
	 */
	public static void main(String[] args) {
		System.out.println(Company.APPLE.toString()); // APPLE
	}

}
