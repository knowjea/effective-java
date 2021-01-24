package code.review;

// NetLengthFieldConfig
// ChannelUtil
// DeployEncoderCodec
// MonitoringProcessor
public class StringFormatTest {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		for (long i = 0; i < 10000000; i++) {
			String.format("%d", 1); // 5.653
//			String.valueOf(1); // 0.011
		}

		long end = System.currentTimeMillis();
		System.out.println("Time : " + (end - start) / 1000.0);

	}

}
