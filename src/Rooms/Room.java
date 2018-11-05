package Rooms;

import People.Student;

public class Room {
    Student occupant;
    int xLoc,yLoc;
    int entered;

    public Room(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }

    public Room(int entered)
    {
        this.entered = entered;
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Student entering
     */
    public void enterRoom(Student x)
    {
        System.out.println("You're in the hallway.");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
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
