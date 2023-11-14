package day05;

public class Ex04_For {

	public static void main(String[] args) {

		for (int i = 0; i < 11; i++) {
			// break continue
			// i 가 5이면 중지

			if (i == 5) {
				break; //즉시 멈추기
			}
			
			System.out.println("i = " + i);
		}

		System.out.println();

		for (int i = 0; i < 11; i++) {
			// break continue
			// i 가 5이면 중지
			
			if (i == 5) {
				continue; // 건너뛰기  *주의사항 출력문이 더 위에있으면 출력이 됨
			}
			
			System.out.println("i = " + i);
		}

	}
}
