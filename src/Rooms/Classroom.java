package Rooms;

import People.Student;

public class Classroom extends Hallway {

	public Classroom(int x, int y) {
		super(x, y);
	}

	/**
	 * Triggers the game ending conditions.
	 * @param x the Student entering
	 */
	@Override
	public void enterRoom(Student x) {

		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("You found a classroom!");
	}

	/**
	 * Removes the player from the room.
	 * @param x
	 */
	public void leaveRoom(Student x)
	{
		occupant = null;
	}
}
