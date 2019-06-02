package code.review;

public class CloneSub implements Cloneable {
	private int subNum = 1;

	public int getSubNum() {
		return subNum;
	}

	public void setSubNum(int subNum) {
		this.subNum = subNum;
	}

	@Override
	protected CloneSub clone() throws CloneNotSupportedException {
		return (CloneSub) super.clone();
	}

}
