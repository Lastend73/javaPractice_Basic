package jdbcPhoneBook;



public class phoneBookMain {

	public static void main(String[] args) {
		
		phoneBookService pbsvc = new phoneBookService();
		boolean run = true;
		
		while (run) {
			// 메뉴출력
			System.out.println("[1]등록 [2]조회 [3]수정 [4]삭제 [5]이름으로 조회 [0]종료");
			System.out.print("메뉴선택 >> ");
			//메뉴 선택
			int selectMenu = pbsvc.scan.nextInt();
			// 선택 메뉴 기능 호출
			switch(selectMenu) {
			case 1:
				pbsvc.insertPhoneBook();
				break;
			case 2: 
				pbsvc.selectPhoneBook();
				break;
			case 3 :
				pbsvc.updatePhoneBook();
				break;
			case 4 : 
				pbsvc.deletePhoneBook();
				break;
			case 5:
				pbsvc.selectPhoneBook_Name();
				break;
			case 0 :
				System.out.println("종료");
				return;
			default :
				System.out.println("잘못 입력하셧습니다. 다시입력해주세요");
				break;
			}
			System.out.println();
		}
		
	}
	
}
