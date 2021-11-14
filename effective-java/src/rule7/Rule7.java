package rule7;

import javax.swing.JFrame;

/**
 * avoid finalizers
 * (종료자 사용을 피하라)
 *
 * @author gwon
 * @history
 *          2018. 7. 22. initial creation
 */
public class Rule7 {

	public static void main(String[] args) throws Throwable {
		System.runFinalizersOnExit(true);
		Runtime.runFinalizersOnExit(true);
		new JFrame();
	}

}
