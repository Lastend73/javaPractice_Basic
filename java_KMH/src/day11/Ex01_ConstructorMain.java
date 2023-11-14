package day11;

public class Ex01_ConstructorMain {

	public static void main(String[] args) {

		Ex01_Constructor obj01 = new Ex01_Constructor();
		System.out.println(obj01.name);
		System.out.println(obj01.number);
		
//		매개변수가 1개인 생성자로 obj02 호출
		Ex01_Constructor obj02 = new Ex01_Constructor(1);
//		매개변수가 2개인 생성자로 obj03 생성
		int num = 100;
		int num2 = 20;
		Ex01_Constructor obj03 = new Ex01_Constructor(num,num2);
//		Ex01_Constructor obj04 = new Ex01_Constructor("ABC","100");
	}
}
