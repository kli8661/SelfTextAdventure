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
		if(!entered)
		{
			System.out.println("You found a classroom.");
		}
		else
		{
			System.out.println("You found this classroom already.");
		}
	}

	/**
	 * Removes the player from the room.
	 * @param x
	 */
	public void leaveRoom(Student x)
	{
		occupant = null;
		entered = true;
	}
}
