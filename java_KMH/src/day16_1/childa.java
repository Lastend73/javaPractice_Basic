package day16_1;

import day16.Parent;

public class childa extends Parent{
	
	public void a() {
		System.out.println("ㅎㅇ");
	}
	
	  //재정의
	void parentMethod() {
		System.out.println("자식클래스에 정의된 parentMethod()");
	}
	//Overloading
	int testMethod(int number) {
		System.out.println("testMethod() 호출");
		return number +1;
	}
	
	  //재정의
	int testMethod() {
		System.out.println("testMethod() 호출");
		return 1;
	}
	
	String childVal;
	void childMethod() {
		System.out.println(protectedField); // package가 달라져도protected는 쓸수있이지만 
//		System.out.println(defaultField); // default는 사용불가
		System.out.println(childVal);
	}
		
}
