package day14;

public class PhoneBook {
	/*연락처 정보*/
	/*이름 전화번호*/
	
	private String name;
	private String phoneNum;
	
	/*public PhoneBook(String name, String phoneNum) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
	}*/
	
	
	public String getName() {
		return name;
	}
		
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
}
