package com.lyg.idlescape.server.skill;

import com.lyg.idlescape.server.player.Player;

public class XpRewardEffect implements Effect {
    public SkillType skill;
    public int amount;

    public XpRewardEffect(SkillType skill, int amount) {
        this.skill = skill;
        this.amount = amount;
    }

    @Override
    public void apply(Player player) {
        player.addSkillExp(skill, amount);
        System.out.println(player.getSkillExp(skill));
    }
}
