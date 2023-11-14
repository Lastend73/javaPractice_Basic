package Jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updateTest {

	public static void main(String[] args) {
		// CRUDTEST 테이블이 새로운 데이터 입력

		Scanner scan = new Scanner(System.in);
		System.out.print("HERE NUMTSET 값>> ");
		int inputNum = scan.nextInt();
		System.out.println("CHARTEST 컬럼 수정");
		String intputStr = scan.next();
		
		// 1. DB접속
		Connection con = null;

		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String uPw = "1111";
		String uId = "KMH_DBA";

		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 드라이버 선언
			con = DriverManager.getConnection(url, uId, uPw);
		} catch (SQLException e) {
			System.out.println("드라이버 오류");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("db오류");
			e.printStackTrace();
		}

		if (con == null) {
			System.out.println("DB 접속 실패");
			return;
		} else {
			System.out.println("DB 접속 성공");
		}
		
		String sql = "UPDATE CRUDTEST SET CHARTEST = ? WHERE NUMTEST =?" ;
		int updateReselt = 0;
		
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setString(1, intputStr);
			pstmt.setInt(2, inputNum);
			updateReselt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(updateReselt > 0) {
			System.out.println("UPDATE 상공");
		}else {
			System.out.println("UPDATE 실패");
		}

		
	}
}
