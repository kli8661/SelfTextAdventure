package Rooms;

import People.Student;

public class Lab extends Room {

	public Lab(int c, int d) {
		super(c, d);

	}

	@Override
	public void enterRoom(Student x) {

		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		if(!entered)
		{
			System.out.println("You've entered a lab.");
		}
		else
		{
			System.out.println("You've entered this lab already.");
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

	public String toString()
	{
		String labstr = "[Lab]";
		return labstr;
	}
}
