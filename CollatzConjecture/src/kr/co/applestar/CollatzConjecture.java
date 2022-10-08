package kr.co.applestar;

import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;



public class CollatzConjecture {

	private static Logger logger =Logger.getLogger(CollatzConjecture.class.getName());
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		logger.setUseParentHandlers(false);
		
		Handler handler = new ConsoleHandler();
		handler.setFormatter(new MyLogFormatter());
		logger.addHandler(handler);
		
		logger.info("Collatz Conjecture Start!");
		
		double curNum = 1;
		
		CollatzNumber cn = new CollatzNumber();
		
		logger.info("시작번호 : " + curNum);
		while (curNum < 50000) {
			cn.setMyNumber(curNum);
			cn.setMaxNumber(0);
			cn.setCnt(0);
			cn.calc();
			logger.info("currNum:" + curNum + ",  count:" + cn.getCnt() + " Times,  MaxNum:" + cn.getMaxNumber());
			curNum++;

		} 
	
	}
	
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
}


