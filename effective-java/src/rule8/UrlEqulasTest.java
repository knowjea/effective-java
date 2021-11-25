package rule8;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 *
 *
 * @author gwon
 * @history
 *          2018. 8. 26. initial creation
 */
public class UrlEqulasTest {
	public static void main(String[] args) throws MalformedURLException, UnknownHostException {
		URL firstUrl = new URL("https://www.google.co.kr/");
		URL secondUrl = new URL("https://142.250.199.67/"); // 구글의 접속 IP는 다양하므로 테스트때마다 다름

		InetAddress address = InetAddress.getByName(firstUrl.getHost());
		System.out.println(address.getHostAddress()); // 142.250.199.67

		InetAddress address2 = InetAddress.getByName(secondUrl.getHost());
		System.out.println(address2.getHostAddress()); // 142.250.199.67

		System.out.println(firstUrl.equals(secondUrl)); // true
	}
}
