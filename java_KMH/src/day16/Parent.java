package day16;

public class Parent  {
	
	String ParentField;

	
	 void parentMethod() {
		System.out.println("부모클래스에 정의된 parentMethod()");
	}
	
	 int testMethod() {
		System.out.println("testMethod() 호출");
		return 1;
	}
	
	protected String protectedField;
	String defaultField;
}

