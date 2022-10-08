package kr.co.applestar;

public class Solution {
	
	public int solution(double num, double maxNum) {
		int answer = 0 ;
		
		double d = num;
		while(d != 1) {
			//System.out.println("   d = " + d);
			if (d % 2 == 0) {
				d = d / 2;
			} else {
				d = (d * 3 ) + 1;
				if (maxNum < d) {
					maxNum = d;
				}
			} 
			answer++;
			//System.out.println("   answer : " + answer);
			
		}
		return answer;
	}
}
