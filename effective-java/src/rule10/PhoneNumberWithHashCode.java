package rule10;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 9. 2. initial creation
 */
public class PhoneNumberWithHashCode {
	private final int areaCode;
	private final int prefix;
	private final int lineNumber;

	public PhoneNumberWithHashCode(int areaCode, int prefix, int lineNumber) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNumber = lineNumber;
	}

	/**
	 *
	 * 전화번호를 문자열로 변환해서 반환한다.
	 * 문자열은 "(XXX) YYY-ZZZZ" 형식으로 표현하여, 지역번호(areaCode), 국번(prefix), 회선번호(lineNumber) 순이다.
	 * 형식은 변경될 수 있다.
	 */
	@Override
	public String toString() {
		return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
	}

	public static void main(String[] args) {
		PhoneNumberWithHashCode p1 = new PhoneNumberWithHashCode(111, 654, 7009);

		System.out.println(p1);
	}

}
