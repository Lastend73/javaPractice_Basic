package day03;

import java.util.Scanner;

public class Ex03_If {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("시험점수는? : ");
		int score = sc.nextInt();
		String grade;
		

		if (score >= 90) {
//			System.out.println("A입니다.");
			// 95 ~ 100 A+
			// 90 ~ 94 A0

			if (score >= 95) {
//				System.out.println("A+입니다.");
				grade = "A+";
			} else {
//				System.out.println("A0입니다.");
				grade = "A0";
			}

		} else if (score >= 80) {
//			System.out.println("B입니다.");
			// 85 ~ 89 B+
			// 80 ~ 84 B0
			if (score >= 85) {
//				System.out.println("B+입니다.");
				grade = "B+";
			} else {
//				System.out.println("B0입니다.");
				grade = "B0";
			}

		} else if (score >= 70) {
//			System.out.println("C입니다.");
			
			if (score >= 75) {
//				System.out.println("C+입니다.");
				grade = "C+";
			} else {
//				System.out.println("C0입니다.");
				grade = "C0";
			}
						
		} else {
//			System.out.println("재수강입니다.");
			grade = "재수강";
		}
		
		System.out.println( grade + "입니다");
	}
}
