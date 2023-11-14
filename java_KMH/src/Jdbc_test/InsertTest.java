package Jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

	public static void main(String[] args) {
		System.out.println("Insert 테스트");
		
		Connection con = null; //import java.sql.Connection <-접속정보 담아주는 곳;
		// 1.DB 접속(DB 접속상태 확인)
		// 주소, 아이디, 비밀번호
		String url = "jdbc:oracle:thin:@//localhost:1521/xe"; // 접속할 DB 주소(아이피)
		String userId = "KMH_DBA"; // 접속할 DB 아이디
		String userPw = "1111"; // 접속할 DB 비밀번호
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //드라이버 선언 
			con = DriverManager.getConnection(url, userId, userPw);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 예외");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 예외");
		}
		
		if(con != null) {
			System.out.println("DB 접속");
		} else {
			System.out.println("DB 접속 실패");
		}
		
		//2. 실행할 쿼리문 전송 및 결과값 반환
		String sql = "INSERT INTO CRUDTEST(NUMTEST, CHARTEST, DATETEST)"
					+ " VALUES(1, '테스트1', SYSDATE)";
		int insertResult = 0; // insert 실행 결과값 저장
		try {
			con.setAutoCommit(false); // auto 커밋을 꺼주는 명령어
			// 접속된 DB에 쿼리문 전송 준비
			PreparedStatement pstmt = con.prepareStatement(sql);
			// DB에서 쿼리문 실행
			insertResult = pstmt.executeUpdate(); //executeUpdate() << 실행요청
			
			con.commit(); // 커밋 명령어
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		 System.out.println("insertResult :" + insertResult);
		 
		if(insertResult > 0) { //실행 결과확인
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
		
	}

}
