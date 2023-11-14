package day10;

public class Ex03_Array {
	
	public static void main(String[] args) {
		
		String[][] strArr = {{"A","B","C"},{"D","E"},{"F","G","H","I"}};
		System.out.println("0행");
//		0행의 모든 문자 출력
		for(int i = 0; i < strArr[0].length; i++) {
			System.out.print(strArr[0][i]+ " ");
		}
		System.out.println("\n1행");
//		1행의 모든 문자 출력		
		for(int i = 0; i < strArr[1].length; i++) {
			System.out.print(strArr[1][i]+" ");
		}
		System.out.println("\n2행");
//		2행의 모든 문자 출력		
		for(int i = 0; i < strArr[2].length; i++) {
			System.out.print(strArr[2][i]+ " ");
		}
		
		System.out.println("\nfor 문\n");
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(i+"행");
			for(int j = 0; j < strArr[i].length; j++) {
				System.out.print(strArr[i][j]+ " ");
			}
			System.out.println();
		}
		
	}

}
