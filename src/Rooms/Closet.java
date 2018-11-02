package Rooms;

import Game.Runner;
import People.Student;

public class Closet extends Hallway implements RoomType {

    public Closet(int x, int y) {
        super(x, y);

    }

    @Override
    public void enterRoom(Student x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found a closet.");
    }
}
