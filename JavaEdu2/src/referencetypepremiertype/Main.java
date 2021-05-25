package referencetypepremiertype;

public class Main {

	//레퍼런스타입, 프리미티어타입
	
	public static void main(String[] args) {
		int[] arr = new int[1];
		arr[0] =10;		
		int num =10;
		
		int[ ] arr2 = arr;
		int num2 = num;
		num2 =100;
		System.out.println(num);
		arr2[0] = 100;
		System.out.println(arr[0]);
	
	}	
		


}
