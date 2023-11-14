package day02;

import java.util.Scanner;

public class Ex05_Question {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// 커피가격
		int coffeePrice = 3000;

		/*
		 * 내가 가지고 있는 돈을 입력받아서 커피를 구매했을때 남은 잔액 출력
		 */
		System.out.println("커피가격 : " + coffeePrice + "원");
		System.out.print("내가 가지고 있는 금액 : ");

		int money = scan.nextInt();

		int result = money - coffeePrice;
		
		if (result >= 0) {
			System.out.println("잔액은 " + result + "원입니다");
		} else {
			System.out.println("잔액이 부족합니다.");
		}

	}
}
