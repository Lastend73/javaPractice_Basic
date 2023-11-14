package day03;

import java.util.Scanner;

public class Ex05_IfQuestion {
	
	public static void main(String[] args) {
		/*
		 1. 커피메뉴 출력
		 2. 커피 메뉴 선택
		 3. 결제방법 출력
		 4. 결제방법 선택
		 5-1. 카드 결제 일 경우 "결제되었습니다" 출력
		 5-2. 현금결제 일 경우
		 	 - 투입 금액 입력
		 	 - 결제후 남은 잔액 출력 "거스름돈 ??원 입니다".
		 */
		Scanner scan = new Scanner(System.in);

		int americno = 2000;
		int latte = 3000;
		int result = 0;
		// 커피가격

		System.out.println("[1]아메리카노(" + americno + ") [2]바닐라라때(" + latte + ")");
		System.out.print("메뉴선택>> ");

		int selectMemu = scan.nextInt();

		System.out.println("[1]카드결제 [2]현금결제");
		System.out.print("결제방법 선택>> ");

		int selectPayment = scan.nextInt();

		if (selectPayment == 1) {
			System.out.println("결제 되었습니다");
		} else if (selectPayment == 2) {

			System.out.print("투입금액 :  ");
			int money = scan.nextInt();

			if (selectMemu == 1) {
				result = money - americno;
			} else if (selectMemu == 2) {
				result = money - latte;
			} 
			
			System.out.println("잔액 : " + result);

		} 

	}
}
