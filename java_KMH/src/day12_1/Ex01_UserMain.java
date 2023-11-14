package day12_1;

import day12.Ex01_User; //다른 패키지에서 가져올대 사용
//                         ctrl 누른상태에서 연결된 클래스를 볼수 있음.
public class Ex01_UserMain {
	
	
	public static void main(String[] args) {
	
		Ex01_User user = new Ex01_User();

		user.publicVal =10; //접근 가능
//		user.defaultVal = 30; //접근 불가능
//		user.protectedVal = 20;//접근 불가능
//		user.privateVal = 10; //접근 불가능
		
//		다른 페키지라서 default, protect 안됨
	}
}
