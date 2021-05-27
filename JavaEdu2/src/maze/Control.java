package maze;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Control {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	int[] ranData = new int[15];
	boolean[] isDuple = new boolean[20];
	
	public void start() {
		int posX = 2;
		int posY = 2;

		for (int i = 0; i < 15; i++) {
			int ranValue = ran.nextInt(20);
			if(!isDuple[ranValue]) {
				ranData[i] = ranValue;
				isDuple[ranValue] = true;
			}
			else {
				i--;
			}
		}
//		System.out.println(Arrays.toString(ranData));

		while (true) {
			
			print();
			
			System.out.println();
			System.out.println("현재 위치 [" + posX + "][" + posY + "]");
			System.out.println("어디갈래?");
			System.out.println("1. 위  2. 아래 3. 왼  4. 오");
			String input = scan.nextLine();
			if (input.equals("1")) {
				if (posY > 0) {
					posY--;
				}else {
					System.out.println("못 간다 이놈아");
				}
			}
		}
	}
	
	public void print() {
		System.out.println("[게임판]");
		for (int i = 1; i <= 25; i++) {
			if(i == 8) {
				System.out.print("P ");
			}
			else {
				System.out.print("_ ");
			}			
			if(i == 5 || i == 10 || i == 15 || i == 20 ) {
				System.out.println("");
			}
		}
	}
	
	
}
