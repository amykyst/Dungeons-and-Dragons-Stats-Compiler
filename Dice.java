/*  by amykyst
    May 20, 2019
    4fun         */

// Some Math.random to get pseudo-random rolls on any-size dice.

public class Dice {

  private int min = 1;
  public int roll;

  // standard die is d6; min: 1, max: 6
  public Dice () {
    roll = (int)(Math.random()*6) + 1;
  }

  // constructor for handling d4, d8, d20, etc. die
  public Dice (int max) {
    roll = (int)( Math.random()*((max-min)+1) ) + min;
  }

  public String toString() {
    return "" + roll;
  }

}
