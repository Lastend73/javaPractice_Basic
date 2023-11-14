package Jdbcadmin;

import java.util.ArrayList;
import java.util.Scanner;

import jdbcshopservice.Goods;

public class adminService {

	private adminDao adao = new adminDao();
	Scanner scan = new Scanner(System.in);

	public void manage() {
		System.out.println("[회원관리]");
		ArrayList<membersinfo> mem = adao.select();
		if (mem == null) {
			System.out.println("회원정보가 없습니다");
			return;
		}
		for (int i = 0; i < mem.size(); i++) {
			System.out.print("[" + i + "][" + mem.get(i).getmState() + "]");
			System.out.print("[성함]" + mem.get(i).getmName() + " ");
			System.out.print("[아이디]" + mem.get(i).getmId() + " ");
			System.out.print("[비밀번호]" + mem.get(i).getmPw() + " ");
			System.out.print("[생년월일]" + mem.get(i).getmBirth() + " ");
			System.out.println("[휴대전화]" + mem.get(i).getmPhone() + " ");
		}

		System.out.print("회원선택 : ");
		int selectMem = scan.nextInt();

		int chageState = adao.chageState(mem.get(selectMem).getmId());
		if (chageState == 0) {
			System.out.println("오류발생");
		} else if (chageState == 1) {
			System.out.println("[" + mem.get(selectMem).getmName() + "]님의 계정을 정지합니다");
		} else if (chageState == 2) {
			System.out.println("[" + mem.get(selectMem).getmName() + "]님의 계정정지를 혜지합니다");
		}
	}

	public void goodsmanage() {
		System.out.println("[상품관리]");
		ArrayList<Goods> Good = adao.goodsSelect();

		if (Good == null) {
			System.out.println("상품정보가 없습니다");
			return;
		}

		for (int i = 0; i < Good.size(); i++) {
			System.out.print("[" + i + "][" + Good.get(i).getGSTATE() + "]");
			System.out.print("[" + Good.get(i).getGNAME() + "] ");
			System.out.print("[" + Good.get(i).getGPRICE() + "] ");
			System.out.print("[" + Good.get(i).getGSTOCK() + "개 남음] ");
			System.out.println("[" + Good.get(i).getGTYPE() + "] ");
		}
		System.out.println();
		
		System.out.print("상품선택 : ");
		int selectOption = scan.nextInt();
		if(Good.get(selectOption).getGSTATE().equals("N")) {
			System.out.println("선택한 상품["+Good.get(selectOption).getGNAME()+"]은");
			System.out.println("현재 판매가 중지된 상품입니다.\n판매상태를 변경겠습니까?");
		}else {
			System.out.println("선택한 상품["+Good.get(selectOption).getGNAME()+"]을");
			System.out.println("판매 중지 하겠습니까?");
		}
		
		System.out.print("[1]예 [2]아니오 : ");
		int selectMenu = scan.nextInt();
		
		if(selectMenu == 1) {
			int chageState = adao.chageGoodsState(Good.get(selectOption).getGCODE());
			
			if(Good.get(selectOption).getGSTATE().equals("Y")) {
				System.out.println("판매중지 처리가 완료되었습니다");
			}else {
				System.out.println("판매중지가 혜지 되었습니다");
			}
		} else if (selectMenu == 2) {
			System.out.println("변경을 취소합니다.");
			return;
		}else {
			System.out.println("잘못 입력하셧습니다.");
			return;
		}
	}

}
