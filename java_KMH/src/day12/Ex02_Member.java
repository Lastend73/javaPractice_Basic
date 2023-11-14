package day12;

public class Ex02_Member {

	private String id; // 아이디
	private String pw; // 비밀번호

//	확인용 getter 수정용 setter


	public Ex02_Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
//  source 에 있는 get set 사용 가능
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
			this.pw = pw;
		
	}



}
