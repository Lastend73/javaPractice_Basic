package day12;

public class Ex02_MemberMain {

	public static void main(String[] args) {

		Ex02_Member memInfo = new Ex02_Member("KHM", "1234");
		
		
//		System.out.println(memInfo.id);
//		 memInfo.id = "KHM1234";

		String myId = memInfo.getId();
		System.out.println(myId);
		
		memInfo.setId("KMH1234");
		
	}
}
