package day16;

public class child extends Parent{

	@Override  //재정의
	void parentMethod() {
		System.out.println("자식클래스에 정의된 parentMethod()");
	}
	//Overloading
	int testMethod(int number) {
		System.out.println("testMethod() 호출");
		return number +1;
	}
	
	int testMethod() {
		System.out.println("testMethod() 호출");
		return 1;
	}
	
	
	String childVal;
	void childMethod() {
		System.out.println(protectedField);
		System.out.println(defaultField);
		System.out.println(childVal);
	}
		
}
