/*  by amykyst
    May 20, 2019
    4fun         */

// This class works as a very simple object to store skills with mods.

public class Skills {

  private String name;
  private int modifier;

  public Skills() {
    name = "unknown";
    modifier = 0;
  }

  public Skills(String n, int m) {
    name = n;
    modifier = m;
  }

  public String toString() {
    return name + ": " + modifier;
  }

}
