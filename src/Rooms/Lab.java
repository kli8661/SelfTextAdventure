package Rooms;

import People.Student;

import java.util.Scanner;

import static Game.Runner.gameOff;

public class Lab extends Room {

	public Lab(int c, int d) {
		super(c, d);

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
				this.key++;
				System.out.println("You currently have " + key + " key fragment(s).");
			}
			else {
				while(!answer.equals("j"))
				{
					System.out.println("Wrong answer, try again.");
					answer = question.nextLine();
					if(answer.equals("j"))
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
			System.out.println("You've already answered a question in this lab.");
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

}
