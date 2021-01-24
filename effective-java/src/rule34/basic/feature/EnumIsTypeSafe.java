package rule34.basic.feature;

import rule34.basic.enums.Company;
import rule34.basic.enums.Country;

/**
 *
 *
 * @author gwon
 * @history
 *          2019. 9. 6. initial creation
 */
public class EnumIsTypeSafe {
	/**
	 * 3. int 상수를 사용할 경우 다른 집합의 상수 값을 잘못 넣을 수 있지만 열거 타입은 타입이므로 컴파일 시 타입 안전성을 제공함.
	 */
	public static void main(String[] args) {
		System.out.println(isDokdoInCountry(Country.KOREA));

		System.out.println(isDokdoInCountry(Company.APPLE)); // Company 열거 타입을 사용하여 컴파일 시 에러 발생.
	}

	/**
	 * Country 열거 타입을 입력 받음
	 *
	 * @param country
	 * @return
	 */
	public static boolean isDokdoInCountry(Country country) {
		if (country == Country.KOREA) {
			return true;
		} else {
			return false;
		}
	}
}
