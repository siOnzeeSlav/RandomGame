package cz.sionzee.randomgame.multiplayer.events;

import cz.sionzee.randomgame.multiplayer.entities.Player;
import cz.sionzee.randomgame.multiplayer.event.Event;
import cz.sionzee.randomgame.multiplayer.event.IEvent;

import java.util.HashSet;

/**
 * Created by sionzee on 29. 10. 2014.
 */
public class PlayerJoinEvent extends Event {

    Player player;

    public PlayerJoinEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
