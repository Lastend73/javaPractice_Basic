package day07;

import java.util.Scanner;

public class Ex03_whileQuestion {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int money = 0;
		boolean run = true; // while 문을 반복실행하기 위한 변수

		while (run) {

			System.out.println("[1]입금 [2]출금 [3]잔고 [4]종료");
			System.out.print("선택 : ");
			int selectMenu = scan.nextInt();

			switch (selectMenu) {
			case 1:
				System.out.println("[입금]");
				System.out.print("입금액 : ");
				int upNum = scan.nextInt();

				money = money + upNum;
				
				System.out.println("잔액은 " + money + "입니다\n");
				
				break;
			case 2:
				System.out.println("[출금]");
				System.out.print("출금액 : ");

				int downNum = scan.nextInt();
				
				if (downNum < money) {
					money = money - downNum;
				} else {
					System.out.println("잔액이 부족합니다");
				}
				
				System.out.println("잔액은 " + money + "입니다\n");
				
				break;
			case 3:
				System.out.println("[잔액]");
				System.out.println("잔액은 " + money + "입니다\n");
				break;
			case 4:
				System.out.println("[종료]");
				run = false;
				break;
			default:
				System.out.println("잘못 입력하셧습니다.");
				break;
			}

		}

	}
}
