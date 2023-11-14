package day13;

import java.util.Scanner;

//서비스 제공
public class MemberService {
	/* 기능 정의 클래스*/
	Scanner scan = new Scanner(System.in);
//	회원 목록
	Member[] memberList = new Member[5];
	int joinOrder = 0;
	
//	회원가입 기능 메소드
	public void memberJoin() {
		System.out.println("[회원가입]");
		int idx = -1;
		for(int i = 0; i < memberList.length; i++) {
			
			if (memberList[i] == null) {
				idx = i;
				break;
			}
		}
		if(idx == -1) {
			System.out.println("더 이상 회원가입 할 수 없습니다.");// 회원가입은 불가능한 상태
			return ;
		}
		
		//회원가입 처리
		//1. 가입정보 입력받고
		System.out.print("id : ");
		String id = scan.next();
		
			for(int i = 0; i < memberList.length; i++) {
				if(memberList[i] != null && memberList[i].getmId().equals(id)) {
				System.out.println("중복된 아이디 입니다.\n다시 기입해주세요");
				return;
				
			}
		}
		
		System.out.print("pw : ");
		String pw = scan.next();
		
		System.out.print("이름 : ");
		String name = scan.next();
			
		//2. 입력된 정보를 하나로 모으는
		Member memberinfo = new Member(id, pw, name);
		
		//3. 회원 목록에 저장
		memberList[idx] = memberinfo;
	}

//	아이디 중복확인
	
//	로그인 기능 메소드
	public void memberLogin() {
		System.out.println("[로그인]");
//		1. 로그인 할 아이디 비밀번호 입력;
		System.out.print("id : ");
		String id = scan.next();
		
		System.out.print("pw : ");
		String pw = scan.next();
		
//		2. 입력한 값과 일치하는 회원정보 검색.
//		3. 일치하는 회원이 있을 경우 "아이디, 비밀번호, 이름" 출력
//		   일치하지 회원이 없을 경우 "아이디/비밀번호가 일치하지 않습니다"/출력
		int idx = -1;
		for (int i = 0; i < memberList.length; i++) {
			if (memberList[i] != null && memberList[i].getmId().equals(id) && memberList[i].getmPw().equals(pw)) {
				idx = i;
				break;
			} 
		}
		
		if (idx > -1) {
			System.out.println("로그인 성공!");
			System.out.println("id : " + memberList[idx].getmId());
			System.out.println("pw : " + memberList[idx].getmPw());
			System.out.println("이름 : " + memberList[idx].getmName());
			
		}else {
			System.out.println("아이디 비밀번호가 일치하지 않습니다");
		}
			
	}

	

	
//	메뉴출력  기능
	
	public void showMenu(){
		
		System.out.println("*****************************");
		System.out.println("[1] 회원가입 [2] 로그인 [3]종료");
		System.out.println("*****************************");
		System.out.print("메뉴 선택 : ");
		
	}
}
