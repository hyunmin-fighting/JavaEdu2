package maze;
import java.util.Random;
import java.util.Scanner;

public class Control {
	Room[][] map = new Room[5][4];

	public void start() {
		Player p = new Player(2, 2);
		// 맵 세팅
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				map[i][j] = new Room();				
			}
		}

		map[0][0].right = 1;
		map[0][2].evetType = 2;
		map[1][0].left = 1;
		map[1][0].right = 1;
		map[2][0].left = 1;
		map[2][0].right = 1;
		map[2][0].down = 1;
		map[3][0].left = 1;
		map[3][0].right = 1;
		map[4][0].left = 1;
		map[4][0].evetType = 1;


		map[2][1].up = 1;
		map[2][1].down = 1;

		map[0][2].down = 2;
		map[2][2].up = 1;
		map[2][2].down = 1;
		map[3][2].down = 1;
		map[2][2].right = 1;
		map[3][2].left = 1;
		map[4][2].down = 3;


		map[0][3].up = 2;
		map[0][3].right = 1;
		map[1][3].left = 1;
		map[1][3].right = 1;
		map[2][3].up = 1;
		map[2][3].right = 1;
		map[2][3].left = 1;
		map[3][3].right = 1;
		map[3][3].left = 1;
		map[4][2].evetType = 3;
		map[4][3].up = 3;
		map[4][3].left = 1;

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("-----------------");
			System.out.println("현재 위치 [" + p.posX + "][" + p.posY + "]");
			System.out.println("어디갈래?");
			System.out.println("1. 위  2. 아래 3. 왼  4. 오");
			String input = scan.nextLine();
			if (input.equals("1")) {
				if (map[p.posX][p.posY].up == 1) {
					p.posY--;
				}
				//빨간문이면..
				else	if (map[p.posX][p.posY].up == 2) {
					if(p.redKey == true) {
						p.posY--;
					}else {
						System.out.println("레드 키가 필요하다");
					}
				}
				//파란문이면..
				else	if (map[p.posX][p.posY].up == 3) {
					if(p.blueKey == true) {
						p.posY--;
					}else {
						System.out.println("블루 키가 필요하다");
					}
				}  
				
				else {
					System.out.println("못 간다 이놈아");
				}
			} 
			
			else if (input.equals("2")) {
				if (map[p.posX][p.posY].down == 1) {
					p.posY++;
				} 
				//빨간문이면..
				else	if (map[p.posX][p.posY].down == 2) {
					if(p.redKey == true) {
						p.posY++;
					}else {
						System.out.println("레드 키가 필요하다");
					}
				}
				//파란문이면..
				else	if (map[p.posX][p.posY].down == 3) {
					if(p.blueKey == true) {
						p.posY++;
					}else {
						System.out.println("블루 키가 필요하다");
					}
				} 
				else {
					System.out.println("못 간다 이놈아");
				}
			} 
			
			
			else if (input.equals("3")) {
				if (map[p.posX][p.posY].left == 1) {
					p.posX--;
				} 
				//빨간문이면..
				else	if (map[p.posX][p.posY].left == 2) {
					if(p.redKey == true) {
						p.posX--;
					}else {
						System.out.println("레드 키가 필요하다");
					}
				}
				//파란문이면..
				else	if (map[p.posX][p.posY].left == 3) {
					if(p.blueKey == true) {
						p.posX--;
					}else {
						System.out.println("블루 키가 필요하다");
					}
				}
				else {
					System.out.println("못 간다 이놈아");
				}
			} 
			
			
			else if (input.equals("4")) {
				if (map[p.posX][p.posY].right == 1) {
					p.posX++;
				} 
				//빨간문이면..
				else	if (map[p.posX][p.posY].right == 2) {
					if(p.redKey == true) {
						p.posX++;
					}else {
						System.out.println("레드 키가 필요하다");
					}
				}
				//파란문이면..
				else	if (map[p.posX][p.posY].right == 3) {
					if(p.blueKey == true) {
						p.posX++;
					}else {
						System.out.println("블루 키가 필요하다");
					}
				}
				else {
					System.out.println("못 간다 이놈아");
				}
			} 
			
			// 이동후
			if (map[p.posX][p.posY].evetType == 1) {
				//영어문제 출제후 맞으면 
				System.out.println("사과를 영어로 쓰세요");
				String answer = scan.next();
				if(answer.equals("apple")) {
					System.out.println("레드 키를 획득하였습니다.");
					p.redKey = true;
					p.posX--;
				}
				else {
					System.out.println("틀렸습니다. 시작위치로 돌아갑니다.");
					p.posX = 2;
					p.posY = 2;
				}
				// A
				
			} else if (map[p.posX][p.posY].evetType == 2) {
				p.blueKey = true;
				// B
				
			} else if (map[p.posX][p.posY].evetType == 3) {
				System.out.println("게임Clear");
				break;
			}

		}
	}
}
