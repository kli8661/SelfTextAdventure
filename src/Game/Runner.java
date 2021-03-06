package Game;

import Board.School;
import People.Student;
import Rooms.Classroom;
import Rooms.Closet;
import Rooms.Lab;
import Rooms.Room;
import java.util.Scanner;

public class Runner {

	private static boolean gameOn = true;
	
	public static void main(String[] args)
	{
		System.out.println("You woke up in an empty school, and you will need to find different rooms. \nOnce you collect all the clues you will make it out!");
		System.out.println("A trail of where you have been will be shown by a '*'.");

		//Fill the building with normal rooms
		Room[][] school = new Room[7][7];
		for(int x = 0; x < school.length; x++)
		{
			for(int y = 0; y < school[x].length; y++)
			{
				school[x][y] = new Room(x,y);
			}
		}

		//Creates a Classroom
		int x = (int)(Math.random()*school.length);
		int y = (int)(Math.random()*school.length);
		school[x][y] = new Classroom(x,y);

		//Creates Closet
		int a = (int)(Math.random()*school.length);
		int b = (int)(Math.random()*school.length);
		if(a == x && b == y) //Makes sure Closet and such cannot have same coordinates as other rooms.
		{
			a = (int)(Math.random()*school.length);
			b = (int)(Math.random()*school.length);
		}
		school[a][b] = new Closet(a,b);

		//Creates Lab
		int c = (int)(Math.random()*school.length);
		int d = (int)(Math.random()*school.length);
		if(c == x && d == y)
		{
			c = (int)(Math.random()*school.length);
			d = (int)(Math.random()*school.length);
		}
		if(c == a && c == b)
		{
			c = (int)(Math.random()*school.length);
			d = (int)(Math.random()*school.length);
		}
		school[c][d] = new Lab(c,d);

		//Setup player 1 and the input scanner
		Student player1 = new Student(0,0);
		school[0][0].enterRoom(player1);
		School tech = new School(school);
		System.out.print(tech.printBoard());
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			System.out.println("Where would you like to move? (Choose W, A, S, D)");
			String move = in.nextLine();
			if(validMove(move, player1, school))
			{
				System.out.print(tech.printBoard());
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
			}
			else {
				System.out.println("Please choose a valid move.");
			}
		}
		in.close();
	}

	/**
	 * Checks that the movement chosen is within the valid game map.
	 * @param move the move chosen
	 * @param p person moving
	 * @param map the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Student p, Room[][] map)
	{
		move = move.toLowerCase().trim();

		switch (move) {
			case "w":
				if (p.getxLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "d":
				if (p.getyLoc()< map[p.getyLoc()].length -1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "a":
				if (p.getyLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			default:
				break;
					
		}

		return true;
	}
	public static void gameOff()
	{
		gameOn = false;
	}
}
