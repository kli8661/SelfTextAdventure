package Board;

import Rooms.Room;

public class School {

    private Room[][] schoolmap;

    public School(Room[][] schoolmap)
    {
        this.schoolmap = schoolmap;
    }

    public String printBoard()
    {
        String boardstr = "";
        for(int i = 0; i < schoolmap.length; i++)
        {
            for(int j = 0; j < schoolmap[i].length; j++)
            {
                boardstr += schoolmap[i][j].toString();
            }
            boardstr += "\n";
        }
        return boardstr;
    }
}
