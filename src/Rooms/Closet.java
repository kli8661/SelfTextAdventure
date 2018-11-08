package Rooms;

import Game.Runner;
import People.Student;

import java.util.Scanner;

public class Closet extends Room {

    public Closet(int a, int b) {
        super(a, b);

    }

    @Override
    public void enterRoom(Student x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        Scanner question = new Scanner(System.in);
        if(!entered)
        {
            System.out.println("You fell into a closet!");
            System.out.println("Here's a multiple choice question for you.");
            System.out.println("What doesn't belong in a closet?");
            System.out.println("Type in 'i', 'j', 'k' or 'l' for your multiple choice answer.");
            System.out.println("i) T-Shirts.");
            System.out.println("j) Prom Dress.");
            System.out.println("k) Big Mac Sandwich.");
            System.out.println("l) A jacket.");
            String answer = question.nextLine();
            if(answer.equals("k"))
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
                while(!answer.equals("k"))
                {
                    System.out.println("Wrong answer, try again.");
                    answer = question.nextLine();
                    if(answer.equals("k"))
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
            System.out.println("You found this closet already.");
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
        if(x.getKey() == 3)
        {
            System.out.println("You have found all the keys and escaped the school!");
            Runner.gameOff();
        }
    }

    public String toString()
    {
        String closetstr = "[Closet]";
        return closetstr;
    }
}
