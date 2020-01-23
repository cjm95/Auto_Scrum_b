package bespin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
	// �̱��� �������� ��� �ϱ��� �� �ڵ��
	private static ConnectDB instance = new ConnectDB();

	public static ConnectDB getInstance() {
		return instance;
	}
	public ConnectDB() {
	}

	private String jdbcUrl = "jdbc:mysql://192.168.121.8:3306/team2_proj?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
	private String dbId = "team2"; // MySQL ���� "������ ��� root"
	private String dbPw = "team2"; // ��й�ȣ "mysql ��ġ �� ������ ��й�ȣ"
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private PreparedStatement pstmt2 = null;
	private ResultSet rs = null;
	String sql = "";
	String sql2 = "";
	String returns = "";
	
	// �����ͺ��̽��� ����ϱ� ���� �ڵ尡 ����ִ� �޼���
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
					returns = "true";// �α��� ����
				} else {
					returns = "false"; // �α��� ����
				}
			} else {
				returns = "noId"; // ���̵� �Ǵ� ��й�ȣ ���� X
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
