package rule76.compare2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 특정 객체를 직렬화 하여 생긴 바이트스트림에 해당 객체 내부의 필드의 대한 참조 값을 추가로 붙여 쓸 수 있다.
 * 악의적인 사용자는 해당 참조값을 자신이 컨트롤할 수 있는 변수에 할당 한 후, 해당 객체에서 접근 불가능하도록 한(private) 필드 등을 조작할 수 있다.
 *
 * 이를 방어하기 위해, 해당 객체는 역직렬화할 때 클라이언트가 가질 수 없어야 하는 객체 참조를 담은 모든 필드를 방어적으로 복사애햐한다.
 * 즉, readObject 메서드 안에서 private로 선언된 필드들을 복사해서 참조를 해도 변경할 수 없도록 해야 한다.
 *
 * @author gwon
 * @history
 *          2019. 6. 4. initial creation
 */
public class MutableClass {
	// 접근 불가능한(private) 필드를 훔칠 클래스 (훔쳐짐)
	public final PeriodNotGood periodNotGood;
	public final Date startNotGood;
	public final Date endNotGood;

	// 접근 불가능한(private) 필드를 훔칠 클래스 (훔칠 수 없음)
	public final PeriodGood periodGood;
	public final Date startGood;
	public final Date endGood;

	public MutableClass() {
		try {
			/**
			 * 훔칠 수 있는 periodNotGood
			 */
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bos);

			out.writeObject(new PeriodNotGood(new Date(), new Date()));

			// Period.start 필드의 참조를 뒤에 추가로 붙여 씀
			byte[] ref = { 0x71, 0, 0x7e, 0, 5 };
			bos.write(ref);

			// Period.end 필드의 참조를 뒤에 추가로 붙여 씀
			ref[4] = 4;
			bos.write(ref);

			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
			periodNotGood = (PeriodNotGood) in.readObject();
			startNotGood = (Date) in.readObject(); // start의 참조를 훔침
			endNotGood = (Date) in.readObject(); // end의 참조를 훔침

			/**
			 * 훔칠 수 없는 periodGood
			 */
			ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
			ObjectOutputStream out2 = new ObjectOutputStream(bos2);

			out2.writeObject(new PeriodGood(new Date(), new Date()));

			// Period.start 필드의 참조를 뒤에 추가로 붙여 씀
			byte[] ref2 = { 0x71, 0, 0x7e, 0, 5 };
			bos2.write(ref2);

			// Period.end 필드의 참조를 뒤에 추가로 붙여 씀
			ref2[4] = 4;
			bos2.write(ref2);

			ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bos2.toByteArray()));
			periodGood = (PeriodGood) in2.readObject();
			startGood = (Date) in2.readObject(); // start의 참조를 훔침
			endGood = (Date) in2.readObject(); // end의 참조를 훔침

		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

	public static void main(String[] args) {
		MutableClass.periodNotGoodTest();
		MutableClass.periodGoodTest();

	}

	/**
	 * 훔칠 수 있는 PeriodNotGood 테스트
	 *
	 * 값이 조작됨
	 */
	public static void periodNotGoodTest() {
		System.out.println("########### PeriodNotGood Test ###########");
		MutableClass mutableClass = new MutableClass();

		Date endOfBrokenClass = mutableClass.endNotGood; // 참조를 훔친 변수

		PeriodNotGood brokenClass = mutableClass.periodNotGood;
		System.out.println(brokenClass); // Period [start=Wed Jun 05 00:32:51 KST 2019, end=Wed Jun
		                                 // 05 00:32:51 KST 2019]
		endOfBrokenClass.setYear(55); // 값 조작

		System.out.println(brokenClass); // Period [start=Wed Jun 05 00:32:51 KST 2019, end=Sun Jun
		                                 // 05 00:32:51 KDT 1955]
	}

	/**
	 * 훔칠 수 없는 PeriodGood 테스트
	 *
	 * 방어적으로 복사하여 값이 조작되지 않음
	 */
	public static void periodGoodTest() {
		System.out.println("########### PeriodGood Test ###########");
		MutableClass mutableClass = new MutableClass();

		Date endOfBrokenClass = mutableClass.endGood; // 참조를 훔친 변수

		PeriodGood brokenClass = mutableClass.periodGood;
		System.out.println(brokenClass); // Period [start=Wed Jun 05 00:32:51 KST 2019, end=Wed Jun
		                                 // 05 00:32:51 KST 2019]
		endOfBrokenClass.setYear(55); // 값 조작

		System.out.println(brokenClass); // Period [start=Wed Jun 05 00:32:51 KST 2019, end=Wed Jun
		                                 // 05 00:32:51 KST 2019]

	}

}
