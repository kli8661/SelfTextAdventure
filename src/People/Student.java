package People;

/**
 * Student represents the player as they move through the game.
 */
public class Student {
	private int xLoc, yLoc;
	private int key;

	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

	//Gets and sets key values so user can collect them and get out the building.
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Student(int xLoc, int yLoc)
	{
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}
}
