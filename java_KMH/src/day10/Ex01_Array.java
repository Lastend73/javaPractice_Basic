package day10;

public class Ex01_Array {
	
	public static void main(String[] args) {
		/* 2차원 배열 */
		
		int[] numbers = {11, 12, 13};
//		크기가 3인 배열
//		|	11	|	12	|	13	|
// idx  	[0]		[1]		[2]
		
		System.out.println(numbers[0]);
	
// idx  	[0]		[1]		[2]
//		|	11	|	12	|	13	| >>행(ROW)
//		|	14	|	15	|	16	| >>열(COULLON)
//		|	17	|	18	|	19	|
		
		int[][] scores = { { 11, 12, 13 }, { 14, 15, 16 }, { 17, 18, 19 } };
		
		 System.out.println(scores[2][2]);
		 System.out.println(scores.length);
		 
		 int[][] scores2 = { { 1,2,3 }, { 4,5,6,7,8 }, { 9,10 } };
//		 idx  	[0]		[1]		[2]
//			|	1	|	2	|	3	| >>행(ROW)
//			|	4	|	5	|	6	|	7	|	8	| >>열(COULLON)
//			|	9	|	10	|
			
		 System.out.println("scores2");
		 System.out.println(scores2[0][0]);
		 System.out.println(scores2[0][1]);
		 System.out.println(scores2[0][2]);
//		 System.out.println(scores2[0][3]);
		 
		System.out.println("행의 개수 : " + scores2.length); //< 행의 갯수;
		System.out.println("0행의 크기 : " + scores2[0].length); //<< 0행의 크기
		System.out.println("1행의 크기 : " + scores2[1].length); //<< 1행의 크기
		System.out.println("2행의 크기 : " + scores2[2].length); //<< 2행의 크기
		 
	}
	
}
