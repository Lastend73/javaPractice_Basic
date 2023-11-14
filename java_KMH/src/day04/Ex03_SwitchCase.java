package day04;

import java.util.Scanner;

public class Ex03_SwitchCase {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자입력>> ");
		String strVal = scan.next(); 
		System.out.println("strVal : " + strVal); 
		
		switch(strVal) { //대소문자 구별함 || 변수 값을 인식직접 분석하기 떄문에 가능
		case "A" : 
			System.out.println("switch A");
			break;
		case "B" :
			System.out.println("switch B");
			break;
		case "ABC" :
			System.out.println("switch ABC");
			break;
		default :	
		}
		
		System.out.println("Switch문 종료");
		//if는 왼쪽과 오른쪽을 비교하기때문에 주소 와 값은 일치하지 않기때문에.
		if(strVal.equals("A")) { // 문자열이라 안됨 strval 은 주소값 또는 숫자 == 안됨 
			System.out.println("IF A");
		}else if(strVal.equals("B")) {
			System.out.println("IF B");
		}else if(strVal.equals("ABC")) {
			System.out.println("IF ABC");
		}
		
		System.out.println("if문 종료");
		System.out.println(strVal == "A");
		
		System.out.println(strVal.equals("A")); // 문자열 비교 메소드 사용해에함 .equals
	}
}
