package maze;

import java.util.Scanner;

public class Control {

	public void start() {
		int posX = 2;
		int posY = 2;
		Scanner scan = new Scanner(System.in);

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
			System.out.print("___ㅣ ");
			if(i == 5 || i == 10 || i == 15 || i == 20 ) {
				System.out.println("");
			}
			
		}
	}
	
	
}
