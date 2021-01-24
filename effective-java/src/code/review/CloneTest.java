package code.review;

// NetConnectionInfo
// ExchangeMessage 정상케이스
public class CloneTest implements Cloneable {
	private String str = "abc";
	private int num = 1;
	private CloneSub sub = new CloneSub();

	public CloneSub getSub() {
		return sub;
	}

	public void setSub(CloneSub sub) {
		this.sub = sub;
	}

	@Override
	public String toString() {
		return super.toString() + " - str : " + str + ", num : " + num + ", subNum : " + sub.getSubNum();
	}

	@Override
	protected CloneTest clone() throws CloneNotSupportedException {
//		CloneTest res = (CloneTest) super.clone();
//		res.sub = sub.clone();
//		return res;

		return (CloneTest) super.clone();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		CloneTest original = new CloneTest();
		CloneTest copy = original.clone();

		original.getSub().setSubNum(2);

		System.out.println(original.toString());
		System.out.println(copy.toString());

		System.out.println(original.getSub());
		System.out.println(copy.getSub());
	}

}
