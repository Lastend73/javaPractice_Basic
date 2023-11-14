package jdbcshopservice;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberService {

	Scanner scan = new Scanner(System.in);
	MemberDao mdao = new MemberDao();
	
	
	public void memberjoin() { // 회원가입 기능
		System.out.println("[회원가입]");
		System.out.print("아이디를 입력해주세요 : ");
		//1. 가입할 회원정보 입력
		String inputId = scan.next();
			// 아이디 중복 체크 (SELECT)
			ArrayList<Member> idcheck = mdao.select(inputId);
			if(idcheck.size() > 0) {
				System.out.println("중복된 아이디 확인");
				return;
			}
		System.out.print("비밃번호를 입력해주세요 : ");
		String inputPd = scan.next();
		
		System.out.print("성함를 입력해주세요 : ");
		String inputName = scan.next();
		
		System.out.print("휴대폰번호를 입력해주세요 : ");
		String inputNum = scan.next();
		
		System.out.print("생일를 입력해주세요(YYYYMMDD) : ");
		String inputBirth = scan.next();
		
		Member mem = new Member();
		mem.setMid(inputId);
		mem.setMmane(inputName);
		mem.setMpw(inputPd);
		mem.setMmbirth(inputBirth);
		mem.setMphone(inputNum);
		//2. 회원정보를 Members 테이블에 INSERT
		int insertMem = mdao.insertMem(mem);
		//3. IMSERT(회원가입) 결과 출력
		if( insertMem > 0) {
			System.out.println("회원가입이 완료되었습니다");
		}else {
			System.out.println("회원가입에 문제가 발생하였습니다.");
		}
	}

private String loginId =null;
	
	public String getLoginId(){
		return loginId;
	}
	
	public void memberLogin() { //로그인 기능 메소드
		System.out.println("[로그인]");
		//1. 로그인할 아이디, 비밀번호 입력
		System.out.print("로그인 아이디 : ");
		String inputMid = scan.next();
		System.out.print("로그인 비밀번호 : ");
		String inputMpw = scan.next();
		//2. 잋치하는 회원정보가 있는지 조회
		Member loginMember= mdao.select_login(inputMid, inputMpw);
		//3 로그인처리
		
		if (loginMember != null) {
			if(loginMember.getMmState().equals("Y")) {
				loginId = loginMember.getMid();
				System.out.println("로그인 성공");				
			}else {
				System.out.println("이용이 정지된 계정입니다");
				System.out.println("관리자에"
						+ "게 문의해주세요");
			}
		}else {
			System.out.println("아이디/비밀번호가 일치하지 않습니다.");
			System.out.println("로그인 실패");
		}
	}

	public void memberLogout() {
		loginId = null;
		System.out.println("로그아웃 되었습니다");
	}

	public void myInfo() {
		Member loginMember= mdao.myInfo(loginId);
		System.out.print("[1]이름 : " + loginMember.getMmane()+" ");
		System.out.print("[2]아이디 : " + loginMember.getMid()+" ");
		System.out.print("[3]생일 : " + loginMember.getMmbirth()+" ");
		System.out.println("[4]전화번호 : " + loginMember.getMphone());
		
		int countOrder = mdao.selectCountOrder(loginId);
		int sumOrder = mdao.selectSumOrder(loginId);

		if(countOrder > 0) {
			System.out.println("[총 주문수] : " + countOrder);	
		}else {
			System.out.println("주문내역이 없습니다.");
		}
		
		if(countOrder > 0) {	
			System.out.println("[총 결제금액] : " + sumOrder);
		}else {
			System.out.println("주문내역이 없습니다.");
		}
	}
	
	

}
