package rule28;

import java.util.ArrayList;
import java.util.List;

/**
 * 배열보다는 리스트를 사용하라
 *
 * @author gwon
 * @history
 *          2019. 8. 26. initial creation
 */
public class Rule28 {
	public static void main(String[] args) {

		/**
		 * 1. 배열과 제네릭을 사용하는 리스트의 차이 (1)
		 *
		 * 배열은 상위 클래스(Object)의 자료형에 하위 클래스(Long)를 구현 가능하므로, 컴파일 에러가 발생하지 않는다.
		 * 하지만, 상위 클래스가 Object이므로 어떠한 타입도 런타임 때 넣을 수 있지만, 타입이 달라 넣을 수 없어 예외가 발생.
		 */
		Object[] objectArray = new Long[1];
		objectArray[0] = "Hello"; // java.lang.ArrayStoreException 발생

		/**
		 * 제네릭은 타입에서는 상위 클래스에 하위 클래스를 구현 불가능하므로, 컴파일 에러가 발생한다.
		 * 따라서 컴파일할 때 바로 알 수 있으므로 제네릭인 리스트를 사용하는 것이 좋다.
		 */
		List<Object> list = new ArrayList<Long>(); // 컴파일 에러
		list.add("Hello");

		/**
		 * 2. 배열과 제네릭을 사용하는 리스트의 차이 (2)
		 *
		 * 배열은 런타임에도 추가하기로 하는 원소의 타입을 인지하고 확인한다.
		 * Long 배열에 String을 넣으려고 한다면 위에서 보듯 java.lang.ArrayStoreException 가 발생한다.
		 * 반대로 제네릭 타입은 컴파일할 때만 검사하며 런타임에는 타입을 소거하여 타입을 알 수 없다.
		 */

		List<?>[] a = new ArrayList<?>[1];
		List<String>[] b = new ArrayList<String>[1];

	}
}
