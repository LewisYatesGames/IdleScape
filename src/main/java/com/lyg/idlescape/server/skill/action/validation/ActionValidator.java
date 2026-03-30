package com.lyg.idlescape.server.skill.action.validation;

import com.lyg.idlescape.server.skill.SkillAction;

public class ActionValidator {
    public void validate(ActionValidationService service, SkillAction[] actions) {
        if (actions == null) {
            throw new IllegalArgumentException("ActionValidator: actions collection is null");
        }

        for (SkillAction action : actions) {
            validateActionValues(action);
            action.validate(service);
        }
    }

    private void validateActionValues(SkillAction action) {
        if (action.getDuration() <= 0) {
            throw new IllegalArgumentException("Skill action duration <= 0: " + action.getActionId());
        }

        if (action.getRequiredLevel() < 1) {
            throw new IllegalArgumentException("Skill action required level is < 1. Not possible for players: " + action.getActionId());
        }
        if (action.getXpReward() < 0) {
            throw new IllegalArgumentException("Skill action rewards no xp: " + action.getActionId());
        }
    }
}
