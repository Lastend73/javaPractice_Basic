package day12;

public class MemberInfo {
	/*회원전보*/
	//아이디, 비밀번호, 이름, 전화번호
	
	private String mId; //아이디
	private String mPw; // 비밀번호
	private String mName;// 이름
	private String mPhone;// 전화번호
	
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
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	
	void Call() {
		System.out.println("이름 :" + mName);
		System.out.println("전화번호 :" + mPhone);
		System.out.println("아이디 :" + mId);
		System.out.println("비밀번호 :" + mPw);
	}
	
	public MemberInfo(String mId, String mPw, String mName, String mPhone) {
		super();
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mPhone = mPhone;
	}
	
}
