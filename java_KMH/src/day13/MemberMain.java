package day13;

//처리
public class MemberMain {

	public static void main(String[] args) {

		MemberService service = new MemberService();

		boolean run = true;

		while (run) {
//			메뉴 추력 기능 메소드 호출
			service.showMenu();

//			메뉴 선택

			int selectMenu = service.scan.nextInt();

			switch (selectMenu) {
			
			case 1: // 회원가입 기능 호출
				service.memberJoin();
				break;

			case 2:// 로그인 기능 호출
				service.memberLogin();
				break;
			
			case 3:
				run = false;
				break;
			
			default : 
				System.out.println("다시 입력해주세요");
			}

			
		}

	}
}
