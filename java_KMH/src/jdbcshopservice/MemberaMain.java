package jdbcshopservice;

import java.util.Scanner;

public class MemberaMain {

	public static void main(String[] args) {
//		Member, MemberService, Memberdao ,memberMain
		Scanner scan = new Scanner(System.in);
		MemberService msvc  =new MemberService();
		shopService svc = new shopService();
		boolean run = true;
		while (run) {
			// 메뉴출력
			System.out.println("로그인 아이디 : " + msvc.getLoginId());
			if(msvc.getLoginId() == null) {
				System.out.println("[1]회원가입 [2]로그인 [9]상품목록(Map) [0]종료"); //로그인을 되지 않을 경우
				
			}else { // 로그인이 되어있을 경우
				System.out.println("[1]정보확인 [2]로그아웃 [3]메뉴주문 [4]주문내역 [5]주문취소 [0]종료");
			}
			System.out.print("메뉴 선택 : ");
			// 메뉴선택
			int selectMenu = scan.nextInt();
			// 선택됨 메뉴 호출
			switch (selectMenu){
			case 1 :
				//로그인 X : 회원가입 기능 호출
				if (msvc.getLoginId() == null) {
					msvc.memberjoin();					
				} else {
					msvc.myInfo();
					
				}
				break;
			case 2 :
				// 로그인 X : 로그인 호출
				if(msvc.getLoginId() == null) {
					msvc.memberLogin(); // ㅎ
				}else {
					// 로그아웃 기능
					msvc.memberLogout();
				}
				break;
			case 3 :
				// 로그인 X : 로그인 호출
				if(msvc.getLoginId() == null) {
					System.out.println("잘못입력하셧습니다");
					break;
				}else {
					svc.order(msvc.getLoginId());
				}
				break;
			case 4 :
				if(msvc.getLoginId() == null) {
					System.out.println("잘못입력하셧습니다");
					break;
				}else {
					svc.OrderList(msvc.getLoginId());
				}
				break;
			case 5 :
				if(msvc.getLoginId() == null) {
					System.out.println("잘못입력하셧습니다");
					break;
				}else {
					svc.deleteOrderList(msvc.getLoginId());
				}
				break;
			case 9 :
				svc.goodsList_map();
				break;
			case 0 :
				System.out.println("종료");
				return;
			default :
				run = false;
				
			}
		}
	}
}
