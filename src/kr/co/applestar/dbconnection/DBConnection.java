package kr.co.applestar.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class DBConnection {
	
	private static Logger logger = Logger.getLogger(DBConnection.class.getName());
	private Connection conn;
	
	private static final String USERNAME = "applestar";
	private static final String PASSWORD = "1235!@#%";
	private static final String URL = "jdbc:mysql://192.168.0.21:3306/applestar";
	
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pstmt = null;
	
	public DBConnection() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			st = conn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Database Connection fail! : " + e.getMessage());
						
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO: handle exception
			}
		}
	}
	
	public boolean insertNumber(double d, long bounce, double m, String hashVal) {
		
		try {
			String sql = "insert into applestar.Collatz_Conjecture(seq, bounce, max_num, hash_value) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDouble(1, d);
			pstmt.setLong(2, bounce);
			pstmt.setDouble(3, m);
			pstmt.setString(4, hashVal);
			
			int cnt = pstmt.executeUpdate();
			
			//System.out.println("   cnt : " + cnt);
			
			if (cnt == 0) {
				//System.out.println("Insert Fail");
				return false;
			} else {
				return true ;
			}
			
		} catch (Exception e) {
			logger.info("Database Insertn fail! : " + d + " "  + e.getMessage());
		}
		return false;
	}
	
	public double getCurrentMaxNumber() {
		
		try {
			String sql = "SELECT max(seq) FROM applestar.Collatz_Conjecture";
			rs = st.executeQuery(sql);
			
			if (rs.next()) {
				logger.info("getCurrentMaxPrimeNumber() : " + rs.getDouble(1));
				
				if (rs.getDouble(1) < 1) {
					return 0;
				} else {
					return rs.getDouble(1);	
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("getCurrentMaxNumber() : " + e.getMessage());
			
		}
		return 0;
	}
	
}
