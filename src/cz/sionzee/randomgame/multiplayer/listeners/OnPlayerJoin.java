package cz.sionzee.randomgame.multiplayer.listeners;

import cz.sionzee.randomgame.multiplayer.entities.Player;
import cz.sionzee.randomgame.multiplayer.event.IEvent;
import cz.sionzee.randomgame.multiplayer.event.RE;
import cz.sionzee.randomgame.multiplayer.events.PlayerJoinEvent;

/**
 * Created by sionzee on 29. 10. 2014.
 */
public class OnPlayerJoin implements IEvent {

    @RE
    public void $(PlayerJoinEvent event) {
        Player player = event.getPlayer();
    }

}
