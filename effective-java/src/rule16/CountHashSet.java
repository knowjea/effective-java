package rule16;

import java.util.Collection;
import java.util.HashSet;

/**
 * 심플한 클래스로 잘 동작할 것 같지만 addAll()을 호출할 경우 문제가 발생한다. addAll()에서 super.addAll()은
 * java.util.AbstractCollection 클래스의 addAll()을 호출하는데 addAll()에서 다시 add()를 호출한다.
 * 따라서 구현한 코드는 중복 계산 되므로 addAll()을 호출하게 되면 항상 원소의 두 배만큼 증가한다.
 *
 * @author gwon
 * @history
 *          2022. 3. 20. initial creation
 */
public class CountHashSet<E> extends HashSet<E> {
	private int addCount = 0;

	public CountHashSet() {

	}

	public CountHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}
}
