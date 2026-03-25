package com.lyg.idlescape.server.world;

import com.lyg.idlescape.server.item.ItemRegistry;

public record GameContext(ItemRegistry itemRegistry, SharedInventory sharedInventory) {
}
