package rule66.compare.stop;

/**
 * {@link FirstStopThread} 수정하는 한 가지 방법은 boolean 값을 동기화하는 것이다.
 * synchronized 사용하여 동기화 할 경우, 당연하게 상호배제(mutually exclusive)를 제공한다.
 * 하지만 이 프로그램에서는 상호배제를 위한 동기화가 아니다. 동기화는 한 스레드가 만든 변화를 다른 스레드에서 관측할 수 있다.
 * 이 프로그램에서는 이를 위하여 동기화를 사용한다. 즉, 후면 스레드는 동기화 메서드인 stopRequested()의 변화를 지속적으로 관찰할 수 있도록 하여
 * 앞서 본 {@link FirstStopThread}의 문제점인 hoisting 최적화를 막아 정상적으로 프로그램이 종료되도록 한다.
 *
 * @author gwon
 * @history
 *          2019. 6. 24. initial creation
 */
public class SecondStopThreadSync {
	private static boolean stopRequested = false;

	private static void requestStop() {
		stopRequested = true;
	}

	private static synchronized boolean stopRequested() {
		return stopRequested;
	}

	public static void main(String[] args) throws InterruptedException {

		Thread bgThread = new Thread(new Runnable() {

			@Override
			public void run() {
				int i = 0;
				while (!stopRequested()) {
					i++;
				}

				System.out.println("finished");

			}
		});

		bgThread.start();

		Thread.sleep(10);
		requestStop();

	}
}
