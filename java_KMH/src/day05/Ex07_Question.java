package day05;

import java.util.Scanner;

public class Ex07_Question {
	
	public static void main(String[] args) {

		/*
		 * 1. 1 ~ 30번 까지의 학생
		 * 2. 짝수번 학생, 홀수번 학생 나눔
		 * 3. 짝수 : 통새우와퍼세트 9700원
		 *    홀수 : 와퍼세트 8900원
		 *    번호가 5의 배수인 학생인 경우 : 와퍼주니어세트 6600원 
		 * 4. 통새우와퍼세트의 총액 
		 *    와퍼세트의 총액
		 *  
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("총인원은 ? :");
		int student = scan.nextInt();

		int even = 0, odd = 0, five = 0;
		int shrimpSetPrice = 9700, wapperSetPrice = 8900, wapperjrSet = 6600;
		System.out.println("통새우와퍼세트 : 9700원, 와퍼세트 가격 : 8900원, 와퍼주니어 6600원\n");

		int shrimpResult = 0, wapperResult = 0, wapperjrResult = 0;

		for (int i = 1; i <= student; i++) {

			if (i % 5 == 0) {
				wapperjrResult = wapperjrResult + wapperjrSet;
				five = five + 1;
				continue;
			}

			if (i % 2 == 0) {
				even = even + 1;
				shrimpResult = shrimpResult + shrimpSetPrice;
			} else {
				odd = odd + 1;
				wapperResult = wapperResult + wapperSetPrice;
			}

		}

		System.out.println("와퍼주니어세트 인원 : " + five + "명");
		System.out.println("와퍼주니어세트 총액 : " + wapperjrResult + "원");

		System.out.println("\n통새우와퍼세트 인원 : " + even + "명");
		System.out.println("통새우와퍼세트 총액 : " + shrimpResult + "원");

		System.out.println("\n와퍼세트 인원 : " + odd + "명");
		System.out.println("와퍼세트 총액 : " + wapperResult + "원");

	}
}
