package com.lyg.idlescape.server.skill;

import java.util.List;

public abstract class SkillAction {
    public final SkillType skillType;
    public final int requiredLevel;
    public final int duration;
    public final int xpReward;
    public final boolean repeatable;

    protected int tick = 0;

    public SkillAction(SkillType type, int level, int duration, int xpReward, boolean repeatable) {
        this.skillType = type;
        this.requiredLevel = level;
        this.duration = duration;
        this.xpReward = xpReward;
        this.repeatable = repeatable;
    }

    public void start() {
        tick = 0;
        onStart();
    }

    public List<Effect> update() {
        tick++;
        return onUpdate();
    }

    public boolean isComplete() {
        return tick >= duration;
    }

    protected abstract void onStart();
    protected abstract List<Effect> onUpdate();
}
