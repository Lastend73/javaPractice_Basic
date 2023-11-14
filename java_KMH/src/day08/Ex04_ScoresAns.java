package day08;

import java.util.Scanner;

public class Ex04_ScoresAns {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		boolean run = true;
		int[] scores = null;
		boolean check = false;

		while (run) {
			// 1. 메튜출력
			System.out.println("**********************************************");
			System.out.println("[1] 과목수입력 [2]성적입력 [3]성적출력 [4]성적분석 [5]종료");
			System.out.println("**********************************************");
			System.out.print("메뉴선택 : ");
			int selectMenu = scan.nextInt();

			if ((selectMenu != 1 || selectMenu != 5) && (scores == null)) {
				System.out.println("[1]과목 수를 입력해주세요");
				continue;
			}

			switch (selectMenu) {
			case 1:

				System.out.print("과목 갯수 : ");
				int size = scan.nextInt();
				scores = new int[size];
				check = false;
				System.out.println();
				break;

			case 2:

				if (scores != null) {

					for (int i = 0; i < scores.length; i++) {
						System.out.println((i + 1) + "번쨰 과목의 점수 >>");
						scores[i] = scan.nextInt();
					}
					check = true;
				} else {
					System.out.println("과목수를 입력해주세요");
				}

				break;

			case 3:

				if (check) {

					for (int i = 0; i < scores.length; i++) {
						System.out.println("scores[" + i + "] : " + scores[i]);
					}

				} else {
					System.out.println("[2]성적입력을 해주세요!");
				}

				break;

			case 4:

				int sum = 0;
				int max = scores[0];
				int min = scores[0];

				for (int i = 0; i < scores.length; i++) {
					sum += scores[i];

					if (max < scores[i]) {
						max = scores[i];
					}
					if (min > scores[i]) {
						min = scores[i];
					}
				}

				double avg = sum / scores.length;

				System.out.println("최대값 : " + max);
				System.out.println("최소값 : " + max);
				System.out.println("평균 : " + avg);
				System.out.println("총점 : " + sum);

				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("다시 입력해주세요");
			}

		}
	}

}
