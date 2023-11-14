package day14;



public class PhoneBookMain {
	
	
	public static void main(String[] args) {
	
		PhoneService2 service = new PhoneService2();
		
		boolean run = true;
		
		while(run) { //while 시작
			
			service.showMeun();
			int selectMenu = service.scan.nextInt();
			
			switch(selectMenu) { //스위치 시작
				case 1:
					// 메뉴출력기은 호출
					service.registInfo();
					break;
				
				case 2:
					service.searchInfo();
					break;
				
				case 3:
					service.modifyInfo();
					break;
				
				case 4:
					service.deleteInfo();
					break;
				
				case 5:
					System.out.println("종료합니다.");
					run = false;
					break;
				
				default :
					System.out.println("잘못 선택하셧습니다.");
			} // 스위치 종료
			
			
		} //while 종료
		
		
	}

}
