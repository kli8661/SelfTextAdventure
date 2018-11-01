package Rooms;

import People.Student;

public class Hallway implements Room{
    Student occupant;
    int xLoc,yLoc;

    public Hallway(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Student entering
     */
    public void enterRoom(Student x)
    {
        System.out.println("You enter a hallway");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
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
