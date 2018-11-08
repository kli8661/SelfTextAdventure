package Rooms;

import People.Student;

import java.util.Scanner;

import static Game.Runner.gameOff;

public class Classroom extends Room {

	public Classroom(int x, int y) {
		super(x, y);
	}

	@Override
	public void enterRoom(Student x) {

		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		x.setKey(this.key);
        Scanner question = new Scanner(System.in);
		if(!entered)
		{
            System.out.println("You found a normal looking classroom, but there's a question on the board.");
            System.out.println("The board says...");
            System.out.println("What are the roots of x^2 + 7x - 30?");
            System.out.println("Type in 'i', 'j', 'k' or 'l' for your multiple choice answer.");
            System.out.println("i) (10, -3)");
            System.out.println("j) (-10, 3)");
            System.out.println("k) (5, 15)");
            System.out.println("l) (7, -8)");
            String answer = question.nextLine();
            if(answer.equals("i"))
            {
                System.out.println("Correct answer, you got a key fragment, combine them all to get out!");
                key++;
                System.out.println("You currently have " + key + " key fragment(s).");
            }
            else {
                while(!answer.equals("i"))
                {
                    System.out.println("Wrong answer, try again.");
                    answer = question.nextLine();
                    if(answer.equals("i"))
                    {
                        System.out.println("Correct answer, you got a key fragment, combine them all to get out!");
                        this.key++;
                        System.out.println("You currently have " + key + " key fragment(s).");
                    }
                }
            }
		}
		else
		{
			System.out.println("You've already answered a question in this classroom.");
            System.out.println("You have " + key + " key fragment(s).");
		}
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
		String classstr = "[Classroom]";
		return classstr;
	}
}
