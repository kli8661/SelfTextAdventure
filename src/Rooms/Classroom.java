package Rooms;

import Game.Runner;
import People.Student;

public class Classroom extends Hallway implements Room{

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
		System.out.println("You found the winning room! Ten points for Gryffindor.");
		Runner.gameOff();
	}
}
