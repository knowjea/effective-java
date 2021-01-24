package rule66.compare.increment.cas;

/**
 * java.util.concurrent.atomic 패키지가 제공하는 클래스들은 원자적 연산을 수행할 수 있는 클래스들을 제공한다.
 * synchronized 키워드 없이도 여러 스레드들에 의해 병렬적으로 수행되어도 결과의 안전성을 보장한다.
 * 내부적으로는 CAS(Compare-And-Swap)을 활용하는데 이는 네이티브 메서드로 짜여 있으며 실제 메모리를 참조하여 구현되어 있다.
 * 아래 함수는 예시로 만든 CAS메서드와 CAS메서드를 이용하여 AtomicLong 클래스가 어떻게 원자적 연사를 수행하는지 보여준다.
 * (자바는 포인터가 없으므로 컴파일은 되지 않는다.)
 *
 * @author gwon
 * @history
 *          2019. 6. 25. initial creation
 */
public class CAS {

	/**
	 * 값을 변경하기전 자신이 기억하고 있는 값과 현재 모든 스레드가 공유하는 메모리 영역의 값을 비교한다.
	 * 비교하여 같지 않을 경우, 다른 스레드가 먼저 해당 값을 변경하였으므로 false를 리턴하여 호출한 곳에서 다시 새로운 값으로 호출하도록 한다.
	 * 비교하여 값이 같을 경우, 현재 스레드가 값을 변경할 차례로 판단하여 메모리 영역에 새로운 값을 저장하고 true를 리턴하여 호출한곳에서 끝내도록 한다.
	 *
	 * @param *pointer	모든 스레드가 공유하는 메모리 영역의 포인터.
	 * @param oldVal	값을 변경하기전 자신이 기억하고 있는 값
	 * @param newVal	변경하고자 하는 값
	 * @return
	 */
	public boolean compareAndSwap(int *pointer, int oldVal, int newVal) {
		if (*pointer != oldVal) {
			return false;
		}

		*pointer = newVal;
		return true;
	}

	/**
	 * 모든 스레드가 공유하는 메모리 영역의 값을 가지고 와, 현재 자신이 기억하는 값으로 저장한다.
	 * 1을 증가시키기 위해 CAS를 호출하는데 이 때 메모리 영역과, 현재 자신이 기억하는 값, 변경값을 인자로 주어 호출한다.
	 * 만약 이 때 동안 다른 스레드가 변경을 할 경우, 자신이 기억하고 있는 값과 메모리 영역의 값이 달라 CAS에서 false가 리턴되어
	 * 다시 현재 자신이 기억하는 값을 새롭게 업데이트하여 반복한다.
	 *
	 */
	public long getAndIncrement(){
		boolean done = false;
		int oldVal;
		while(!done){
			oldVal = *pointer;
			done = compareAndSwap(pointer, oldVal, oldVal + 1);
		}

		return oldVal + 1;
	}
}
