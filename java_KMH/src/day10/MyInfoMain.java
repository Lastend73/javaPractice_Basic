package day10;

public class MyInfoMain {

	public static void main(String[] args) {
		int score = 100;
		score = 80;
		System.out.println(score);
		String str = "B";
		System.out.println(str);
//		[타입][객체] = new [연산자](연산자는 클래스이름)
		MyInfo info01 = new MyInfo();
//		.은 MyInfo 의 정보중 선택해서 접속
		
		
		System.out.println(info01.name);
		System.out.println(info01.age);
//		info01의 printMyInfo() 호출
		info01.printMyInfo();
		
		
//		info01의 name필드에 이름저장
		info01.name = "황규민";
		System.out.println(info01.name);
		
//		info01의 age필드에 이름저장
		info01.age = 24;
		System.out.println(info01.age);
		
		info01.printMyInfo();
		
		System.out.println();
		
		MyInfo info02 = new MyInfo();
		info01.printMyInfo();
		info02.printMyInfo();
		
		System.out.println(info01);
	}
}
