package rule45;

/**
 * 지역 변수의 유효범위를 최소화하라
 *
 * @author gwon
 * @history
 *          2019. 7. 31. initial creation
 */
public class Rule45 {

	public static void main(String[] args) {
		/** 1. 지역 변수를 먼저 선언하지 말고, 처음 사용하는 곳에서 선언하는 것이 좋다. */

		/** 2. 지역 변수 선언시에는 초기값을 설정해야한다. 만약 초기값을 설정하기 어렵다면 선언하는것은 좋지 않다. */

		/** 3. for문 조건절에는 순환문 변수를 선언할 수 있으므로 while문보다는 for문을 사용해라. */
		for (int i1 = 0; i1 < 10; i1++) {
			System.out.println(i1);
		}

		/** j1 변수는 메서드가 끝날 때까지 유효하므로 for문이 좋다. **/
		int j1 = 0;
		while (j1 < 10) {
			System.out.println(j1++);
		}

		/** j1 변수가 메서드 끝날 때까지 유효하므로 j2를 사용해야 하는 곳에 실수로 j1를 사용해도 컴파일도 잘되고 실행되지만 이상하게 동작한다. */
		int j2 = 0;
		while (j1 < 10) {
			System.out.println(j2++);
		}

		/**
		 * while문과 다르게 for문은 순환문 변수를 사용하면 i1은 위 for문에서 사용하고 사라진다. 실수로 i1을 사용한다고 하면 컴파일 에러가 발생하므로
		 * for문이 좋다.
		 */
		for (int i2 = 0; i1 < 10; i2++) {
			System.out.println(i2);
		}

		/********************************* 3. End **********************************/

		/** 4. Rule45.getNum()을 순환할 때마다 게속 호출하여 사용하므로 좋지 않다. **/
		for (int i = 0; i < Rule45.getNum(); i++) {
			System.out.println(i);
		}

		/** 이처럼 미리 계산해 넣어두고 사용함으로써 재계산할 필요가 없어 좋다. */
		for (int i = 0, n = Rule45.getNum(); i < n; i++) {
			System.out.println(i);
		}

		/********************************* 4. End **********************************/

		/** 5. 메서드의 크기를 줄이고특정한 기능에 집중하게 되면 저절로 지역 변수의 유효범위가 최소화 된다. */
	}

	public static int getNum() {
		return 10;
	}
}
