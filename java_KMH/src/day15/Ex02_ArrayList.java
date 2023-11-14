package day15;

import java.util.ArrayList;

public class Ex02_ArrayList {

	public static void main(String[] args) {

		ArrayList<String> strList = new ArrayList<String>();
		strList.add("A"); // 0번 인덱스에 "A"저장
		strList.add("B"); // 1번 인덱스에 "B"저장
		strList.add("C"); // 2번 인덱스에 "C"저장

		System.out.println("0번인덱스 : " + strList.get(0));
		System.out.println("1번인덱스 : " + strList.get(1));
		System.out.println("2번인덱스 : " + strList.get(2));
		System.out.println("size : " + strList.size());

		strList.add(1, "D"); // (인덱스 번호, 입력값)
		System.out.println("0번인덱스 : " + strList.get(0));
		System.out.println("1번인덱스 : " + strList.get(1));
		System.out.println("2번인덱스 : " + strList.get(2));
		System.out.println("3번인덱스 : " + strList.get(3));
		// 이것은 대채되는 것이 아닌 한칸씩ㅏㅣ 밀려남
		System.out.println("size : " + strList.size());

		strList.remove(2); // 삭제가 아닌 떙기는거임
		System.out.println("strList.remove(2) 실행 후");
		System.out.println("size : " + strList.size());
		System.out.println("0번인덱스 : " + strList.get(0));
		System.out.println("1번인덱스 : " + strList.get(1));
		System.out.println("2번인덱스 : " + strList.get(2));

		strList.remove("D");
		System.out.println("strList.remove(\"D\") 실행 후");
		System.out.println("size : " + strList.size());
		System.out.println("0번인덱스 : " + strList.get(0));
		System.out.println("1번인덱스 : " + strList.get(1));

		System.out.println("for문 시작");
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(i + "번 인덱스 : " + strList.get(i));
		}

		ArrayList<Member> memList = new ArrayList<Member>();
		Member[] memArr = new Member[5];
		System.out.println("ArrayList 시작");
		for (int i = 0; i < memList.size(); i++) {

			System.out.println(memList.get(i).getMid());
		}
		System.out.println("Array 시작");
		for (int i = 0; i < memArr.length; i++) {

			System.out.println(memArr[i].getMid());
		}
		System.out.println("Array 끝");

	}
}
