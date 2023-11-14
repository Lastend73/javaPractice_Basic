package day16;

public class Developer extends Person {

	String langType;
	String company;

	public Developer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Developer(String name, int age, String addr, String langType, String company) {

		this.name = name;
		this.age = age;
		this.addr = addr;
		this.langType = langType;
		this.company = company;
	}
	
	public void myjob() {
		
		System.out.println("나는 devloper입니다.");	
		}
	
	public void Developer() {
		
	}

}
