package com.lyg.idlescape.server.skill.action.validation;

import com.lyg.idlescape.server.item.ItemRegistry;
import com.lyg.idlescape.server.world.ItemEntry;

public class DefaultActionValidationService implements ActionValidationService {
    private final ItemRegistry registry;

    public DefaultActionValidationService(ItemRegistry registry) {
        this.registry = registry;
    }

    public void validateItemEntries(ItemEntry[] items) {
        if (items == null) {
            throw new IllegalArgumentException("Items collection is null");
        }
        for (ItemEntry item : items) {
            registry.get(item.itemID());
        }
    }
}
