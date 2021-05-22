package day2;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {

		/* 1~45 중복되지 않는 숫자 6개 로또 */
		
		Random ran = new Random();
		int[] data = {-1, -1, -1, -1, -1, -1};
		boolean isDuple = false;

		for (int i = 0; i < 6; i++) {
			while(true) {
				int ranNum = ran.nextInt(45)+1; 
				//중복확인
				for (int j = 0; j < data.length; j++) {
					if(ranNum == data[j]) {
						isDuple = true;
						break;
					}
				}
				//중복이 됬으면...
				if(isDuple == true) {
					isDuple = false;
					continue;
				}
				//중복이 안됬으면...
				else {
					data[i] = ranNum;
					break;
				}	
			} //While문 종료
		}	//For문 종료
		
		//화면출력..
		System.out.println(Arrays.toString(data));
	}
}
