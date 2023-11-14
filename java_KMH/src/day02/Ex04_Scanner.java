package day02;

import java.util.Scanner;

public class Ex04_Scanner {

	public static void main(String[] args) {

		// 스캐너로 숫자를 두개입력
		Scanner scan = new Scanner(System.in);
		int number1, number2;

		System.out.print("첫번쨰 숫자 입력>> ");
		number1 = scan.nextInt();

		System.out.print("두번쨰 숫자 입력>> ");
		number2 = scan.nextInt();

		System.out.println("덧셈 : " + (number1 + number2));
		System.out.println("뺄셈 : " + (number1 - number2));
		System.out.println("곱셈 : " + (number1 * number2));
		System.out.println("나눗셈 : " + (number1 / number2));
		System.out.println("나머지 : " + (number1 % number2));

	}
}
