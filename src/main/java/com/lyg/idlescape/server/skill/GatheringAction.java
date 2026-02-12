package com.lyg.idlescape.server.skill;

import com.lyg.idlescape.server.skill.effect.Effect;
import com.lyg.idlescape.server.skill.effect.XpRewardEffect;

import java.util.List;

public class GatheringAction extends SkillAction {
    public GatheringAction(SkillType type, int level, int duration, int xpReward, boolean repeatable) {
        super(type, level, duration, xpReward, repeatable);
    }

    @Override
    protected void onStart() { }

    @Override
    public List<Effect> onUpdate() {
        if (isComplete()) {
            return List.of(
                    new XpRewardEffect(skillType, xpReward)
                    //TODO: Add resource reward also
            );
        }
        return List.of();
    }
}
