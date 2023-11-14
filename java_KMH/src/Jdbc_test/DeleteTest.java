package Jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {
	
	public static void main(String[] args) {
		
		//1. DB접속
		
		Connection con = null;
		String uId ="KMH_DBA"; // 아이디
		String uPw = "1111"; // 비밀번호
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 드라이버 선언
			con = DriverManager.getConnection(url, uId, uPw); // 접속 연결
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 오류 ");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 오류");
			e.printStackTrace();
		}
		
		if (con == null) { //con 값으로 연결 확인 가능
			System.out.println("접속 실패");
		}else {
			System.out.println("접속 성공");
		}
	
		//2. 접속된 DB 쿼리문 전송 결과값을 반환
		String sql = "DELETE FROM CURDTEST"; // 쿼리문 작성
		int deleteresult = 0; //실행 결과값 진행
		
		try {
			PreparedStatement pstmt= con.prepareStatement(sql); // 전송 준비
			deleteresult = pstmt.executeUpdate(); //쿼리문 실행
			
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		
		if(deleteresult > 0 ) {
			System.out.println(deleteresult + "행 Delete 성공");
		}else {
			System.out.println("DELETE 실패");
		}
		
	}
}
