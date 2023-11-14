package day14;

import java.util.Scanner;

public class PhoneService {
	
	
	Scanner scan = new Scanner(System.in);
	
	/* 기능정의 클래스 */
	
	/* 메뉴출력 기능 : showMenu() 
	  [1]등록 [2]검색 [3]수정 [4]삭제
	*/
	
	void showMeun() {
		System.out.println("**********************************");
		System.out.println("[1]등록 [2]검색 [3]수정 [4]삭제 [5]종료");
		System.out.println("**********************************");
		System.out.print("메뉴선택 : ");
	}
	
	/* 연락처저장기능 : registInfo() */
	
	PhoneBook[] pbList = new PhoneBook[5]; // 연락처 목록
	
	void registInfo() {
		System.out.println("[등록]");
		int idx = -1;
		for (int i = 0; i < pbList.length; i++) {
			if (pbList[i] == null) {
				idx = i;
				break;
			}

		}

		if (idx == -1) {
			System.out.println("더이상 연락처를 저장할 수 없슨니다.");
			System.out.println("연락처를 삭제해주세요!");
			return;
		}

		System.out.print("이름 : ");
		String inputName = scan.next();

		System.out.print("전화번호 : ");
		String inputPhoneNum = scan.next();

		PhoneBook phoneTotal = new PhoneBook();
		phoneTotal.setName(inputName);
		phoneTotal.setPhoneNum(inputPhoneNum);
		pbList[idx] = phoneTotal;

		System.out.println("새 연락처가 등록 되었습니다.\n");

	}
	
	/* 연락처검색기능 :searchInfo()
	 * 1. 수정할 연락처 검색
	 * 2. 연락처가 검색되었을경우 
	  - 이름으로 전화번호검색 
	  - 전화번호로 이름 검색
	  3. 검색되지 않았을 경우
	   - "등록되지 않은 연락처 입니다." 출력
	  검색된 연락처를 출력("이름 : ", "전화번호 : ")
	 */  
	
	
	
	void searchInfo() {
		System.out.println("[검색]");
		System.out.print("찿을 이름: ");
		String nameSearch = scan.next();
		int idx = searchIdx(nameSearch);
		
		if(idx > -1) {
			System.out.println("이름 : " + pbList[idx].getName());
			System.out.println("번호 : " + pbList[idx].getPhoneNum());
			System.out.println();
		} else {
			System.out.println("검색된 연락처는 없습니다.\n");
		}
	}
	
	public int searchIdx(String searchName) {
		int idx = -1;
		for (int i = 0; i < pbList.length; i++) {
			if (pbList[i] != null) {
				if (pbList[i].getName().equals(searchName)) {
					idx = i;
					break;
				}
			}
		}
		
		return idx;
	}
	
	/* 연락처 변결기능 : modifyInfo()
	  1. 수정할 연락처 검색
	  2. 연락처 검색되었을 경우 
	   - 이름을 수정
	   - 전화번호 수정
	  3. 검색되지 않았을 경우
	   - "등록되지 않은 연락처 입니다." 출력
	  */
	
	void  modifyInfo() {
		
		System.out.println("[수정]");
		System.out.println("[수정할 연락처검색]");
		System.out.print("검색할 이름 : ");
		String searchName = scan.next();
		int idx = searchIdx(searchName);
		
		if (idx > -1) {
			//연락처 수정방법.
			System.out.println("수정할 연락처가 검색되었습니다. ");
			System.out.print("[1]이름수정 [2]번호수정 :");
			int selectMenu = scan.nextInt();
			if(selectMenu == 1) {
				System.out.print("변경 후 이름 : ");
				String changeName = scan.next();
				String oldName = pbList[idx].getName();
				pbList[idx].setName(changeName);
				System.out.println("["+oldName+"] >> [" + changeName + "]\n로 수정되었습니다." );
			} else if (selectMenu == 2) {
				System.out.print("변경 후 번호 : ");
				String changeNum = scan.next();
				String oldNum = pbList[idx].getPhoneNum();
				pbList[idx].setName(changeNum);
				System.out.println("["+oldNum+"] >> [" + changeNum + "]\n로 수정되었습니다." );
				pbList[idx].setPhoneNum(changeNum);
				
			}
			
			
		}else {
			System.out.println("검색된 연락처가 없습니다.\n");
		}
	}
	
	/* 연착처삭제 기능 : deleteInfo() 
	  1. 삭제할 연락처 검색
	  2. 연락처 검색되었을 경우 
	   - 삭제
	  3. 검색되지 않았을 경우
	   - "등록되지 않은 연락처 입니다." 출력
	   */
	
	void deleteInfo() {
		System.out.println("[삭제]");
		System.out.println("[삭제 연락처검색]");
		System.out.print("검색할 이름 : ");
		String searchName = scan.next();
		int idx = searchIdx(searchName);
		
		if (idx > -1) {
			//연락처 수정방법.
			pbList[idx] = null;
			System.out.println("삭제되었습니다.\n");
		}else {
			System.out.println("검색된 연락처가 없습니다.\n");
		}
	}
}

