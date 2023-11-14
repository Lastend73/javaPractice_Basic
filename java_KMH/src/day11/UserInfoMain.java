package day11;

import java.util.Scanner;

public class UserInfoMain {

	public static void main(String[] args) {

		UserInfo myInfo = new UserInfo("KMH", "1234", "황규민", "01099472958");

		/*
		 * 로그인 기능 : 1.아이디,비밀번호 입력 
		 *            2.입력된 아이디, 비밀번호 회원정보와 일치하는지 확인 
		 *            3. 일치하면 "로그인성공", 일치하지 않으면 "아이디/비밀번호가 일치하지 않습니다."
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("아이디 입력 : ");
		String loginId = scan.next();
		System.out.print("비밀번호 입력 : ");
		String loginPw = scan.next();
		
		boolean Check = myInfo.loginCheck(loginId,loginPw); //check : 일치하면 true 일치하지않으면 false
		
		if(Check) {
//			 로그인 성공
//			회원정보 출력 >> myInfo객체의 모든 필드값을 출력
//			myInfo의 showinfo 메소드 출력;
			myInfo.showInfo();
			System.out.println(myInfo);
			
		}else {
			System.out.println("아이디/비밀번호가 일치하지 않습니다");
		}
			
		

	}
}
