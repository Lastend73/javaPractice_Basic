package Jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class selectTest {

	public static void main(String[] args) {
		// CRUDTEST 테이블이 새로운 데이터 입력

		Scanner scan = new Scanner(System.in);
		System.out.print("NUMTEST 입력>> ");
		int inputNum = scan.nextInt();

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

		// 2. 쿼리문 실행 및 결과값 반환
		String sql = "SELECT NUMTEST, CHARTEST, TO_CHAR(DATETEST,'YYYY-MM-DD') FROM CRUDTEST" // 실행할 쿼리문 작성
				+ " WHERE NUMTEST = ?";
		// 결과값을 저장할 변수
		ArrayList<CrudDto> crudList = new ArrayList<CrudDto>();
		// where절
		CrudDto cruddto = null;
		try {
			// 접속된 DB쿼리문 전송 준비
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, inputNum);

			// 쿼리문 실행 및 결과 값 변환
			ResultSet rs = pstmt.executeQuery(); // table 을 가져오기 위한 ResultSet 타입이 필요함
			while (rs.next()) {
				CrudDto crud = new CrudDto();
				crud.setNumtest(rs.getInt(1)); // 첫번째 열의 값을 가져오기 int값이라 int로 설정| 숫자로 설정해도 되고 컬럼 명을 적어도 됨
				crud.setChartest(rs.getString("CHARTEST")); // 두번째 열의 값을 가져오기 String값이라 String로 설정
				crud.setDatetest(rs.getString(3));
				crudList.add(crud);

				cruddto = new CrudDto();
				cruddto.setNumtest(rs.getInt(1)); // 첫번째 열의 값을 가져오기 int값이라 int로 설정| 숫자로 설정해도 되고 컬럼 명을 적어도 됨
				cruddto.setChartest(rs.getString("CHARTEST")); // 두번째 열의 값을 가져오기 String값이라 String로 설정
				cruddto.setDatetest(rs.getString(3));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3. 출력
		for (int i = 0; i < crudList.size(); i++) {
			System.out.print(crudList.get(i).getNumtest());
			System.out.print(" " + crudList.get(i).getChartest());
			System.out.println(" " + crudList.get(i).getDatetest());
		}
		if(cruddto == null) {
			System.out.println("조회된 정보는 없습니다.");
		}else {
			System.out.print(cruddto.getNumtest());
			System.out.print(" " + cruddto.getChartest());
			System.out.println(" " + cruddto.getDatetest());
			
		}

	}
}
