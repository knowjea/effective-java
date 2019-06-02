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
		URL secondUrl = new URL("https://www.google.co.kr/webhp?hl=ko&sa=X&ved=0ahUKEwiRiKyjtIrdAhUCUt4KHSe7C88QPAgD");

		System.out.println(firstUrl.getRef());
		InetAddress address = InetAddress.getByName(firstUrl.getHost());
		System.out.println(address.getHostAddress());

		InetAddress address2 = InetAddress.getByName(secondUrl.getHost());
		System.out.println(address2.getHostAddress());
		System.out.println(firstUrl.getFile());
		System.out.println(secondUrl.getFile());
		System.out.println(firstUrl.equals(secondUrl));
	}
}
