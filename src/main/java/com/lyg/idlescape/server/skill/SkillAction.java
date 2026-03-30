package com.lyg.idlescape.server.skill;

import com.lyg.idlescape.server.skill.action.validation.ActionValidationService;
import com.lyg.idlescape.server.skill.effect.Effect;

import java.util.List;

public abstract class SkillAction {
    private final String actionId;
    private final SkillType skillType;
    private final int requiredLevel;
    private final int duration;
    private final int xpReward;
    private final boolean repeatable;

    private int tick = 0;

    public SkillAction(String actionId, SkillType type, int level, int duration, int xpReward, boolean repeatable) {
        if (actionId == null || actionId.isBlank()) {
            throw new IllegalArgumentException("actionId is null");
        }
        this.actionId = actionId;
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

    public abstract void validate(ActionValidationService service);

    protected abstract void onStart();
    protected abstract List<Effect> onUpdate();

    public String getActionId() {
        return actionId;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public int getDuration() {
        return duration;
    }

    public int getXpReward() {
        return xpReward;
    }

    public boolean isRepeatable() {
        return repeatable;
    }

    public int getTick() {
        return tick;
    }
}
