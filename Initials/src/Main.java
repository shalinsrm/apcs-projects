import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import kareltherobot.*;

public class Main implements Directions{
  public static void main(String[] args) {
    World.setVisible(true);// allows us to see the run

    // The line below creates a Robot that we will refer to as r.  
    // Find out what the numbers and direction do!
    Robot r = new Robot(9,5,West,100);
		
    // examples of commands you can invoke on a Robot// move one step in the direction it is facing
    r.putBeeper();
    r.move();
    r.putBeeper();
    r.move();
    r.putBeeper();
    r.move();
    r.putBeeper();
    r.turnLeft();
    r.move();
    r.turnLeft();
    r.turnLeft();
    r.turnLeft();
    r.move();
    r.putBeeper();
    r.turnLeft();
    r.move();
    r.turnLeft();
    r.move();
    r.putBeeper();
    r.move();
    r.turnLeft();
    r.turnLeft();
    r.turnLeft();
    r.move();
    r.putBeeper();
    r.turnLeft();
    r.move();
    r.turnLeft();
    r.turnLeft();
    r.turnLeft();
    r.move();
    r.putBeeper();
    r.turnLeft();
    r.move();
    r.putBeeper();
    r.turnLeft();
    r.turnLeft();
    r.turnLeft();
    r.move();
    r.putBeeper();
    r.move();
    r.putBeeper();
    r.move();
    r.turnLeft();
    r.turnLeft();
    r.turnLeft();
    r.move();
    r.putBeeper();

  }
}