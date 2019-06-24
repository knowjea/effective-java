package rule66.compare.increment;

import java.util.concurrent.atomic.AtomicLong;

/**
 * {@link rule47} 어떤 라이브러리가 있는지 파악하고, 적절히 활용하라 규칙처럼 {@link SecondIncrementSync}과 같이
 * 원하는 일을 해주면서도, 동기화를 사용한 해법보다 성능도 좋은 클래스는 자바에서 제공한다.
 * 좀 더 자세한 설명은 {@link CAS} 참고
 *
 *
 * @author gwon
 * @history
 *          2019. 6. 24. initial creation
 */
final class ThirdAtomicLong {
	private static final AtomicLong cnt = new AtomicLong();

	public static long getNum() {
		return cnt.getAndIncrement();
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					getNum();
				}

				System.out.println("t1 finished");
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					getNum();
				}

				System.out.println("t2 finished");
			}
		});

		t1.start();
		t2.start();

		Thread.sleep(1000);

		System.out.println(cnt); // 2000
	}
}
