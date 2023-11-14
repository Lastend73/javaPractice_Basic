package day10;

public class MyInfo {
	String name; // 이름
	int age; // 나이
	
	private/*접근제한자*/ String phone1; // 전화번호
	String phone2;
	
	void printMyInfo() { // 내 정보 출력 기능
		System.out.println("내 정보 출력");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}
