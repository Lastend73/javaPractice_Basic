package day06;

import java.util.Scanner;

public class Ex03_While {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		boolean run = false;

		while (run) {
			System.out.print("숫자입력 : ");
			int inputNum = scan.nextInt();

			/*
			 * if( inputNum == 0) { break; }
			 */

			switch (inputNum) {
			case 0:
				System.out.println("switch-case");
				run = false;
				break;

			}

			System.out.println("입력한 숫자 : " + inputNum);

		}

	}

}
