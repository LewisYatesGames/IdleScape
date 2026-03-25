package com.lyg.idlescape.server.world;

import com.lyg.idlescape.server.player.Player;
import com.lyg.idlescape.server.util.Tickable;

import java.util.ArrayList;
import java.util.List;

public class World implements Tickable {
    private final List<Player> players;

    private final GameContext context;

    public World(GameContext context) {
        players = new ArrayList<>();
        this.context = context;
    }

    public void registerPlayer(Player player) {
        players.add(player);
    }

    public void deRegisterPlayer(Player player) {
        players.remove(player);
    }

    public void tick() {
        for (Player player : players) {
            player.update(context);
        }
    }
}
