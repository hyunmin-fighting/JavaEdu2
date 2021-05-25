package day2;

import java.util.ArrayList;

public class Voca {
	
	ArrayList<String> engArr = new ArrayList<String>();
	ArrayList<String> korArr = new ArrayList<String>();
	
	private String eng;
	private String kor;
	
	public Voca() {}
	
	public Voca(String eng, String kor) {	
		this.eng = eng;
		this.kor = kor;
	}
	
	
	
	
	int size() {
		int size = engArr.size();
		return size;
	}
	
	void add() {
		engArr.add(eng);
		korArr.add(kor);
	}
	
	void update(int i, String data1, String data2) {
		engArr.set(i, data1);
		korArr.set(i, data2);
	}
	
	void remove(int i) {
		engArr.remove(i);
		korArr.remove(i);
	}

	
}	
