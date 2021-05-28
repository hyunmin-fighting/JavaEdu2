package maze;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Control {
	int turn;
	ArrayList<Player> player = new ArrayList<>();
	Room[][] map = new Room[5][4];

	public void start() {
		turn = 0;
		
		Player p = new Player(2, 2);
		// 맵 세팅
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				map[i][j] = new Room();
			}
		}

		map[0][0].right = 1;
		map[1][0].left = 1;
		map[1][0].right = 1;
		map[2][0].left = 1;
		map[2][0].right = 1;
		map[2][0].down = 1;
		map[3][0].left = 1;
		map[3][0].right = 1;
		map[4][0].left = 1;

		map[2][1].up = 1;
		map[2][1].down = 1;

		map[0][2].down = 2;
		map[2][2].up = 1;
		map[2][2].down = 1;
		map[3][2].down = 1;
		map[2][2].right = 1;
		map[3][2].left = 1;

		map[0][3].up = 2;
		map[0][3].right = 1;
		map[1][3].left = 1;
		map[1][3].right = 1;
		map[2][3].up = 1;
		map[2][3].right = 1;
		map[2][3].left = 1;
		map[3][3].right = 1;
		map[3][3].left = 1;
		map[4][3].up = 3;
		map[4][3].left = 1;
		
		//이벤트 세팅
		map[4][0].evetType =1;
		map[0][2].evetType =2;
		map[4][2].evetType =3;
		
	

		Scanner scan = new Scanner(System.in);
		Player p1 = new Player(2, 2);
		p1.name ="개똥이";
//		Player p2 = new Player(2, 2);
//		p2.name ="소똥이";
		player.add(p1);
//		player.add(p2);
		while (true) {
			p = player.get(turn);
			
			System.out.println("-----------------");
			System.out.println(p.name+" 현재 위치 [" + p.posX + "][" + p.posY + "]");
			System.out.println("어디갈래?");
			System.out.println("1. 위  2. 아래 3. 왼  4. 오");
			String input = scan.nextLine();
			if (input.equals("1")) {
				if (map[p.posX][p.posY].up == 1) {
					p.posY--;
				} else if (map[p.posX][p.posY].up == 2) {
					if (p.redKey == true) {
						p.posY--;
					} else {
						System.out.println("레드 키가 필요하다");
					}
				} else if (map[p.posX][p.posY].up == 3) {
					if (p.blueKey == true) {
						p.posY--;
					} else {
						System.out.println("블루 키가 필요하다");
					}
				} else {
					System.out.println("못 간다 이놈아");
				}
			} else if (input.equals("2")) {
				if (map[p.posX][p.posY].down == 1) {
					p.posY++;
				} else if (map[p.posX][p.posY].down == 2) {
					if (p.redKey == true) {
						p.posY++;
					} else {
						System.out.println("레드 키가 필요하다");
					}
				} else if (map[p.posX][p.posY].down == 3) {
					if (p.blueKey == true) {
						p.posY++;
					} else {
						System.out.println("블루 키가 필요하다");
					}
				} else {
					System.out.println("못 간다 이놈아");
				}
			} else if (input.equals("3")) {
				if (map[p.posX][p.posY].left == 1) {
					p.posX--;
				} else if (map[p.posX][p.posY].left == 2) {
					if (p.redKey == true) {
						p.posX--;
					} else {
						System.out.println("레드 키가 필요하다");
					}
				} else if (map[p.posX][p.posY].left == 3) {
					if (p.blueKey == true) {
						p.posX--;
					} else {
						System.out.println("블루 키가 필요하다");
					}
				} else {
					System.out.println("못 간다 이놈아");
				}
			} else if (input.equals("4")) {
				if (map[p.posX][p.posY].right == 1) {
					p.posX++;
				} else if (map[p.posX][p.posY].right == 2) {
					if (p.redKey == true) {
						p.posX++;
					} else {
						System.out.println("레드 키가 필요하다");
					}
				} else if (map[p.posX][p.posY].right == 3) {
					if (p.blueKey == true) {
						p.posX++;
					} else {
						System.out.println("블루 키가 필요하다");
					}
				} else {
					System.out.println("못 간다 이놈아");
				}
			} // 이동후

			if (map[p.posX][p.posY].evetType == 1) {
				System.out.println("apple 뜻?");
				input = scan.nextLine();
				if(input.equals("사과")) {
					p.redKey = true;
					System.out.println("정답! 레드키 획득!~");
				}else {
					System.out.println("땡!");
				}
			} else if (map[p.posX][p.posY].evetType == 2) {
				p.blueKey = true;
				System.out.println("정답! 블루키 획득!~");
			} else if (map[p.posX][p.posY].evetType == 3) {
				System.out.println("끝");
				break;
			}

			turn++;
			if(player.size() == turn) {
				turn = 0;
			}
			
		}
	}
}
