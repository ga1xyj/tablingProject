package dev.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	//설정
	/*
	private String jdbcDriver="oracle.jdbc.driver.OracleDriver";
	private String oracleUrl="jdbc:oracle:thin:@localhost:1521:xe";
	private String connectedId="tabling";
	private String connectedPwd="tabling";
	*/
	/*
	 * Field
	 */
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	Statement st;

	/*
	 * Method
	 */
	
	
	// dao의 메서드를 실행할때마다 커넥션을 하지 않고 커넥션 풀 사용
	public void connect() {
		try {
			// server.xml 에 등록해놓은 orcleDriver 정보 불러오기
			InitialContext ic = new InitialContext();
			// 톰캣 가상 환경에 저장되어 있음
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	public void connect() {
		try {
			Class.forName(jdbcDriver);
			//jdbcDriver 로딩
			conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
		}catch(ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		}catch(SQLException e) {
			System.out.println("DB 연결 실패");
		}
		
	}
	*/

	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
