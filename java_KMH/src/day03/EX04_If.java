package day03;

import java.util.Scanner;

public class EX04_If {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		/*
		System.out.println("[1]메뉴1 [2]메뉴2");
		System.out.print("메뉴선택>> ");
		
		int selectMenu = scan.nextInt();
		
		if( selectMenu == 1 ) {
			System.out.println("[1]선택");
		}else if ( selectMenu == 2) {
			System.out.println("[2]선택");
		}
		*/
		
		System.out.print("현재 가지고 있는 돈 >> ");
		int money = scan.nextInt();
		
		
		int americno = 2000;
		int latte = 3000;
		// 커피가격
				
		System.out.println("[1]아메리카노("+ americno + ") [2]바닐라라때("+ latte+")");
		System.out.print("메뉴선택>> ");

		int selectMemu = scan.nextInt();

		
		if (selectMemu == 1) {
			money = money- americno;
//			System.out.println("[1]아메리카노(2000)");
		} else if (selectMemu == 2) {
			money = money - latte;
//			System.out.println("[2]바닐라라데(3500)");
		} else {
			System.out.println("잘못 누름");
		}
		
		
		if (money >= 0) {
			System.out.println("잔액 : " + money + "원");
		} else {
			System.out.println("잔액 " + Math.abs(money) + "원 부족");
		}

		/*
		 * 내가 가지고 있는 돈을 입력받아서 커피를 구매했을때 남은 잔액 출력
		 */

	}

}

