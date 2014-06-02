package db.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BatchSQL {

	public static void runSQL(List<String> list) {
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/";
		String driver = "com.mysql.jdbc.Driver";
		
		String dbName = "batch_test";
		
		Connection connection = null;
		Statement stmt = null;
		
		Long start = System.currentTimeMillis();
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url+dbName, user, password);
			connection.setAutoCommit(false);
			stmt = connection.createStatement();
			for (String sql : list) {
				stmt.executeUpdate(sql);
			}
			connection.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		Long end = System.currentTimeMillis();
		System.out.println("Last ---> " + (end - start));
		
	}
	
	public static void runSQL(String sql) {
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/";
		String driver = "com.mysql.jdbc.Driver";
		
		String dbName = "batch_test";
		
		Connection connection = null;
		Statement stmt = null;
		
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url+dbName, user, password);
			connection.setAutoCommit(false);
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			connection.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		
//		for(int i = 0; i < 10; i++) {
//			System.out.println("===============" + i + "==========================");
//			number(100);
//			number(1000);
//			number(10000);
//			System.out.println("==========================================");
//		}
		
		Long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			runSQL("insert into batch (name, uuid) values ('test" + i + "', " + i + ");");
		}
		Long end = System.currentTimeMillis();
		System.out.println("Last ---> " + (end - start));
	}
	
	public static void number(int num) {
		List<String> sqlList = new ArrayList<String>();
		for (int i = 0; i < num; i++) {
			sqlList.add("insert into batch (name, uuid) values ('test" + i + "', " + i + ");");
			//System.out.println("insert into batch (name, uuid) values 'test" + i + "', " + i + ");");
		}
		System.out.print("number is " + num + " ");
		BatchSQL.runSQL(sqlList);
	}
}
