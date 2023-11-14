package day06;

public class Ex02_While {

	public static void main(String[] args) {
		/* 반복문 - While */
		/*
		 * while(반복조건) { 반복 실행될 부분 }
		 */
		System.out.println("for문 시작");
		
		for (int i = 1; i <= 5; i++) {

			System.out.print(i + " ");
		}
		
		System.out.println("\nfor문정료");
		
		System.out.println("Whlie문 시작");
		
		int j = 1;
		
		while(j <= 5){
			System.out.print(j + " ");
			j++;
		}
		System.out.println("while문 종료");
		
		int k  = 1;
		System.out.println("Whlie문 시작");
		while(true){
			System.out.println("k : " + k );
			k++;
		
			if ( k > 5) {
				break;
			}
			
			
		}
		
		int z = 1;
		boolean run = true;
		
		while(run){
			System.out.print(z + " ");
			z++;
		
			if ( z > 5) {
				run = false;
			}
			
			
		}
		
		System.out.println("while문 종료");
	}
}
