package day2;
import java.util.ArrayList;
import java.util.Scanner;

public class Control {
	
	ArrayList<String> engArr = new ArrayList<>();
	ArrayList<String> korArr = new ArrayList<>();
	
	Scanner scan = new Scanner(System.in);
	String inputNum = "";
	
	public void start() {
		
		while (true) {
			System.out.println("\n뭐 할래?");
			System.out.println("[1. 추가]  [2. 수정] [3. 삭제] [4. 검색] [5. 종료]");
			System.out.print("[입력] >>> ");
			inputNum = scan.nextLine();
			
				 if (inputNum.equals("1")) add();
			else if (inputNum.equals("2")) update();
			else if (inputNum.equals("3")) remove();
			else if (inputNum.equals("4")) search();
			else if (inputNum.equals("5")) break;
		
		}
	}



	void add() {
		System.out.println("추가할 문자 Type 선택");
		System.out.println("[1. 영어]  [2. 한글]");
		String inputNum = scan.nextLine(); 
		System.out.print("추가할 문자를 입력하세요 : ");
		String inputData = scan.nextLine(); 
		boolean check = checkCharType(inputNum, inputData);	
		if(inputNum.equals("1") && check == true) {	//문자Type을 영어로 선택했고 입력된 문자가 알파벳일경우
			engArr.add(inputData);
			System.out.println("영어 문자 ["+ inputData + "]이 추가되었습니다\n");
		}
		else if(inputNum.equals("2") && check == true) { //문자Type을 한글로 선택했고 입력된 문자가 한글일경우
			korArr.add(inputData);
			System.out.println("한글 문자 ["+ inputData + "]이 추가되었습니다\n");
		}
		else {	//그밖의 경우
			System.out.println("선택한 문자Type과 입력한 문자형태가 불일치 합니다.\n");
			return;
		}
	}


	void update() {
		if(engArr.size() == 0 && korArr.size() == 0) {
			System.out.println("단어를 추가하세요");
			return;
		}
		
		search();
		
		System.out.println();
		System.out.println("수정할 문자 Type 선택");
		System.out.println("[1. 영어]  [2. 한글]");
		String inputNum = scan.nextLine(); 
		
		if(inputNum.equals("1") && engArr.size() == 0) {
			System.out.println("빈 단어장입니다.");
			return;
		}
		else if(inputNum.equals("2") && korArr.size() == 0) {
			System.out.println("빈 단어장입니다.");
			return;
		}
		
		System.out.print("수정할 문자의 번호를 입력하세요 : ");
		int selNum = scan.nextInt(); 
		
		if(inputNum.equals("1") && selNum <= engArr.size()){
			System.out.println("수정할 문자를 입력하세요 : ");
			String newInputData = scan.next();
			boolean check = checkCharType(inputNum, newInputData);
			if(check) {
				engArr.set(selNum - 1, newInputData);
				System.out.println("영어 문자 ["+ newInputData + "]로 수정되었습니다\n");
			}
			else {
				System.out.println("선택한 문자Type과 입력한 문자형태가 불일치 합니다.\n");
			}
		}
		else if(inputNum.equals("2") && selNum <= korArr.size()){
			System.out.println("수정할 문자를 입력하세요 : ");
			String newInputData = scan.next();
			boolean check = checkCharType(inputNum, newInputData);
			if(check) {
				korArr.set(selNum - 1, newInputData);
				System.out.println("한글 문자 ["+ newInputData + "]로 수정되었습니다\n");
			}
			else {
				System.out.println("선택한 문자Type과 입력한 문자형태가 불일치 합니다.\n");
			}
		}
		else {
			System.out.println("노트에 기재되지 않은 번호입니다.");
		}		
	}
	
	
	void remove() {
		if(engArr.size() == 0 && korArr.size() == 0) {
			System.out.println("삭제할 단어가 없습니다.");
			return;
		}
		
		search();
		
		System.out.println();
		System.out.println("삭제할 문자 Type 선택");
		System.out.println("[1. 영어]  [2. 한글]");
		String inputNum = scan.nextLine(); 
		
		if(inputNum.equals("1") && engArr.size() == 0) {
			System.out.println("빈 단어장입니다.");
			return;
		}
		else if(inputNum.equals("2") && korArr.size() == 0) {
			System.out.println("빈 단어장입니다.");
			return;
		}
		
		System.out.print("삭제할 문자의 번호를 입력하세요 : ");
		int selNum = scan.nextInt(); 
		if(inputNum.equals("1") && selNum <= engArr.size()){
			System.out.println("영어 문자 [" + engArr.get(selNum - 1) + "] 가 삭제되었습니다.");
			engArr.remove(selNum - 1);
		}
		else if(inputNum.equals("2") && selNum <= korArr.size()){
			System.out.println("한글 문자 [" + korArr.get(selNum - 1) + "] 가 삭제되었습니다.");
			korArr.remove(selNum - 1);
		}
		else {
			System.out.println("존재하지 않는 번호입니다.");
		}
		
	}

	
	void search() {
		System.out.println("\n[영어 단어장]");
		if(engArr.size() == 0) {
			System.out.println("빈 단어장입니다.");
		}
		else {
			for (int i = 0; i < engArr.size(); i++) {
				System.out.print((i+1) + "." + engArr.get(i) + " ");
			}
			System.out.println();
		}
		
		System.out.println("\n[한글 단어장]");
		if(korArr.size() == 0) {
			System.out.println("빈 단어장입니다.");
		}
		else {
			for (int i = 0; i < korArr.size(); i++) {
				System.out.print((i+1) + "." + korArr.get(i) + " ");
			}
			System.out.println();
		}
	}
	
	
	boolean checkCharType(String inputNum, String inputData) {
		boolean isCorr = false;
		String wordType = inputData.substring(0, 1);
		int length = wordType.getBytes().length;

		if(inputNum.equals("1")) {
			if(length == 1) {
				isCorr = true;
			}
			else {
				isCorr = false;
			}
		}
		
		else if(inputNum.equals("2")) {
			if(length == 3) {
				isCorr = true;
			}
			else {
				isCorr = false;
			}
		}
		return isCorr;
	}
	
	
	
}
