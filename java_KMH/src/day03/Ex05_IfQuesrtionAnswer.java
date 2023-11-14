package day03;

import java.util.Scanner;

public class Ex05_IfQuesrtionAnswer {
  
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		System.out.println("[1]아메리카노(2000) [2]바닐라라때(3500)");
		System.out.print("메뉴선택>> ");
		
		int selectmenu = scan.nextInt();
		int coffeePrice = 0 ;
		boolean memuCheck = true; // 제시된 번호를 잘 선택했는지
		
		if( selectmenu == 1) {
			coffeePrice = 2000;
			System.out.println("아메리카노 선택");
		} else if ( selectmenu == 2) {
			coffeePrice = 3500;
			System.out.println("바닐라라떼 선택");
		} else {
			System.out.println("잘못된 선택입니다");
			memuCheck = false;
		}
		
		if (memuCheck == true) {
			System.out.println("[1]카드결제 [2]현금결제");
			System.out.println("결제방법선택 >>");

			selectmenu = scan.nextInt();

			if (selectmenu == 1) {
				System.out.println( coffeePrice +"원 결제되었습니다");
			} else if (selectmenu == 2) {
				System.out.println("투입금액입력 >> ");
				int money = scan.nextInt();
				System.out.println("거스름돈 " + (money - coffeePrice) + "입니다");
			}

		}
	}
}
