package day11;

public class Ex01_Constructor { //생성자
	
	int number;  // 번호
	String name; // 이름
		
	//기본 생성자 (아무것도 안만들었을대 자동으로 만들어짐)
	/*
	  public Ex01_Constructor() {
		this.name = "황규민";
		this.number = 1; //혹은 위에 int number = 1;
	}*/
	
	public Ex01_Constructor() {
		System.out.println("기본생성자 호출");
	}

//	생성자 - 매개변수가 1개인 생성자
	public Ex01_Constructor(int num/* 매개변수 */) {
		System.out.println("매개변수가 1개인 생성자 호출");
		System.out.println("num : " + num);
	}

//	생성자 - 매개변수가 2개인 생성자
	public Ex01_Constructor(int num, int num2/* 매개변수 */) {
		System.out.println("매개변수가 2개인(int, int) 생성자 호출");
		System.out.println("num : " + num);
		System.out.println("num2 : " + num2);
	}

	public Ex01_Constructor(int num, String str/* 매개변수 */) {
		System.out.println("매개변수가 2개인(int, str) 생성자 호출");
		System.out.println("num : " + num);
		System.out.println("str : " + str);
	}

}
