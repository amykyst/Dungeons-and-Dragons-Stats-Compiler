/*  by amykyst
    May 20, 2019
    4fun         */

// Main class in this project.

public class GetStats {

  public static void main(String[] args) {

    // level int determines skill bonuses for proficiency
    int level = 1;
    // create a new Attributes object for a player of level "level"
    Attributes player_attributes = new Attributes(level);
    // print out the attributes
    System.out.println(player_attributes.toString());
    // print out the skills (done separately to be more modular)
    System.out.println(player_attributes.getListOfSkills());
  }
}
