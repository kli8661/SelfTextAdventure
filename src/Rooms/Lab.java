package Rooms;

import Game.Runner;
import People.Student;

public class Lab extends Hallway implements RoomType
{

	public Lab(int x, int y) {
		super(x, y);

	}

	@Override
	public void enterRoom(Student x) {

		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("You found the lab.");
	}

}
