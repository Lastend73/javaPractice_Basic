package day06;

import java.util.Scanner;

public class Ex04_while {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int coffeeStock = 10; // 커피 재고
		int coffeePrice = 300; // 한잔 가격

		while (true) {
			System.out.println("커피가격 : " + coffeePrice);
			System.out.print("돈을 넣어 주세요 : ");
			int money = scan.nextInt();

			if (money == coffeePrice) {
				
				System.out.println("커피 1잔을 준다.");
				coffeeStock--;
				System.out.println("남은 커피 개수 : " + coffeeStock + "잔\n");
			} else if (money > coffeePrice) {
				System.out.println("커피 1잔을 준다.");
				System.out.println("거스름돈 : " + (money - coffeePrice) );
				coffeeStock--;
				System.out.println("남은 커피 개수 : " + coffeeStock + "잔\n");
				
			}else {
				
				System.out.println("돈이 부족합니다.\n");
				
			}
			
			if(coffeeStock == 0) {
				System.out.println("재고 소진");
				break;
			}

		}

	}

}
