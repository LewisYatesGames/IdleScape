package com.lyg.idlescape;

import java.util.EnumMap;
import java.util.Map;

public class Player {

    private final Map<SkillType, SkillProgress> skills = new EnumMap<>(SkillType.class);

    private SkillProgress getSkill(SkillType skill){
        return skills.computeIfAbsent(skill, _ -> new SkillProgress(0));
    }

    public int getSkillExp(SkillType skill){
        return getSkill(skill).getExperience();
    }

    public int getSkillLevel(SkillType skill){
        return getSkill(skill).getSkillLevel();
    }

    public void addSkillExp(SkillType skill, int exp){
        getSkill(skill).addExperience(exp);
    }

}
