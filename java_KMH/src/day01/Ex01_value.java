package day01;

import javax.sound.sampled.BooleanControl;

public class Ex01_value {
	//필드
	//메소드
	//생성자
	
	public static void main(String[] args) { //<-메소드
		/* 변수 */
		
		/*
		 * 프로그램을 실행하는데 필요한
		 * 데이터를 저장하기 위해
		 * 메모리 공간안에 영역을 할당하고
		 * 이름을 부여하는것
		 */
		// 자료형 : 숫자 || 문자
		//정수형 숫자 : byte, short, int, long
		
		int number = 10; //변수를 선언하고 초기화
		
		int number2; //int 타입 변수 number2를 선언
		number2 = 20;//number2 를 초기화
		
		int number3 = 30;
		int number4;
		System.out.println(number3);
//		System.out.println(number4); // ctrl + / 행 전체 주석 
		
		
//		[변수타입] [변수명] = [변수값];
//		  int      b    =    10
		/*
		 [byte 타입]  : 1byte >> 8bit 
		 [short 타입] : 2byte >> 16bit
		 [int 타입]   : 4byte >> 32bit
		 [long 타입]  : 8byte >> 64bit
		 		 	 	 
		  */
		
		byte byteNUM1 = 127;
		short shortNUM1 = 128;
		int intNUM1  = 1234567890;
		long longNUM1 = 12345678901L; // long 은 끝날때 숫자끝에 (l,L) 붙여야함.
		//주로 int를 사용
		
		//실수형 숫자 
		/* 
		 [float 타입]  : 4byte
		 [double 타입] : 8byte
		 		 
		  */
		
		float floatNUM = 10.123F; // float은 끝날때 숫자끝에 (F,f) 붙여야함
		double doubleNum1 = 111.11234; // double 은 끝에안 붙혀도됨
		//주로 double 사용
		
		// [boolean 타입] : ture || fale 구분
		boolean boolVal1 = true;
		boolean boolVal2 = false;
		boolean boolVal3 = 10>20;
		
		// [char 타입] : 문자를 저장
		// 문자 표기 방식 : '' 
		
		double a = 1000000000.111;
		char charVal1 = 'a';
		
		String strVal1 = "abcd"; // 문자열(문자가 2개이상) 은 "" 문자(문자가1개) 은 ''
		
		//int, double, boolean, String <<사용예정
		}
	
}
