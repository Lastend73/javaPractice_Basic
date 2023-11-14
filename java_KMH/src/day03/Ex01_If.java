package day03;



public class Ex01_If {

	public static void main(String[] args) {
		
		/* 조건문 - if */
		/*
		if(조건식) {
			조건식이 true 일 경우 실행되는 부분	
		} else {
			조건식이 false 일 경우 실행되는 부분
		}
		*/
		
		System.out.println("if문 시작");
		boolean boolVal = true;
		
		if(boolVal) { //true
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		System.out.println("if문 종료");
		
		
		int score = 85;
		
		if (score >= 90) {
			System.out.println("A학점입니다.");
		} else if (score >= 80) {
			System.out.println("B학점입니다.");
		} else {
			System.out.println("80점 미만입니다");
		}
		
		// 변수 사용 범위
		int num1 = 1;
		int num2 = 2;
		
		if ( num1 < num2 ) {
			
			System.out.println("num1이 num2보다 작다");
			int num3 = 10;
			System.out.println("num3 : " + num3);
			
		}
		
	}

}
