package day07;

import java.util.Scanner;

public class Ex04_Orderlist {
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		String orderList = ""; //주문한 매뉴
		boolean menuOpen = true;
		int totalMoney = 0, coffeePrice = 0;
		while (menuOpen) {
			
			System.out.println("[1]아메리카노(2000) [2]바닐라라떼(3500) [3]아이스티(3000) [0]주문종료");
			System.out.print("메뉴선택 :");
			int selectMenu = scan.nextInt();
			
			switch(selectMenu) {//switch 시작
			
			case 1:
				System.out.println("[아메리카노]\n");
				orderList =  orderList + "[아메리카노]";
				coffeePrice = 2000;
				totalMoney += coffeePrice;
				break;
			case 2: 
				System.out.println("[바닐라라떼]\n");
				orderList =  orderList + "[바닐라라떼]";
				coffeePrice = 3500;
				totalMoney += coffeePrice;
				break;
			case 3: 
				System.out.println("[아이스티]\n");
				orderList =  orderList + "[아이스티]";
				coffeePrice = 3000;
				totalMoney += coffeePrice;
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
		if(orderList == "") {
			System.out.println("주문하신 메뉴가 없습니다");
		}else {
			
			System.out.println("주문한 메뉴는 " + orderList + "입니다.");
			System.out.println("결제 금액은 " + totalMoney + "입니다.");
		}
	}
}
