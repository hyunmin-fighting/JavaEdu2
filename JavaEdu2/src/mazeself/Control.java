package mazeself;

import java.util.ArrayList;
import java.util.Scanner;

public class Control {
	// player 객체를 담을 'p' ArrayList 선언 
	// Room 객체를 담을 2차원 'map' 배열 선언	
	ArrayList<Player> player = new ArrayList<Player>();	
	Room[][] map = new Room[5][4];						
	// 순번 변수 선언
	int turn;	
	
	public void play() {
		// 순번 초기화
		turn = 0;
		// 2차원 'map' 배열크기만큼의 Room 객체 생성 (20개) 
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Room();
			}
		}
	
		// 생성된 각각의 Room객체의 문위치 속성 정의(서버로 부터 Data다운 받아 업데이트 영역)
		// 0:문없음_Default값, 1:일반문, 2:레드문, 3:블루문
		map[0][0].setRight(1);
		map[1][0].setLeft(1);
		map[1][0].setRight(1);
		map[2][0].setLeft(1);
		map[2][0].setRight(1);
		map[2][0].setDown(1);
		map[3][0].setLeft(1);
		map[3][0].setRight(1);
		map[4][0].setLeft(1);
		
		map[2][1].setUp(1);
		map[2][1].setDown(1);

		map[0][2].setDown(2);
		map[2][2].setRight(1);
		map[2][2].setUp(1);
		map[2][2].setDown(1);
		map[3][2].setLeft(1);
		map[4][2].setDown(3);
		
		map[0][3].setRight(1);
		map[0][3].setUp(2);
		map[1][3].setLeft(1);
		map[1][3].setRight(1);
		map[2][3].setLeft(1);
		map[2][3].setRight(1);
		map[2][3].setUp(1);
		map[3][3].setLeft(1);
		map[3][3].setRight(1);
		map[4][3].setLeft(1);
		map[4][3].setUp(3);

		// 생성된 각각의 Room객체의 Event Type 속성 정의(서버로 부터 Data다운 받아 업데이트 영역)
		// 1:영어문제+정답시 레드키 획득, 2: 블루키획득, 3: 게임클리어
		map[4][0].setEventType(1);
		map[0][2].setEventType(2);
		map[4][2].setEventType(3);
		
		Scanner scan = new Scanner(System.in);
		// Player 객체 생성 & ArrayList에 추가
		Player p1 = new Player(2,2);
		Player p2 = new Player(2,2);
		p1.setName("김현민");
		p2.setName("김가현");
		player.add(p1);
		player.add(p2);	

		while(true) {
			// 현재 순번의 객체를 p 참조변수로 복사
			Player p = player.get(turn);
			// 이동 전 좌표 출력
			System.out.println("[" + p.getName() + "]님의 이동 전 위치 : [" + p.getPosX() + "," + p.getPosY() + "]");
			
			System.out.println("[" + p.getName() + "]님, 이동 방향을 선택하세요");
			System.out.println("1.상, 2.하, 3.좌, 4.우, 5.게임 포기");
			System.out.print("[입력 >>>] ");
			String input = scan.nextLine();
			
			// (이동전 행위_메서드) 
			// Player객체의 move 메서드 호출
				 if(input.equals("1")) p.moveUp(map);
			else if(input.equals("2")) p.moveDown(map);
			else if(input.equals("3")) p.moveLeft(map);
			else if(input.equals("4")) p.moveRight(map);
			else if(input.equals("5")) {System.out.println("[" + p.getName() + "]님이 게임을 포기하였습니다."); break;}
			
			// 이동 후 좌표 출력
			System.out.println("[" + p.getName() + "]님의 이동 후 위치 : [" + p.getPosX() + "," + p.getPosY() + "]");
			
			// (이동후 행위_메서드) 
			// Room객체의 checkRoomEvent 메서드 호출(player객체를 매개변수로 포함)
			boolean win = map[p.getPosX()][p.getPosY()].checkRoomEvent(p);
			if(win) break;
			
			// 게임Turn 돌리기 
			turn++;
			System.out.println("======================================\n");
			if(player.size() == turn) {
				turn = 0;
			}
		}
		
	}
	
}
