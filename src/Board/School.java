package Board;

import Rooms.Classroom;
import Rooms.Closet;
import Rooms.Hallway;
import Rooms.Lab;

public class School {

    private String[][] school;

    public School(String[][] school)
    {
        this.school = school;
    }

    public void edit(String replace, int row, int column)
    {
        school[row][column] = replace;
    }

    public void fill(String str)
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
