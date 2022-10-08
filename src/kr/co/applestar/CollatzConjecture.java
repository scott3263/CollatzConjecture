package kr.co.applestar;

import java.util.logging.Logger;

import kr.co.applestar.dbconnection.DBConnection;

public class CollatzConjecture {

	private static Logger logger =Logger.getLogger(CollatzConjecture.class.getName());
	private static DBConnection conn = new DBConnection();
	
	public static void main(String[] args) {
		logger.info("Collatz Conjecture Start!");
		
		// 현재 DB의 max값을 가져온다
		double startVal;
		startVal =  conn.getCurrentMaxNumber();
		logger.info("현재 DB의 최대값 startVal : " + startVal);
		
		CollatzNumber cn = new CollatzNumber();
		
		//logger.info("���۹�ȣ : " + curNum);
		while (startVal < 500) {
			logger.info("startVal : "  + startVal);
			try {
				if (cn.calc(startVal)) {
					logger.info("startVal:" + startVal + ", bounce : " + cn.getBounce() + "  count:" + cn.getCalcCnt() + " Times,  MaxNum:" + cn.getMaxNumber());
					startVal++;	
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


