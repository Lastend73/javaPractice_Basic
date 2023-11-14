package day08;

import java.util.Scanner;

public class Ex03_Array {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("과목수 입력 :");
		int size = scan.nextInt();
		int[] scores = new int[size];
				
		//점수 입력
		
		for (int i = 0 ; i < size; i++) {
			
			System.out.print((i+1)+"번째 과목의 점수 : ");
			scores[i] = scan.nextInt();
		}
		
		for (int i = 0 ; i < size; i++) {
			System.out.println("scores[" + i + "] :" + scores[i]);
		}
		
		
		// 최대값 MAX 최소값 MIN
//		int scores = {80, 88, 89, 78, 100};
		
		int max = scores[0], min = scores[0];
//		1. max, scores[0]값을 비교 max <scores[0] :: max = 80
//		1. max, scores[1]값을 비교 max <scores[1] :: max = 80
		
		for(int i = 0; i < size; i ++ ) {
			
			if (scores[i] > max) {
				max = scores[i];
			}
			
			if (scores[i] < min) {
				min = scores[i];
				
			}
			
		}
				
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
	}

}
