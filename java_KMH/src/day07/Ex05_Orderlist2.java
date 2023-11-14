package day07;

import java.util.Scanner;

public class Ex05_Orderlist2 {
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		String orderList = ""; //주문한 매뉴
		boolean menuOpen = true;
		int coffeePrice = 0;
		int americano = 0, latte = 0, iceTea=0;
		while (menuOpen) {
			
			System.out.println("[1]아메리카노(2000) [2]바닐라라떼(3500) [3]아이스티(3000) [0]주문종료");
			System.out.print("메뉴선택 :");
			int selectMenu = scan.nextInt();
			
			switch(selectMenu) {//switch 시작
			
			case 1:
				System.out.println("[아메리카노]\n");
				orderList =  orderList + "[아메리카노]";
				americano ++;
				coffeePrice += 2000;
				break;
			case 2: 
				System.out.println("[바닐라라떼]\n");
				orderList =  orderList + "[바닐라라떼]";
				coffeePrice += 3500;
				latte ++;
				break;
			case 3: 
				System.out.println("[아이스티]\n");
				orderList =  orderList + "[아이스티]";
				coffeePrice += 3000;
				iceTea++;
				break;
			case 0 :
				System.out.println("[주문종료]\n");
				menuOpen = false;
				break;
			default :
				System.out.println("잘못 선택 했습니다.\n 다시 입력해주세요\n");
				break;
				
			}//switch 종료
			
		}//while 종료
		if( coffeePrice > 0) {
			
			System.out.print("주문한 메뉴는 ");
			System.out.print("[아메리카노 " + americano + "잔]");
			System.out.print("[바닐라라떼 " + latte + "잔]");
			System.out.println("[아이스티 " + iceTea + "잔]");
			System.out.println("결제 금액은 " + coffeePrice + "입니다.");

		}else {
			
			System.out.println("주문하신 메뉴가 없습니다");
		}
	}
}
