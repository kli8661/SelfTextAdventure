package Board;

public class Room {

    private Room[][] school;

    public Room(Room[][] school)
    {
        this.school = school;
    }

    public Room(int x, int y)
    {
        this.school = new Room[x][y];
    }

    public void edit(Room replace, int row, int column)
    {
        school[row][column] = replace;
    }

    public void fill(Room str)
    {
        for(int i = 0; i < school.length; i++)
        {
            for(int j = 0; j < school[i].length; j++)
            {
                school[i][j] = str;
            }
        }
    }

    public String toString()
    {
        String boardstr = "";
        for(int i = 0; i < school.length; i++)
        {
            for(int j = 0; j < school[i].length; j++)
            {
                boardstr += school[i][j];
            }
            boardstr += "\n";
        }
        return boardstr;
    }
}
