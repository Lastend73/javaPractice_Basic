package day08;

import java.util.Scanner;

public class Ex04_Scores {
	
	public static void main(String[] args) {
	
		/*
		 1. 과목수 배열 생성
		 2. 성적을 입력
		 3. 입력 했던 모든 과목의 성적 출력
		 4. 성적분석 (총점, 평균,최대값, 최소값)
		 
		 */
		
		Scanner scan = new Scanner(System.in);

		boolean run = true;
		int size = 0;
		int[] scores = null;
		boolean scoreCheck = false;

		while (run) {
			// 1. 메튜출력
			System.out.println("***********************************************");
			System.out.println("* [1] 과목수입력 [2]성적입력 [3]성적출력 [4]성적분석 [5]종료 *");
			System.out.println("************************************************");
			System.out.print("메뉴선택 : ");
			int selectMenu = scan.nextInt();

			if (selectMenu == 1) {
				System.out.print("과목 갯수 : ");
				size = scan.nextInt();
				scores = new int[size];
				scoreCheck = false;
				System.out.println();
				
			} else if (selectMenu == 2) {

				if (size == 0) {
					System.out.println("과목수가 0개입니다\n과묵수를 입력해주세요\n");
					continue;
				}

				for (int i = 0; i < size; i++) {
					System.out.print((i + 1) + "번째 과목의 점수를 입력해주세요 : ");
					scores[i] = scan.nextInt();
				}
				
				System.out.println("입력완료\n");
				scoreCheck = true;

			} else if (selectMenu == 3) {

				if (size == 0) {
					System.out.println("과목수가 0개입니다\n과묵수를 입력해주세요\n");
					continue;
				}

				if (scoreCheck == false) {
					System.out.println("성적을 입력해주세요\n");
					continue;
				}

				for (int i = 0; i < size; i++) {
					System.out.println((i + 1) + "번째 과목의 점수 : " + scores[i]);
				}
				System.out.println("");

			} else if (selectMenu == 4) {

				if (size == 0) {
					System.out.println("과목수가 0개입니다\n과묵수를 입력해주세요\n");
					continue;
				}

				int max = scores[0];
				int min = scores[0];
				int sum = 0;

				for (int i = 0; i < size; i++) {

					if (max > scores[i]) {
						max = scores[i];
					}
					if (min < scores[i]) {
						min = scores[i];
					}

					sum += scores[i];

				}

				double avg = (double) sum / size;

				System.out.println("최대값 : " + max);
				System.out.println("최소값 : " + min);
				System.out.println("최대값 : " + sum);
				System.out.println("평균값 : " + avg);
				System.out.println();

			} else if (selectMenu == 5) {
				System.out.println("종료");
				break;
			} else {
				
				System.out.println("잘못 입력하셧습니다.\n다시 선택해주세요\n");

			}

		}

	}
}
