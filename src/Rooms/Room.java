package Rooms;

import People.Student;

import static Game.Runner.gameOff;

public class Room {
    Student occupant;
    int xLoc,yLoc;
    boolean entered;
    int key;

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
        x.setKey(this.key);
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
        if(key == 3)
        {
            gameOff();
        }
    }

    public String toString()
    {
        String hallwaystr = "[Hallway]";
        return hallwaystr;
    }
}
