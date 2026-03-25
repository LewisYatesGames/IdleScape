package com.lyg.idlescape.server.skill.effect;

import com.lyg.idlescape.server.player.Player;
import com.lyg.idlescape.server.world.GameContext;

public interface Effect {
    void apply(Player player, GameContext context);
}
