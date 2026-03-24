package com.lyg.idlescape.server.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemRegistry {
    private final Map<String, Item> registry;

    public ItemRegistry(List<Item> items) {
        registry = new HashMap<>();
        populateRegistry(items);
    }

    private void populateRegistry(List<Item> items) {
        for (Item item : items) {
            registry.put(item.id(), item);
        }
    }

    public Item get(String itemId) {
        var item = registry.getOrDefault(itemId, null);
        if (item == null) {
            throw new IllegalArgumentException("Item doesn't exist: " + itemId + ". returning null");
        }
        return item;
    }
}
