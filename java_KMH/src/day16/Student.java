package day16;

public class Student extends Person{
	
	String univName;
	String major;
	
	public Student(String name, int age, String addr,String univName,String major) {
		super(name,age,addr);
		this.univName = univName;
		this.major = major;
	}
	
	public void myjob() {
		
	System.out.println("나는 Student입니다.");	
	}
	
	public Student() {
		
	}
	
}
