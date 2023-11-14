package day09;

public class Ex02_Split {
	
	public static void main(String[] args) {
		
		String[] menuList = { "아메리카노:2000", "바닐라라뗴:3500", "아이스티:3000" };
		System.out.println(menuList[0]);
		
		String[] menuInfo = menuList[0].split(":"); // "아메리카노", 2000;
		String menuName = menuInfo[0];
		String menuPrice = menuInfo[1];
		
		int price = Integer.parseInt(menuPrice); //문자열을 정수형으로 변경 "2000" >> 2000
		
		String strVal = "010-9947-2958"; // "010","9947","2958"
		String[] splitResult = strVal.split("-"); //split 안에있는 문자 기준으로 나눈다 ex) - 로 기준이라 010, 9947, 2958로 나눠서 배열에 집어넣음
		int a =0;
		System.out.println(splitResult.length);
		for(int i = 0; i < splitResult.length; i++) {
			
			System.out.println(splitResult[i]);
		}
	}
	
}
