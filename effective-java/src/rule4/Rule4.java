package rule4;

/**
 * Enforce noninstantiability with a private constructor
 * (Use private constructors to prevent object creation)
 *
 * @author gwon
 * @history
 *          2018. 6. 24. initial creation
 */
public class Rule4 {
	public static void main(String[] args) {
		Rule4 rule4 = new Rule4();

		rule4.canNotCreateObjects();
	}

	/**
	 * Java utilities that can not create objects
	 */
	public void canNotCreateObjects() {
//		private Math mathUtil = new Math();
//		private Arrays arrayUtil = new Arrays();
//		private Collections collections = new Collections();

//		UtilityClass utilityClass = new UtilityClass();

	}

}
