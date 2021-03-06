package Rooms;

import Game.Runner;
import People.Student;

import java.util.Scanner;

public class Lab extends Room {

	public Lab(int c, int d) {
		super(c, d);

	}

	@Override
	//Student answers question upon entering the lab.
	public void enterRoom(Student x) {

		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		Scanner question = new Scanner(System.in);
		if(!entered)
		{
			System.out.println("You stumbled upon a lab!");
			System.out.println("Here's a multiple choice question for you.");
			System.out.println("What do you do during if fire gets on your clothing?");
			System.out.println("Type in 'i', 'j', 'k' or 'l' for your multiple choice answer.");
			System.out.println("i) Run around and scream.");
			System.out.println("j) Drop and roll to extinguish the fire.");
			System.out.println("k) Have someone pour water on you");
			System.out.println("l) Call your mother.");
			String answer = question.nextLine();
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
			System.out.println("You've already answered a question in this lab.");
			System.out.println("You have " + x.getKey() + " key fragment(s).");
			if(x.getKey() == 3)
			{
				System.out.println("You have found all the key fragments and escaped the school!");
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
