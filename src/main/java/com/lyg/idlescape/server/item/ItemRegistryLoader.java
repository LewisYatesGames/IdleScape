package com.lyg.idlescape.server.item;

import java.util.ArrayList;
import java.util.List;

//TODO: Currently hardcoded, update to actually load data
public class ItemRegistryLoader {
    public final List<Item> items;

    public ItemRegistryLoader() {
        items = new ArrayList<>();
        items.add(new Item("item_log", "log", "a log"));
        items.add(new Item("item_copper_ore", "copper ore", "copper ore, can be smelted with tin ore"));
        items.add(new Item("item_tin_ore", "tin ore", "tin ore, can be smelted with copper ore"));
        items.add(new Item("item_bronze_bar", "bronze bar", "bronze bar, created from tin and copper"));
    }
}
