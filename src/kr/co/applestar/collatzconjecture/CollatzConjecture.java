package kr.co.applestar.collatzconjecture;

import java.util.logging.Logger;

import kr.co.applestar.dbconnection.DBConnection;
import kr.co.applestar.hash.sha256;

public class CollatzConjecture {

	private static Logger logger =Logger.getLogger(CollatzConjecture.class.getName());
	private static DBConnection conn = new DBConnection();
	
	public static void main(String[] args) {
		logger.info("Collatz Conjecture Start!");
		
		// 현재 DB의 max값을 가져온다
		double startVal;
		CollatzNumber cn = new CollatzNumber();
		
		startVal =  conn.getCurrentMaxNumber() + 1;
		logger.info("현재 DB의 최대값 startVal : " + startVal);
		
		//logger.info("���۹�ȣ : " + curNum);
		while (true) {
			//logger.info("startVal : "  + startVal);
			try {
				if (cn.calc(startVal)) {
					//logger.info("startVal :" + startVal + ", bounce : " + cn.getBounce() + " Times,  MaxNum :" + cn.getMaxNumber());
					
					//hash값 얻기
					String encryptSHA = sha256.SHA256(Double.toString(startVal));
					
					// DB insert
					if (conn.insertNumber(startVal, cn.getBounce(), cn.getMaxNumber(), encryptSHA)) {
						//logger.info("Insert Success");
					}else {
						logger.info("Insert Fail");
					}
					
				} else {
					logger.info("cn.calc returns fail!");
				}	
			} catch (Exception e) {
				logger.info("e.Message : " + e.getMessage());
			}
			startVal++;
		} 
	
	}
	
	/*
	public static class MyLogFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(record.getMillis());

            StringBuffer sb = new StringBuffer(1000);
            sb.append(dateFormat.format(date));
            sb.append(" [");
            sb.append(record.getLevel());
            sb.append("] ");
            sb.append(record.getMessage());
            sb.append("\n");
            return sb.toString();
        }
    }
    */
}


