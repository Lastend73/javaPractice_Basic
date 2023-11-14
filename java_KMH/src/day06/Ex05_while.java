package day06;

import java.util.Scanner;

public class Ex05_while {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int americano = 2000, latte = 3500;
		int coffeePrice = 0;

		while (true) {

			System.out.println("[1]아메리카노(2000) [2]바닐라라때(3500)");
			System.out.print("매뉴 선택 : ");
			int selectMenu = scan.nextInt();

			System.out.print("돈을 넣어주세요 :");
			int money = scan.nextInt();

			if ((selectMenu == 1 && money >= americano)) {
				System.out.println("거스름돈은 " + (money - americano) + "원입니다");
				coffeePrice += americano;
				System.out.println("누적 판매 금액 : " + coffeePrice);
				System.out.println();
			} else if ((selectMenu == 2 && money >= latte)) {
				System.out.println("거스름돈은 " + (money - latte) + "원입니다");
				coffeePrice += latte;
				System.out.println("누적 판매 금액 : " + coffeePrice);
				System.out.println();

			} else {
				System.out.println("잘못 입력하셧습니다\n");
			}

			if (coffeePrice >= 10000) {
				System.out.println("판매완료");
				break;
			}

		}
		System.out.println("while문 종료");

	}

}
