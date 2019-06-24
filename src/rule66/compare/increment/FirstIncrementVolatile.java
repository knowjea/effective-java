package rule66.compare.increment;

/**
 * volatile은 데이터를 읽을때는 가장 최근에 기록된 값을 읽도록 보장하지만 쓰기에 대해서는 동기화를 지원하지 않는다.
 * getNum()으로 가장 최근에 기록된 값에서 ++을 하지만, 두 개의 쓰레드가 동시에 같은 값을 읽어서 ++할 경우에는 결국 같은 값을 쓰게 된다.
 * 따라서 아래 결과는 2000이 되지 않는다. 따라서 이럴 땐 상호배제를 위해 synchronized를 사용해야 한다. {@link SecondIncrementSync}
 *
 * @author gwon
 * @history
 *          2019. 6. 24. initial creation
 */
final class FirstIncrementVolatile {
	private static volatile int cnt = 0;

	public static int getNum() {
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

		System.out.println(cnt); // not 2000
	}
}
