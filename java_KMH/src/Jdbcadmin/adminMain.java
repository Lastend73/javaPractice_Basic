package Jdbcadmin;

import java.util.Scanner;

public class adminMain {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	
		adminService adsv = new adminService();
		
		boolean run = true;
		
		while(run) {
			System.out.println("[1]회원관리 [2]상품관리 [0]종료");
			System.out.print("선택 : ");
			
			int selectMenu = scan.nextInt();
			
			switch(selectMenu) {
			case 1:
				adsv.manage();
				break;
			case 2:
				adsv.goodsmanage();
				break;
			case 0 :
				run = false;
				System.out.println("프로그램을 종료합니다");
				return;
			}
			
		}
	}

}
