package day08;

public class Ex02_Array {

	public static void main(String[] args) {

		// 80, 88, 90, 78 ,100

		int[] scores = { 80, 88, 90, 78, 100 };

//		System.out.println(scores[0]);
//		System.out.println(scores[1]);
//		System.out.println(scores[2]);
//		System.out.println(scores[3]);
//		System.out.println(scores[4]);

		for (int i = 0; i < scores.length; i++) {
			System.out.println("scores[" + i + "] 값 : " + scores[i]);
		}

		// scores 배열에 90이 몇번 index에 있는지
		for (int i = 0; i < scores.length; i++) {

			if (scores[i] == 90) {

				System.out.println("90은 " + i + "번 인덱스에 있습니다.");
				System.out.print(scores[i] + "를 ");
				scores[i] = 95;
				System.out.println(scores[i] + "로 변경");

			}

		}
		
		int sum = 0;
		
		for (int i = 0; i < scores.length; i++) {

			sum += scores[i];
		}
		double avg = (double)sum /scores.length;
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);

		
	}

}
