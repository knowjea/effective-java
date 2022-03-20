package rule16;

import java.util.Collection;
import java.util.Set;

/**
 *
 *
 * @author gwon
 * @history
 *          2022. 3. 20. initial creation
 */
public class CountHashSetByComposit<E> {
	private int addCount = 0;
	private Set<E> s;

	public CountHashSetByComposit(Set<E> s) {
		this.s = s;
	}

	public boolean add(E e) {
		addCount++;
		return s.add(e);
	}

	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return s.addAll(c);
	}
}
