package rule8;

/**
 * Obey the general contract when overriding equals
 * (equals를 재정의할 때는 일반 규약을 따르라)
 *
 * @author gwon
 * @history
 *          2018. 7. 29. initial creation
 */
public class Rule8 {
	public static void main(String[] args) {
		XClass xClass = new XClass();
		YClass yClass = new YClass();

		xClass.age = 10;
		yClass.years = 10;

		System.out.println(xClass.equals(yClass)); // true
		System.out.println(yClass.equals(xClass)); // fasle

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		throw new AssertionError();
	}

}
