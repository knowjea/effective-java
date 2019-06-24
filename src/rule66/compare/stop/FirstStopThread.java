package rule66.compare.stop;

/**
 * 한 스레드의 boolean 값이 true가 되면 후면 스레드는 중지되는 프로그램이다.
 * 하지만 최소 약 10밀리세컨드 이상을 sleep하면 후면 스레드는 해당 루프를 돌면서 boolean 값은 자신이 바꿀 수 없는 값이고 항상 동일하다고 생각하여
 * 해당 변수를 무시하도록 소스를 변경한다. 이런 최적화를 JVM(Hotspot JVM)최적화 기술인 끌어올리기(hoisting)라고 하는데
 * 그 덕에 후면 스레드는 절대 끝나지 않는 경우가 발생한다.
 *
 * @author gwon
 * @history
 *          2019. 6. 24. initial creation
 */
public class FirstStopThread {
	private static boolean stopRequested = false;

	public static void main(String[] args) throws InterruptedException {

		Thread bgThread = new Thread(new Runnable() {

			@Override
			public void run() {
				int i = 0;
				while (!stopRequested) {
//					System.out.println(i++); // 최적화가 발생하지 않는다. 해당 메서드는 Thread-safe하기 때문.
					i++;
				}

				/**
				 * hoisting할 경우 위 소스는 아래와 같이 변경된다.
				 * if (!stopRequested) {
				 * while (true) {
				 * i++;
				 * }
				 * }
				 *
				 *****************************/

				System.out.println("finished"); // 호출되지 않음

			}
		});

		bgThread.start();

//		Thread.sleep(1); // 아주 빠르게 true를 줄 경우, 최적화가 되기전에 true 되므로 후면 스레드는 종료된다.
		Thread.sleep(10);
		stopRequested = true;

	}
}
