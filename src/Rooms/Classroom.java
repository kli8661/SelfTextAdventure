package Rooms;

import People.Student;

public class Classroom extends Room {

	public Classroom(int x, int y) {
		super(x, y);
	}

	@Override
	public void enterRoom(Student x) {

		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("You found a classroom.");
		entered++;
	}

	/**
	 * Removes the player from the room.
	 * @param x
	 */
	public void leaveRoom(Student x)
	{
		occupant = null;
		entered++;
	}

	public String ifEntered(Student x)
	{
		if(entered > 0)
		{
			return "You have already entered this room!";
		}
		return "";
	}
}
