package com.adj.test;

import java.sql.*;

//import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// new com.mysql.jdbc.Driver();
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.2.50:3306/itvtest", "root", "root");
			// 连接数据库adj，账号root，密码root
			 stmt = conn
					.createStatement();
			
			rs = stmt.executeQuery("select * from datapool limit 999,6;");
			while (rs.next()) {
				System.out.println(rs.getString("datainfo"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}