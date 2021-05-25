package day2;
import java.util.ArrayList;
import java.util.Scanner;

public class Control {
//	ArrayList<String> engArr = new ArrayList<>();
//	ArrayList<String> korArr = new ArrayList<>();
	ArrayList<Voca> vocaArr = new ArrayList<>();
	
	Voca v = new Voca();

	public void showVoca() {
		for (int i = 0; i < v.size(); i++) {
			System.out.println(i + 1 + ". " + v.engArr.get(i) + " : " + v.korArr.get(i));
		}
	}

	public void start() {
		/**
		 * 
		 * 1. 단어 추가 2. 단어 수정 3. 단어 삭제 4. 게임 5. 끝내기
		 * 
		 */

		Scanner scan = new Scanner(System.in);
		String input = "";
		while (true) {
			System.out.println("뭐 할래?");
			System.out.println("1. 추가  2. 수정 3. 삭제 4. 게임 5. 끝");
			input = scan.nextLine();

			if (input.equals("1")) {
				System.out.println("추가할 영어/한글 입력");
				v = new Voca(scan.nextLine(), scan.nextLine());
				v.add();
				showVoca();
				
			} else if (input.equals("2")) {
				showVoca();
				System.out.println("몇 번 수정할래?");
				input = scan.nextLine();
				int tempInt = Integer.parseInt(input)-1;
				System.out.println("수정할 영어/한글 입력");
				v.update(tempInt, scan.nextLine(), scan.nextLine());

				
			} else if (input.equals("3")) {
				showVoca();
				System.out.println("몇 번 삭제할래?");
				input = scan.nextLine();
				int tempInt = Integer.parseInt(input)-1;
				v.remove(tempInt);


			} else if (input.equals("4")) {

			} else if (input.equals("5")) {
				break;
			}
		}
	}
}
