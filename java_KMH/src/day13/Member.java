package day13;
//기능 비교
public class Member {
	
	/* 회원정보 : 아이디,비밀번호,이름*/
	
	public Member(String mId, String mPw, String mName) {
		super();
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
	}
	private String mId; //아이디
	private String mPw; //비밀번호
	private String mName; // 이름
	
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	
	
}
