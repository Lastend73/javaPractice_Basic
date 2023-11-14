package day07;

import java.util.Scanner;

public class Ex03_whileQuestionAns {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int money = 0;
		boolean run = true; // while 문을 반복실행하기 위한 변수

		while (run) {

			System.out.println("[1]입금 [2]출금 [3]잔고 [4]종료");
			System.out.print("선택 : ");
			int selectMenu = scan.nextInt();

			if (selectMenu == 1) {

				System.out.println("[입금]");
				System.out.print("입금 금액 : ");
				int deposit = scan.nextInt();
				money += deposit;

			} else if (selectMenu == 2) {

				System.out.println("[출금]");
				System.out.print("출금 금액 : ");
				int withdraw = scan.nextInt();

				if (money >= withdraw) {
					money = -withdraw;
				} else {
					System.out.println("잔액이 부족합니다");
				}

			} else if (selectMenu == 3) {
				System.out.println("[잔액]");
				
			} else {
				System.out.println("[종료]");
				break;
			}
			
			System.out.println("잔액 : " + money + "원\n" );
		}
	}
}
