package rule34.basic.feature;

import rule34.Rule34.Company;

/**
 *
 *
 * @author gwon
 * @history
 *          2019. 9. 6. initial creation
 */
public class EnumIsSingleton {
	/**
	 * 2. 열거 타입은 싱글톤이므로 인스턴스가 하나만 존재한다.
	 */
	public static void main(String[] args) {
		Company company = new Companny(); // 싱글톤으로 구현하여 외부에서 접근 가능한 생성자가 존재하지 않아 컴파일 에러 발생.
	}
}
