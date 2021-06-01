package mazeself;

public class Player {

	// Player속성1 : 좌표
	private int posX;
	private int posY;	
	// Player속성2 : 이름
	private String name;
	// Player속성3 : 레드키/블루키 보유여부
	private boolean redKey;
	private boolean blueKey;
	// Player속성4 : 맵정보
	private Room[][] map;

	// 생성자
	public Player(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public boolean chkDir(int value) {
		
		boolean result = false;
		
		// 이동하는 방향에 일반문이 있으면..
		if(value == 1) result = true;							
		
		// 이동하는 방향에 레드문이 있으면..
		else if(value == 2) {
			//현재 Player가 레드키를 가지고있으면 이동가능..
			if(isRedKey()) result = true;							
			//현재 Player가 레드키를 가지고 있지 않으면 이동 불가능..
			else System.out.println("!!!!!레드키가 없습니다!!!!!");
		}
		
		// 이동하는 방향에 블루문이 있으면..
		else if(value == 3) {
			//현재 Player가 블루키를 가지고있으면 이동가능..
			if(isBlueKey()) result = true;
			//현재 Player가 블루키를 가지고 있지 않으면 이동 불가능..
			else System.out.println("!!!!!블루키가 없습니다!!!!!");
		}
		
		// 기타
		else System.out.println("!!!!!이동할 수 없습니다!!!!!");
		
		return result;
	}
	

	// Player행위(메서드)1 : 위로 이동
	public void moveUp(Room[][] map) {
		if(chkDir(map[posX][posY].getUp())) posY--;
	}

	// Player행위(메서드)2 : 아래로 이동
	public void moveDown(Room[][] map) {
		if(chkDir(map[posX][posY].getDown())) posY++;
	}
	
	// Player행위(메서드)3 : 왼쪽으로 이동
	public void moveLeft(Room[][] map) {
		if(chkDir(map[posX][posY].getLeft())) posX--;
	}
	
	// Player행위(메서드)4 : 오쪽으로 이동
	public void moveRight(Room[][] map) {
		if(chkDir(map[posX][posY].getRight())) posX++;
	}
	

	
	// getter, setter
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRedKey() {
		return redKey;
	}

	public void setRedKey(boolean redKey) {
		this.redKey = redKey;
	}

	public boolean isBlueKey() {
		return blueKey;
	}

	public void setBlueKey(boolean blueKey) {
		this.blueKey = blueKey;
	}
	
	

	
	
}
