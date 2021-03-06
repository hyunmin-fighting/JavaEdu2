package mazeself;

import java.util.Scanner;

public class Room {

	Scanner scan = new Scanner(System.in);
	
	//Room속성1 : (이동전)현재방의 문 종류 및 위치 ( 0:없다, 1:일반문, 2:레드문, 3:블루문)
	private int up;
	private int down;
	private int left;
	private int right;
	
	//Room속성2 : (이동후)이동후 방의 이벤트 Type (1:영어퀴즈+정답시 1번열쇠 획득, 2:도착시 2번열쇠 획득_레드문 통과시, 3:게임클리어)   
	private int eventType;
	
	//Room행위(메서드)1 : Room에 있는 Event 확인 
	public boolean checkRoomEvent(Player player) {
		boolean win = false;
		
		if(eventType == 1) {
			System.out.println("영어퀴즈!");
			System.out.print("사과의 스펠링은 ? : ");
			String input = scan.nextLine();
			
			if(input.equals("apple")) {
				//정답
				player.setRedKey(true);
				System.out.println("정답 >> 레드키를 획득하였습니다.");
			}
			else {
				//오답
				System.out.println("오답입니다.");	
			}	
		}
		
		// B위치 도착 : 블루키 획득
		else if(eventType == 2) {
			player.setBlueKey(true);
			System.out.println("블루키를 획득하였습니다.");
		}
		
		// F위치 도착 : 게임 클리어
		else if(eventType == 3) {
			System.out.println("[" + player.getName() + "]님이 게임을 승리하였습니다.");
			win = true;
		}
		
		return win;
	}
	

	
	
	
	//getter, Setter
	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getEventType() {
		return eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}
	
	
	
}
