package com.lyg.idlescape.server.skill.action.validation;

import com.lyg.idlescape.server.world.ItemEntry;

public interface ActionValidationService {
    void validateItemEntries(ItemEntry[] items);
}
