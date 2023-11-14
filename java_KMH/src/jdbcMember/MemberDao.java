package jdbcMember;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	Connection getConnection() {
		Connection con = null;

		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String userId = "KMH_DBA";
		String userPw = "1111";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, userId, userPw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 예외");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 예외");
		}

		if (con != null) {
			System.out.println("DB 접속");
		} else {
			System.out.println("DB 접속 실패");
		}

		return con;
	}

	public int insertMem(Member mem) {
		Connection con = getConnection();

		if (con == null) {
			System.out.println("DB연결 실패");
			return 0;
		}

		String sql = "INSERT INTO MEMBERS(MID, MPW, MNAME, MPHONE, MBIRTH) VALUES(?, ?, ?, ?, TO_DATE(?,'YYYYMMDD'))";
		int result = 0;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem.getMid());
			pstmt.setString(2, mem.getMpw());
			pstmt.setString(3, mem.getMmane());
			pstmt.setString(4, mem.getMphone());
			pstmt.setString(5, mem.getMmbirth());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<Member> select(String inputId) {
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결 실패");
			return null;
		}
		String sql = "SELECT * FROM MEMBERS WHERE MID = ?";
		ArrayList<Member> mblist = new ArrayList<Member>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Member mb = new Member();
				mb.setMid(rs.getString(1));
				mb.setMpw(rs.getString(2));
				mb.setMmane(rs.getString(3));
				mb.setMphone(rs.getString(4));
				mb.setMmbirth(rs.getString(5));
				mblist.add(mb);
			}
		} catch (SQLException e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		}
		return mblist;
	}

	
	
	public Member select_login(String inputMid, String inputMpw) {
		// 1 DB 접속
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결 실패");
			return null;
		}

		String sql = "SELECT * FROM MEMBERS WHERE MID = ? AND MPW = ?";
		Member loginMember = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputMid);
			pstmt.setString(2, inputMpw);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				loginMember = new Member();
				loginMember.setMid(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginMember;
	}

}
