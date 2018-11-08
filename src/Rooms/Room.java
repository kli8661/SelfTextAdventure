package Rooms;

import Game.Runner;
import People.Student;

import static Game.Runner.gameOff;

public class Room {
    Student occupant;
    int xLoc,yLoc;
    boolean entered;

    public Room(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }

    public Room(boolean entered)
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
        entered = true;
    }

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveRoom(Student x)
    {
        occupant = null;
        entered = true;
        if(x.getKey() == 3)
        {
            System.out.println("You have found all the keys and escaped the school!");
            Runner.gameOff();
        }
    }

    public String toString()
    {
        String hallwaystr = "[Hallway]";
        return hallwaystr;
    }
}
