package day01;

public class Ex02_vaule {
	public static void main(String[] args) {
		
		// JAVA 시험 점수
		// java + score 시작은 소문자 새로운 단어가 나올떄 대문자
		int javaScore = 90;			
		char charVal = 'A';
		String strVal = "문자열변수"; 
		
		System.out.println(javaScore);
		System.out.println("javaScore");
		
		int oracleScore = 80;
		System.out.println(oracleScore);
		
		System.out.println("문자출력");
		System.out.println("자바 점수 : " + javaScore);
		System.out.println(javaScore + oracleScore);
		System.out.println("총점 : "+javaScore + oracleScore);
		System.out.println("총점 : "+(javaScore + oracleScore) );
		// " 총점 : 90" +80
	}


}
