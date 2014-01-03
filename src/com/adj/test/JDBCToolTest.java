package com.adj.test;

import java.sql.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import java.sql.DriverManager;

public class JDBCToolTest {

	Connection conn = null;

	PreparedStatement pstmt = null;

	@Before
	public void initialize() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// new com.mysql.jdbc.Driver();
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.2.50:3306/itvtest", "root", "root");
			// 连接数据库adj，账号root，密码root
			// fk4asddsadasdjkjkmmcasnnnasdasdasdkasd
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接错误");
		}
	}

	@Test
	public void execute() throws Exception {

		// values (9999,'<?xmlent></log>',1,'1318925923359','2011-10-18
		// 16:19:15','2011-10-18 16:18:43','')

		pstmt = conn
				.prepareStatement("insert into datapool2 values (?, ?, ?, ?, ?, ?, ?)");
		pstmt.setString(1, "9999");
		pstmt.setString(2, "<?xmlent></log>");
		pstmt.setString(3, "1");
		pstmt.setString(4, "1318925923359");
		pstmt.setString(5, "2011-10-18 16:18:43");
		pstmt.setString(6, "2011-10-18 16:18:43");
		pstmt.setString(7, null);
		pstmt.executeUpdate();
	}

	// fffffffffffffffffffffffk
	@After
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