package day09;

import java.util.Scanner;

public class Ex01_Array {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String[] menuList = { "아메리카노:2000", "바닐라라뗴:3500", "아이스티:3000" };
		int[] priceList = { 2000, 3500, 3000 };
		int totalPrice = 0;
		int[] orderCount = new int[menuList.length];

		while (true) {

//			System.out.println("[1]아메리카노 [2]바닐라라떼 [3]아이스티 ");
			// menuList 배열의 모든 값 출력
			for (int i = 0; i < menuList.length; i++) {
				System.out.print("[" + (i + 1) + "]" + menuList[i] + " ");
			}
			System.out.println("[" + (menuList.length + 1) + "]주문종료");
			// 주문 내역 추가

			System.out.print("\n메뉴선택 : ");
			int selectMenu = scan.nextInt();

			// selectMenu >= 0 && selectMenu < menulist.length
			if (selectMenu <= menuList.length && selectMenu > 0) {

				System.out.println("선택한 메뉴 : " + menuList[selectMenu - 1]);
				System.out.println(priceList[selectMenu - 1] + "원 입니다.");
				totalPrice += priceList[selectMenu - 1];
				orderCount[selectMenu - 1]++;
				System.out.println();

			} else if (selectMenu == menuList.length + 1) {

				System.out.println("[주문종료]선택");
				break;

			} else {

				System.out.println("다시 선택해주세요!");

			}
		} // while문 종료
		
		int totalPrice2 = 0;
		
		for (int i = 0; i < menuList.length; i++) {
			
			if (orderCount[i] != 0) {
				totalPrice2 = totalPrice2 + orderCount[i] * priceList[i];
				System.out.println(menuList[i] + ": " + orderCount[i] + "잔");
				
			}
		}
		
		System.out.println("결제할 금액은 " + totalPrice + "원 입니다.");
		System.out.println("결제할 금액은 " + totalPrice2 + "원 입니다.");
	}
//		주문내역, 총액
}
