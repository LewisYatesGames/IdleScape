package com.lyg.idlescape.server.skill.effect;

import com.lyg.idlescape.server.player.Player;
import com.lyg.idlescape.server.world.GameContext;
import com.lyg.idlescape.server.world.ItemEntry;

public class ItemRewardEffect implements Effect {
    private final ItemEntry[] items;

    public ItemRewardEffect(ItemEntry[] items) {
        this.items = items;
    }

    @Override
    public void apply(Player player, GameContext context) {
        context.sharedInventory().addItems(items);
    }
}
