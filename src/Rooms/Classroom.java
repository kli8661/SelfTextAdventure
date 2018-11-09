package Rooms;

import Game.Runner;
import People.Student;

import java.util.Scanner;

public class Classroom extends Room {

	public Classroom(int x, int y) {
		super(x, y);
	}

	@Override
    /**
     * Enters room and answers a question.
     */
    public void enterRoom(Student x) {

		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
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
            if(answer.equals("j"))
            {
                System.out.println("Correct answer, you got a key fragment, combine them all to get out!");
                x.setKey(x.getKey() + 1); //Increments key integer if student answers a question correctly, collect all 3 to win the game.
                System.out.println("You currently have " + x.getKey() + " key fragment(s).");
                if(x.getKey() == 3)
                {
                    System.out.println("You have found all the keys and escaped the school!");
                    Runner.gameOff();
                }
            }
            else {
                while(!answer.equals("j"))
                {
                    System.out.println("Wrong answer, try again.");
                    answer = question.nextLine();
                    if(answer.equals("j"))
                    {
                        System.out.println("Correct answer, you got a key fragment, combine them all to get out!");
                        x.setKey(x.getKey() + 1);
                        System.out.println("You currently have " + x.getKey() + " key fragment(s).");
                        if(x.getKey() == 3)
                        {
                            System.out.println("You have found all the keys and escaped the school!");
                            Runner.gameOff();
                        }
                    }
                }
            }
		}
		else
		{
			System.out.println("You've already answered a question in this classroom.");
            System.out.println("You have " + x.getKey() + " key fragment(s).");
            if(x.getKey() == 3)
            {
                System.out.println("You have found all the key fragment and escaped the school!");
                Runner.gameOff();
            }
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
	}

	public String toString()
    {
        if(entered) {
            return "{*}";
        }
        return "{ }";
    }
}
