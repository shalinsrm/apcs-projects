import java.awt.RadialGradientPaint;
import javax.swing.plaf.basic.BasicBorders;
import kareltherobot.*;
import java.util.Scanner;

public class Main implements Directions{
  public static void main(String[] args) {
    World.setVisible(true);// allows us to see the run
    World.setDelay(1);

    // The line below creates a Robot that we will refer to as r.  
    // Find out what the numbers and direction do!
		
    Scanner input = new Scanner(System.in);
    System.out.print("Size: ");
  
    
    int size = input.nextInt();
    size = size-1;

    int grid_size = 2 * (size + 2);

    World.setSize(grid_size, grid_size);
    Robot r = new Robot(1,grid_size/2,North,infinity);

    // Bottom Left

    int number_of_reps = size;
    for (int j = 1; j <= number_of_reps; j++) {
    
      for (int i = 1; i <= size; i++) {
        up_left(r);
      }

      // Top Left

      for (int i = 1; i <= size; i++) {
        up_right(r);
      }

      // Top Right

      for (int i = 1; i <= size; i++) {
        down_right(r);
      }

      // Bottom Left

      for (int i = 1; i <= size; i++) {
        down_left(r);
      }

      r.move();
      size = size-1;

    }

    r.putBeeper();

  }

  public static void up_left(Robot r) {
      r.putBeeper();
      r.turnLeft();
      r.move();
      r.turnLeft();
      r.turnLeft();
      r.turnLeft();
      r.move();
    }

    public static void up_right(Robot r) {
      r.putBeeper();
      r.turnLeft();
      r.turnLeft();
      r.turnLeft();
      r.move();
      r.turnLeft();
      r.move();
    }

    public static void down_right(Robot r) {
      r.putBeeper();
      r.turnLeft();
      r.turnLeft();
      r.turnLeft();
      r.move();
      r.turnLeft();
      r.turnLeft();
      r.turnLeft();
      r.move();
      r.turnLeft();
      r.turnLeft();
    }

    public static void down_left(Robot r) {
      r.putBeeper();
      r.turnLeft();
      r.move();
      r.turnLeft();
      r.move();
      r.turnLeft();
      r.turnLeft();
    }

}