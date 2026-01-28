package com.lyg.idlescape;

public class SkillProgress {

    private int experience;

    public SkillProgress(int experience){
        this.experience = experience;
    }

    public int getExperience(){
        return experience;
    }

    public void addExperience(int amount){
        experience += amount;
    }

    public int getSkillLevel() {
        double points = 0;
        for (int lvl = 1; lvl <= 99; lvl++) {
            points += Math.floor(lvl + 300.0 * Math.pow(2.0, lvl / 7.0));
            int expNeeded = (int)Math.floor(points / 4);

            if (experience < expNeeded) {
                return lvl;
            }
        }
        return 99;
    }

}
