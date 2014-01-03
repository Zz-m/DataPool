package com.adj.dataInsert;

import java.sql.*;

import org.junit.Test;

//import java.sql.DriverManager;

public class JDBCTool {

	Connection conn = null;

	PreparedStatement pstmt = null;
@Test
	public void initialize() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// new com.mysql.jdbc.Driver();
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.2.50:3306/itvtest", "root", "root");
			// 连接数据库adj，账号root，密码root

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接错误");
		} 
	}

	public void execute(String[] data) throws Exception {
		

			pstmt = conn
					.prepareStatement("insert into datapool2 values (?, ?, ?, ?, ?,? ,?)");
			pstmt.setInt(1, Integer.parseInt(data[0]));
			pstmt.setString(2, data[1]);
			pstmt.setInt(3, Integer.parseInt(data[2]));
			pstmt.setString(4, data[3]);
			pstmt.setString(5, data[4]);
			pstmt.setString(6, data[5]);
			pstmt.setString(7, data[6]);
			pstmt.executeUpdate();
		
	}
@Test
	public void destroy() {
		try {

			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}