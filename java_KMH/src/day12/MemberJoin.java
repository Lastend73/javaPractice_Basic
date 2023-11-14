package day12;

import java.util.Scanner;

public class MemberJoin {
	
	public static void main(String[] args) {
//		 회원정보들을 저장 할 배열 (회원 5명)
		MemberInfo[] memList = new MemberInfo[5];
		Scanner scan = new Scanner(System.in);
	
//		1번회원이 가입하면 1번회원 정보를 저장;
//		회원가입
//		1. 가입 정보를 입력
//		2. 입력된 정보를 MemberInfo의 객체에 저장
		
//		System.out.print("ID : ");
		String id = "KMH";//scan.next();
		
//		System.out.print("PW : ");
		String pw = "1234";//scan.next();
		
//		System.out.print("NAME : ");
		String Name = "황규민";//scan.next();
		
		
//		System.out.print("PHONE : ");
		String Phone = "010-9947-2958";//scan.next();
		
		MemberInfo mem01 = new MemberInfo(id, pw, Name, Phone);
		mem01.setmPhone(Phone);
		mem01.setmName(Name);
		mem01.setmId(id); 
		mem01.setmPw(pw);

		
//		3. memList배열에 0번 인덱스에 저장

		
		memList[0] = mem01;
		
			
		System.out.println("아이디 : " + memList[0].getmId());
		System.out.println("비밀번호 : " + memList[0].getmPw());
		
//		5. 2번회원 가입 >> 가입할 아이디 >> 중복확인
		System.out.print("ID : ");
		id = scan.next();
		
//		System.out.print("PW : ");
//		pw = scan.next();
//		
//		System.out.print("NAME : ");
//		Name = scan.next();
//	
//		System.out.print("PHONE : ");
//		Phone = scan.next();
		boolean idCheck = true;
		
		for(int i = 0; i < memList.length; i++) {
			if(memList[i].getmId() != null) {
				
				if(id.equals(memList[i].getmId())){
					
					idCheck = false;
				}
			}
		}
		
		if (idCheck) {
			System.out.println("사용 가능한 아이디 입니다.");
		} else {
			System.out.println("중복된 아이디 입니다.");
		}
		
	}

}

