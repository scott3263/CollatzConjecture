package kr.co.applestar;

public class CollatzNumber {
	private double myNumber;
	private double maxNumber;
	private long bounce;
	private int calcCnt;
	
	public long getBounce() {
		return bounce;
	}
	public void setBounce(long bounce) {
		this.bounce = bounce;
	}
	public int getCalcCnt() {
		return calcCnt;
	}
	public void setCalcCnt(int calcCnt) {
		this.calcCnt = calcCnt;
	}
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
	
	public boolean calc(double myNum) {
		System.out.println("calc myNum : " + myNum);
		this.myNumber = myNum;
		
		try {
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
				this.calcCnt++;
			}	
		} catch (Exception e) {
			System.out.println("e.getMessage() : " + e.getMessage());
		}
		
		
		return true;
	}
}
