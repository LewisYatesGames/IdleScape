package com.lyg.idlescape.server.skill;

import com.lyg.idlescape.server.skill.effect.Effect;
import com.lyg.idlescape.server.skill.effect.ItemRewardEffect;
import com.lyg.idlescape.server.skill.effect.XpRewardEffect;
import com.lyg.idlescape.server.world.ItemEntry;

import java.util.List;

public class GatheringAction extends SkillAction {
    private final ItemEntry[] itemRewards;

    public GatheringAction(String actionId, SkillType type, int level, int duration, int xpReward, ItemEntry[] itemRewards, boolean repeatable) {
        super(actionId, type, level, duration, xpReward, repeatable);
        this.itemRewards = itemRewards;
    }

    @Override
    protected void onStart() { }

    @Override
    public List<Effect> onUpdate() {
        if (isComplete()) {
            return List.of(
                    new XpRewardEffect(getSkillType(), getXpReward()),
                    new ItemRewardEffect(itemRewards)
            );
        }
        return List.of();
    }
}
