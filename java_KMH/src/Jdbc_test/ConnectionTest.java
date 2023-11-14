package Jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		System.out.println("접속 테스트");
		// localhost >> 192.168.0.???
		String url = "jdbc:oracle:thin:@//localhost:1521/xe"; // db위치 (ip 주소, 포트번호)
		String userID = "KMH_DBA"; // 사용자 이름id
		String userpw = "1111"; // 사용자 비밀번호

		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 오타 발생시 또는 ojdbc가 없으면 드라이버 exception 뜸
			Connection con = DriverManager.getConnection(url, userID, userpw); // 접속상태 저장 [주소 잘못 입력시 db exception 발생]
			System.out.println("DB 접속 성공");

			// 쿼리문 작성
			String sql = "SELECT * FROM EMP";
			String sql2 = "INSERT, UPDATE, DELETE";

			PreparedStatement pstmt = con.prepareStatement(sql); // 준비 단계
			ResultSet rs = pstmt.executeQuery();// select 문만 쓸때 사용 ResultSet으로 받고 executeQuery() 사용
			// int result = pstmt.executeUpdate();//int 로 받고 insert,update,delete는
			// executeUpdate()로 사용
			// rs.next() >> 레코드의 위치로를 다음으로 이동
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
			rs.close(); // 종료하기
			pstmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 Exception");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB Exception");
			e.printStackTrace();
		}

	}

}
