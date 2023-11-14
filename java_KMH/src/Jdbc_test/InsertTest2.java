package Jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest2 {
	
	public static void main(String[] args) {
		//CRUDTEST 테이블이 새로운 데이터 입력 
		//1. 사용자로 부터 데이터 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자입력 >> ");
		int inputNum = scan.nextInt();
		System.out.print("문자입력 >> ");
		String inputStr = scan.next();
		System.out.print("날짜입력(yyyymmdd) >>");
		String inputDate = scan.next();
		
		// 받은데이터를 CRUDTEST 테이블에 입력하는 처리
		//2. DB접속
		Connection con = null;
		
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String uPw = "1111";
		String uId = "KMH_DBA";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //드라이버 선언
			con = DriverManager.getConnection(url,uId,uPw);
		} catch (SQLException e) {
			System.out.println("드라이버 오류");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("db오류");
			e.printStackTrace();
		}
		
		if( con == null) {
			System.out.println("DB 접속 실패");
			return;
		}else {
			System.out.println("DB 접속 성공");
		}

		// 3. 쿼리문 실행 및 결과값 반환 (inputNum, inputStr, inputDate
		
		String sql = "INSERT INTO CRUDTEST(NUMTEST, CHARTEST, DATETEST)"
				+" VALUES(? , ? , ?)"; // 실행할 쿼리문 작성
		int insertResult = 0; // insert 처리 결과값 저장
		
		try {
			//접속된 DB쿼리문 전송 준비
			PreparedStatement pstmt = con.prepareStatement(sql);
			//? 자리에 값 입력
			pstmt.setInt(1, inputNum); // pstmt.setInt(물음표 번째 숫자, 들어갈 정보); 
			pstmt.setString(2, inputStr); // 2번쨰 물음표
			pstmt.setString(3, inputDate); // 3번째 물음표
			
			// 쿼리문 실행 및 결과 값 변환
			insertResult = pstmt.executeUpdate(); // 실행;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("insertResult = " + insertResult);
		
		if(insertResult >0) {
			System.out.println("입력성공");
		} else {
			System.out.println("입력실패");
		}
		
		
	}
}
