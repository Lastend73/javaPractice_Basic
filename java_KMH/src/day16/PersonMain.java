package day16;

public class PersonMain {
	public static void main(String[] args) {

		
		Person person = new Person("황규민",24,"인천");
//		person.name = "황규민";
//		person.age = 24;
//		person.addr = "인천";
		
		
		
		Student stu = new Student("황규민",24,"인천","인하대학교","정보토신");
		
		Developer dev = new Developer("황규민",24,"인천","Java","JCIA");
		
//		person.myjob();
//		stu.myjob();
//		dev.myjob();
		
		personService psvc = new personService();
		psvc.ChoiceType(person);
		psvc.ChoiceType(stu);
		psvc.ChoiceType(dev);
		
		Person personSTU = new Student();
		if (personSTU instanceof Student) {
			
		}
		Person personDev = new Developer();
	}
}
