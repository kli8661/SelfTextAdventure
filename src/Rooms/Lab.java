package Rooms;

import People.Student;

import java.util.Scanner;

public class Lab extends Room {

	public Lab(int c, int d) {
		super(c, d);

	}

	@Override
	public void enterRoom(Student x) {

		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		Scanner question = new Scanner(System.in);
		while(!entered) {
			System.out.println("You stumbled upon a lab!");
			System.out.println("Here's a multiple choice question for you.");
			System.out.println("What do you do during if fire gets on your clothing?");
			System.out.println("Type in 'a' 'b' 'c' or 'd' for your multiple choice answer.");
			System.out.println("a) Run around and scream.");
			System.out.println("b) Drop and roll to extinguish the fire.");
			System.out.println("c) Have someone pour water on you");
			System.out.println("d) Call your mother.");
			String answer = question.nextLine();
			if (answer == "b")
			{
				System.out.println("Correct answer, you got a key fragment, combine them all to get out!");
				key++;
			}
			else
			{
				if (answer == "a" || answer == "c" || answer == "d") {
					System.out.println("Wrong answer, try again");
					question.nextLine();
				}
				else
					{

						System.out.println("Input a valid answer!");
						question.nextLine();
					}
			}

			question.close();
			entered = true;
		}
		if(entered)
		{
			System.out.println("You've entered this lab already.");
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
		String labstr = "[Lab]";
		return labstr;
	}
}
