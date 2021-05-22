package day2;

import java.util.Arrays;
import java.util.Random;

public class Lotto2 {

	public static void main(String[] args) {

		/* 1~45 중복되지 않는 숫자 6개 로또 */
		
		Random ran = new Random();
		
		int[] data = new int[6];
		boolean[] idx = new boolean[46];
		int i = 0;
		
		while(true) {
			int ranNum = ran.nextInt(45)+1;
			boolean isDuple = false;
			//랜덤번호의 인덱스 불리언값 확인
			//인덱스 불리언값이 false면 중복되지 않은 상태이고 인덱스 불리언 값을 true로 변환
			if(idx[ranNum] == false) {
				idx[ranNum] = true;
				isDuple = false;
				data[i] = ranNum;
				i++;
			}
			// 인덱스 불리언값이 true로 중복된 상태
			else {
				isDuple = true;
			}

			// i값이 6이면 While루프 종료
			if(i == 6) {
				break;
			}
		}
		System.out.println(Arrays.toString(data));
		
	}
}

