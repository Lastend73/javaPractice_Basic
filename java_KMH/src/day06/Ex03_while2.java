package day06;

import java.util.Scanner;

public class Ex03_while2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		loopwhile :	//라벨링(이름은 알아서 [ex loopwhile] :(콜론중요) 해당 명령어 위로 붙이기
		while (true) {
			System.out.print("숫자입력 : ");
			int inputNum = scan.nextInt();
			
			/*if( inputNum == 0) {
				break;
			}*/
			
			switch (inputNum) {
			case 0:
				System.out.println("switch-case");
				break loopwhile;

			}

			System.out.println("입력한 숫자 : " + inputNum);

		}

	}

}
