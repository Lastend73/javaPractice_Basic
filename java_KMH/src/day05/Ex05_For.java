package day05;

import java.util.Scanner;

public class Ex05_For {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("시작숫자>>");
		int startNum = scan.nextInt();
		System.out.print("종료숫자>>");
		int endNum = scan.nextInt();
		
		int sum = 0; // 총합을 저장할 변수
		
		for(int i = startNum; i <= endNum; i++) {
			System.out.print(i + " ");
			
			if(i % 3 != 0) {
				continue;
			}
			sum = sum+i;
		}
		
		System.out.println("\nfor문종료");
		System.out.println("sum = " + sum);
		
	}
}
