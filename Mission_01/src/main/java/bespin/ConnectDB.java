package bespin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
	// 싱글톤 패턴으로 사용 하기위 한 코드들
	private static ConnectDB instance = new ConnectDB();

	public static ConnectDB getInstance() {
		return instance;
	}
	public ConnectDB() {
	}

	private String jdbcUrl = "jdbc:mysql://192.168.121.8:3306/team2_proj?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
	private String dbId = "team2"; // MySQL 계정 "로컬일 경우 root"
	private String dbPw = "team2"; // 비밀번호 "mysql 설치 시 설정한 비밀번호"
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private PreparedStatement pstmt2 = null;
	private ResultSet rs = null;
	String sql = "";
	String sql2 = "";
	String returns = "";
	
	// 데이터베이스와 통신하기 위한 코드가 들어있는 메서드
	public String selectdb() {
		try {
			returns = "";
			sql = "select * from bespineer";
			pstmt = connect(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				returns += rs.getString(1) + "/";
				returns += rs.getString(2) + "/";
				returns += rs.getString(3) + "/";
				returns += rs.getString(4) + "/";
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { close(); }
		
		return returns;
	}
/*
	public String logindb(String id, String pwd) {
		try {
			sql = "select id,pwd from member where id=? and pwd=?";
			pstmt = connect(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("id").equals(id) && rs.getString("pwd").equals(pwd)) {
					returns = "true";// 로그인 가능
				} else {
					returns = "false"; // 로그인 실패
				}
			} else {
				returns = "noId"; // 아이디 또는 비밀번호 존재 X
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { close(); }
		
		return returns;
	}	
	*/
	public PreparedStatement connect(String sql) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
		pstmt = conn.prepareStatement(sql);

		return pstmt;
	}

	public void close() {
		if (rs != null) try {rs.close();} catch (SQLException ex) {}
		if (pstmt != null) try {pstmt.close();} catch (SQLException ex) {}
		if (conn != null) try {conn.close();} catch (SQLException ex) {}
	}
}
