package day07;

import java.util.Scanner;

public class Ex01_while {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int number = 0;
		boolean run = true; // while 문을 반복실행하기 위한 변수
		
		while(run) {
			
			System.out.println("[1]증가 [2]감소 [3]종료");
			System.out.println("선택 : ");
			int selectMenu = scan.nextInt();
			
			switch(selectMenu) {
			case 1:
				number++;
				break;
			case 2 : 
				number--;
				break;
			case 3 : 
				run = false;
				break;
			}
			
			
			System.out.println("현재 값은 " + number + "입니다");
		}
		
	}
	
}
