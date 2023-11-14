package day07;

import java.util.Scanner;

public class Ex02_while {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int number = 0;
		boolean run = true; // while 문을 반복실행하기 위한 변수

		while (run) {

			System.out.println("[1]증가 [2]감소 [3]종료");
			System.out.print("선택 : ");
			int selectMenu = scan.nextInt();

			switch (selectMenu) {
			case 1:
				System.out.print("증가시킬 값 입력 : ");
				int upNum = scan.nextInt();
				number = number + upNum;
				break;
			case 2:
				System.out.print("감소시킬 값 입력 : ");
				int downNum = scan.nextInt();
				number = number - downNum;
				break;
			case 3:
				run = false;
				break;
			default :
				System.out.println("잘못 입력하셧습니다.");
				break;
			}

			System.out.println("현재 값은 " + number + "입니다\n");
		}

	}

}
