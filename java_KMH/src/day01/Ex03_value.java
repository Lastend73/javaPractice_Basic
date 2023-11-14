package day01;

public class Ex03_value {

	public static void main(String[] args) {
		/*		
		int javaScore = 100;
		int oracleScore = 80;
		*/
		int num1, num2;
		num1 = 20;
		int javaScore = 100, oracleScore = 80;
		int totalScore = javaScore + oracleScore;
		System.out.println(totalScore);
//		System.out.println(javaScore + oracleScore);

		System.out.println(totalScore/2);
//		System.out.println((javaScore + oracleScore) /2);
		
		String name = "황규민 ";
		String birth = "2000년 9월";
		String myInfo = name + birth;
		System.out.println(myInfo);
		
		System.out.println(name + javaScore);
		String testVal = "100";
		System.out.println(javaScore);
		System.out.println(testVal);
		
		int number = 10;
		int intResult = number; //10
		
		String result = 10+""; // "10" 문자를 숫자로
		
		int re = Integer.parseInt("100"); //숫자를 문자로
		
		System.out.println(intResult+10);
		
		
		
		
	}

}
