package voca;


import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {		
		Control ctl = new Control();
		ctl.start();
		
		ArrayList<String> engArr = new ArrayList<>();
		engArr.add("가"); //삽입
		engArr.add("나");
		engArr.add("다");
		engArr.add("라");
		engArr.add(2, "A"); //삽입
		engArr.set(2, "B");  //치환
		int size  = engArr.size(); // 길이
		System.out.println(engArr.get(0)); // 검색
		engArr.remove(1); //1번째 삭제
		engArr.clear();// 몽땅 삭제
	}

}

