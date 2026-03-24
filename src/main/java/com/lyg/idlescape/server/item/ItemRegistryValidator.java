package com.lyg.idlescape.server.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemRegistryValidator {
    public ItemRegistryValidator(List<Item> items) {
        validateItemData(items);
    }

    public boolean validateItemData(List<Item> items) {
        Map<String, Item> validated = new HashMap<>();

        for (Item item : items) {
            if (item.name().isEmpty() || item.description().isEmpty()) {
                throw new IllegalArgumentException("Entry has no name or description: " + item.id() + ". Please add");
            }
            if (validated.putIfAbsent(item.id(), item) != null) {
                throw new IllegalStateException("Entry already exists with: " + item.id());
            }
        }
        return true;
    }

}
