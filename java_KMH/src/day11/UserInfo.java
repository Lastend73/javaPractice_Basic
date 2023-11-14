package day11;

public class UserInfo {

	String userId;
	String userPw;
	String userName;
	String userPhone;

	public UserInfo(String userId, String userPw, String userName, String userPhone) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPhone = userPhone;
	}

	boolean loginCheck(String loginId, String loginPw) {
		System.out.println("아이디 비밀번호 확인 기능 호출");
		/*
		 * boolean result = false; if (this.userId.equals(loginId) &&
		 * this.userPw.equals(loginPw)) { // 문자열 비교 (.equal) return true; }
		 */
		if (this.userId.equals(loginId) && this.userPw.equals(loginPw)) { // 문자열 비교 (.equal)
			return true;
		} else {
			return false;
		}

	}
	
	void showInfo() {
		System.out.println("로그인 완료");
		System.out.println();
		System.out.println("아이디 : "+ userId);
		System.out.println("비밀번호 : "+ userPw);
		System.out.println("이름 : "+ userName);
		System.out.println("휴대폰 번호 : "+ userPhone);
		
	}

	@Override
	public String toString() {
		return "UserInfo [아이디 : " + userId + ", 비밀번호 : " + userPw + ", userName=" + userName + ", userPhone="
				+ userPhone + "]";//우클릭 source 에서 밑에서 4번째 << 아이디값 대신에 출력
	}

}
