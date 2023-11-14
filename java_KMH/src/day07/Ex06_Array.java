package day07;

public class Ex06_Array {
	
	public static void main(String[] args) {
	
		/* 배열 Array*/
//		타입 이름 = 값;
		int num = 10;
		num = 20;
		num = 30;
		System.out.println(num);
//		배열 선언
//		타입[] 이름 = {값1, 값2}
//		타입 이름[] = {값1, 값2}
		
		int[] arrNumber = {10, 20};
		int arrNumber2[] = {10, 20};
		int[] menuCount = {3,5,4};
		
		System.out.println(menuCount[0]);
		System.out.println(menuCount[1]);
		System.out.println(menuCount[2]);
//		System.out.println(menuCount[3]);
		System.out.println(menuCount.length);
		
		System.out.println("for");
		for (int i = 0; i < menuCount.length; i++) {
			System.out.println(menuCount[i]);
		}
		
	}
}
