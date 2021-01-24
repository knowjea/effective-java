package code.review;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// SeedCipher
// Iso8583Bitmap
public class PublicStaticFinalTest {
	public static final int VERSION = 1;

	public static final String[] NUM_LIST = { "1", "2", "3", "4" };

	private static final String[] UNMODIFY_NUM_LIST = { "1", "2", "3", "4" };
	public static final List<String> NUM_LIST_2 = Collections.unmodifiableList(Arrays.asList(UNMODIFY_NUM_LIST));

	private static final String[] CLONE_NUM_LISE = { "1", "2", "3", "4" };

	public static final String[] NUM_LIST_3() {
		return CLONE_NUM_LISE.clone();
	}

	public static void main(String[] args) {
//		PublicStaticFinalTest.VERSION = 2; // final이므로 한 번 값을 주었으면 변경 불가능
//		PublicStaticFinalTest.NUM_LIST={"2"}; // final이므로 한 번 값을 주었으면 변경 불가능

//		PublicStaticFinalTest.NUM_LIST[0] = "5"; // 실행됨. 하지만 원하지 않는 결과일 것임

//		PublicStaticFinalTest.NUM_LIST_2.get(0) = new String("5"); // 방어함 unmodifiableList 사용.
	}
}
