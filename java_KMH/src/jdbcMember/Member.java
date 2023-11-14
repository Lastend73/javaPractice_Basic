package jdbcMember;

public class Member {	
	//MEMBer
	// 아이디, 비밀번호, 이름 , 전화벅호, 생년웡ㄹ일
	
	private String mid;
	private String mpw;
	private String mmane;
	private String mPhone;
	private String mmbirth;
	
	private String mgraeh;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMmane() {
		return mmane;
	}
	public void setMmane(String mmane) {
		this.mmane = mmane;
	}
	public String getMphone() {
		return mPhone;
	}
	public void setMphone(String mphone) {
		this.mPhone = mphone;
	}
	public String getMmbirth() {
		return mmbirth;
	}
	public void setMmbirth(String mmbirth) {
		this.mmbirth = mmbirth;
	}
}
