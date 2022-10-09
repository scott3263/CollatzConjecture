package kr.co.applestar.collatzconjecture;

public class CollatzNumber {
	private double myNumber;
	private double maxNumber;
	private long bounce;
	//private int calcCnt;
	
	public long getBounce() {
		return bounce;
	}
	public void setBounce(long bounce) {
		this.bounce = bounce;
	}
	
	/*
	public int getCalcCnt() {
		return calcCnt;
	}
	public void setCalcCnt(int calcCnt) {
		this.calcCnt = calcCnt;
	}
	*/
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
		
		myNumber = myNum;
		bounce = 0 ;
		maxNumber = 0 ;
		//calcCnt = 0;
		//System.out.println("calc myNumber : " + myNumber);
		
		try {
			while(myNumber != 1) {
				//System.out.println("   myNumber = " + myNumber);
				
				if (myNumber % 2 == 0) {
					myNumber = myNumber / 2;
				} else {
					myNumber = (myNumber * 3 ) + 1;
				}
				
				if (maxNumber < myNumber) {
					maxNumber = myNumber;
				}
				//calcCnt++;
				bounce++;				
				//break;
			}	
		} catch (Exception e) {
			System.out.println("e.getMessage() : " + e.getMessage());
			return false;
		}
		
		
		return true;
	}
}
