package rule66.compare.increment;

/**
 * 메서드를 동기화로 선언하면 여러 스레드가 동시에 호출하더라도 서로 겹쳐 실행되지 않는다.
 * 더 좋은 방법도 있다. 사실 아래와 같은 경우를 위해 자바에서는 atomic 패키지에 다양한 클래스를 제공한다. {@link ThirdAtomicLong}
 *
 * @author gwon
 * @history
 *          2019. 6. 24. initial creation
 */
final class SecondIncrementSync {
	private static int cnt = 0;

	// synchronized 메서드
	public static synchronized int getNum() {
		return cnt++;
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
