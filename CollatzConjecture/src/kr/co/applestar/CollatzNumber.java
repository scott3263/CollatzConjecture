package kr.co.applestar;

public class CollatzNumber {
	private double myNumber;
	private double maxNumber;
	private int cnt;
	
	public double getMyNumber() {
		return myNumber;
	}
	public void setMyNumber(double myNumber) {
		this.myNumber = myNumber;
	}
	public double getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(double maxNumber) {
		this.maxNumber = maxNumber;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public void calc() {
		while(this.myNumber != 1) {
			//System.out.println("   d = " + d);
			if (this.myNumber % 2 == 0) {
				this.myNumber = this.myNumber / 2;
			} else {
				this.myNumber = (this.myNumber * 3 ) + 1;
			}
			
			if (this.maxNumber < this.myNumber) {
				this.maxNumber = this.myNumber;
			}
			this.cnt++;
		}
	}
}
