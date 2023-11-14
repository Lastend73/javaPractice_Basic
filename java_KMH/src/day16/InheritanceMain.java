package day16;

public class InheritanceMain {

	public static void main(String[] args) {
		child chd = new child();
		
		chd.ParentField = " ";
		chd.parentMethod();
		
		Parent prt = new Parent();
		prt.parentMethod();
		
		chd.testMethod();
		
		
		ParentClass parent = new ParentClass();
		ChildClass child = new ChildClass();
		
	}
	
}

