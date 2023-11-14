package day06;

public class Ex01_for {

	public static void main(String[] args) {

		/* 중립 for 문 */
/*
 		for( 초기화식; 조건식; 증감식){
 		
 			반복 실행될 부분
 			
 		}
    
*/	
		for (int i = 0; i <=5; i++) {
				System.out.println(" [i = " + i +"]");
				
			for(int j = 0; j <= 3; j++) { // j :  0 1 2 3 : 4번
				
				System.out.println(" j = " + j);
				
			}
			
		}
		
		
		for (int i = 2; i <= 9; i++) {
			System.out.println(i + "단");
				
			for (int j = 1; j <= 9; j++) { // j : 0 1 2 3 : 4번

				System.out.println(i + " * " + j + " = " + i*j);

			}
			System.out.println();

		}

	}

}
