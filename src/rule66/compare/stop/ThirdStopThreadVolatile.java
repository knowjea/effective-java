package rule66.compare.stop;

/**
 * {@link SecondStopThreadSync}에서 설명했듯이, 이 프로그램에서 동기화는 상호배제를 목적으로 사용하지 않았다.
 * 즉, 락이 필요없다. 비록 순환문의 각 단계마다 동기화를 실행하는 비용이 크진 않지만 그래도 동기화를 쓰지 않는것보다는 비용이 크다.
 * 락이 필요없고 비용을 줄이고 싶다면 volatile를 사용하면 된다. volatile은 어떤 스래드건 가장 최근에 기록된 값을 읽도록 보장한다.
 * (하지만 volatile이 volatile을 사용하지 않는것보다 비용이 적은것은 아니다.)
 *
 * @author gwon
 * @history
 *          2019. 6. 24. initial creation
 */
public class ThirdStopThreadVolatile {
	private static volatile boolean stopRequested = false;

	public static void main(String[] args) throws InterruptedException {

		Thread bgThread = new Thread(new Runnable() {

			@Override
			public void run() {
				int i = 0;
				while (!stopRequested) {
					i++;
				}

				System.out.println("finished");

			}
		});

		bgThread.start();

		Thread.sleep(10);
		stopRequested = true;

	}
}
