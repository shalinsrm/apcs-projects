import java.awt.Robot;
import java.util.Scanner;  //may be necessary for input

import javax.swing.JOptionPane;  //may be necessary for input

import kareltherobot.*;

public class Driver implements Directions {
// declared here so it is visible in all the methods!! 
// It will be assigned a value in the getInfo method
	// private static Robot roomba; 


	// You will add very many variables!!

	 
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		Driver d = new Driver();

		Scanner worldFileInput = new Scanner(System.in);
  	System.out.print("World File name (needs to be exact): ");
  	String worldFile = worldFileInput.nextLine();

		String wrldName = worldFile;

		World.readWorld(wrldName);
		World.setVisible(true);
		World.setDelay(0);

		Scanner initialXInput = new Scanner(System.in);
  	System.out.print("X Coordinate of Robot: ");
  	int initialX = initialXInput.nextInt();

		Scanner initialYInput = new Scanner(System.in);
  	System.out.print("Y Coordinate of Robot: ");
  	int initialY = initialYInput.nextInt();

		Scanner directionInput = new Scanner(System.in);
  	System.out.print("Select the number of the direction you want the robot to face initially. North(1), East(2), South(3), West(4). ");
  	int direction = directionInput.nextInt();

		Robot roomba;
		if (direction == 1) {
			roomba = new Robot(initialY,initialX,North,0);
		}
		else if (direction == 2) {
			roomba = new Robot(initialY,initialX,East,0);
		}
		else if (direction == 3) {
			roomba = new Robot(initialY,initialX,South,0);
		}
		else {
			roomba = new Robot(initialY,initialX,West,0);
		}

		while (roomba.frontIsClear()) {
            roomba.move();
        }
         
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.turnLeft();
        
		while (roomba.frontIsClear()) {
				roomba.move();
		}

		roomba.turnLeft();
		roomba.turnLeft();
		roomba.turnLeft();


		int traversal = 1;
		int beeperCount = 0;
		int numberOfPiles = 0;
		int largestPile = 0;
		int largestPileX = 0;
		int largestPileY = 0;
 
		while (true) {

			if (roomba.nextToABeeper()) { 
				numberOfPiles += 1;
				int currentPileSize = 0;
		
				while (roomba.nextToABeeper()) {
				roomba.pickBeeper();
				beeperCount+=1;
				currentPileSize += 1;
				}
				
				if (currentPileSize > largestPile) {
					largestPile = currentPileSize;
					largestPileX = roomba.avenue();
					largestPileY = roomba.street();
				}
			}

			while (roomba.frontIsClear()) {
				roomba.move();
				
				if (roomba.nextToABeeper()) {
					numberOfPiles += 1;
					int currentPileSize = 0;
				
					while (roomba.nextToABeeper()) {
							roomba.pickBeeper();
							beeperCount+=1;
							currentPileSize +=1;
					}

					if (currentPileSize > largestPile) {
            largestPile = currentPileSize;
            largestPileX = roomba.avenue();
            largestPileY = roomba.street();
					}
				}
			}

			if (traversal % 2 == 1) {
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();
				if (roomba.frontIsClear()) {
				roomba.move();
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();
				}

				traversal += 1;
			}
			else {
				roomba.turnLeft();
				if (roomba.frontIsClear()) {
				roomba.move();
				roomba.turnLeft();
				traversal += 1;
				}
				else {
					break;
				}
			}
		}
		System.out.println(beeperCount);
		System.out.println(numberOfPiles);

		//calculating area 

		int boxWidth = 0;
		int boxHeight = 0;
	
		while (!roomba.facingSouth()) {
			roomba.turnLeft();
		}
		while (roomba.frontIsClear()) {
			roomba.move();
		}
		while (!roomba.facingWest()) {
			roomba.turnLeft();
		}
		while (roomba.frontIsClear()) {
			roomba.move();
		}

		roomba.turnLeft();
		roomba.turnLeft();

		while (roomba.frontIsClear()) {
			roomba.move();
			boxWidth+=1;
		}
		roomba.turnLeft();

		while (roomba.frontIsClear()) {
			roomba.move();
			boxHeight+=1;
		}

		boxHeight+=1;
		boxWidth+=1;
		int boxArea = (boxHeight * boxWidth);
		double averagePileSize = (double)beeperCount / (double)numberOfPiles;
		double percentDirty = ((double)numberOfPiles / (double)boxArea);

		System.out.println("The Area is " + boxArea + " square units");
		System.out.println("The total number of piles is " + numberOfPiles);
		System.out.println("The total number of beepers is " + beeperCount);
		System.out.println("The largest pile of beepers has " + largestPile + " beepers");
		System.out.println("The largest pile is at avenue: " + largestPileX + " street: " + largestPileY);
		System.out.println("Box Width " + boxWidth);
		System.out.println("Box Height " + boxHeight);
		System.out.println("The average pile size is " + averagePileSize);
		System.out.println("The fraction dirty is " + percentDirty);
		System.out.println("The percent dirty is " + (percentDirty*100) + "%");
		
	}
}