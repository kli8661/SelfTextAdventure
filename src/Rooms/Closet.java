package Rooms;

import People.Student;

public class Closet extends Hallway{

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

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveRoom(Student x)
    {
        occupant = null;
    }
}
