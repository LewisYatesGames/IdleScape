package com.lyg.idlescape.server.player;

import com.lyg.idlescape.server.skill.Effect;
import com.lyg.idlescape.server.skill.SkillAction;
import com.lyg.idlescape.server.skill.SkillProgress;
import com.lyg.idlescape.server.skill.SkillType;

import java.util.EnumMap;
import java.util.Map;

public class Player {
    private final Map<SkillType, SkillProgress> skills = new EnumMap<>(SkillType.class);

    private SkillAction skillAction;

    public void update() {
        if (skillAction == null)
            return;

        var effects = skillAction.update();

        for (Effect effect : effects) {
            effect.apply(this);
        }

        if (skillAction.isComplete()) {
            if (!skillAction.repeatable) {
                skillAction = null;
            } else {
                skillAction.start();
            }
        }
    }

    public void setSkillAction(SkillAction skillAction) {
        this.skillAction = null;
        if (getSkillLevel(skillAction.skillType) < skillAction.requiredLevel) {
            return;
        }

        this.skillAction = skillAction;
        this.skillAction.start();
    }

    private SkillProgress getSkill(SkillType skill) {
        return skills.computeIfAbsent(skill, _ -> new SkillProgress(0));
    }

    public int getSkillExp(SkillType skill) {
        return getSkill(skill).getExperience();
    }

    public int getSkillLevel(SkillType skill) {
        return getSkill(skill).getSkillLevel();
    }

    public void addSkillExp(SkillType skill, int exp) {
        getSkill(skill).addExperience(exp);
    }
}
