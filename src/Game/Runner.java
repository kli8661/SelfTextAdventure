package Game;

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
		//Fill the building with normal rooms
		Room[][] school = new Room[6][6];
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
		System.out.println("Classroom");
		System.out.println(x);
		System.out.println(y);

		//Creates Closet
		int a = (int)(Math.random()*school.length);
		int b = (int)(Math.random()*school.length);
		school[a][b] = new Closet(a,b);
		System.out.println("Closet");
		System.out.println(a);
		System.out.println(b);

		//Creates Lab
		int c = (int)(Math.random()*school.length);
		int d = (int)(Math.random()*school.length);
		school[c][d] = new Lab(c,d);
		System.out.println("Lab");
		System.out.println(c);
		System.out.println(d);

		//Setup player 1 and the input scanner
		Student player1 = new Student("FirstName", "FamilyName", 0,0);
		school[0][0].enterRoom(player1);
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			System.out.println("Where would you like to move? (Choose W, A, S, D)");
			String move = in.nextLine();
			if(validMove(move, player1, school))
			{
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
