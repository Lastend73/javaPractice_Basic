package day08;

public class Ex01_Array {
	
	
	public static void main(String[] args) {
	
		/*Array 배열*/
		/* 같은 타입의 데이터를 하나의 변수에 저장하는구조 */
//		타이베[ 배열이름 = {값1, 값2}
		
		int[] numbers = {11,12,13,14,15};
//		| 11 | 12 | 13 | 14 | 15|
//idx	 [0]	1   2    3    4
		System.out.println("numbers[0] : " + numbers[0]);
		numbers[0] =21; 
		System.out.println("numbers[0] : " + numbers[0]);
		
		int[] numArr1 = new int[5]; //크기가 5인 int 타입의 배열을 선어
//		|      |     |    |      |     |
//idx	 [0]	  1     2     3    4		
		
		numArr1[0] = 100;
		numArr1[1] = 200;
		
		System.out.println("배열의 크기 : " + numArr1.length);
		
	}
}
