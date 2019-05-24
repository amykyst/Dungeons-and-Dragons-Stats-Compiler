/*  by amykyst
    May 20, 2019
    4fun         */

// The big daddy class that holds skill names, and does a bunch of shit.

public class Attributes {

  public int[] big6_attributes;
  public int[] big6_modifiers;
  public static String[] big6_att_names = {"STR","DEX","CON","INT","WIS","CHA"};
  private static int len = 6;
  private static int num_of_best_rolls = 3;
  private static String[] skill_names_list = {"Acrobatics","Animal Handling","Arcana","Athletics","Deception","History","Insight","Intimidation","Investigation","Medicine","Nature","Perception","Performance","Persuasion","Religion","Sleight of Hand","Stealth","Survival"};

  private static String[] str_skills_list = {"Athletics"};
  private static String[] dex_skills_list = {"Acrobatics","Sleight of Hand","Stealth"};
  private static String[] con_skills_list = {""};
  private static String[] int_skills_list = {"Arcana","History","Investigation","Nature","Religion"};
  private static String[] wis_skills_list = {"Animal Handling","Insight","Medicine","Perception","Survival"};
  private static String[] cha_skills_list = {"Deception","Intimidation","Performance","Persuasion"};

  public int player_level = 0;
  public int proficiency = 0;

  public Attributes(int level) {
    big6_attributes = getAttributes(new int[len]);
    big6_modifiers = getModifiers(big6_attributes);
    player_level = level;
    setProficiency(player_level);
  }

  public void setProficiency(int level) {
    if (level < 5) proficiency = 2;
    else if (level < 9) proficiency = 3;
    else if (level < 13) proficiency = 4;
    else if (level < 17) proficiency = 5;
    else proficiency = 6;
  }

  private int[] getModifiers(int[] attributes) {
    // using floor of [ (attribute - 10) / 2 ]
    int[] modifiers = new int[attributes.length];
    for (int i = 0; i < attributes.length; i++) {
      if (attributes[i] % 2 == 1) attributes[i]++;
      modifiers[i] = (attributes[i] - 10) / 2;
    }
    return modifiers;
  }

  private int[] getAttributes(int[] new_array) {
    for (int i = 0; i < new_array.length; i++) {
      new_array[i] = getBestRoll3d6();
    }
    return new_array;
  }

  // -------------------------------------------------------------------

  private int getBestRoll3d6() {

    int[] sums = new int[num_of_best_rolls];

    for (int i = 0; i < num_of_best_rolls; i++) {
      int onesum = 0;
      for (int j = 0; j < num_of_best_rolls; j++) {
        Dice d = new Dice();
        onesum += d.roll;
      }
      sums[i] = onesum;
    }

    int best = sums[0];

    for (int k = 0; k < sums.length; k++) {
      if (sums[k] < best) continue;
      else best = sums[k];
    }

    return best;
  }

  // -------------------------------------------------------------------

  public String getListOfSkills() {

    Skills[] skills = new Skills[skill_names_list.length];
    for (int i = 0; i < skills.length; i++) {
      skills[i] = new Skills(skill_names_list[i], getSkillMod(skill_names_list[i]));
    }
    String s = "List of Skills:";
    for (int i = 0; i < skills.length; i++) {
      s += "\n" + skills[i];
    }
    return s;
  }


  public int getSkillMod(String skill_string) {
    int decider = 10;
    for (int i = 0; i < str_skills_list.length; i++) {
      if (str_skills_list[i] == skill_string) decider = 0;
    }
    for (int i = 0; i < dex_skills_list.length; i++) {
      if (dex_skills_list[i] == skill_string) decider = 1;
    }
    for (int i = 0; i < con_skills_list.length; i++) {
      if (con_skills_list[i] == skill_string) decider = 2;
    }
    for (int i = 0; i < int_skills_list.length; i++) {
      if (int_skills_list[i] == skill_string) decider = 3;
    }
    for (int i = 0; i < wis_skills_list.length; i++) {
      if (wis_skills_list[i] == skill_string) decider = 4;
    }
    for (int i = 0; i < cha_skills_list.length; i++) {
      if (cha_skills_list[i] == skill_string) decider = 5;
    }
    if (decider < 10) return big6_modifiers[decider];
    else return 0;
    /* we can later add +proficiency to this return, if the player
    decides they are proficient */
  }


  public String toString() {
    String s = "Big Six:";
    for (int i = 0; i < len; i++) {
      s += "\n" + big6_att_names[i] + ": " + big6_modifiers[i] +
        " (" + big6_attributes[i] + ")";
    }
    return s + "\n";
  }

}
