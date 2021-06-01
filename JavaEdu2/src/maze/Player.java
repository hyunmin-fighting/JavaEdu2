package maze;

public class Player {
	int posX;
	int posY;
	
	String name;
	boolean redKey;
	boolean blueKey;
	
	public Player(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public boolean chk(int value) {
		boolean result = false;
		if (value == 1) {
			result = true;
		} else if (value == 2) {
			if (redKey == true) {
				result = true;
			} else {
				System.out.println("레드 키가 필요하다");
			}
		} else if (value == 3) {
			if (blueKey == true) {
				result = true;
			} else {
				System.out.println("블루 키가 필요하다");
			}
		} else {
			System.out.println("못 간다 이놈아");
		}
		return result;
	}
	
	public void right(Room[][] map) {
		if(chk(map[posX][posY].right)) {
			posX++;
		}
	}
	
	public void left(Room[][] map) {
		if(chk(map[posX][posY].left)) {
			posX--;
		}
	}
	
	public void down(Room[][] map) {
		if(chk(map[posX][posY].down)) {
			posY++;
		}
	}
    
	public void up(Room[][] map) {
		if(chk(map[posX][posY].up)) {
			posY--;
		}
	}
	
}
