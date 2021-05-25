package day3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Quiz[] quizArr = new Quiz[3];
			
		quizArr[0] = new Quiz("한국의 수도는?", "부산", "서울", "인천", "제주도", "2");
		quizArr[1] = new Quiz("1+1?", "10", "5", "1", "2", "4");
		quizArr[2] = new Quiz("사과?", "banana", "apple", "aaa", "bbbbb", "2");

		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < quizArr.length; i++) {
			System.out.println("문제. " + quizArr[i].question);
			System.out.println(" 1) " + quizArr[i].ch1);
			System.out.println(" 2) " + quizArr[i].ch2);
			System.out.println(" 3) " + quizArr[i].ch3);
			System.out.println(" 4) " + quizArr[i].ch4);

			System.out.println("-------------------");

			// String answerStr = answer[i];
			// // 키 입력
			// String input = scan.nextLine();
			// // 정답 비교
			// if (answerStr.equals(input)) {
			// // 정답
			// } else {
			// // 오답
			// }
		}

	}

}

